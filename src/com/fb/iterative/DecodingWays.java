package com.fb.iterative;

/**
 * @author swamy on 3/10/21
 */
public class DecodingWays {
  public static void main(String[] args) {
      DecodingWays d = new DecodingWays();
      int res = d.decode("123");
      System.out.println(res);
  }

    private int decode(String s) {
      if (s.length() == 0)
          return 0;
      int n = s.length();
      int oneBack = 1;
      int twoBack = 1;
      for(int i =1; i< n; i++){
          int current = 0;
          if(s.charAt(i) != '0'){
              current = oneBack;
          }
          Integer twoDigit = Integer.parseInt(s.substring(i-1, i+1));
          if(twoDigit >=10 && twoDigit<=26){
              current += twoBack;
          }
          twoBack = oneBack;
          oneBack = current;
      }
      return oneBack;

    }
}
