# csc496: FINAL Project
**Topology sort for course scheduling**

[RAW DATA](https://www.wcupa.edu/sciences-mathematics/computerScience/undergradCourses.aspx)

**Roadmap**
1. Get data from website
2. Create graph data structure
3. Create algorithm for topology
4. Bonus points

**File Structure**
- web_scraper.py: reads data from site and outputs to a text file for later reading
- Graph.java: structure for creating graph from output of web_scraper.py
- ClassScheduler.java: contains algorithms for topology sort
- Main.java: contains main method to output final product

**Roles**

Devin
- Graph.java
- Bonus 2

Brian
- Main.java
- ClassScheduler.java
- Bonus 1

Shaun
- web_scraper.py
- Video

**Bonus**
1. Rewrite the algorithm with a cap of three courses per semester: find the fastest graduation path
2. Build an interactive Web/GUI application to display the algorithm
3. Rewrite the algorithm to fill out the CSC advising sheet: find the fastest graduation path (least amount of semesters
)




**Notes from meeting with Jiang**
- CSC301: no prerequisites
- only consider csc courses
- Bonus 1: max three - hardest - find fastest completion of courses
- Bonus 2: click a button, displays everything, user input possible
- Bonus 3: complete csc courses to graduate the fastest - complete grading sheet
- Video: code demo, display output, explain output, show single round
