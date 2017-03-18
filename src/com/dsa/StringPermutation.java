package com.dsa;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> permutationList = getPermutations("abc");

        for(String s:permutationList) {
            System.out.println(s);
        }
    }
    public static ArrayList<String> getPermutations(String s) {
        ArrayList<String> permutations = new ArrayList<String>();
        if (s == null) {
            return null;
        } else if (s.length() == 0) {
            permutations.add("");
            return permutations;
        }
        char first = s.charAt(0); // get the first character
        String remainder = s.substring(1); // remove the first character
        ArrayList<String> words = getPermutations(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                permutations.add(insertCharAt(word, first, j));
            }
        }
        return permutations;
    }
    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }
}