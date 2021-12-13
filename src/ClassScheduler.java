import java.util.ArrayList;

public class ClassScheduler {
    private Graph graph;

    public ClassScheduler(Graph graph) {
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
    Graph graph;
    ArrayList<Node> semester;

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
