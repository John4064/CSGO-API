# Author: John Parkhurst
# Brief: Selenium Web Scraping application for hltv.org
from selenium.webdriver.common.by import By

from config import *
from selenium import webdriver
import re


class HltvScraper():


    #Looking for class result-con
    def gatherData(self) -> None:
        """
        @brief: Gathers the html content that we want from the page
        :return: None
        """
        resultData = login_form = self.driver.find_elements(by=By.CLASS_NAME,value="result-con")
        print(resultData)
        return

    def __init__(self):
        print("Scrape Initiated")
        self.driver = webdriver.Firefox()
        self.driver.get(url)
        try:
            self.gatherData()
        except:
            self.driver.close()
            print("ERROR")
            return
        self.driver.close()
        print("DONE")
