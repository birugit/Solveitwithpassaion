package com.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * 1. Topic: Streams, Iterable and Comparator
 * Sort the Item object, Customer requested from website like follows:
 * myonlineshop.com/item?sortField=todayDate&&ascendingOrder=false
 * <p>
 * if ascendingOrder is not specified, consider default to true
 * <p>
 * Method Signature:
 * private List<Item> sort(Iterable<Item> items, Date sortField, String ascendingOrder) {
 * <p>
 * return new ArrayList<>();
 * }
 * <p>
 * <p>
 * class Item{
 * private String itemName;
 * private Date todayItems;
 * <p>
 * //get
 * //set
 * <p>
 * }
 */
public class SortIterable {
    static class Item {
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
        SortIterable s = new SortIterable();
        Item macPro = new Item("Mac Book Pro", 3000.0);
        Item macAir = new Item("Mac Air", 1000.0);
        Item boseHeadSet = new Item("Bose headset", 300.0);
        Item fitBit = new Item("Fitbit", 300.0);

        Iterable<Item> itemList = Arrays.asList(macPro, macAir, boseHeadSet, fitBit);
        System.out.println("====Original Items List====");
        itemList.forEach(
                p -> {
                    System.out.println(p);
                }
        );
System.out.println();
        List<Item> res = s.sort(itemList);
        System.out.println("*****Items List Sorted*****");
        res.forEach(
                p -> System.out.println(p)
        );

    }

    private List<Item> sort(Iterable<Item> items) {
        ArrayList<Item> list = StreamSupport.stream(items.spliterator(), false)//true for parallel stream
                .sorted(
                        (a, b) -> {
                            if (a.price == b.price)
                                return a.name.compareToIgnoreCase(b.name);
                            else
                                return a.price.compareTo(b.price);
                        }

                ).collect(Collectors.toCollection(ArrayList::new));
        return list;
    }
  /*  Iterable<String> iterable
            = Arrays.asList("Testing", "Iterable", "conversion", "to", "Stream");

    List<String> result = StreamSupport.stream(iterable.spliterator(), false)
            .map(String::toUpperCase)
            .collect(Collectors.toList());

    assertThat(
            result, contains("TESTING", "ITERABLE", "CONVERSION", "TO", "STREAM"))*/
}
