import java.util.ArrayList;
import java.util.Hashtable;

public class Graph {
    protected ArrayList<Node> nodes;
	private Hashtable<String, Node> nodeHash;

	public Graph() {
		nodes = new ArrayList<>();
		nodeHash = new Hashtable<>();
	}
	public Graph(Graph graph) {
		nodes = new ArrayList<>();
		nodeHash = new Hashtable<>();

		for(Node x: graph.getCourses()) {
			if(x.hasPrereqs()) {
				this.addNode(x.getCourse(), x.getName(), x.getPrereqsString());
			} else {
				this.addNode(x.getCourse(), x.getName());
			}
		}
	}

	public void addNode(String number, String name) {
		Node node = new Node(number, name);
		nodes.add(node);
		nodeHash.put(number, node);
	}
	/*
	public void addNode(String number, String name, ArrayList<Node> prereqs) {
		nodes.add(new Node(number, name, prereqs));
	}
	 */

	public void addNode(String number, String name, String[] prereqs) {
		Node node = new Node(number, name);
		for(String x: prereqs) {
			if(nodeHash.containsKey(x)) {
				node.addPrereq(nodeHash.get(x));
			}
		}
		nodes.add(node);
		nodeHash.put(number, node);
	}

	public void removeNode(Node node) {
		for(Node x: nodes) {
			x.removePrereq(node);
		}
		nodes.remove(node);
	}

	public boolean isEmpty() {
		return nodes.isEmpty();
	}

	public ArrayList<Node> getCourses() {
		return nodes;
	}
}


class Node {
	String number;
	String name;
	ArrayList<Node> prereqs;

	public Node(String number, String name) {
		this.number = number;
		this.name = name;
		prereqs = new ArrayList<>();
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

	public void addPrereq(Node node) {
		prereqs.add(node);
	}
	public void removePrereq(Node node) {
		prereqs.remove(node);
	}
	public String[] getPrereqsString() {
		String[] strArray = new String[prereqs.size()];
		if(this.hasPrereqs()) {
			for(int i = 0; i < strArray.length; i++) {
				strArray[i] = prereqs.get(i).getCourse();
			}
		}

		return strArray;
	}
	public ArrayList<Node> getPrereqs() {
		return prereqs;
	}
	public boolean hasPrereqs() {
		return !prereqs.isEmpty();
	}

	public String toString() {
		return this.number;
	}
}
