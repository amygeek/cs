package com.dsa.backtracking;

import java.util.HashSet;

public class WordBreak {

    public boolean findUsingDP(String s, HashSet<String> dict,
                               HashSet<String> cache, String answer) {
        if (s.length() == 0) {
            System.out.println(answer);
            return true;
        } else if (cache.contains(s)) {
            return false;
        } else {

            int index = 0;
            String word = "";
            while (index < s.length()) {
                word += s.charAt(index);// add one char at a time check if word already being solved
                if (dict.contains(word)) {
                    if (findUsingDP(s.substring(index + 1), dict, cache, answer + word + " ")) {
                        return true;
                    } else {
                        System.out.println("backtrack");
                        index++;
                    }
                } else {
                    index++;
                }
            }
            cache.add(s);// memoization for future;
            return false;
        }
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();
        set.add("this");
        set.add("is");
        set.add("sumit");
        set.add("jain");
        set.add("the");
        set.add("problem");
        String s = "thisissumitjain";

        WordBreak ws = new WordBreak();

        // create another HashSet so store the sub problems result
        HashSet<String> cache = new HashSet<String>();
        ws.findUsingDP(s, set, cache, "");
    }

}
