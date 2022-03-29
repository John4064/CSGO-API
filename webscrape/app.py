# Author: John Parkhurst
# Brief: Selenium Web Scraping application for hltv.org
from config import *
from selenium import webdriver
import re


class HltvScraper():

    def gatherData(self) -> None:
        """
        @brief: Gathers the html content that we want from the page
        :return: None
        """
        print(1)
        return

    def __init__(self):
        print("Scrape Initiated")
        self.driver = webdriver.Firefox()
        self.driver.get(url)

        self.gatherData()


        self.driver.close()
        print("DONE")
