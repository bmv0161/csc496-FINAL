from bs4 import BeautifulSoup as soup
from urllib.request import urlopen


  # url is saved as a string
  url = 'https://www.wcupa.edu/sciences-mathematics/computerScience/undergradCourses.aspx'

  # urlopen makes a request to webpage at url
  #result is an object which is saved as url_object
  url_object = urlopen(url)

  # the raw html from the webpage is saved in page_html
  page_html = url_object.read()

  # converts raw html to BeautifulSoup object 'soup_html'
  soup_html = soup(page_html, 'html.parser')

  # FIRST VERSION: ROUGH PROTOTYPE
  # ------------------------------
  # # finds first four table headers and stores them in list
  # first_four_table_headers = soup_html.find_all('th', limit=4)
  # 
  # # finds the first row (after first four table headers)
  # next_row = first_four_table_headers[ len(first_four_table_headers) - 1 ].find_next('tr')
  # 
  # # all content within row (between <tr> and </tr>)
  # next_row_contents = next_row.contents
  # 
  # # makes a list of all cells in row
  # cells = next_row_contents.find_all('td')
  # 
  # # prints contents of each cell in row
  # for cell in cells:
  #   print(cell.find('p').string)

  # VERSION TWO: ITERATIVE, INCLUDES ALL ROWS (NOT JUST CSC)
  # --------------------------------------------------------

  # # all rows in every table on page (all_rows[0] contains column headers)
  # all_rows = soup_html.find_all('tr')

  # loops through every row and prints contents of each individual cell
  for row in soup_html.find_all('tr'):
    for cell in row.find_all('td'):
      print(cell)
