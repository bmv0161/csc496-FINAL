import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;


public class Graph {
    private ArrayList<Node> courseList = null;

    public boolean contains(String courseNum) {
        for(Node x: courseList) {
            if(x.getCourse().equals(courseNum)) { return true; }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new URLParser().getClassList());
    }
}

enum Offerings {
    WINTER, SPRING, SUMMER, FALL
}

class Node {
    private String courseNum;
    private ArrayList<Node> prereq = null;

    public Node() {
    }
    public Node(String course) {
        this.courseNum = course;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }
    public void setPrereq(ArrayList<Node> prereq) {
        this.prereq = prereq;
    }
    public void addPrereq(Node course) {
        this.prereq.add(course);
    }

    public String toString() {
        return courseNum + " - " + prereq;
    }

    public String getCourse() {
        return this.courseNum;
    }
    public ArrayList<Node> getPrereq() {
        return this.prereq;
    }
}

class URLParser {
    private final String url =
            "https://www.wcupa.edu/sciences-mathematics/computerScience/undergradCourses.aspx";
    private Element table = null;
    private ArrayList<Node> courseList = new ArrayList<Node>();

    public URLParser() {
        try {
            Document doc = Jsoup.connect(url).get();
            table = doc.select("table.responsiveTable").get(0);
            //System.out.println(doc.outerHtml());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private void parseTable() {
        for(Element row: table.select("tr")) {
            Node course = new Node();
            for(Element col: row.select("td")) {
                if(col.attr("data-label").equals("Course Number")) {
                    Elements link = col.select("a");
                    String label = link.text();
                    course.setCourseNum(label);
                }else if(col.attr("data-label").equals("Prerequisites")) {
                    String prereq = col.text();

                    //System.out.println(col.);
                }
                courseList.add(course);

            }
        }
    }

    public ArrayList<Node> getClassList() {
        if(courseList.isEmpty()) {
            parseTable();
        }
        return courseList;
    }
}
