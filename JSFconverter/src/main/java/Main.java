import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
  static final String srcFolderPath = "src/main/resources/src";
  static final String dstFolderPath = "src/main/resources/dst/";
  static final String pattern = "\\h*<h:graphicImage[^>]*>";

  public static void main(String[] args) throws IOException {
    FileHandler handler = new FileHandler();
    File[] directoryListing = handler.readAllFiles(srcFolderPath);
    if (directoryListing != null) {
      for (File file : directoryListing) {
        String content = handler.readFile(file.getPath());
        Parser parser = new Parser();
        List<String> matches = parser.matchMultiline(content, pattern);
        for(String s : matches){
//          System.out.println(s);
//          System.out.println(parser.mapToImg(s));
          content = content.replace(s, parser.mapToImg(s));
          handler.writeFile(dstFolderPath + file.getName(), content);
        }
      }
    }
  }
}