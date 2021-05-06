package com.java8.funtionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalITest {
    public static void main(String[] args) {


        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        numbers.removeIf( number -> number%2 == 0 );

        System.out.println(numbers);

        List<String> studentName = Arrays.asList("unitQty", "entryId", "hana","stone");
        List<String> result = studentName.stream()	// Convert list to stream
                .filter(name -> !"hana".equals(name))	// remove "hana" hana from list
                .collect(Collectors.toList());			// collect the output and convert Stream to List
// print using method reference
        result.forEach(System.out::println);

        FulfilledUPC fulfilledUPC1 = new FulfilledUPC();
        fulfilledUPC1.setEntryId(12);
        fulfilledUPC1.setUpc("123456");

        FulfilledUPC  fulfilledUPC2 = new FulfilledUPC();
        fulfilledUPC2.setEntryId(123);
        fulfilledUPC2.setUpc("123457");

        FulfilledUPC  fulfilledUPC3 = new FulfilledUPC();
     //   fulfilledUPC3.setEntryId(123);
        fulfilledUPC3.setUpc("123458");

        List<FulfilledUPC> ffList = Arrays.asList(fulfilledUPC1,fulfilledUPC2);

   //    List<FulfilledUPC> l = ffList.stream().filter(eId -> !(eId.getEntryId() != null)).collect(Collectors.toList());

     //   Predicate<FulfilledUPC> condition = fulfilledUPC -> fulfilledUPC.getEntryId()>0;

      //  ffList.removeIf(e -> e.getEntryId() > 0);

    //    System.out.println(ffList);


        ffList.forEach(System.out::println);

      /*  private List<OrderLine> removeItemPriceAtOrderLine(List<OrderLine> orderLines) {
            return orderLines.stream()
                    .filter(orderLine -> {
                        return !(orderLine.getItemPrice()!= null);
                    })
                    .collect(Collectors.toList());
        }

        /**
         * Identifies the actual substituted Upcs
         * @param fulfilledUpc
         * @return fulfilledUPC list
         */

    }
    static class FulfilledUPC{
        public Integer getEntryId() {
            return entryId;
        }

        public void setEntryId(Integer entryId) {
            this.entryId = entryId;
        }

        Integer entryId;

        public String getUpc() {
            return upc;
        }

        public void setUpc(String upc) {
            this.upc = upc;
        }

        String upc;
    }
}
