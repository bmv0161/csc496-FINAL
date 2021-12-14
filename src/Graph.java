import java.util.ArrayList;
import java.util.Hashtable;

public class Graph {
    private ArrayList<Node> courses;
	private Hashtable<String, Node> nodeHash;

	public Graph() {
		courses = new ArrayList<>();
		nodeHash = new Hashtable<>();
	}

	public Graph(Graph graph) {
		courses = new ArrayList<>();
		nodeHash = new Hashtable<>();

		for(Node x: graph.getCourses()) {
			addNode(new Node(x));
		}
	}

	public String toStringHash() {
		return nodeHash.toString();
	}

	public void addNode(Node node) {
		if(nodeHash.containsKey(node.getCourse())) {
			nodeHash.replace(node.getCourse(), node);
		} else {
			nodeHash.put(node.getCourse(), node);
		}
	}
	public void addNode(String course) {
		this.addNode(new Node(course));
	}
	public void addNode(String course, String name) {
		this.addNode(new Node(course, name));
	}
	public void addNode(String course, String name, ArrayList<String> prereqs) {
		this.addNode(new Node(course, name, prereqs));
		for(String x: prereqs) {
			if(!nodeHash.containsKey(x)) {
				addNode(new Node(x));
			}
		}
	}

	private void setCourses() {
		if(courses.isEmpty() && !isEmpty()) {
			for(String x: nodeHash.keySet()) {
				courses.add(nodeHash.get(x));
			}
		}
	}

	public void removeNode(Node node) {
		for(Node x: courses) {
			x.removePrereq(node.getCourse());
		}
		courses.remove(node);
		nodeHash.remove(node.getCourse());
	}


	public boolean isEmpty() {
		return nodeHash.isEmpty();
	}

	public ArrayList<Node> getCourses() {
		setCourses();
		return courses;
	}

	public String toString() {
		setCourses();

		String str = "";
		for (Node x: courses) {
			str += String.format("%s:\t%s\n", x.getCourse(), x.getPrereqs());
		}
		return str;
	}
}


class Node {
	String course;
	String name;
	ArrayList<String> prereqs;

	public Node(Node node) {
		this.course = node.getCourse();
		this.name = node.getName();
		this.prereqs = new ArrayList<>(node.getPrereqs());
	}
	public Node(String number) {
		this.course = number;
		this.name = "";
		prereqs = new ArrayList<>();
	}
	public Node(String number, String name) {
		this.course = number;
		this.name = name;
		prereqs = new ArrayList<>();
	}
	public Node(String number, String name, ArrayList<String> prereqs) {
		this.course = number;
		this.name = name;
		this.prereqs = prereqs;
	}

	public String getCourse() {
		return this.course;
	}
	public String getName() {
		return this.name;
	}
	public ArrayList<String> getPrereqs() {
		return prereqs;
	}

	public void addPrereq(String node) {
		prereqs.add(node);
	}
	public void removePrereq(String node) {
		prereqs.remove(node);
	}

	public boolean hasPrereqs() {
		return !prereqs.isEmpty();
	}

	public String toString() {
		return this.course;
	}
}
