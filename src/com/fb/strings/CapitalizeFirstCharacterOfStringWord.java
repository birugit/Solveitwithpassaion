package com.fb.strings;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author swamy on 3/12/21
 */
public class CapitalizeFirstCharacterOfStringWord {
  public static void main(String[] args) {
    String res = capitalizeFirstCharacter("i want this sentance capitalized");
    System.out.println(res);

    upperCaseAllFirstCharacter("i want this sentance capitalized");

  }

    private static String capitalizeFirstCharacter(String word) {
     return Stream.of(word.trim().split("\\s"))
              .filter(w -> w.length() >0)
              .map(w -> w.substring(0,1).toUpperCase()+ w.substring(1))
              .collect(Collectors.joining(""));
    }

    /**
     * \b word boundary
     * . any character
     * (..) define a group
     * * matches zero or more occurances
     * ? matches zero or one occurance
     * @param text
     */
    public static void upperCaseAllFirstCharacter(String text) {
        String regex = "\\b(.)(.*?)\\b";
        String result = Pattern.compile(regex).matcher(text).replaceAll(
                matche -> matche.group(1).toUpperCase() + matche.group(2)
        );

        System.out.println(result);
    }
}
