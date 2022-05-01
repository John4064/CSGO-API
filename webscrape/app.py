# Author: John Parkhurst
# Brief: Selenium Web Scraping application for hltv.org

from bs4 import BeautifulSoup
import requests
from config import *
import re


class HltvScraper():

    """
        resultData = login_form = self.driver.find_elements(by=By.CLASS_NAME,value="result-con")

        for element in resultData:
            temp = element.find_element(by=By.XPATH,value=".//a[@class='a-reset']")
            """



    def gatherSize(self)-> None:
        """
        @brief: We use our field self.page to analyze the page to figure out how many matches there are to scrape!\n
        Sets self.size\n
        :return: None
        """

        self.size =0
        return

    #Looking for class result-con
    def processData(self) -> None:
        """
        @brief: Processes the html we scraped off the page!
        :return: None
        """
        #Result Text

        soup = BeautifulSoup(self.page.content, "html.parser")
        results = soup.find(id="pagination-data")
        job_elements = soup.find_all("span", class_="pagination-data")
        for job_element in job_elements:
            print(job_element.text)

        if(results!= None):
            #print(results.prettify())
            print(self.page.text)

        return

#Plan is to iterate through all the matches on said page and put into json of info to add to our api!
    def __init__(self):
        print("Scrape Initiated")
        self.page = requests.get(resulturl)
        self.processData()
        try:
            print("BEEEP")
        except:
            print("ERROR")
            return
        print("DONE")
