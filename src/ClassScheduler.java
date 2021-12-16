import java.util.ArrayList;

//interface for ClassScheduler program
public interface ClassScheduler {
    public String planSemester();
    public void planGraduation();
    public Graph getGraph();
}

//Base Class scheduler implementing Topology sort through SemesterPlanner
class ClassSchedulerBase implements ClassScheduler {
    protected Graph graph;

    public ClassSchedulerBase(Graph graph) {
        this.graph = graph;
    }

    public Graph getGraph() {
        return graph;
    }

    public void planGraduation() {
        for(int i = 1; !graph.isEmpty(); i++ ) {
            System.out.printf("Semester %d: %s\n", i, planSemester());
        }
    }

    public String planSemester() {
        return new SemesterPlanner(graph).toString();
    }
}
//Creates arraylist of courses available to take next semester
class SemesterPlanner {
    protected Graph graph;
    protected ArrayList<Node> semester;

    public SemesterPlanner() {
        graph = new Graph();
        semester = new ArrayList<>();
    }
    public SemesterPlanner(Graph graph) {
        this.graph = graph;
        this.semester = new ArrayList<>();
        sort();
    }
    //implements topology sort to add available courses to semester list and removes that course from graph
    public void sort() {
        for(Node x: graph.getCourses()) {
            if(!x.hasPrereqs()) {
                semester.add(x);
            }
        }
        for(Node x: semester) {
            graph.removeNode(x);
        }
    }

    public ArrayList<Node> getSemester() {
        return semester;
    }

    public String toString() {
        return semester.toString();
    }
}

//Bonus 1: ClassScheduler with cap of 3 courses each semester through SemesterPlannerCap
class ClassSchedulerCap extends ClassSchedulerBase {
    public ClassSchedulerCap(Graph graph) {
        super(graph);
    }

    public String planSemester() {
        return new SemesterPlannerCap(graph).toString();
    }
}
//Creates semester plan with cap of 3 courses each semester
class SemesterPlannerCap extends SemesterPlanner {
    private final int CAP = 3;
    ArrayList<Node> stack;

    public SemesterPlannerCap(Graph graph) {
        this.graph = graph;
        this.stack = new ArrayList<>();
        sort();
    }
    //Implements topology sort to create semester list
    //Finds most efficient plan by prioritizing taking courses that are prerequisites for other courses earlier
    //Thereby, maximizing the number of courses taken each semester
    public void sort() {
        for(Node x: graph.getCourses()) {
            if(!x.hasPrereqs() && (semester.size() < CAP)) {
                if(graph.isPrereq(x)) {
                    semester.add(x);
                } else {
                    stack.add(0,x);
                }
            }
        }
        while(semester.size() < CAP && !stack.isEmpty()) {
            semester.add(stack.remove(0));
        }

        for(Node x: semester) {
            graph.removeNode(x);
        }
    }
}
