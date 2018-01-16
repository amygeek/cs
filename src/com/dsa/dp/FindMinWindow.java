package com.dsa.dp;

/**
 * Given a set T of characters and a string S, find the minimum window in S which will contain all the characters in T in complexity O(n).

 eg,
 S = “ADOBECODEBANC”
 T = “ABC”

 Minimum window is “BANC”.
 */
public class FindMinWindow {

    // Returns false if no valid window is found. Else returns
// true and updates minWindowBegin and minWindowEnd with the
// starting and ending position of the minimum window.
    static boolean minWindow(char[] S, char[] T, int minWindowBegin, int minWindowEnd) {
        int sLen = S.length;
        int tLen = T.length;
        int[] needToFind = new int[256];

        for (int i = 0; i < tLen; i++)
            needToFind[T[i]]++;

        int[] hasFound = new int[256];
        int minWindowLen = Integer.MAX_VALUE;
        int count = 0;
        for (int begin = 0, end = 0; end < sLen; end++) {
            // skip characters not in T
            if (needToFind[S[end]] == 0) {
                continue;
            }

            hasFound[S[end]]++;
            if (hasFound[S[end]] <= needToFind[S[end]]) {
                count++;
            }

            // if window constraint is satisfied
            if (count == tLen) {
                // advance begin index as far right as possible,
                // stop when advancing breaks window constraint.
                while (needToFind[S[begin]] == 0 || hasFound[S[begin]] > needToFind[S[begin]]) {
                    if (hasFound[S[begin]] > needToFind[S[begin]]) {
                        hasFound[S[begin]]--;
                    }

                    begin++;
                }

                // update minWindow if a minimum length is met
                int windowLen = end - begin + 1;
                if (windowLen < minWindowLen) {
                    minWindowBegin = begin;
                    minWindowEnd = end;
                    minWindowLen = windowLen;
                } // end if
            } // end if
        } // end for

        return (count == tLen) ? true : false;
    }

    public static void main (String[] args) {
        String s = "ADOBECODEBANC";
        String t =  "ABC";

        System.out.println(minWindow(s.toCharArray(), t.toCharArray(), 0, 0));
    }
}

