import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileHandler {
  public File[]  readAllFiles(String srcFolderPath){
    File dir = new File(srcFolderPath);
    return dir.listFiles();
  }

  public String readFile(String filepath){
    try {
      return new String(Files.readAllBytes(Paths.get(filepath)));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void writeFile(String filename, String content) throws IOException {
    Files.writeString(Paths.get(filename),
        content,
        StandardOpenOption.CREATE,
        StandardOpenOption.TRUNCATE_EXISTING);
  }
}
