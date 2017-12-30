package com.dsa.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;



public class ArrayDS {
    static void move_zeros_to_left_in_array(int[] A) {
        if (A == null) {
            return;
        }

        int write_index = A.length-1;
        int read_index = A.length-1;

        while(read_index >= 0) {
            if(A[read_index] != 0) {
                A[write_index] = A[read_index];
                write_index--;
            }

            read_index--;
        }

        while(write_index >= 0) {
            A[write_index] = 0;
            write_index--;
        }
    }

    public static HashMap<String, Integer> find_buy_sell_stock_prices(
            int[] array) {
        if(array == null || array.length < 2) {
            return null;
        }

        int current_buy = array[0];
        int global_sell = array[1];
        int global_profit = global_sell - current_buy;

        int current_profit = Integer.MIN_VALUE;

        for(int i=1 ; i < array.length ; i++) {
            current_profit = array[i] - current_buy;

            if(current_profit > global_profit) {
                global_profit = current_profit;
                global_sell = array[i];
            }

            if(current_buy > array[i]) {
                current_buy = array[i];
            }
        }

        HashMap<String, Integer> result = new HashMap<String, Integer>();
        result.put("buyPrice", global_sell - global_profit);
        result.put("sellPrice", global_sell);

        return result;
    }


    // find_sum_of_two function return true if
    // there are two values in array who
    // sum to value and returns false otherwise
    static boolean find_sum_of_two(int[] A, int val) {
        Set<Integer> found_values = new HashSet<Integer>();
        for (int a : A) {
            if (found_values.contains(val - a)) {
                return true;
            }

            found_values.add(a);
        }

        return false;
    }

    // find_sum_of_two_2 function return true if
    // there are two values in array who
    // sum to value and returns false otherwise
    // this solution works only if data is sorted.
    // does not require any extra memory.
    static boolean find_sum_of_two_2(int[] A, int val) {

        for (int i = 0, j = A.length - 1; i < j;) {
            int sum = A[i] + A[j];
            if (sum == val) {
                return true;
            }

            if (sum < val) {
                ++i;
            } else {
                --j;
            }
        }

        return false;
    }
    
    public static void main ( String[] args) {

    }
}
