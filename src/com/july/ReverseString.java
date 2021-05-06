package com.july;
/**
 Given an input string, reverse the string word by word.



 Example 1:

 Input: "the sky is blue"
 Output: "blue is sky the"
 Example 2:

 Input: "  hello world!  "
 Output: "world! hello"
 Explanation: Your reversed string should not contain leading or trailing spaces.
 Example 3:

 Input: "a good   example"
 Output: "example good a"
 Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class ReverseString {
    public static void main(String[] args) {
        ReverseString r = new ReverseString();
        System.out.println(r.reverseWords("the sky is blue"));
    }
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuffer sBuff = new StringBuffer();
        for(int i=str.length-1;i>=0;i--){
            if(!str[i].isEmpty()){
                sBuff= sBuff.append(str[i]);
                if(i!=0){
                    sBuff.append(" ");
                }
            }

        }
        return sBuff.toString().trim();
    }
}
