import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  static final String filepath = "src/main/resources/example.jsp";
  static final String pattern = "<h:graphicImage[^>]*>";

  public static void main(String[] args) throws IOException {
    FileHandler handler = new FileHandler();
    String content = handler.readFile(filepath);
    Parser parser = new Parser();
    List<String> matches = parser.matchMultiline(content, pattern);
    for(String s : matches){
      System.out.println(s);
      System.out.println(parser.mapper(s));
      content = content.replace(s, parser.mapper(s));
    }
    handler.writeFile("src/main/resources/output.jsp", content);
  }
}