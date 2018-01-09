package com.dsa.array;
import java.util.Arrays;
/**
 * find the next lexicographic permutation of the given list of numbers than the number formed by the given array.
 *
 We need to find the first pair of two successive numbers a[i]a[i] and a[i-1]a[i−1], from the right,
 which satisfy a[i] > a[i-1]. Now, no rearrangements to the right of a[i-1] can create a larger permutation
 since that subarray consists of numbers in descending order. Thus, we need to rearrange the numbers to the right of a[i-1] including itself.

 Now, what kind of rearrangement will produce the next larger number? We want to create the permutation just larger than the current one.
 Therefore, we need to replace the number a[i-1] with the number which is just larger than itself among the numbers lying to its right section, say a[j].

 Time complexity : O(n). In worst case, only two scans of the whole array are needed.

 Space complexity : O(1). No extra space is used. In place replacements are done.
 */

public class nextPermutation {

    public void nextPerm (int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {

        nextPermutation p = new  nextPermutation();
        //int[] n = {1,2,3}; //[1,3,2]
        //int[] n = {3,2,1}; //[1,2,3]
        //int[] n = {1,1,5}; //[1,5,1]
        /*
        1) loop through from the end of array and find the index (index 3 value 4) of the value that is smaller than previous one
        2) loop through from the end of array and find the index of its value that is less than (index 6 value 5)
        3) swap those two indexes
        4) revert the right side of the array, in the example it is index 3
         */
        int[] n = {1,5,8,4,7,6,5,3,1}; //[1, 5, 8, 5, 1, 3, 4, 6, 7]


        p.nextPerm(n);

        System.out.println(Arrays.toString(n));

    }
}
