class Node:
    def __init__(self, number, name, neighbors=[]):
        self.number = number
        self.name = name
        self.neighbors = neighbors
        
class Graph:
    def __init__(self, nodes=[]):
        self.nodes = nodes

    def add_node(self, number, name, neighbors=[]):
        new_node = Node(number, name, neighbors)
        self.nodes.append(new_node)

    def add_edge(self, node1, node2):
        node1.edges.append(node2)
        node2.edges.append(node1)

data = {
    "courses": [
        {
            "number": "CSC 110",
            "prereqs": [],
            "name": "Fundamentals in Computer Science"
        },
        {
            "number": "CSC 112",
            "prereqs": [],
            "name": "Programming & Data Science"
        },
        {
            "number": "CSC 115",
            "prereqs": [],
            "name": "Introduction to Computer Programming"
        },
        {
            "number": "CSC 116",
            "prereqs": [],
            "name": "Gen Ed Science"
        },
        {
            "number": "CSC 141",
            "prereqs": [],
            "name": "Computer Science I"
        },
        {
            "number": "CSC 142",
            "prereqs": ["CSC 141"],
            "name": "Computer Science II"
        },
        {
            "number": "CSC 220",
            "prereqs": ["MAT 151", "MAT 161"],
            "name": "Foundations of Computer Science"
        },
        {
            "number": "CSC 231",
            "prereqs": ["CSC 142"],
            "name": "Computer Systems"
        },
        {
            "number": "CSC 240",
            "prereqs": ["CSC 142"],
            "name": "Computer Science III"
        },
        {
            "number": "CSC 241",
            "prereqs": ["CSC 240", "MAT 151", "MAT 161"],
            "name": "Data Structures and Algorithms"
        },
        {
            "number": "CSC 242",
            "prereqs": ["CSC 142", "MAT 151"],
            "name": "Computer Organization"
        },
        {
            "number": "CSC 301",
            "prereqs": [],
            "name": "Computer Security & Ethics"
        },
        {
            "number": "CSC 302",
            "prereqs": ["CSC 301", "CSC 335"],
            "name": "Computer Security"
        },
        {
            "number": "CSC 317",
            "prereqs": ["graph.nodes[6]", "graph.nodes[0]", "graph.nodes[1]"],
            "name": "Introduction to Digital Image Processing"
        },
        {
            "number": "CSC 321",
            "prereqs": ["CSC 241"],
            "name": "Database Management Systems"
        },
        {
            "number": "CSC 331",
            "prereqs": ["CSC 220", "CSC 240", "CSC 241"],
            "name": "Operating Systems"
        },
        {
            "number": "CSC 335",
            "prereqs": ["CSC 240", "CSC 241"],
            "name": "Data Communications and Networking I"
        },
        {
            "number": "CSC 336",
            "prereqs": ["CSC 335"],
            "name": "Data Communications and Networking II"
        },
        {
            "number": "CSC 345",
            "prereqs": ["CSC 220", "CSC 241"],
            "name": "Programming Language Concepts and Paradigms"
        },
        {
            "number": "CSC 400",
            "prereqs": ["CSC 240", "CSC 241"],
            "name": "Internship"
        },
        {
            "number": "CSC 402",
            "prereqs": ["CSC 241"],
            "name": "Software Engineering"
        },
        {
            "number": "CSC 404",
            "prereqs": ["CSC 240", "CSC 241"],
            "name": "Software Engineering & Testing"
        },
        {
            "number": "CSC 416",
            "prereqs": ["CSC 220", "CSC 240", "CSC 241"],
            "name": "Design and Construction of Compilers"
        },
        {
            "number": "CSC 417",
            "prereqs": ["CSC 241"],
            "name": "User Interfaces"
        },
        {
            "number": "CSC 466",
            "prereqs": ["CSC 231"],
            "name": "Distributed and Parallel Programming"
        },
        {
            "number": "CSC 468",
            "prereqs": ["CSC 231"],
            "name": "Introduction to Cloud Computing"
        },
        {
            "number": "CSC 471",
            "prereqs": ["CSC 242"],
            "name": "Modern Malware Analysis"
        },
        {
            "number": "CSC 472",
            "prereqs": ["CSC 242"],
            "name": "Software Security"
        },
        {
            "number": "CSC 476",
            "prereqs": ["CSC 241"],
            "name": "Game Development"
        },
        {
            "number": "CSC 481",
            "prereqs": ["CSC 241"],
            "name": "Artificial Intelligence"
        },
        {
            "number": "CSC 490",
            "prereqs": ["CSC 220", "CSC 241"],
            "name": "Independent Project"
        },
        {
            "number": "CSC 495",
            "prereqs": ["CSC 241"],
            "name": "Topics in Computer Science"
        },
        {
            "number": "CSC 496",
            "prereqs": ["CSC 241"],
            "name": "Topics in Complex Systems"
        },
        {
            "number": "CSC 497",
            "prereqs": ["CSC 241"],
            "name": "Topics in Computer Security"
        },
        {
            "number": "CSC 499",
            "prereqs": ["CSC 241"],
            "name": "Independent Study in Computer Science"
        }
    ]
}
for course in data["courses"]:
    print(course["name"])

