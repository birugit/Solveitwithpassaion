package com.techniques.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, find all of its permutations preserving the character sequence but changing case.
 * <p>
 * Example 1:
 * <p>
 * Input: "ad52"
 * Output: "ad52", "Ad52", "aD52", "AD52"
 * Example 2:
 * <p>
 * Input: "ab7c"
 * Output: "ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"
 */
public class StringPermutationsByChangingCase {
    public static void main(String[] args) {
        StringPermutationsByChangingCase s = new StringPermutationsByChangingCase();
        String str = "ad52";
        List<String> res = s.findStringPermutations(str);
        System.out.println(res);
    }

    List<String> findStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null)
            return permutations;
        permutations.add(str);

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                int size = permutations.size();
                for (int j = 0; j < size; j++) {
                    char[] chars = permutations.get(j).toCharArray();
                    if (Character.isUpperCase(chars[j]))
                        chars[i] = Character.toLowerCase(chars[i]);
                    else
                        chars[i] = Character.toUpperCase(chars[i]);
                    permutations.add(String.valueOf(chars));
                }

            }

        }
        return permutations;

    }
}
