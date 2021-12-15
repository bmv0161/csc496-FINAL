import java.util.ArrayList;

public interface ClassScheduler {
    public String planSemester();
    public void planGraduation();

}

class ClassSchedulerBase implements ClassScheduler {
    protected Graph graph;

    public ClassSchedulerBase(Graph graph) {
        this.graph = graph;
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

class ClassSchedulerCap extends ClassSchedulerBase {
    public ClassSchedulerCap(Graph graph) {
        super(graph);
    }

    public String planSemester() {
        return new SemesterPlannerCap(graph).toString();
    }
}
class SemesterPlannerCap extends SemesterPlanner {
    private final int CAP = 3;
    ArrayList<Node> stack;

    public SemesterPlannerCap(Graph graph) {
        this.graph = graph;
        this.stack = new ArrayList<>();
        sort();
    }

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
