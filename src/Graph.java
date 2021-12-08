import java.util.ArrayList;

public class Graph {
    public ArrayList<Node> nodes = new ArrayList<>();

	public void addNode(String number, String name) {
		nodes.add(new Node(number, name));
	}
	public void addNode(String number, String name, ArrayList<Node> prereqs) {
		nodes.add(new Node(number, name, prereqs));
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
	public String toString() {
		return this.number;
	}
}
