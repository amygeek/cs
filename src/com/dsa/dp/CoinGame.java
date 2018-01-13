package com.dsa.dp;

public class CoinGame {

    public static int solve(int[] arr ) {
        int n = arr.length;
        
        int[][] res = new int[n][n];

        for (int interval = 0; interval < n; interval++) {
            for (int i = 0, j = interval; j < n; i++, j++) {
                // a = res(i+2,j) - Alice chooses i Bob chooses i+1
                // b = res(i+1,j-1)- Alice chooses i , Bob chooses j OR Alice chooses j , Bob chooses i
                // c = res(i,j-2)- Alice chooses j , Bob chooses j-1
                int a, b, c;
                if (i + 2 <= j) {
                    a = res[i + 2][j];
                } else {
                    a = 0;
                }
                //////////////////////////////////
                if (i + 1 <= j - 1)
                    b = res[i + 1][j - 1];
                else
                    b = 0;
                //////////////////////////////////
                if (i <= j - 2)
                    c = res[i][j-2];
                else
                    c = 0;
                //////////////////////////////////
                res[i][j] = Math.max(arr[i] + Math.min(a, b), arr[j]+ Math.min(b, c));
            }
        }
        return res[0][n - 1];
    }

    public static void main(String[] args) {
        int[] B = { 6, 9,1,2,16,8};
        System.out.println("Max value pick up by player1(Alice) " + solve(B));
    }

}