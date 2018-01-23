package com.dsa.dp;

// Java program to find smallest window containing
// all characters of a pattern.

public class MinWindowStringMatch {

    static final int noOfChars = 256;

    // Function to find smallest window containing
    // all characters of 't'
    static String findSubString(String s, String t)
    {
        int sLen = s.length();
        int tLen = t.length();

        // check if string's length is less than pattern's
        // length. If yes then no such window can exist
        if (sLen < tLen)
        {
            System.out.println("No such window exists");
            return "";
        }

        int hashStrT[] = new int[noOfChars];
        int hashStrS[] = new int[noOfChars];

        // store occurrence ofs characters of pattern
        for (int i = 0; i < tLen; i++)
            hashStrT[t.charAt(i)]++;

        int start = 0, start_index = -1, minLen = Integer.MAX_VALUE;

        // start traversing the string
        int count = 0;  // count of characters
        for (int j = 0; j < sLen ; j++)
        {
            // count occurrence of characters of string
            hashStrS[s.charAt(j)]++;

            // If string's char matches with pattern's char
            // then increment count
            if (hashStrT[s.charAt(j)] != 0 && hashStrS[s.charAt(j)] <= hashStrT[s.charAt(j)] ) {
                count++;
            }
               

            // if all the characters are matched
            if (count == tLen) {
                // Try to minimize the window i.e., check if
                // any character is occurring more no. of times
                // than its occurrence  in pattern, if yes
                // then remove it from starting and also remove
                // the useless characters.
                while ( hashStrS[s.charAt(start)] > hashStrT[s.charAt(start)]  || hashStrT[s.charAt(start)] == 0) {

                    if (hashStrS[s.charAt(start)] > hashStrT[s.charAt(start)]) {
                        hashStrS[s.charAt(start)]--;
                    }
                        
                    start++;
                }

                // update window size
                int windowLen = j - start + 1;
                if (minLen > windowLen) {
                    minLen = windowLen;
                    start_index = start;
                }
            }
        }

        // If no window found
        if (start_index == -1)
        {
            System.out.println("No such window exists");
            return "";
        }

        // Return substring starting from start_index
        // and length minLen
        return s.substring(start_index, start_index + minLen);
    }

    // Driver Method
    public static void main(String[] args)
    {
        String s = "this is a test string";
        String t = "tist";

//        String s = "ADOBECODEBANC";   //BANC
//        String t =  "ABC";

        System.out.print("Smallest window is : " + findSubString(s, t));
    }
}