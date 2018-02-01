package com.dsa.dp;

/**
 * If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be carried out in only one way.
 * Drop the egg from the first-floor window; if it survives, drop it from the second floor window. Continue upward until it breaks.
 * In the worst case, this method may require 36 droppings. Suppose 2 eggs are available. What is the least number of egg-droppings
 * that is guaranteed to work in all cases?
 The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be dropped so that total number of trials are minimized.
 When we drop an egg from a floor x, there can be two cases (1) The egg breaks (2) The egg doesn’t break.

 1) If the egg breaks after dropping from xth floor, then we only need to check for floors lower than x with remaining eggs; so the problem reduces to x-1 floors and n-1 eggs
 2) If the egg doesn’t break after dropping from the xth floor, then we only need to check for floors higher than x; so the problem reduces to k-x floors and n eggs.

 Since we need to minimize the number of trials in worst case, we take the maximum of two cases. We consider the max of above two cases for every floor
 and choose the floor which yields minimum number of trials.

 k ==> Number of floors
 n ==> Number of Eggs
 eggDrop(n, k) ==> Minimum number of trials needed to find the critical
 floor in worst case.
 eggDrop(n, k) = 1 + min{max(eggDrop(n - 1, x - 1), eggDrop(n, k - x)):
 x in {1, 2, ..., k}}

 Time Complexity: O(nk^2)
 Auxiliary Space: O(nk)

                    floors
  egg   1   2   3   4   5   6
    1   1   2   3   4   5   6
    2   1   2

    if ( i > j )
        res[i][j] = res[i-1][j]
    else
        //res[i-1][k-1] means the egg breaks which is one egg less and one floor less to go
        // res[i][j-k] means the egg doesn't break and we have j-k floor to go
        res[i][j] = 1 + min( max(res[i-1][k-1], res[i][j-k]

            k is between 1 to j
 */
public class EggDropping {

    public int calculate(int eggs, int floors){

        int res[][] = new int[eggs+1][floors+1];
        int min =0;
        for(int i=0; i <= floors; i++){
            res[1][i] = i;
        }

        for(int i = 2; i <= eggs; i++){
            for(int j = 1; j <=floors; j++){
                res[i][j] = Integer.MAX_VALUE;
                for(int k = 1; k <=j ; k++){
                    min = 1 + Math.max(res[i-1][k-1], res[i][j-k]);
                    if(min < res[i][j]){
                        res[i][j] = min;
                    }
                }
            }
        }
        return res[eggs][floors];
    }

    public int calculateRecursive(int eggs, int floors){
        if(eggs == 1){
            return floors;
        }
        if(floors == 0){
            return 0;
        }
        int min = 1000;
        for(int i=1; i <= floors; i++){
            int val = 1 + Math.max(calculateRecursive(eggs-1, i-1),calculateRecursive(eggs, floors-i));
            if(val < min){
                min = val;
            }
        }
        return min;
    }

    public static void main(String args[]){
        EggDropping ed = new EggDropping();
        int r = ed.calculate(2,6);
        System.out.println(r);
    }
}

