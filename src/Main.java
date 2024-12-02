import day2.RedNosedReports;

public class Main {
  public static void main(String[] args) {
    FileManager file = new FileManager("data/day2.txt");
    RedNosedReports rnr = new RedNosedReports(file.getString());
    System.out.println(rnr.getNumberSafe());
  }
}
