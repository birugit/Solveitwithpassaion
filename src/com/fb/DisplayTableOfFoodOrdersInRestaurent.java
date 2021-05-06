package com.fb;

import java.util.*;

/**
 * Given the array orders, which represents the orders that customers have done in a restaurant.
 * More specifically orders[i]=[customerNamei,tableNumberi,foodItemi] where customerNamei is the
 * name of the customer, tableNumberi is the table customer sit at, and foodItemi is the item
 * customer orders.
 *
 * <p>Return the restaurant's “display table”. The “display table” is a table whose row entries
 * denote how many of each food item each table ordered. The first column is the table number and
 * the remaining columns correspond to each food item in alphabetical order. The first row should be
 * a header whose first column is “Table”, followed by the names of the food items. Note that the
 * customer names are not part of the table. Additionally, the rows should be sorted in numerically
 * increasing order.
 *
 * <p>Example 1:
 *
 * <p>Input: orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried
 * Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]] Output:
 * [["Table","Beef Burrito","Ceviche","Fried
 * Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
 * Explanation: The displaying table looks like: Table,Beef Burrito,Ceviche,Fried Chicken,Water 3 ,0
 * ,2 ,1 ,0 5 ,0 ,1 ,0 ,1 10 ,1 ,0 ,0 ,0 For the table 3: David orders "Ceviche" and "Fried
 * Chicken", and Rous orders "Ceviche". For the table 5: Carla orders "Water" and "Ceviche". For the
 * table 10: Corina orders "Beef Burrito".
 *
 * @author swamy on 2/25/21
 */
public class DisplayTableOfFoodOrdersInRestaurent {
  public static void main(String[] args) {
      DisplayTableOfFoodOrdersInRestaurent d = new DisplayTableOfFoodOrdersInRestaurent();

      List<String> order1 = Arrays.asList(new String[]{"David", "3", "Ceviche"});

      List<String> order2 = Arrays.asList(new String[]{"Corina","10","Beef Burrito"});
      List<String> order3 = Arrays.asList(new String[]{"David","3","FriedChicken"});
      List<String> order4 = Arrays.asList(new String[]{"Carla","5","Water"});
      List<String> order5 = Arrays.asList(new String[]{"Carla","5","Ceviche"});
      List<String> order6 = Arrays.asList(new String[]{"Rous","3","Ceviche"});

    List<List<String>>   orders = Arrays.asList(order1, order2, order3, order4, order5, order6);
      List<List<String>> res = d.displayTable(orders);

      res.forEach(System.out::println);
  }

    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> result = new ArrayList();
        HashMap<String, Integer> hm = new HashMap();
        ArrayList<String> menu = new ArrayList();
        for (List<String> str:orders) {
            if(!hm.containsKey(str.get(2))) {
                hm.put(str.get(2), 1);
                menu.add(str.get(2));
            }
        }
        Collections.sort(menu);
        menu.add(0, "Table");
        result.add(menu);
        for (int i=1; i<menu.size(); i++) {
            hm.put(menu.get(i), i);
        }
        int[][] count = new int[501][];
        for (List<String> str:orders) {
            int table = Integer.valueOf(str.get(1));
            if (count[table] == null) {
                count[table] = new int[menu.size()];
                count[table][0] = table;
            }
            count[table][hm.get(str.get(2))]++;
        }
        for (int i=1; i<501; i++) {
            if (count[i] != null) {
                List<String> cnt = new ArrayList<String>();
                for (int j=0; j<count[i].length; j++) {
                    cnt.add(String.valueOf(count[i][j]));
                }
                result.add(cnt);
            }
        }
        return result;
    }
}
