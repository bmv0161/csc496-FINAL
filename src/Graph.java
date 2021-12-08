import java.util.ArrayList;

public class Graph {
    protected ArrayList<Node> nodes = null;

	public Graph() {
		nodes = new ArrayList<Node>();
	}
	public Graph(Graph graph) {
		this.nodes = new ArrayList<Node>(graph.getCourses());
	}

	public void addNode(String number, String name) {
		nodes.add(new Node(number, name));
	}
	public void addNode(String number, String name, ArrayList<Node> prereqs) {
		nodes.add(new Node(number, name, prereqs));
	}

	public void removeNode(Node node) {
		for(Node x: nodes) {
			for(Node y: x.getPrereqs()) {
				if(y.getCourse().equals(node.getCourse())) {
					//x.removePrereq(y);
				}
			}
		}
		nodes.remove(node);
	}

	public ArrayList<Node> getCourses() {
		return nodes;
	}
}

enum Offerings {
    WINTER, SPRING, SUMMER, FALL
}

class Node {
	String number;
	String name;
	ArrayList<Node> prereqs;

	public Node(String number, String name) {
		this.number = number;
		this.name = name;
		prereqs = new ArrayList<Node>();
	}
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
	public void removePrereq(Node node) {
		prereqs.remove(node);
	}

	public String toString() {
		return this.number;
	}
}
