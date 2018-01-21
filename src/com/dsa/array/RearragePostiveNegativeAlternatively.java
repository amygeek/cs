package com.dsa.array;
import java.util.Arrays;
/*
Given an array arr[] which has negative and positive elements, rearrange the array in such a manner that positive and negative elements occupy the alternate positions and if there are extra positive or negative elements are left then append it to the end.

Examples:

int[] arr = { 1, 2, -3, -4, -5, 6, -7, -8, 9, 10, -11, -12, -13, 14 };
Output: -13 9 -3 10 -5 6 -7 2 -12 1 -11 14 -4 -8

Time Complexity : O(n) Space Complexity: O(1)

Use Quick sort technique.

Take the pivot element as 0 and do the first round of Quick Sort.
After above step you will have all the negative elements on left and all the positive elements on the right.

Then just the every alternate element in the left half (negative elements) with the elements in the right (positive elements)
 */
public class RearragePostiveNegativeAlternatively {

    public void swap( int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void rerrange(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (right > left) {
            while (arr[left] < 0 && left < right)
                left++;
            while (arr[right] > 0 && left < right)
                right--;

            if (left < right) {

                swap(arr, left, right);
                left++;
                right--;
            }
        }

        // At the point all the negative elements on the left half and
        // positive elements on the right half of the array
        // swap the every alternate element in the left half (negative
        // elements) with the elements in the right (positive elements)
        left = 1;
        right = 0;
        while (arr[right] < 0) {
            right++;
        }

        while (arr[left] < 0 && right < arr.length) {

            swap(arr, left, right);

            left += 2;
            right++;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print("  " + arr[i]);
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        int[] arr = { 1, 2, -3, -4, -5, 6, -7, -8, 9, 10, -11, -12, -13, 14 };
        //-13  9  -3  10  -5  6  -7  2  -12  1  -11  14  -4  -8
        RearragePostiveNegativeAlternatively i = new RearragePostiveNegativeAlternatively();
        i.rerrange(arr);
    }
}