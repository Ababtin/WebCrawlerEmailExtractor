import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class WebCrawlerEmailExtractor{
    private static final HashSet<String> visitedLinks = new HashSet<>(); 
    private static final String emailRegex = "Ali"; 
    private static int emailCount = 0; 
    private static final int MAX_EMAILS =700; 

    public static void main(String[] args) {
        String startUrl = "https://en.wikipedia.org/wiki/Ali"; 
        String outputFile = "found_emails.txt"; 
        try (FileWriter writer = new FileWriter(outputFile)) {
            crawl(startUrl, writer); 
            System.out.println(emailCount + " emails written successfully to " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
    public static void crawl(String url, FileWriter writer) {
        if (visitedLinks.contains(url) || emailCount >= MAX_EMAILS) { 
            return;
        }
        try {
            visitedLinks.add(url);
            Document document = Jsoup.connect(url).get();
            extractEmails(document.text(), writer);
            if (emailCount >= MAX_EMAILS) {
                return;
            }
            Elements links = document.select("a[href]"); 
            for (Element link : links) {
                String nextUrl = link.absUrl("href"); 
                if (!nextUrl.isEmpty() && nextUrl.startsWith("https://ccis.ksu.edu.sa")) { 
                    crawl(nextUrl, writer); 
                }
                if (emailCount >= MAX_EMAILS) {
                    return;
                }
            }
        } catch (IOException e) {
           
        }
    }
    public static void extractEmails(String text, FileWriter writer) throws IOException {
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find() && emailCount < MAX_EMAILS) {
            String email = matcher.group();
            writer.write(email + "\n"); 
            emailCount++;
        }
    }
}