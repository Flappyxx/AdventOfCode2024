package day7;

import java.math.BigInteger;
import java.util.ArrayList;

public class BridgeRepair {
  ArrayList<BigInteger> results;
  ArrayList<ArrayList<BigInteger>> numbers;

  public BridgeRepair(String data){
    results = new ArrayList<>();
    numbers = new ArrayList<>();
    String[] lines = data.split("\n");
    for (String line : lines) {
      String[] dataLine = line.split(":");
      results.add(new BigInteger(dataLine[0]));
      String[] numbers = dataLine[1].trim().split(" ");
      ArrayList<BigInteger> numberLine = new ArrayList<>();
      for (String number : numbers) {
        numberLine.add(new BigInteger(number));
      }
      this.numbers.add(numberLine);
    }
  }

  public String getResult(){
    BigInteger res = new BigInteger("0");
    for (int i = 0; i < results.size(); i++) {
      ArrayList<BigInteger> resultsArray = calculate(numbers.get(i));
      if(resultsArray.contains(results.get(i))){
        res = res.add(results.get(i));
      }
    }
    return res.toString();
  }

  private ArrayList<BigInteger> calculate(ArrayList<BigInteger> numbers){
    if(numbers.size() > 1){
      ArrayList<BigInteger> add = new ArrayList<>(numbers);
      add.add(0,(add.remove(1).add(add.remove(0))));

      ArrayList<BigInteger> mult = new ArrayList<>(numbers);
      mult.add(0,(mult.remove(1).multiply(mult.remove(0))));

      ArrayList<BigInteger> concat = new ArrayList<>(numbers);
      String number2 = concat.remove(1).toString();
      String number1 = concat.remove(0).toString();
      concat.add(0,new BigInteger(number1 + number2));
      
      ArrayList<BigInteger> res =  calculate(add);
      res.addAll(calculate(mult));
      res.addAll(calculate(concat));
      return res;
    }
    return numbers;
  }
}
