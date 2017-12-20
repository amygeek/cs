package com.dsa;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.lang.String;

class IntPair {

    final int first;
    final int second;

    IntPair(int x, int y) {
        first = x;
        second = y;
    }
}

class Boggle {
    char[][] grid;
    Set<String> dictionary;
    boolean[][] state;
    int len;

    public Boggle(char[][] g, HashSet<String> d) {
        grid = g;
        dictionary = d;
        len = g.length;
        state = new boolean[len][len];
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                state[i][j]= false;
            }
        }
    }

    public HashSet<String> findAllWord() {
        StringBuilder current = new StringBuilder();
        HashSet<String> words = new HashSet<String>();
        for (int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                findAllWordsRec(i, j, current, words);
            }
        }
        return words;
    }

    public void findAllWordsRec(int i, int j, StringBuilder current, HashSet<String> words) {
        if ( current.length() > 0 && dictionary.contains( current.toString() ) ) {
            words.add( current.toString() );
        }

        ArrayList<IntPair> neighbors = findNeighbors(i, j);

        for (IntPair p: neighbors ) {
            current.append( grid[p.first][p.second] );
            state[p.first][p.second] = true;
            findAllWordsRec( p.first, p.second, current, words);
            current.setLength(current.length() - 1);
            state[p.first][p.second] = false;
        }
    }

    public ArrayList<IntPair> findNeighbors (int x, int y) {
        int startX = Math.max(0, x-1);
        int startY = Math.max(0, y-1);
        int endX = Math.min(len -1, x +1);
        int endY = Math.min(len - 1, y+1);
        ArrayList<IntPair> neighbors = new ArrayList<IntPair>();
        for(int i=startX; i<=endX ; i++) {
            for(int j=startY; j<=endY; j++) {
                if (state[i][j]) {
                    continue;
                }
                neighbors.add( new IntPair(i, j) );
            }
        }
        return neighbors;
    }

    public static void main (String[] args) {
        char[][] g = {
                {'c', 'a', 't'},
                {'r', 'r', 'e'},
                {'t', 'o', 'n'}};

//        char[][] g = new char[3][3];
//        g[0][0] = 'c';
//        g[0][1] = 'a';
//        g[0][2] = 't';
//        g[1][0] = 'r';
//        g[1][1] = 'r';
//        g[1][2] = 'e';
//        g[2][0] = 't';
//        g[2][1] = 'o';
//        g[2][2] = 'n';
        
        HashSet dict = new HashSet();
        dict.add("cat");
        dict.add("cater");
        dict.add("art");
        dict.add("toon");
        dict.add("moon");
        dict.add("not");
        dict.add("eat");
        dict.add("ton");

        Boggle b = new Boggle(g, dict);

        HashSet<String> words = b.findAllWord();

        for(String word: words) {
            System.out.print(word + ' '); //art ton not cater cat eat
        }
    }
}
