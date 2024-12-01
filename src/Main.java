import day1.HistorianHysteria;

public class Main {
  public static void main(String[] args) {
    FileManager file = new FileManager("data/day1.txt");
    HistorianHysteria hh = new HistorianHysteria(file.getString());
    System.out.println(hh.getDifference());
    System.out.println(hh.getSimilarity());
  }
}
