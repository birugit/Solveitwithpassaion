package com.fb.dp.bottomup;

/**
 * @author swamy on 3/10/21
 */
public class DecodeWays {
  public static void main(String[] args) {
      DecodeWays d = new DecodeWays();
      int res = d.decode("123");
      System.out.print(res);
  }

    private int decode(String s) {
      int[] dp = new int[s.length()+1];
      dp[0] = 1;
      dp[1] = s.charAt(0)== '0'? 0: 1;
      for(int i = 2; i< dp.length; i++){
          if(s.charAt(i-1) != '0')
          dp[i] += dp[i - 1];
          Integer twoDigit = Integer.valueOf(s.substring(i-2, i));
          if(twoDigit >=10 && twoDigit<=26){
              dp[i] += dp[i - 2];
          }
      }
      return dp[s.length()];
    }
}
