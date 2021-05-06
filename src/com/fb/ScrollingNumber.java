package com.fb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * A Scrolling Number is a number that has two characterisitics:
 *
 * <p>No digits repeat themselves. All digits in the number "scroll" through themselves.
 *
 * @author swamy on 3/12/21
 */
public class ScrollingNumber {
  public static void main(String[] args) {
      findCombinations(100, 500);
  }

    public static void findCombinations(int a, int b) {

        boolean isFound = false;
        for (int c = a; c <= b; c++) {
            final Set<Integer> set = new HashSet<Integer>();
            final Map<Integer, Integer> map = new HashMap<>();
            final String number = String.valueOf(c);
            if (number.contains("0")) {
                continue;
            }
            for (int i = 0; i < number.length(); i++) {
                final int digit = number.charAt(i);
                set.add(digit);
                map.put(digit, i);
            }
            //repeating digits not allowed
            if (number.toCharArray().length != set.size()) {
                continue;
            }

            final int length = number.length();
            int j = 0;
            int k = 1;
            System.out.println(number);
            while (k <= length) {
                set.remove((int) number.charAt(j));
                System.out.println(number.charAt(j)+":"+map.get((int) number.charAt(j)));
                j = (number.charAt(j) + map.get((int) number.charAt(j))) % length;
                System.out.println(j);
                k++;
            }
            if (j == 0 && set.size() == 0) {
                System.out.println(number);
                isFound = true;
            }

        }
        if (!isFound) {
            System.out.println(-1);
        }

    /*    IntStream.range(100, 500).filter(ScrollingNumber::notContainsZero)
                .filter(ScrollingNumber::noDuplicateDigit)
                */



    }



    static boolean notContainsZero(int i){
    String s = String.valueOf(i);
        IntPredicate isTrue = index -> s.contains("0");
        return isTrue.equals("true");
    }

    static boolean noDuplicateDigit(int i){

        Set<Integer> sets = new HashSet<Integer>();
        Map<Integer, Integer> maps = new HashMap<>();
        sets.add(i);
       // maps.put(i, index);
        String s = String.valueOf(i);
      return  s.toCharArray().length != sets.size();

    }
}
