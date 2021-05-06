package com.techniques.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ParenthesesString{
    String str;
    int openCount;//open parentheses count
    int closeCount;//close parentheses count

    public ParenthesesString(String s,int openCount, int closeCount) {
        str = s;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}

/*
Time: 2^N leaf Nodes and 2^N-1 intermdeian node = 2^N + 2^N-1 => O(2^N), also current string with ( or ) ; total O(N*2^N_
Space: O2^N cobinations, O(N*2N)
 */
public class GenerateParentheses {

    public List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<>();
        Queue<ParenthesesString> queue = new LinkedList<>();
        queue.add(new ParenthesesString("", 0, 0));
        while (!queue.isEmpty()) {
            ParenthesesString ps = queue.poll();
            //if we have reached the maximum number of open and close parentheses, add the result
            if (ps.openCount == num && ps.closeCount == num) {
                result.add(ps.str);
            } else {
                if (ps.openCount < num)
                    queue.add(new ParenthesesString(ps.str + "(", ps.openCount + 1, ps.closeCount));
                    if (ps.openCount > ps.closeCount)// if we can add a close parentheses, add it
                        queue.add(new ParenthesesString(ps.str + ")", ps.openCount, ps.closeCount + 1));

            }

        }
        return result;
    }

    public List<String> generateParenthesesRecursive(int num){
        List<String> result = new ArrayList<>();
        char[] parenthesesString = new char[2 * num];
        generateValidParenthesesRecursive(num, 0, 0, parenthesesString, 0, result);
        return result;
    }

    private void generateValidParenthesesRecursive(int num, int openCount, int closeCount, char[] parenthesesString, int index, List<String> result) {
    if(openCount == num && closeCount == num){
        result.add(new String(parenthesesString));
    }else{
        if(openCount < num) {
            parenthesesString[index] = '(';
            generateValidParenthesesRecursive(num, openCount + 1, closeCount, parenthesesString,
                    index + 1, result);
        }
        if(openCount > closeCount){
            parenthesesString[index] = ')';
            generateValidParenthesesRecursive(num, openCount, closeCount + 1, parenthesesString, index +1,result);
        }
        }

    }

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        List<String> res = g.generateValidParentheses(3);
        System.out.println(res);

        List<String> recursive = g.generateParenthesesRecursive(3);
        System.out.println(recursive);
    }
}
