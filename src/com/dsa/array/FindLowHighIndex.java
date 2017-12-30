package com.dsa.array;

import java.util.List;

public class FindLowHighIndex {
    static int find_low_index(List<Integer> arr, int key) {

        int low = 0;
        int high = arr.size()-1;
        int mid = high/2;

        while (low <= high) {

            int mid_elem = arr.get(mid);

            if (mid_elem < key) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }

            mid = low + (high-low)/2;
        }

        if (arr.get(low) == key) {
            return low;
        }

        return -1;
    }

    static int find_high_index(List<Integer> arr, int key) {

        int low = 0;
        int high = arr.size()-1;
        int mid = high/2;

        while (low <= high) {

            int mid_elem = arr.get(mid);

            if (mid_elem <= key) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }

            mid = low + (high-low)/2;
        }

        if (arr.get(high) == key) {
            return high;
        }

        return -1;
    }
}
