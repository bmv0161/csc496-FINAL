import java.util.ArrayList;
import java.util.Hashtable;

//Stores list of courses in Hashtable and outputs them as unordered Arraylist of Nodes
public class Graph {
    private ArrayList<Node> courses;
	private Hashtable<String, Node> nodeHash;
	private boolean update;

	public Graph() {
		courses = new ArrayList<>();
		nodeHash = new Hashtable<>();
		update = true;
	}

	public Graph(Graph graph) {
		this();
		for(Node x: graph.getCourses()) {
			addNode(new Node(x));
		}
	}

	//Adds node to Hashtable
	public void addNode(Node node) {
		//replace if incomplete entry exists else put Node in hashtable
		if(nodeHash.containsKey(node.getCourse())) {
			nodeHash.replace(node.getCourse(), node);
		} else {
			nodeHash.put(node.getCourse(), node);
		}
		if(node.hasPrereqs()) {
			checkPrereqs(node.getPrereqs());
		}
		update = false;
	}
	//Overloading addNode
	public void addNode(String course) {
		this.addNode(new Node(course));
	}
	public void addNode(String course, String name) {
		this.addNode(new Node(course, name));
	}
	public void addNode(String course, String name, ArrayList<String> prereqs) {
		this.addNode(new Node(course, name, prereqs));
		checkPrereqs(prereqs);
	}
	//used by addNode methods to add Prerequisite nodes if not already in table
	private void checkPrereqs(ArrayList<String> prereqs) {
		for(String x: prereqs) {
			if(!nodeHash.containsKey(x)) {
				addNode(new Node(x));
			}
		}
	}
	//sets Arraylist of courses if not in sync with HashTable and returns Arraylist
	public ArrayList<Node> getCourses() {
		if(!update && !isEmpty()) {
			for(String x: nodeHash.keySet()) {
				courses.add(nodeHash.get(x));
			}
			update = true;
		}
		return courses;
	}

	//removes node from each prerequisite list and hashtable
	public void removeNode(Node node) {
		getCourses();
		for(Node x: courses) {
			x.removePrereq(node.getCourse());
		}
		courses.remove(node);
		nodeHash.remove(node.getCourse());
	}
	//return given node from graph
	public Node getNode(String str) {
		return nodeHash.get(str);
	}
	public Node getNode(Node node) {
		return nodeHash.get(node.getCourse());
	}

	//checks if given node is a prereq to any other node in the graph
	public boolean isPrereq(Node node) {
		for(String str: nodeHash.keySet()) {
			if(getNode(str).hasPrereq(node.getCourse())) {
				return true;
			}
		}
		return false;
	}
	public boolean isPrereq(String str) {
		return isPrereq(getNode(str));
	}
	//checks if hashtable is empty
	public boolean isEmpty() {
		return nodeHash.isEmpty();
	}

	//Prints out course number and prereqs
	public String toString() {
		if(!update) { getCourses(); }

		String str = "";
		for (Node x: courses) {
			str += String.format("%s:\t%s\n", x.getCourse(), x.getPrereqs().toString());
		}
		return str;
	}
}

//Stores Course info and Prerequisites
class Node {
	String course;
	String name;
	ArrayList<String> prereqs;

	//Overloading constructors
	public Node() {
		course = "";
		name = "";
		prereqs = new ArrayList<>();
	}
	public Node(Node node) {
		this.course = node.getCourse();
		this.name = node.getName();
		this.prereqs = new ArrayList<>(node.getPrereqs());
	}

	public Node(String number) {
		this();
		this.course = number;
	}
	public Node(String number, String name) {
		this();
		this.course = number;
		this.name = name;
	}
	public Node(String number, String name, String[] prereqs) {
		this();
		this.course = number;
		this.name = name;
		setPrereqs(prereqs);
	}
	public Node(String number, String name, ArrayList<String> prereqs) {
		this.course = number;
		this.name = name;
		this.prereqs = prereqs;
	}

	//getter methods
	public String getCourse() {
		return this.course;
	}
	public String getName() {
		return this.name;
	}
	public ArrayList<String> getPrereqs() {
		return prereqs;
	}

	//setter methods
	public void setCourse(String course) {
		this.course = course;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrereqs(String[] prereqs) {
		for(String x: prereqs) {
			this.prereqs.add(x);
		}
	}

	//prerequisite handling
	public void addPrereq(String node) {
		prereqs.add(node);
	}
	public void removePrereq(String node) {
		prereqs.remove(node);
	}
	//checks if course has prerequisites
	public boolean hasPrereqs() {
		return !prereqs.isEmpty();
	}
	//checks if course has given prerequisite course
	public boolean hasPrereq(String str) {
		return prereqs.contains(str);
	}

	//returns course number
	public String toString() {
		return String.format("%s", course);
	}
}
