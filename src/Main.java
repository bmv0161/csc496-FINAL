import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String args[]){
        Graph graph = new DataParser().getGraph();

        Graph copy = new Graph(graph);
        for(int i = 0; !copy.isEmpty(); i++) {
            System.out.println(copy);
            System.out.printf("Semester %d:\t%s\n\n",
                    i, new ClassScheduler(copy).planSemester());
        }
    }
}
class DataParser {
    Graph graph;
    String filePath = "./courses.txt";

    public DataParser() {
        graph = new Graph();
    }

    private Graph parseData() throws IOException{
        Scanner read = new Scanner(new File(filePath));

        while(read.hasNext()) {
            Node course = new Node();
            for (int i = 0; i < 4; i++) {
                switch (i) {
                    case 0 -> {
                        String str = read.nextLine();
                        str = str.replaceAll("\\s", "");
                        if(isCSC(str)) {
                            course.setCourse(str);
                        }
                    }
                    case 1 -> {
                        if(!course.getCourse().equals("")) {
                            course.setName(read.nextLine());
                        } else {
                            read.nextLine();
                        }
                    }
                    case 2 -> {
                        if(!course.getCourse().equals("")) {
                            String str = read.nextLine();
                            if (!str.equalsIgnoreCase("None")) {
                                for (String s : str.split(",")) {
                                    s = s.replaceAll("\\s", "");
                                    //s = s.substring(0,6);
                                    if(isCSC(s)) {
                                        course.addPrereq(s);
                                    }
                                }
                            }
                        } else {
                            read.nextLine();
                        }
                    }
                    case 3 -> read.nextLine();
                }
            }
            if(!course.getCourse().equals("")) {
                graph.addNode(course);
            }
        }

        return graph;
    }

    public boolean isCSC(String str) {
        return str.matches("CSC\\d\\d\\d");
    }

    public Graph getGraph(){
        if(graph.isEmpty()) {
            try {
                parseData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return graph;
    }
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
