import day3.MullItOver;

public class Main {
  public static void main(String[] args) {
    FileManager file = new FileManager("data/day3.txt");
    MullItOver mio = new MullItOver(file.getStringWithoutLineBreak());
    System.out.println(mio.getTotal());
  }
}
