import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

//Creates Graph from DataParser and outputs graduation plan from ClassSchedulerCap semester by semester
public class Main {
    public static void main(String args[]){
        Graph graph = new DataParser().getGraph();

        printAlgorithm("base topology sorter",
                new ClassSchedulerBase(new Graph(graph)), new ClassSchedulerBase(new Graph(graph)));
        printAlgorithm("topology sorter with cap",
                new ClassSchedulerCap(new Graph(graph)), new ClassSchedulerCap(new Graph(graph)));
    }
    
    public static void printAlgorithm(String title, ClassScheduler scheduler, ClassScheduler copy) {
        System.out.printf("~~~   %s   ~~~\n\n", title.toUpperCase());
        scheduler.planGraduation();
        System.out.println();
        stepThroughGraduationPlan(copy);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void stepThroughGraduationPlan(ClassScheduler scheduler) {
        Graph graph = scheduler.getGraph();
        for(int i = 1; !graph.isEmpty(); i++) {
            System.out.println(graph);
            System.out.printf("Semester %d:\t%s\n\n",
                    i, scheduler.planSemester());
        }
    }
}


//creates Graph object based on output from web_scraper.py
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
