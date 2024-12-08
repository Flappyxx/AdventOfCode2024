import day5.PrintQueue;
import day6.GuardGallivant;
import day7.BridgeRepair;
import day8.ResonantCollinearity;

public class Main {
  public static void main(String[] args) {
    FileManager file = new FileManager("data/day8.txt");
    ResonantCollinearity rc = new ResonantCollinearity(file.getString());
    System.out.println(rc.getResult());
  }
}
