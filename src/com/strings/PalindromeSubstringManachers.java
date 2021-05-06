package com.strings;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * Example 1:
 *
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 *
 * Example 2:
 *
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class PalindromeSubstringManachers {

    public static void main(String[] args) {
        PalindromeSubstringManachers palindromeSubstringManachers = new PalindromeSubstringManachers();
        String s = "aaa";
   //     int res = palindromeSubstringManachers.countSubstrings(s);
     //   System.out.println(res);

        System.out.println(palindromeSubstringManachers.countSubstringsExpand(s));
    }

    public int countSubstrings(String S) {
        char[] A = new char[2 * S.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';
        int t = 2;
        for (char c: S.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';
        }

        int[] Z = new int[A.length];
        int center = 0, right = 0;
        for (int i = 1; i < Z.length - 1; ++i) {

            /*
            if i<right , do reflection as we already have computed value
            Ex:
            @#a#a#a#$
            i=4 right=5 center =3
            this is the situation where we already computed the value of z[i]*/
            if (i < right)
                Z[i] = Math.min(right - i, Z[2 * center - i]);
            /*Expand around center if it matches
            Now, why is this algorithm linear? The while loop only checks the condition more than once when Z[i] = right - i.
            In that case, for each time Z[i] += 1, it increments right, and right can only be incremented up to 2*N+2 times.
             */
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1])
                Z[i]++;
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        //
       // longest substring
        int length = 0;   // length of longest palindromic substring
        int mid = 0;   // center of longest palindromic substring
        for (int i = 1; i < Z.length-1; i++) {
            if (Z[i] > length) {
                length = Z[i];
                mid = i;
            }
        }
        System.out.println("Longest Substring");
        System.out.println(S.substring((mid - 1 - length) / 2, (mid - 1 + length) / 2));

        //print all substrings
        System.out.println("Print All Substrings");
      for(int i =0; i< 2*S.length()+1; i++) {
          int len = Z[i + 2];
          int cen = i + 2;
         System.out.println( S.substring((cen - 1 - len) / 2, (cen - 1 + len) / 2));
      }

        //no of substrings
        System.out.println("Number of Substrings");
        int ans = 0;
        for (int v: Z)
            ans += (v + 1) / 2;
        return ans;
    }



    /*
    T: O(N^2) Each expansion do O(N) work
    S:O(n)
     */
    public int countSubstringsExpand(String S) {
        int N = S.length(), ans = 0;
        for (int center = 0; center <= 2*N-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}
