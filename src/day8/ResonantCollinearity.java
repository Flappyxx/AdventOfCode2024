package day8;

import java.util.ArrayList;

public class ResonantCollinearity {
  ArrayList<ArrayList<Node>> map;

  public ResonantCollinearity(String data){
    this.map = new ArrayList<>();
    String[] lines = data.split("\n");
    for (String line: lines) {
      ArrayList<Node> lineMap = new ArrayList<>();
      for (int i = 0; i < line.length(); i++) {
        lineMap.add(new Node(line.charAt(i)));
      }
      map.add(lineMap);
    }
  }

  public int getResult(){
    setResonance();
    return getNbResonance();
  }

  private void setResonance(){
    for (int i = 0; i < map.size(); i++) {
      for (int j = 0; j < map.get(i).size(); j++) {
        char character = map.get(i).get(j).value;
        if(character != '.'){
          map.get(i).get(j).resonance = true;
          for (int k = i; k < map.size(); k++) {
            for (int l = 0; l < map.get(k).size(); l++) {
              if(character == map.get(k).get(l).value && i != k && j != l){
                try{
                  int mult = 1;
                  while (true){
                    map.get(mult*(i-k)+i).get(mult*(j-l)+j).resonance = true;
                    mult++;
                  }
                }
                catch (Exception e){
                }
                try{
                  int mult = 1;
                  while (true){
                    map.get(mult*(k-i)+k).get(mult*(l-j)+l).resonance = true;
                    mult++;
                  }
                }
                catch (Exception e){

                }
              }
            }
          }
        }
      }
    }
  }

  private int getNbResonance(){
    int res = 0;
    for (int i = 0; i < map.size(); i++) {
      for (int j = 0; j < map.get(i).size(); j++) {
        if(map.get(i).get(j).resonance){
          res++;
        }else {
        }
      }
    }
    return res;
  }
}

class Node {
  char value;
  boolean resonance;

  public Node(char value){
    this.value = value;
    this.resonance = false;
  }
}