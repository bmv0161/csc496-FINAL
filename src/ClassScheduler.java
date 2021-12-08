import java.util.ArrayList;

public class ClassScheduler {
    private Graph graph = null;

    public ClassScheduler(Graph graph) {
        this.graph = graph;
    }

    public void planSemester() {
        TopologySorter sort = new TopologySorter(graph);
        System.out.println(sort.getSemesterPlan());
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
        for(Node x: new ArrayList<Node>(graph.getCourses())) {
            if(x.getPrereqs().isEmpty()) {
                //System.out.println(x.getCourse());
                semester.add(x);
                graph.removeNode(x);
            }
        }
    }

    public ArrayList<Node> getSemesterPlan() {
        return semester;
    }
}
