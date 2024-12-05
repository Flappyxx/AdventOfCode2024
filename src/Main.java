import day5.PrintQueue;

public class Main {
  public static void main(String[] args) {
    FileManager file = new FileManager("data/day5.txt");
    PrintQueue pq = new PrintQueue(file.getString());
    System.out.println(pq.getResponse());
  }
}
