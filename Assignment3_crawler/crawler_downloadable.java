package crawler;
import java.io.IOException;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.opencsv.CSVWriter;
public class crawler_downloadable {
    static boolean getOccuringChar(String str) {
        int count = 0;
        for(int i=0; i<str.length(); ++i) {
            if(str.charAt(i)=='/') {
                if(count++ > 7) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        ArrayList <String> url_List = new ArrayList<>();
        Set <String> url_Set = new HashSet<>();
        Set <String> pdf_Set = new HashSet<>();
        String url = "https://pec.ac.in";
        url_List.add(url);
        url_Set.add(url);
        String curr_Url;

        CSVWriter csvwriter_Pdf = new CSVWriter(new FileWriter(new File("pdf.csv")));
        String[] header_Pdf = { "pdfURL" };
        csvwriter_Pdf.writeNext(header_Pdf);

        for (int i=0; i<url_List.size(); i++) {
            try {
                curr_Url = url_List.get(i);
                Document doc = Jsoup.connect(currUrl).get();
                Elements links = doc.select("a[href]");
                for (Element link: links) {
                    String page_url = link.absUrl("href");
                    if(!page_url.contains("http")) {
                        page_url = "https://pec.ac.in" + page_url;
                    }
                    if ((!url_Set.contains(page_url)) && page_url.contains("https://pec.ac.in/") && getOccuringChar(page_url)) {
                        if (page_url.endsWith(".pdf") && !pdf_Set.contains(page_url)) {
                            csvwriter_Pdf.writeNext(new String[] { page_url });
                            pdf_Set.add(page_url);
                        } else {
                            url_List.add(page_url);
                            url_Set.add(page_url);
                        }
                    }
                }
                Elements i_frame = doc.select("iframe");
                for (Element frame: i_frame) {
                    String page_url = frame.attr("data-src");

                    if (!url_Set.contains(page_url) && page_url.contains("https://pec.ac.in/") && page_url.endsWith(".pdf") && !pdf_Set.contains(page_url) && getOccuringChar(page_url)) {
                        csvwriter_Pdf.writeNext(new String[] { page_url });
                        pdf_Set.add(page_url);
                    }
                }
                System.out.println("URL: " + curr_Url);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        csvwriter_Pdf.close();
    }
}
