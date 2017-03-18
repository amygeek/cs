package com.dsa;

public class UniqueCharacters {
    /**
     * @param args
     */
    public static void main(String[] args) {

        String s1 = "Apple";
        String s2 = "Pear";

        System.out.println(s1 + " is unique? " + isUnique( s1.toLowerCase() ) );
        System.out.println(s2 + " is unique? " + isUnique( s2.toLowerCase() ) );

    }
    public static boolean isUnique(String str) {
        //create a boolean array
        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            //get ASCII value of characters
            int val = str.charAt(i);
            //Check in the boolean array if it is unique then set the value to true at corresponding index position
            //if value is already set at the required index position then return false
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
}