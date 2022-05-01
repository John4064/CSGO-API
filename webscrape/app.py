# Author: John Parkhurst
# Brief: Selenium Web Scraping application for hltv.org
from selenium.webdriver import *
from selenium.webdriver.common.by import By
from bs4 import BeautifulSoup
import requests

from config import *
from selenium import webdriver
import re


class HltvScraper():

    """
        resultData = login_form = self.driver.find_elements(by=By.CLASS_NAME,value="result-con")

        for element in resultData:
            temp = element.find_element(by=By.XPATH,value=".//a[@class='a-reset']")
            """
    #Looking for class result-con
    def gatherData(self) -> None:
        """
        @brief: Gathers the html content that we want from the page
        :return: None
        """
        print(self.page.text)
        print("aa")

        return

#Plan is to iterate through all the matches on said page and put into json of info to add to our api!
    def __init__(self):
        print("Scrape Initiated")
        #Mac
        #self.driver = webdriver.Firefox()
        #windows
        self.page = requests.get(resulturl)
        try:
            self.gatherData()
        except:
            print("ERROR")
            return
        print("DONE")
