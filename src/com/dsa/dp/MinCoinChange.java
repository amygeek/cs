package com.dsa.dp;

/*
Given a amount ‘A’ and n coins,   v1<v2<v3<………..<vn . Write a program to find out minimum numbers of coins
required to make the change for the amount ‘A’.

Example:

Amount: 5
Coins [] = 1, 2, 3.

No of ways to make the change are : { 1,1,1,1,1} , {1,1,1,2}, {2,2,1},{1,1,3} and {3,2}.
So as we can see minimum number of coins required are 2 ( 3+2=5}.

We will maintain an array to store the optimal solutions for the smaller problems, say we call it as coinReq[]. length of this array will be amount+1. (starts with 0).
So coinReq[n] will be our final answer, minimum no of coins required to make change for amount ‘n‘.
Since we are using Bottom-up approach, so will start filling the coinReq[] from 0 to n. we will start solving it from the smaller possible amount which is 0 here.
We need 0 coins to make change for amount 0, so coinReq[0]=0.
We will use another array CC[] (size = number of coins )will store the solution for amount n with using all the coins, minimum of all these will the optimal solution for the amount.
Since we are finding the solution for all the amounts 0 to N, we have to reset CC[] every time ( for amount = 1 to N)
 */
public class MinCoinChange {


    public int minCoinDynamic(int amount, int[] coins) {
        int[] coinReq = new int[amount+1]; // this will store the optimal solution
        // for all the values -- from 0 to
        // given amount.
        int[] CC = new int[coins.length]; // resets for every smaller problems
        // and minimum in it is the optimal
        // solution for the smaller problem.
        coinReq[0] = 0; // 0 coins are required to make the change for 0
        // now solve for all the amounts
        for (int amt = 1; amt <= amount; amt++) {

            for (int j = 0; j < CC.length; j++) {
                CC[j] = -1;
            }
            // Now try taking every coin one at a time and fill the solution in
            // the CC[]
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= amt) { // check if coin value is less than
                    // amount
                    CC[j] = coinReq[amt - coins[j]] + 1; // if available,
                    // select the
                    // coin and add
                    // 1 to solution
                    // of
                    // (amount-coin
                    // value)
                }
            }
            //Now solutions for amt using all the coins is stored in CC[]
//			take out the minimum (optimal) and store in coinReq[amt]
            coinReq[amt]=-1;
            for(int j=1;j<CC.length;j++){
                if(CC[j]>0 && (coinReq[amt]==-1 || coinReq[amt]>CC[j])){
                    coinReq[amt]=CC[j];
                }
            }
        }
        //return the optimal solution for amount
        return coinReq[amount];

    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 3 };
        int amount = 20;
        MinCoinChange m = new MinCoinChange();
        System.out.println("(Dynamic Programming) Minimum Coins required to make change for "
                + amount + " are: " + m.minCoinDynamic(amount, coins));
    }

}