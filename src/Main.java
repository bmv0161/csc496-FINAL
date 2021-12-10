import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        Graph graph = new Graph();
        createGraph(graph);

        printGraph(graph);
        new ClassScheduler(new Graph(graph)).planGraduation();

        //printGraph(graph);
    }

    public static void printGraph(Graph graph) {
        for (Node x: graph.getCourses()) {
            System.out.println(x.getCourse() + " --\t" + x.getPrereqs());
        }
        System.out.println();
    }

    public static void createGraph(Graph graph) {
        graph.addNode("MAT 151", "Introduction to Discrete Mathematics");
        graph.addNode("MAT 161", "Calculus I");
        graph.addNode("CSC 141", "Computer Science I", new String[]{"MAT 151"});
        graph.addNode("CSC 142", "Computer Science II", new String[]{"MAT 151", "MAT 161", "CSC 141"});
        graph.addNode("CSC 220", "Foundations of Computer Science", new String[]{"MAT 161", "CSC 142"});
    }
/*
    public static void createGraph2(Graph graph) {
        graph.addNode("MAT 151", "Introduction to Discrete Mathematics");
        graph.addNode("MAT 161", "Calculus I");
        graph.addNode("CSC 141", "Computer Science I");
        graph.addNode("CSC 142", "Computer Science II", new ArrayList<Node>(Arrays.asList(graph.nodes.get(2))));
        graph.addNode("CSC 220", "Foundations of Computer Science", new ArrayList<Node>(Arrays.asList(graph.nodes.get(0), graph.nodes.get(1))));
        graph.addNode("CSC 231", "Computer Systems", new ArrayList<Node>(Arrays.asList(graph.nodes.get(3))));
        graph.addNode("CSC 240", "Computer Science III", new ArrayList<Node>(Arrays.asList(graph.nodes.get(3))));
        graph.addNode("CSC 241", "Data Structures and Algorithms", new ArrayList<Node>(Arrays.asList(graph.nodes.get(0), graph.nodes.get(1), graph.nodes.get(6))));
        graph.addNode("CSC 242", "Computer Organization", new ArrayList<Node>(Arrays.asList(graph.nodes.get(3), graph.nodes.get(0))));
        graph.addNode("CSC 301", "Computer Security & Ethics");
        graph.addNode("CSC 335", "Data Communications and Networking I", new ArrayList<Node>(Arrays.asList(graph.nodes.get(7), graph.nodes.get(8))));
        graph.addNode("CSC 302", "Computer Security", new ArrayList<Node>(Arrays.asList(graph.nodes.get(3), graph.nodes.get(10))));
        graph.addNode("CSC 317", "Introduction to Digital Image Processing", new ArrayList<Node>(Arrays.asList(graph.nodes.get(7), graph.nodes.get(0), graph.nodes.get(1))));
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
    }
    */
}
