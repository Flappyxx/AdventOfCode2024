import day3.MullItOver;
import day4.CeresSearch;

public class Main {
  public static void main(String[] args) {
    FileManager file = new FileManager("data/day4.txt");
    CeresSearch cs = new CeresSearch(file.getString());
    System.out.println(cs.getnbXshapeMAS());
  }
}
