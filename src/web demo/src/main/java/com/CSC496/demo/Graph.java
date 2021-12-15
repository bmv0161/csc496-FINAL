package com.CSC496.demo;

import java.util.ArrayList;
import java.util.Hashtable;

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

	public void addNode(Node node) {
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
	private void checkPrereqs(ArrayList<String> prereqs) {
		for(String x: prereqs) {
			if(!nodeHash.containsKey(x)) {
				addNode(new Node(x));
			}
		}
	}

	public ArrayList<Node> getCourses() {
		if(!update && !isEmpty()) {
			for(String x: nodeHash.keySet()) {
				courses.add(nodeHash.get(x));
			}
			update = true;
		}
		return courses;
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

	public String toString() {
		if(!update) { getCourses(); }

		String str = "";
		for (Node x: courses) {
			str += String.format("%s:\t%s\n", x.getCourse(), x.getPrereqs().toString());
		}
		return str;
	}
}


class Node {
	String course;
	String name;
	ArrayList<String> prereqs;

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

	public String getCourse() {
		return this.course;
	}
	public String getName() {
		return this.name;
	}
	public ArrayList<String> getPrereqs() {
		return prereqs;
	}

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
		return String.format("%s", course);
	}
}
