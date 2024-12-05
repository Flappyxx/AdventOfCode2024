package day5;

import java.util.ArrayList;

public class PrintQueue {
  ArrayList<ArrayList<Integer>> pagesArray;
  ArrayList<Order> pageOrder;

  public PrintQueue(String data){
    pagesArray = new ArrayList<>();
    pageOrder = new ArrayList<>();
    String[] extract = data.split("\n\n");
    String[] pageOrderExtract = extract[0].split("\n");
    String[] pagesExtract = extract[1].split("\n");

    for (String pageExtract: pagesExtract) {
      ArrayList<Integer> page = new ArrayList<>();
      String[] numbers = pageExtract.split(",");
      for (String number: numbers) {
         page.add(Integer.parseInt(number));
      }
      pagesArray.add(page);
    }

    for (String order : pageOrderExtract) {
      String[] numbers = order.split("\\|");
      pageOrder.add(new Order(Integer.parseInt(numbers[0]),Integer.parseInt(numbers[1])));
    }
  }

  public int getResponse() {
    int res = 0;
    for (ArrayList<Integer> pages: pagesArray) {
      if(!isGoodOrder(pages)){
        ArrayList<Integer> orderPages = reorder(pages);
        res += orderPages.get((orderPages.size()-1)/2);
      }
    }
    return res;
  }

  public ArrayList<Integer> reorder(ArrayList<Integer> pages){
    ArrayList<Integer> result = new ArrayList<>();
    result.add(pages.get(0));

    for (int i = 1; i < pages.size(); i++) {
      int pos = 0;

      loop : while (true){
        while (true){
          for (Order order: pageOrder) {
            if(pos == result.size()){
              result.add(pages.get(i));
              break loop;
            }
            if(pages.get(i) == order.before && result.get(pos) == order.next){
              result.add(pos,pages.get(i));
              break loop;
            }
            if(pages.get(i) == order.next && result.get(pos) == order.before){
              pos++;
            }
          }
        }
      }

    }

    return result;
  }

  public boolean isGoodOrder(ArrayList<Integer> pages){
    ArrayList<Integer> alreadyChecked = new ArrayList<>();
    for (int page: pages) {
      for (Order order: pageOrder) {
        if(order.next == page){
          if(!alreadyChecked.contains(order.before) && pages.contains(order.before)){
            return false;
          }
        }
      }
      alreadyChecked.add(page);
    }
    return true;
  }
}

class Order {
  int before;
  int next;

  public Order(int before,int next){
    this.next = next;
    this.before = before;
  }
}
