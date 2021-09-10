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

list = []

for n in range(1, 107):
    webpage = requests.get(f'http://nicecard.kr/bbs/board.php?bo_table=faq&wr_id={n}')
    soup = BeautifulSoup(webpage.content, 'html.parser')
    res = soup.select('#bo_v_con')

    for n in res:
        result = n.get_text()
        result = result.replace(u'\xa0', u'')
        result = result.replace(u'\u200b',u'')#\ufeff
        result = result.replace(u'\ufeff', u'')
        result = result.replace("A)","\n")
        result = result.replace("-","")
        # result = result.replace("Q)" , "")
        fw.write(str(result) + '\n')


fw.close

