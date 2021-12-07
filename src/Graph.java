import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;


public class Graph {
    public static void main(String[] args) {
        new URLParser().getClassList();
    }
}

enum Offerings {
    WINTER, SPRING, SUMMER, FALL
}

class Node {
    private String course;
    private ArrayList<Node> prereq = null;

    public Node(String course) {
        this.course = course;
    }
    public Node(String course) {
        this.course = course;
    }

    public String getCourse() {
        return this.course;
    }
    public Node getPrereq() {
        return this.prereq;
    }
}

class URLParser {
    private final String url =
            "https://www.wcupa.edu/sciences-mathematics/computerScience/undergradCourses.aspx";
    private Element table = null;
    private ArrayList<Node> classList = new ArrayList<>();

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
            for(Element col: row.select("td")) {
                if(col.attr("data-label").equals("Course Number")) {
                    Elements link = col.select("a");
                    String label = link.text();
                    System.out.println(label);
                }else if(col.attr("data-label").equals("Prerequisites")) {
                    System.out.println(col.text());
                    //System.out.println(col.);
                }

            }
        }
    }

    public ArrayList<Node> getClassList() {
        if(classList.isEmpty()) {
            parseTable();
        }
        return classList;
    }
}
