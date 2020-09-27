package crawler;
import java.util.*;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.opencsv.CSVWriter;
public class crawler_focused {
    private static final List<String> faculty= new LinkedList<>();
    public static boolean link_related(String link) {
        for(String str : faculty)
        {
            if(link.contains(str) ) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        ArrayList <String> url_List = new ArrayList<>();
        Set <String> url_Set = new HashSet<>();
        String url = "https://pec.ac.in/";
        url_List.add(url);
        url_Set.add(url);
        String curr_Url;
        faculty.addAll(Arrays.asList(("faculty research programmes campus administration members committee institute department centres professor prof assistant teacher teaching engineer doctor scholar chairman qualification director phd ").split(" ")));

        CSVWriter csvwriter_Url = new CSVWriter(new FileWriter(new File("faculty_urls.csv")));
        CSVWriter csvwriter_Tag = new CSVWriter(new FileWriter(new File("faculty_text.csv")));
        String[] header_Url = { "TextForURL", "URL" };
        String[] header_Tag = { "TypeOfTag", "TextEnclosed" };
        csvwriter_Url.writeNext(header_Url);
        csvwriter_Tag.writeNext(header_Tag);

        for (int i = 0; i < url_List.size(); i++) {
            try {
                curr_Url = url_List.get(i);
                Document doc = Jsoup.connect(curr_Url).get();
                String title = doc.title();
                if (curr_Url.contains("faculty")) {
                    csvwriter_Tag.writeNext(new String[] {});
                    csvwriter_Tag.writeNext(new String[] { "url: " + (i + 1), curr_Url });
                    csvwriter_Tag.writeNext(new String[] { "titleTag", title });
                }
                Elements links = doc.select("a[href]");
                for (Element link: links) {
                    String page_url, url_Text;
                    page_url = link.absUrl("href");
                    if(!page_url.contains("http")) {
                        page_url = "https://pec.ac.in" + page_url;
                    }
                    url_Text = link.text();
                    if ((!url_Set.contains(page_url)) && url_Text.length() > 0) {
                        if (link_related(page_url)) {

                            if (curr_Url.contains("faculty")) {
                                csvwriter_Url.writeNext(new String[] {});
                                csvwriter_Url.writeNext(new String[]{url_Text, page_url});
                            }
                            url_Set.add(page_url);
                            url_List.add(page_url);
                        }
                    }
                }
                if (curr_Url.contains("faculty")) {
                    Elements paragraph_Tag = doc.select("p");
                    for (Element p: paragraph_Tag) {
                        String text;
                        text = p.text();
                        if (text.length() > 2) {
                            csvwriter_Tag.writeNext(new String[] { "p", text });
                        }
                    }

                    Elements h1_Tag = doc.select("h1");
                    for (Element h: h1_Tag) {
                        String text;
                        text = h.text();
                        if (text.length() > 0) {
                            csvwriter_Tag.writeNext(new String[] { "h1", text });
                        }
                    }
                    System.out.println("URL: " + curr_Url);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        csvwriter_Tag.close();
        csvwriter_Url.close();
    }	
}

