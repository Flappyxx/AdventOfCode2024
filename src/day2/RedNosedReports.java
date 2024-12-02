package day2;
import java.util.ArrayList;

public class RedNosedReports {
  ArrayList<ArrayList<Integer>> reports;
  public RedNosedReports(String file){
    reports = new ArrayList<>();
    String[] lines = file.split("\n");
    for (String line: lines) {
      String[] data = line.split(" ");
      ArrayList<Integer> levels = new ArrayList<>();
      for (String level: data) {
        levels.add(Integer.parseInt(level));
      }
      reports.add(levels);
    }
  }

  public int getNumberSafe(){
    int nbSafe = 0;
    for (ArrayList<Integer> levels : reports) {
      if (isSafeWithDampener(levels)){
        nbSafe++;
      }
    }
    return nbSafe;
  }

  private static boolean isSafe(ArrayList<Integer> report) {
    for (int i = 0; i < report.size() - 1; i++) {
      int diff = Math.abs(report.get(i+1) - report.get(i));
      if (diff < 1 || diff > 3) {
        return false;
      }
    }

    boolean increasing = true;
    boolean decreasing = true;

    for (int i = 0; i < report.size() - 1; i++) {
      if (report.get(i) >= report.get(i+1)) {
        increasing = false;
      }
      if (report.get(i) <= report.get(i+1)) {
        decreasing = false;
      }
    }

    return increasing || decreasing;
  }

  private static boolean isSafeWithDampener(ArrayList<Integer> report) {
    if (isSafe(report)) {
      return true;
    }
    for (int i = 0; i < report.size(); i++) {
      ArrayList<Integer> modifiedReport = new ArrayList<>(report);
      modifiedReport.remove(i);
      if (isSafe(modifiedReport)) {
        return true;
      }
    }
    return false;
  }
}
