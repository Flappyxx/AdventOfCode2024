import day5.PrintQueue;
import day6.GuardGallivant;

public class Main {
  public static void main(String[] args) {
    FileManager file = new FileManager("data/day6.txt");
    GuardGallivant gg = new GuardGallivant(file.getString());
    System.out.println(gg.getNbInfiniteLoop());
  }
}
