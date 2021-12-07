// import org.jsoup.Jsoup;
// import org.jsoup.nodes.Document;
// import org.jsoup.nodes.Element;
// import org.jsoup.select.Elements;
// import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Graph {
    public ArrayList<Node> nodes = new ArrayList<Node>();

    public boolean contains(String courseNum) {
        for(Node x: nodes) {
            if(x.getCourse().equals(courseNum)) { return true; }
        }
        return false;
    }

	public void addNode(String number, String name, ArrayList<Node> prereqs) {
		Node course = new Node(number, name, prereqs);
		nodes.add(course);
	}

    public static void main(String args[]) {
		Graph graph = new Graph();
		ArrayList<Node> empty = new ArrayList<Node>();
		graph.addNode("MAT 151", "Introduction to Discrete Mathematics", empty);
		graph.addNode("MAT 161", "Calculus I", empty);
		graph.addNode("CSC 141", "Computer Science I", empty);
		graph.addNode("CSC 142", "Computer Science II", new ArrayList<Node>(Arrays.asList(graph.nodes.get(2))));
		graph.addNode("CSC 220", "Foundations of Computer Science", new ArrayList<Node>(Arrays.asList(graph.nodes.get(0), graph.nodes.get(1))));
		graph.addNode("CSC 231", "Computer Systems", new ArrayList<Node>(Arrays.asList(graph.nodes.get(3))));
		graph.addNode("CSC 240", "Computer Science III", new ArrayList<Node>(Arrays.asList(graph.nodes.get(3))));
		graph.addNode("CSC 241", "Data Structures and Algorithms", new ArrayList<Node>(Arrays.asList(graph.nodes.get(0), graph.nodes.get(1), graph.nodes.get(6))));
		graph.addNode("CSC 242", "Computer Organization", new ArrayList<Node>(Arrays.asList(graph.nodes.get(3), graph.nodes.get(0))));
		graph.addNode("CSC 301", "Computer Security & Ethics", empty);
		graph.addNode("CSC 335", "Data Communications and Networking I", new ArrayList<Node>(Arrays.asList(graph.nodes.get(7), graph.nodes.get(8))));
		graph.addNode("CSC 302", "Computer Security", new ArrayList<Node>(Arrays.asList(graph.nodes.get(3), graph.nodes.get(10))));
		graph.addNode("CSC 317", "Introduction to Digital Image Processing", new ArrayList<Node>(Arrays.asList(graph.nodes.get(3), graph.nodes.get(0), graph.nodes.get(1))));
		graph.addNode("CSC 321", "Database Management Systems", new ArrayList<Node>(Arrays.asList(graph.nodes.get(7))));
		graph.addNode("CSC 331", "Operating Systems", new ArrayList<Node>(Arrays.asList(graph.nodes.get(3), graph.nodes.get(6), graph.nodes.get(7))));
		graph.addNode("CSC 336", "Data Communications and Networking II", new ArrayList<Node>(Arrays.asList(graph.nodes.get(10))));
		graph.addNode("CSC 345", "Programming Language Concepts and Paradigms", new ArrayList<Node>(Arrays.asList(graph.nodes.get(4), graph.nodes.get(7))));
		graph.addNode("CSC 400", "Internship", new ArrayList<Node>(Arrays.asList(graph.nodes.get(6), graph.nodes.get(7))));
		graph.addNode("CSC 402", "Software Engineering", new ArrayList<Node>(Arrays.asList(graph.nodes.get(7))));
		graph.addNode("CSC 404", "Software Engineering & Testing", new ArrayList<Node>(Arrays.asList(graph.nodes.get(6), graph.nodes.get(7))));
		graph.addNode("CSC 416", "Design and Construction of Compilers", new ArrayList<Node>(Arrays.asList(graph.nodes.get(4), graph.nodes.get(6), graph.nodes.get(7))));
		graph.addNode("CSC 417", "User Interfaces", new ArrayList<Node>(Arrays.asList(graph.nodes.get(7))));
		graph.addNode("CSC 466", "Distributed and Parallel Programming", new ArrayList<Node>(Arrays.asList(graph.nodes.get(5))));
		graph.addNode("CSC 468", "Introduction to Cloud Computing", new ArrayList<Node>(Arrays.asList(graph.nodes.get(5))));
		graph.addNode("CSC 471", "Modern Malware Analysis", new ArrayList<Node>(Arrays.asList(graph.nodes.get(8))));
		graph.addNode("CSC 472", "Software Security", new ArrayList<Node>(Arrays.asList(graph.nodes.get(8))));
		graph.addNode("CSC 476", "Game Development", new ArrayList<Node>(Arrays.asList(graph.nodes.get(7))));
		graph.addNode("CSC 481", "Artificial Intelligence", new ArrayList<Node>(Arrays.asList(graph.nodes.get(7))));
		graph.addNode("CSC 490", "Independent Project", new ArrayList<Node>(Arrays.asList(graph.nodes.get(4), graph.nodes.get(7))));
		graph.addNode("CSC 495", "Topics in Computer Science", new ArrayList<Node>(Arrays.asList(graph.nodes.get(7))));
		graph.addNode("CSC 496", "Topics in Complex Systems", new ArrayList<Node>(Arrays.asList(graph.nodes.get(7))));
		graph.addNode("CSC 497", "Topics in Computer Security", new ArrayList<Node>(Arrays.asList(graph.nodes.get(7))));
		graph.addNode("CSC 499", "Independent Study in Computer Science", new ArrayList<Node>(Arrays.asList(graph.nodes.get(7))));

		for (Node x: graph.nodes) {
			System.out.println(x.getCourse() + " -- " + x.getName() + "\n\t" + x.getPrereqs());
		}
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
	String number;
	String name;
	ArrayList<Node> prereqs;
	public Node(String number, String name, ArrayList<Node> prereqs) {
		this.number = number;
		this.name = name;
		this.prereqs = prereqs;
	}

	public String getCourse() {
		return this.number;
	}

	public String getName() {
		return this.name;
	}

	public ArrayList<Node> getPrereqs() {
		return this.prereqs;
	}
	public String toString() {
		return this.number;
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