graph = Graph()
graph.add_node("MAT 151", "Introduction to Discrete Mathematics")
graph.add_node("MAT 161", "Calculus I")
graph.add_node("CSC 141", "Computer Science I")
graph.add_node("CSC 142", "Computer Science II", [graph.nodes[2]])
graph.add_node("CSC 220", "Foundations of Computer Science", [graph.nodes[0], graph.nodes[1]])
graph.add_node("CSC 231", "Computer Systems", [graph.nodes[4]])
graph.add_node("CSC 240", "Computer Science III", [graph.nodes[4]])
graph.add_node("CSC 241", "Data Structures and Algorithms", [graph.nodes[0], graph.nodes[1], graph.nodes[6]])
graph.add_node("CSC 242", "CSC 242", "Computer Organization", [graph.nodes[4], graph.nodes[0]])
graph.add_node("CSC 301", "Computer Security & Ethics")
graph.add_node("CSC 335", "Data Communications and Networking I", [graph.nodes[6], graph.nodes[7]])
graph.add_node("CSC 302", "Computer Security", [graph.nodes[9], graph.nodes[10]])
graph.add_node("CSC 317", "Introduction to Digital Image Processing", [graph.nodes[6], graph.nodes[0], graph.nodes[1]])
graph.add_node("CSC 321", "Database Management Systems", [graph.nodes[7]])
graph.add_node("CSC 331", "Operating Systems", [graph.nodes[4], graph.nodes[6], graph.nodes[7]])
graph.add_node("CSC 336", "Data Communications and Networking II", [graph.nodes[10]])
graph.add_node("CSC 345", "Programming Language Concepts and Paradigms", [graph.nodes[4], graph.nodes[7]])
graph.add_node("CSC 400", "Internship", [graph.nodes[6], graph.nodes[7]])
graph.add_node("CSC 402", "Software Engineering", [graph.nodes[7]])
graph.add_node("CSC 404", "Software Engineering & Testing", [graph.nodes[6], graph.nodes[7]])
graph.add_node("CSC 416", "Design and Construction of Compilers", [graph.nodes[4], graph.nodes[6], graph.nodes[7]])
graph.add_node("CSC 417", "User Interfaces", [graph.nodes[7]])
graph.add_node("CSC 466", "Distributed and Parallel Programming", [graph.nodes[5]])
graph.add_node("CSC 468", "Introduction to Cloud Computing", [graph.nodes[5]])
graph.add_node("CSC 471", "Modern Malware Analysis", [graph.nodes[8]])
graph.add_node("CSC 472", "Software Security", [graph.nodes[8]])
graph.add_node("CSC 476", "Game Development", [graph.nodes[7]])
graph.add_node("CSC 481", "Artificial Intelligence", [graph.nodes[7]])
graph.add_node("CSC 490", "Independent Project", [graph.nodes[4], graph.nodes[7]])
graph.add_node("CSC 495", "Topics in Computer Science", [graph.nodes[7]])
graph.add_node("CSC 496", "Topics in Complex Systems", [graph.nodes[7]])
graph.add_node("CSC 497", "Topics in Computer Security", [graph.nodes[7]])
graph.add_node("CSC 499", "Independent Study in Computer Science", [graph.nodes[7]])