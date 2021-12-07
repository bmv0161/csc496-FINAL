import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;


public class Graph {
    private ArrayList<Node> nodes = null;

    public boolean contains(String courseNum) {
        for(Node x: courseList) {
            if(x.getCourse().equals(courseNum)) { return true; }
        }
        return false;
    }

	public static addNode(String number, String name, ArrayList<Node> prereqs) {
		Node course = new Node(number, name, prereqs)
		nodes.add(course);
	}

    public static void main(String[] args) {
        System.out.println(new URLParser().getClassList());
    }
}

enum Offerings {
    WINTER, SPRING, SUMMER, FALL
}
/*
class Node {
    private String courseNum;
    private ArrayList<Node> prereq = null;

    public Node() {
    }
    public Node(String course) {
        this.courseNum = course;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }
    public void setPrereq(ArrayList<Node> prereq) {
        this.prereq = prereq;
    }
    public void addPrereq(String course) {
        this.prereq.add(course);
    }

    public String toString() {
        return courseNum + " - " + prereq;
    }

    public String getCourse() {
        return this.courseNum;
    }
    public ArrayList<Node> getPrereq() {
        return this.prereq;
    }
}
*/

class Node {
	public Node(this, String number, String name, ArrayList<Node> prereqs) {
		this.number = number;
		this.name = name;
		this.prereqs = neighbors
	}

	public String toString() {
		return this.number + "----" + this.name
	}
}
/*
class URLParser {
    private final String url =
            "https://www.wcupa.edu/sciences-mathematics/computerScience/undergradCourses.aspx";
    private Element table = null;
    private ArrayList<Node> courseList = new ArrayList<Node>();

    public URLParser() {
        try {
            Document doc = Jsoup.connect(url).get();
            table = doc.select("table.responsiveTable").get(0);
            //System.out.println(doc.outerHtml());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private void parseTable() {
        for(Element row: table.select("tr")) {
            Node course = new Node();
            for(Element col: row.select("td")) {
                if(col.attr("data-label").equals("Course Number")) {
                    Elements link = col.select("a");
                    String label = link.text();
                    course.setCourseNum(label);
                }else if(col.attr("data-label").equals("Prerequisites")) {
                    String prereq = col.text();

                    //System.out.println(col.);
                }
                courseList.add(course);

            }
        }
    }

    public ArrayList<Node> getClassList() {
        if(courseList.isEmpty()) {
            parseTable();
        }
        return courseList;
    }
}
*/

public static void main(String args[]) {
	Graph graph = new Graph();
	graph.add_node("MAT 151", "Introduction to Discrete Mathematics");
	graph.add_node("MAT 161", "Calculus I");
	graph.add_node("CSC 141", "Computer Science I");
	graph.add_node("CSC 142", "Computer Science II", [graph.nodes.get(4)]);
	graph.add_node("CSC 220", "Foundations of Computer Science", [graph.nodes.get(0), graph.nodes.get(1)]);
	graph.add_node("CSC 231", "Computer Systems", [graph.nodes.get(4)]);
	graph.add_node("CSC 240", "Computer Science III", [graph.nodes.get(4)]);
	graph.add_node("CSC 241", "Data Structures and Algorithms", [graph.nodes.get(0), graph.nodes.get(1), graph.nodes.get(4)]);
	graph.add_node("CSC 242", "CSC 242", "Computer Organization", [graph.nodes.get(4), graph.nodes.get(0)]);
	graph.add_node("CSC 301", "Computer Security & Ethics");
	graph.add_node("CSC 335", "Data Communications and Networking I", [graph.nodes.get(4), graph.nodes.get(7)]);
	graph.add_node("CSC 302", "Computer Security", [graph.nodes.get(4), graph.nodes[10]]);
	graph.add_node("CSC 317", "Introduction to Digital Image Processing", [graph.nodes.get(4), graph.nodes.get(0), graph.nodes.get(1)]);
	graph.add_node("CSC 321", "Database Management Systems", [graph.nodes.get(7)]);
	graph.add_node("CSC 331", "Operating Systems", [graph.nodes.get(4), graph.nodes.get(4), graph.nodes.get(7)]);
	graph.add_node("CSC 336", "Data Communications and Networking II", [graph.nodes[10]]);
	graph.add_node("CSC 345", "Programming Language Concepts and Paradigms", [graph.nodes.get(4), graph.nodes.get(7)]);
	graph.add_node("CSC 400", "Internship", [graph.nodes.get(4), graph.nodes.get(7)]);
	graph.add_node("CSC 402", "Software Engineering", [graph.nodes.get(7)]);
	graph.add_node("CSC 404", "Software Engineering & Testing", [graph.nodes.get(4), graph.nodes.get(7)]);
	graph.add_node("CSC 416", "Design and Construction of Compilers", [graph.nodes.get(4), graph.nodes.get(4), graph.nodes.get(7)]);
	graph.add_node("CSC 417", "User Interfaces", [graph.nodes.get(7)]);
	graph.add_node("CSC 466", "Distributed and Parallel Programming", [graph.nodes.get(5)]);
	graph.add_node("CSC 468", "Introduction to Cloud Computing", [graph.nodes.get(5)]);
	graph.add_node("CSC 471", "Modern Malware Analysis", [graph.nodes[8]]);
	graph.add_node("CSC 472", "Software Security", [graph.nodes[8]]);
	graph.add_node("CSC 476", "Game Development", [graph.nodes.get(7)]);
	graph.add_node("CSC 481", "Artificial Intelligence", [graph.nodes.get(7)]);
	graph.add_node("CSC 490", "Independent Project", [graph.nodes.get(4), graph.nodes.get(7)]);
	graph.add_node("CSC 495", "Topics in Computer Science", [graph.nodes.get(7)]);
	graph.add_node("CSC 496", "Topics in Complex Systems", [graph.nodes.get(7)]);
	graph.add_node("CSC 497", "Topics in Computer Security", [graph.nodes.get(7)]);
	graph.add_node("CSC 499", "Independent Study in Computer Science", [graph.nodes.get(7)]);
}