package com.aug;

/**
 Given a word, you need to judge whether the usage of capitals in it is right or not.

 We define the usage of capitals in a word to be right when one of the following cases holds:

 All letters in this word are capitals, like "USA".
 All letters in this word are not capitals, like "leetcode".
 Only the first letter in this word is capital, like "Google".
 Otherwise, we define that this word doesn't use capitals in a right way.


 Example 1:

 Input: "USA"
 Output: True


 Example 2:

 Input: "FlaG"
 Output: False
 */
public class DetectCapitals {
    public static void main(String[] args) {


    String word = "UsA";
      System.out.println(DetectCapitals.detectCapital(word));

    }

    private static boolean detectCapital(String word) {

        boolean match1 = true, match2 =true, match3=true;

        //case1: All upper cases :USA
        for(int i=0; i<word.length(); i++){
            if(!Character.isUpperCase(word.charAt(i))) {
                match1 = false;
                break;
            }

        }
        if(match1 )
            return true;

        //case2: all lower cases: coding
        for(int i=0; i<word.length(); i++){
            if(!Character.isLowerCase(word.charAt(i))){
                match2 = false;
                break;
            }
        }
        if( match2)
            return true;

        //case3: First upper, remaining small: India
        if(!Character.isUpperCase(word.charAt(0))){
            match3 = false;
        }else{
            if(match3){
                for(int i =1; i< word.length(); i++){
                    if(!Character.isLowerCase(word.charAt(i))){
                        match3 = false;
                        break;
                    }
                }
            }
        }
        if(match3)
            return true;

        return false;
    }
}
