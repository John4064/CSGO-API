# Author: John Parkhurst
# Brief: Selenium Web Scraping application for hltv.org

from bs4 import BeautifulSoup
import requests
from config import *

"""
We are gonna need an iterate method once we properly process all the text on one page, size is done though!
"""

class HltvScraper():
    """
        resultData = login_form = self.driver.find_elements(by=By.CLASS_NAME,value="result-con")

        for element in resultData:
            temp = element.find_element(by=By.XPATH,value=".//a[@class='a-reset']")
            """

    def gatherSize(self) -> None:
        """
        @brief: We use our field self.page to analyze the page to figure out how many matches there are to scrape!\n
        Sets self.size\n
        :return: None
        """
        soup = BeautifulSoup(self.page.content, "html.parser")
        job_elements = soup.find_all("span", class_="pagination-data")
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

    # Looking for class result-con
    def processData(self) -> None:
        """
        @brief: Processes the html we scraped off the page!
        :return: None
        """
        # Result Text
        soup = BeautifulSoup(self.page.content, "html.parser")
        results = soup.find(id="pagination-data")
        if (results != None):
            # print(results.prettify())
            print(self.page.text)

        return

    # Plan is to iterate through all the matches on said page and put into json of info to add to our api!
    def __init__(self):
        print("Scrape Initiated")
        self.page = requests.get(resulturl)
        self.size = 0

        self.processData()
        try:
            self.gatherSize()
            print("BEEP")
        except:
            print("ERROR")
            return
        print("DONE")
