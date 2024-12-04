package day4;

import java.util.ArrayList;

public class CeresSearch {
  ArrayList<ArrayList<Character>> tab;

  public CeresSearch(String data){
    tab = new ArrayList<>();
    String[] lines = data.split("\n");
    for (String line: lines) {
      ArrayList<Character> tabLine = new ArrayList<>();
      for(int i =0; i < line.length();i++){
        tabLine.add(line.charAt(i));
      }
      tab.add(tabLine);
    }
  }

  public int getnbXMAS(){
    int res = 0;
    for(int row = 0;row < tab.size();row++){
      for(int column = 0; column < tab.get(row).size();column++){
        if(tab.get(row).get(column) == 'X'){
          boolean up = false;
          boolean down = false;
          boolean left = false;
          boolean right = false;
          if(row >= 3){
            up = true;
            if(tab.get(row-1).get(column) == 'M' && tab.get(row-2).get(column) == 'A' && tab.get(row-3).get(column) == 'S'){
              res++;
            }
          }
          if(row <= tab.size()-4){
            down = true;
            if(tab.get(row+1).get(column) == 'M' && tab.get(row+2).get(column) == 'A' && tab.get(row+3).get(column) == 'S'){
              res++;
            }
          }
          if(column >= 3){
            left = true;
            if(tab.get(row).get(column-1) == 'M' && tab.get(row).get(column-2) == 'A' && tab.get(row).get(column-3) == 'S'){
              res++;
            }
          }
          if(column <= tab.get(row).size()-4){
            right = true;
            if(tab.get(row).get(column+1) == 'M' && tab.get(row).get(column+2) == 'A' && tab.get(row).get(column+3) == 'S'){
              res++;
            }
          }

          if(up && right){
            if(tab.get(row-1).get(column+1) == 'M' && tab.get(row-2).get(column+2) == 'A' && tab.get(row-3).get(column+3) == 'S'){
              res++;
            }
          }

          if(up && left){
            if(tab.get(row-1).get(column-1) == 'M' && tab.get(row-2).get(column-2) == 'A' && tab.get(row-3).get(column-3) == 'S'){
              res++;
            }
          }

          if(down && right){
            if(tab.get(row+1).get(column+1) == 'M' && tab.get(row+2).get(column+2) == 'A' && tab.get(row+3).get(column+3) == 'S'){
              res++;
            }
          }

          if(down && left){
            if(tab.get(row+1).get(column-1) == 'M' && tab.get(row+2).get(column-2) == 'A' && tab.get(row+3).get(column-3) == 'S'){
              res++;
            }
          }
        }
      }
    }
    return res;
  }

  public int getnbXshapeMAS(){
    int res = 0;
    for(int row = 1;row < tab.size()-1;row++){
      for(int column = 1; column < tab.get(row).size()-1;column++){
        if(tab.get(row).get(column) == 'A') {
          char upright = tab.get(row-1).get(column+1);
          char upleft = tab.get(row-1).get(column-1);
          char downright = tab.get(row+1).get(column+1);
          char downleft = tab.get(row+1).get(column-1);
          if(upright == 'M' && upleft == 'M' && downright == 'S' && downleft == 'S'){
            res++;
          }
          if(upright == 'S' && upleft == 'S' && downright == 'M' && downleft == 'M'){
            res++;
          }
          if(upright == 'M' && upleft == 'S' && downright == 'M' && downleft == 'S'){
            res++;
          }
          if(upright == 'S' && upleft == 'M' && downright == 'S' && downleft == 'M'){
            res++;
          }

        }
      }
    }
    return res;
  }
}
