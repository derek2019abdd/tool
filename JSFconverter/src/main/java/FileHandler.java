import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileHandler {
  public String readFile(String filepath){
    try {
      return new String(Files.readAllBytes(Paths.get(filepath)));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  public void writeFile(String filepath, String content) throws IOException {
    Files.write(Paths.get(filepath),
        content.getBytes(StandardCharsets.UTF_8),
        StandardOpenOption.CREATE,
        StandardOpenOption.TRUNCATE_EXISTING);
  }
}
