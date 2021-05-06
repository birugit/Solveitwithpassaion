package com.strings;

public class IsSubsequence {
    public static void main(String[] args) {
        String source = "abc";
        String target = "ahbgdc";
      //  boolean res = IsSubsequence.findSubsequence(source, target);
       // System.out.println(res);

        boolean isSub =IsSubsequence.isSubsequenceDP(source, target);
        System.out.println(isSub);
    }

    public static boolean findSubsequence(String source, String target){
        int leftP = 0, rightP = 0;
        int sourceL = source.length(), targetL = target.length();
        while(leftP < sourceL && rightP < targetL){
            if(source.charAt(leftP) == target.charAt(rightP)){
                leftP +=1;
            }
            rightP +=1;
        }
        return leftP== sourceL;
    }

    public static  boolean isSubsequenceDP(String s, String t) {

        Integer sourceLen = s.length(), targetLen = t.length();
        // the source string is empty
        if (sourceLen == 0)
            return true;

        int[][] dp = new int[sourceLen + 1][targetLen + 1];
        // DP calculation, we fill the matrix column by column, bottom up
        for (int col = 1; col <= targetLen; col++) {
            for (int row = 1; row <= sourceLen; row++) {
                if (s.charAt(row - 1) == t.charAt(col - 1))
                    // find another match
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                else
                    // retrieve the maximal result from previous prefixes
                    dp[row][col] = Math.max(dp[row][col - 1], dp[row - 1][col]);
            }
            // check if we can consume the entire source string,
            // with the current prefix of the target string.
            if (dp[sourceLen][col] == sourceLen)
                return true;
        }

        // matching failure
        return false;
    }
}
