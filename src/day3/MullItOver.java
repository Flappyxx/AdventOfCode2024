package day3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MullItOver {
  String data;

  public MullItOver(String data){
    this.data = data;
  }

  public int getTotal(){
    int res = 0;
    boolean ok = true;
    Pattern pattern = Pattern.compile("(mul\\(-?[0-9]+,-?[0-9]+\\))|(do\\(\\))|(don't\\(\\))");
    Matcher matcher = pattern.matcher(data);
    while (matcher.find()){
      String multiplication = matcher.group();
      if(multiplication.equals("do()")){
        ok = true;
        continue;
      }
      if(multiplication.equals("don't()")){
        ok = false;
        continue;
      }
      int nb1 = Integer.parseInt(multiplication.substring(multiplication.indexOf("(")+1,multiplication.indexOf(",")));
      int nb2 = Integer.parseInt(multiplication.substring(multiplication.indexOf(",")+1,multiplication.indexOf(")")));
      if(ok){
        res += nb1 * nb2;
      }
    }
    return res;
  }
}
