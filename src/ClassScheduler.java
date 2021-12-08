import java.util.ArrayList;

public class ClassScheduler {
    private Graph graph = null;

    public ClassScheduler(Graph graph) {
        this.graph = graph;
    }

    public void planGraduation() {
        int i = 1;
        while(!graph.isEmpty()) {
            System.out.printf("Semester %d: %s\n", i, planSemester());
            i++;
        }
    }

    public String planSemester() {
        TopologySorter sort = new TopologySorter(graph);
        return sort.getSemesterPlan().toString();
        //System.out.println("---\t" + sort.getSemesterPlan());
    }
}

class TopologySorter {
    Graph graph = null;
    Graph newGraph = null;
    ArrayList<Node> semester = null;

    public TopologySorter(Graph graph) {
        this.graph = graph;
        this.semester = new ArrayList<Node>();
        sort();
    }

    public void sort() {
        for(Node x: graph.getCourses()) {
            if(x.hasPrereqs()) {
                //System.out.println(x.getCourse());
                semester.add(x);
            }
        }
        for(Node x: semester) {
            graph.removeNode(x);
        }
    }

    public ArrayList<Node> getSemesterPlan() {
        return semester;
    }
}
