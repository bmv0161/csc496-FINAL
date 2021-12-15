# csc496: FINAL Project
**Topology sort for course scheduling**

[RAW DATA](https://www.wcupa.edu/sciences-mathematics/computerScience/undergradCourses.aspx)

**Roadmap**
1. Get data from website
2. Create graph data structure
3. Create algorithm for topology
4. Bonus points

**File Structure**
1. Graph.java: stores directed graph data structure
2. ClassScheduler.java: can perform topology sort to output graduation plan
3. Main.java: contains project driver -> Creates Graph from courses.txt and prints algorithms
4. web_scraper.py: parses html of course catalog with Beautiful soup and pipes data to courses.txt
5. courses.txt: stores output from web_scraper.py

**Roles**

Devin
- Graph.java

Brian
- ClassScheduler.java

Shaun
- Video

Shared
- Bonuses

**Bonus**
1. Rewrite the algorithm with a cap of three courses per semester: find the fastest graduation path
2. Build an interactive Web/GUI application to display the algorithm
3. Rewrite the algorithm to fill out the CSC advising sheet: find the fastest graduation path (least amount of semesters)




**Notes from meeting with Jiang**
- CSC301: no prerequisites
- only consider csc courses
- Bonus 1: max three - hardest - find fastest completion of courses
- Bonus 2: click a button, displays everything, user input possible
- Bonus 3: complete csc courses to graduate the fastest - complete grading sheet
- Video: code demo, display output, explain output, show single round
