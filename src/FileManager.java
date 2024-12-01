import java.io.BufferedReader;
import java.io.FileReader;

public class FileManager {
  private String path;

  public FileManager(String path){
    this.path = path;
  }

  public String getString() {
    try{
      StringBuilder sb = new StringBuilder();
      FileReader fileReader = new FileReader(path);
      BufferedReader br = new BufferedReader(fileReader);
      String line;
      while((line = br.readLine()) != null){
        sb.append(line + "\n");
      }
      return sb.toString();
    }catch(Exception e){
      throw new RuntimeException(e.getMessage());
    }
  }
}
