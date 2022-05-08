# Author: John Parkhurst
# Brief: Selenium Web Scraping application for hltv.org
from typing import List

from bs4 import BeautifulSoup
import requests
from config import *
from hltvMatch import *

"""
We are gonna need an iterate method once we properly process all the text on one page, size is done though!
"""


class HltvScraper():
    idList = []
    urlList = []

    # teaamA is the winning team in our database from now on!
    teamA = []
    teamB = []
    scoreA = []
    scoreB = []
    compEvent = []
    matchType = []

    #List of hltvmatch objects
    matchList = []

    def gatherSize(self) -> None:
        """
        @brief: We use our field self.page to analyze the page to figure out how many matches there are to scrape!\n
        Sets self.size\n
        :return: None
        """
        job_elements = self.soup.find_all("span", class_="pagination-data")
        # CLEAN THIS UP SLOPPY
        for job_element in job_elements:
            data = job_element.text.split(" ")
            break
        tempMax = 0
        for value in data:
            if value.isnumeric():
                if int(value) > tempMax:
                    tempMax = int(value)
        self.size = tempMax
        return

    def gatherIDURL(self) -> None:
        """
        @brief: from the specific result page we are on it reads the results href tag to gather id & url of said match
        :return: None
        """

        # Subresult list is the div of list of matches for the day(may 8th, may7th)
        subResultList = self.soup.find_all("div", class_="results-sublist")
        # REFACTOR AAND PROPERLY NAME SUBLIST, RESULT LIST, RESULT, TAG, HEADER!!!!!
        # Resultlist is the results in that subgroup
        for resultList in subResultList:
            # Result is the indivual match itself
            result = resultList.find_all("div", class_="result-con")
            # The tag/data for the result match
            for tag in result:
                # The link for specific ressult( /matches/2356031/apeskvsmasonic-pinnacle-cup-iv
                resultLink = tag.find("a", class_="a-reset")
                tempList = resultLink.get('href').split('/')
                self.idList.append(tempList[2])
                self.urlList.append(baseurl + resultLink.get('href'))

        return

    def gatherScores(self):
        """
        @brief: Gathers the score of the matches and sets them in ScoreA(winning) scoreB(losing)
        :return:
        """

        for scoreL, scoreW in zip(self.soup.find_all("span", class_="score-lost"),
                                  self.soup.find_all("span", class_="score-won")):
            self.scoreA.append(scoreW.text)
            self.scoreB.append(scoreL.text)



        return

    def gatherTypeEvent(self):
        """
        @brief Gathers the competition type(ESEAA SPRING 2022) and match type(bo3,bo5,trn)
        Sets matchtype,compevent
        :return: None
        """
        for event, match_type in zip(self.soup.find_all("span", class_="event-name"),
                                     self.soup.find_all("div", class_="map-text")):
            # print(event.text)
            # print(match_type.text)
            self.compEvent.append(event.text)
            self.matchType.append(match_type.text)

    def gatherTeams(self):
        for team1, team2, teamW in zip(self.soup.find_all("div", class_="line-align team1"),
                                       self.soup.find_all("div", class_="line-align team2"),
                                       self.soup.find_all("div", class_="team team-won")):
            team1 = team1.text.strip()
            team2 = team2.text.strip()
            if (teamW.text == team1):
                # Making sure we have the coirrect winning team
                self.teamA.append(team1)
                self.teamB.append(team2)
                # print("Won: " + team1)
                # print("Lost: " + team2)
            else:
                self.teamA.append(team2)
                self.teamB.append(team1)
                # print("Won: " + team2)
                # print("Lost: " + team1)

    # Looking for class result-con
    def processData(self, urlList: List[str]) -> None:
        """
        @brief: Processes the html we scraped off the page!
        :return: None
        """
        try:
            # Gather id/url of match
            self.gatherIDURL()
        except:
            print("ERROR OCCURRED GATHERING ID/URL")

        try:
            # Gather the winning/losing score
            self.gatherScores()
        except:
            print("ERROR OCCURRED GATHERING SCORES")

        try:
            # Gathering type of match and competition
            self.gatherTypeEvent()
        except:
            print("ERROR OCCURRED IN  GATHERING COMPETITION/TYPE")

        try:
            # Gather winning and losing team!
            self.gatherTeams()
        except:
            print("ERROR OCCURRED IN GATHERING TEAMS")
        return

    def report(self):
        """
        @brief a test function where we print out all the data we collect
        :return:
        """
        print("Number of matches: {}".format(self.size))
        print("({})ID REPORT:".format(len(self.idList)))
        for elem in self.idList:
            print("ID IS :{}".format(elem))
        print("({})URL REPORT:".format(len(self.urlList)))
        for elem in self.urlList:
            print("URL IS:{}".format(elem))
        print("({},{})TEAM REPORT:".format(len(self.teamA),len(self.teamB)))
        for i in range(len(self.teamA)):
            print("Winning Team IS:{}".format(self.teamA[i]))
            print("Losing Team IS:{}".format(self.teamB[i]))
        print("({},{})Score Report:".format(len(self.scoreA),len(self.scoreB)))
        for x in range(len(self.scoreA)):
            print("Winning Score IS:{}".format(self.scoreA[x]))
            print("Losing Score IS:{}".format(self.scoreB[x]))
        print("({},{})Event/Type Report:".format(len(self.compEvent), len(self.matchType)))
        for event,type in zip(self.compEvent,self.matchType):
            print("The event is: "+event)
            print("The Match type is: "+type)

        return

    def urlGenerator(self) -> List[str]:
        """
        Generate all potential urls we need to scrape
        :return: A string array of all potential hltv.org results based on max size on page 1
        """
        urls=[]
        numPages=self.size/100
        for num in range(0,self.size,100):
            urls.append(offsetUrl.format(num))
        return urls

    def putObj(self):
        #Replace with size after testing

        for iter in range(100):
            temp= hltvMatch(self.idList[iter],self.urlList[iter],self.teamA[iter],self.teamB[iter],self.scoreA[iter],
                            self.scoreB[iter],self.compEvent[iter],self.matchType[iter])
            self.matchList.append(temp)

        return

    # Plan is to iterate through all the matches on said page and put into json of info to add to our api!
    def __init__(self):
        print("Scrape Initiated")
        self.page = requests.get(resulturl)
        self.size = 0
        self.soup = BeautifulSoup(self.page.content, "html.parser")
        try:
            #
            self.gatherSize()
            urlList=self.urlGenerator()
            self.processData(urlList)
        except:
            print("ERROR OVERALL")
            return
        #Put into objects
        self.putObj()


        #self.report()
        print("DONE")