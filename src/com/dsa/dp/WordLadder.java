package com.dsa.dp;

import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;


class Item {

    String word;
    int len;

    public Item( String word, int len ) {
        this.word = word;
        this.len = len;
    }
}

public class WordLadder {

    //check both length of a and b. If the length differed by only 1 char, return true; otherwise return false
    public boolean isAdjacent ( String a, String b ) {
        int n = a.length();
        int count = 0;

        for ( int i=0; i<n; i++ ) {

            if ( a.charAt(i) != b.charAt(i)) {
                count++;
            }
            if ( count > 1 ) {
                return false;
            }
        }

        return (count == 1) ? true: false;
    }

    public int shortestChainLen (String start, String target, Set<String> dict ) {

        LinkedList<Item> q = new LinkedList<Item>();
        Item item = new Item(start, 1);
        q.add(item);

        while (!q.isEmpty() ) {

            //remove item from front of the queue
            Item current = q.remove();

            for (Iterator<String> i = dict.iterator(); i.hasNext();) {

                String word = i.next();

                if ( this.isAdjacent( current.word, word )) {

                    item.word = word;
                    item.len = current.len + 1;
                    q.add(item);

                    //System.out.print(item.word + " -> ");

                    // Remove adjacent item from dictionary so that this word is not processed again.  This is like marking visited
                    i.remove();

                    // If we reached target, return the length. we can also return the chained item list, we just need to loop through the item
                    if ( word == target ) {

                        return item.len;
                    }

                }
            }
        }

        return 0;
    }

    public static void main( String[] args ) {
        WordLadder w = new WordLadder();

        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("cog");
        String start = "hit";
        String target = "cog";

//        String start = "TOON";
//        String target = "PLEA";
//
//        dict.add("POON");
//        dict.add("PLEE");
//        dict.add("SAME");
//        dict.add("POIE");
//        dict.add("PLEA");
//        dict.add("PLIE");
//        dict.add("POIN");

        //int num = w.ladderLength(start, target, dict);
        int num = w.shortestChainLen(start, target, dict);
        System.out.println( num );

    }
}