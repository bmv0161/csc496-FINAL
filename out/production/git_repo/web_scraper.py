# Author(s): Shaun Derstine
# Last Edit: 12/13/2021
# Description: This script writes all WCUPA CSC courses to 'courses.txt' in this format...
#	       Course Number
#	       Course Title
#	       Prerequisites
#	       Offerings

from bs4 import BeautifulSoup as soup
from urllib.request import urlopen

def main():
  # url is saved as a string
  url = 'https://www.wcupa.edu/sciences-mathematics/computerScience/undergradCourses.aspx'

  # urlopen makes a request to webpage at url
  #result is an object which is saved as url_object
  url_object = urlopen(url)

  # the raw html from the webpage is saved in page_html
  page_html = url_object.read()

  # converts raw html to BeautifulSoup object 'soup_html'
  soup_html = soup(page_html, 'html.parser')

  # creates txt file for later writing
  # write_file = open("courses.txt", "w")

  # # all rows in every table on page (all_rows[0] contains column headers)
  # all_rows = soup_html.find_all('tr')

  # column headers
  headers = soup_html.find('tr')

  # loops through every row and prints contents of each individual cell
  for row in headers.find_all_next('tr'):
    for cell in row.find_all('td'):
      # check if p tag exists in cell because of poor formatting of website
      if cell.find('p'):
        # print none if cell is empty, otherwise print contents
        if cell.find('p').string == '\xa0':
          print('None')
        else:
          print(cell.find('p').string)
      # if no p tag exists for cell, print out contents of cell directly
      else:
        if cell.string == '\xa0':
          print('None')
        else:
          print(cell.string)

if __name__ == "__main__":
  main()
