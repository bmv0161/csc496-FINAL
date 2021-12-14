import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

public class URLParser {
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
                    if(isCSC(label)) {
                        System.out.print(label + " - ");
                        //course.setCourseNum(label);
                    }
                }else if(col.attr("data-label").equals("Prerequisites") && course.getCourse() != null) {
                    String prereq[] = new String[0];
                    if(!col.text().isBlank()) {
                        prereq = col.text().split(",");
                        for(String x: prereq) {
                            x = x.trim();
                            if(isCSC(x)) {
                                System.out.print(x + " ");
                                //courseList.add(new Node(x));
                            }
                        }
                    }
                }
                System.out.println();
                //courseList.add(course);

            }
        }
    }

    public boolean isCSC(String course) {
        return course.startsWith("CSC");
    }

    public ArrayList<Node> getClassList() {
        if(courseList.isEmpty()) {
            parseTable();
        }
        return courseList;
    }
}
