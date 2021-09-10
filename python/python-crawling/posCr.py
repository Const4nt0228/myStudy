import requests
from bs4 import BeautifulSoup
import re

# webpage = requests.get("https://www.okpos.co.kr/customer/customer_0304.php")
webpage = requests.get("https://www.okpos.co.kr/customer/customer_0304.php?&page=2")

soup = BeautifulSoup(webpage.content, "html.parser")


def search_Q():
    res = soup.find_all('h4')
    for n in res:
        print(n.get_text())


def search_A():
    res = soup.find_all('div','content')
    for n in res:
        print(n.get_text().strip())


if __name__ == "__main__":
     search_A()
     #search_Q()

