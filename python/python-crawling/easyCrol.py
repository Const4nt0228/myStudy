from selenium import webdriver as wd
from bs4 import BeautifulSoup
import requests
from pathlib import Path

# driver = wd.Chrome('C:\chromedriver.exe')
# driver.maximize_window()
#
# url = 'http://nicecard.kr/bbs/board.php?bo_table=faq&page=1'
# driver.get(url)
#
# driver.find_element_by_xpath('//*[@id="fboardlist"]/div/table/tbody/tr[2]/td[2]/a').click()
#
# #content = driver.find_element_by_xpath('//*[@id="bo_v_con"]')
#
# html = driver.page_source


# for n in 107

fw = open('C:/Users/User/Desktop/crol.txt', 'w')

webpage = requests.get("https://www.okpos.co.kr/customer/customer_0304.php?&page=2")

soup = BeautifulSoup(webpage.content, "html.parser")

fw.close

