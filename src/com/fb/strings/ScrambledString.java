package com.fb.strings;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author swamy on 3/12/21
 */
public class ScrambledString {
  public static void main(String[] args) {
      ScrambledString s = new ScrambledString();
    //  boolean res =  s.isScramble("","");
     // System.out.println(res);
      boolean res1 = s.isScrambleRecusrive("great","rgeat");
      System.out.println(res1);
  }

    /**
     * recursive
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScrambleRecusrive(String s1, String s2) {

        if(s1.equals(s2))
            return true;

        int[] letters = new int[26];
        for(int i=0;i<s1.length();i++)
        {
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }

    /*    Stream<Object> let = Stream.of(s1, s2).map(i -> {
            letters[s1.charAt(Integer.parseInt(i))- 'a']++;
            letters[s2.charAt(Integer.parseInt(i))- 'a']--;
            return letters;
        });*/


     /*   for(int i=0;i<26;i++)
        {
            if(letters[i]!=0)
                return false;
        }*/
        IntStream intStream1 = Arrays.stream(letters);
        boolean nonZero = intStream1.anyMatch( n ->n>0);
          if(nonZero)
            return false;

        int n = s1.length();
        for(int i=1;i<s1.length();i++)
        {
            boolean cond1= isScrambleRecusrive(s1.substring(0,i),s2.substring(0,i))
                    && isScrambleRecusrive(s1.substring(i),s2.substring(i));

            boolean cond2 = isScrambleRecusrive(s1.substring(0,i), s2.substring(n-i))
                    && isScrambleRecusrive(s1.substring(i), s2.substring(0,n-i));

            if(cond1==true || cond2==true)
                return true;
        }

        return false;
    }


  /**
   * dp[i][j][1] indiates whether s1(i) equals to s2(j) and third dimension represents length.
   * dp[i][j][k] indicates whether s1(i, i+k) can be changed from s2(j, j+k). if dp[i][j][l] and
   * dp[i+l][j+l][k-l] are true, dp[i][j][k] is true. You can understand as which s1(i, i+l) and
   * s2(j, j+l) is scramble and s1(i+l, i+k) and s2(j+l, j+k) is scramble, so s1(i, i+k) and s2(j,
   * j+k) is scramble. There is same argument. if dp[i][j+k-l][l] and dp[i+l][j][k-l] are true,
   * dp[i][j][k] is true.
   *
   * @param s1
   * @param s2
   * @return
   */
  public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        int m = s1.length();
        int n = s2.length();
        if (m != n) return false;

        boolean[][][] dp = new boolean[m][m][m+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }

      for (int k = 2; k <= m; k++) {
          for (int i = 0; i <= m - k; i++) {
              for (int j = 0; j <= m - k; j++) {
                  dp[i][j][k] = false;
                  for (int l = 1; l < k; l++) {
                      if ((dp[i][j][l] && dp[i+l][j+l][k-l])
                              || (dp[i][j+k-l][l] && dp[i+l][j][k-l])) {
                          dp[i][j][k] = true;
                      }
                  }
              }
          }
      }
        return dp[0][0][s1.length()];
    }
}
