package day1;

import java.util.ArrayList;
import java.util.Collections;

public class HistorianHysteria {
  ArrayList<Integer> array1;
  ArrayList<Integer> array2;

  public HistorianHysteria(String data){
    array1 = new ArrayList<>();
    array2 = new ArrayList<>();
    String[] res = data.split("(\n|   )");
    boolean i = true;
    for (String number : res) {
      int nb = Integer.parseInt(number.trim());
      if(i){
        array1.add(nb);
      }else{
        array2.add(nb);
      }
      i = !i;
    }
    Collections.sort(array1);
    Collections.sort(array2);
  }

  public int getDifference(){
    int res = 0;
    for (int i = 0; i< array1.size();i++){
      res += Math.abs(array1.get(i)-array2.get(i));
    }
    return res;
  }

  public int getSimilarity(){
    int res = 0;
    for (int nb1 : array1) {
      int repetition = 0;
      for (int nb2 : array2) {
        if(nb1 == nb2) repetition++;
      }
      res += nb1 * repetition;
    }
    return res;
  }
}
