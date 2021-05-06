package com.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author swamy on 1/25/21
 */
public class GroupBy {


    static class Item {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String name;
        Double price;

        public Item(String name, Double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }

    }
    public static void main(String[] args) {
        GroupBy g = new GroupBy();
        Item macPro = new Item("Mac Book Pro", 3000.0);
        Item macAir = new Item("Mac Air", 1000.0);
        Item boseHeadSet = new Item("Bose headset", 300.0);
        Item fitBit = new Item("Fitbit", 300.0);

        List<Item> itemList = Arrays.asList(macPro, macAir, boseHeadSet, fitBit);
        System.out.println("====Original Items List====");
        itemList.forEach(
                p -> {
                    System.out.println(p);
                }
        );

        ArrayList<Item> res = g.groupBy(itemList);
        System.out.println("====Filtered Items List====");
        res.forEach(e -> System.out.println(e));
    }

    private ArrayList<Item> groupBy(List<Item> itemList) {
      return (ArrayList<Item>) itemList.stream()
              .filter(e-> e.price >300)
              .collect(Collectors.groupingBy(e->e.name));

    }
}
