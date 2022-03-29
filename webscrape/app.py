#Author: John Parkhurst
#Brief: Selenium Web Scraping application for hltv.org
from config import *
from selenium import webdriver


class HltvScraper():


    def __init__(self):
        print("Scrape Initiated")
        self.driver = webdriver.Firefox()
        self.driver.get(url)
        print("DONE")