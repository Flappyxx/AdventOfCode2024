package day6;

import java.util.ArrayList;

public class GuardGallivant {
  ArrayList<ArrayList<Node>> map;
  int x;
  int y;


  public GuardGallivant(String data){
    String[] lines = data.split("\n");
    int nbLine = 0;
    map = new ArrayList<>();
    for (String line: lines) {
      ArrayList<Node> nodeLine = new ArrayList<>();
      for (int i = 0; i < line.length(); i++) {
        switch (line.charAt(i)){
          case '.':{
            nodeLine.add(new Node(false));
            break;
          }
          case '#':{
            nodeLine.add(new Node(true));
            break;
          }
          case '^':{
            this.x = i;
            this.y = nbLine;
            nodeLine.add(new Node(false));
            break;
          }
        }
      }
      nbLine++;
      map.add(nodeLine);
    }
  }

  public int getResponse(){
    explore();
    return getNbVisited();
  }

  private int getNbVisited(){
    int res =0;
    for (ArrayList<Node> nodeLine: map) {
      for (Node node: nodeLine) {
        if(node.visited){
          res++;
        }
      }
    }
    return res;
  }
  public int getNbInfiniteLoop(){
    int res = 0;
    int initX = x;
    int initY = y;
    for (ArrayList<Node> nodeLine: map) {
      for (Node node: nodeLine) {
        x = initX;
        y = initY;
        if(!node.isObstacle){
          node.isObstacle = true;
          try {
            explore();
          }catch (Exception e){
            res++;
          }
          node.isObstacle = false;
        }
      }
    }
    return res;
  }

  private void explore(){
    int direction = 0;//0: up, 1: right, 2: down, 3: left
    int nbStep = 0;
    while (x>=0 && x<map.get(0).size() && y>=0 && y< map.size()){
      map.get(y).get(x).visited = true;
      switch (direction){
        case 0:{
          if(y > 0){
            if(map.get(y-1).get(x).isObstacle){
              direction = 1;
            }
            else {
              y--;
            }
          }
          else{
            y--;
          }
          break;
        }
        case 1:{
          if(x < map.get(0).size()-1){
            if(map.get(y).get(x+1).isObstacle){
              direction = 2;
            }
            else {
              x++;
            }
          }
          else {
            x++;
          }
          break;
        }
        case 2:{
          if(y < map.size()-1){
            if(map.get(y+1).get(x).isObstacle){
              direction = 3;
            }
            else {
              y++;
            }
          }
          else {
            y++;
          }
          break;
        }
        case 3:{
          if(x > 0){
            if(map.get(y).get(x-1).isObstacle){
              direction = 0;
            }
            else {
              x--;
            }
          }
          else {
            x--;
          }
          break;
        }
      }
      nbStep++;
      if(nbStep >= 100000){
        throw new RuntimeException();
      }
    }
  }

}

class Node {
  boolean visited;
  boolean isObstacle;

  public Node(boolean isObstacle){
    this.isObstacle = isObstacle;
    this.visited = false;
  }
}
