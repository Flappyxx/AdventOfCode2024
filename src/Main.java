import day5.PrintQueue;
import day6.GuardGallivant;
import day7.BridgeRepair;

public class Main {
  public static void main(String[] args) {
    FileManager file = new FileManager("data/day7.txt");
    BridgeRepair br = new BridgeRepair(file.getString());
    System.out.println(br.getResult());
  }
}
