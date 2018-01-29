package com.dsa.dp;

import java.util.*;

/*
time: O(nm) n is the length of the start word and m is the number of like-sized words in the dictionary
space: O(n);
 */
public class WordLadder {

    /*
    beginWord = "hit"
    endWord = "cog"
    words = ["hot","dot","dog","lot","log","cog"]
    shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog"

        hit     hot     dot     dog     cog
                        lot
         1      2       3       4       5

         1      1
       2   3    2
     4  5   6   3
     */
    public int ladderLen( String beginWord, String endWord, List<String> words) {

        HashSet<String> set = new HashSet<>(words);

        if ( set.contains( beginWord ) ) {
            set.remove( beginWord );
        }

        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        queue.offer(beginWord);

        while ( !queue.isEmpty() ) {

            String word = queue.poll();
            int current = map.get( word );

            for (int i=0; i<word.length(); i++ ) {

                char[] chars = word.toCharArray();

                for (char j='a'; j<='z'; j++ ) {

                    chars[i] = j;

                    String temp = new String(chars);

                    if ( set.contains( temp ) ) {
                        if ( temp.equals( endWord ) ) {
                            return current + 1;
                        }
                        map.put(temp, current + 1 );
                        queue.offer(temp);
                        set.remove(temp);
                    }
                }
            }
        }
        return 0;
    }

    public static void main( String[] args ) {
        WordLadder w = new WordLadder();

        String start = "hit";
        String target = "cog";

        List<String> words = Arrays.asList("hot","dot","dog","lot","log","cog");

        int num = w.ladderLen(start, target, words);
        System.out.println( num );

    }
}