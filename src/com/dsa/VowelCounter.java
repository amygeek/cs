package com.dsa;

/**
 * How to count number of vowels and consonants in a String?
 */

public class VowelCounter {

    public static void main(String args[]) {

        String str = "How many vowels in this String";
        char[] letters = str.toCharArray();
        int count = 0;
        for (char c : letters) {
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;
                    break;
                default:
                    // no count increment
                    }
        }
        System.out.println("Number of vowels in String [" + str + "] is : " + count);
    }
}
