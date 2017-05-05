package com.dsa;
public class MakeChange {
    public static int makeChange ( int n ) {
        int [] changes = {25, 10, 5, 1};
        int [][] map = new int[n+1][changes.length];
        return makeChange(n, changes, 0, map);
    }

    public static int makeChange( int amount, int[] changes, int index, int[][] map) {
        if (map[amount][index] > 0 ) {
            return map[amount][index];
        }

        if(index >= changes.length - 1) {
            return 1;
        }
        int changeAmount = changes[index];
        int ways = 0;

        for (int i=0; i * changeAmount < amount; i++ ) {
            int remainder = amount - i * changeAmount;
            ways += makeChange(remainder, changes, index+1, map);
        }

        map[amount][index] = ways;
        return  ways;
    }

    public static void main(String[] args) {
        int ways = makeChange(100);
        System.out.println(ways);
    }
}