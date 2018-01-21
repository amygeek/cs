package com.dsa.array;
import java.util.Arrays;
/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
public class SortColor {

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    void sortColors(int[] nums, int n) {
        int low = 0;
        int high = n - 1;
        int mid = 0;
        while ( mid <= high ) {

            switch ( nums[mid] ){

                case 0:
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, high);
                    high--;
                    break;

            }
        }
    }
    public void sortColors(int[] nums) {
        if(nums==null||nums.length<2){
            return;
        }

        int[] countArray = new int[3];
        for(int i=0; i<nums.length; i++){
            countArray[nums[i]]++;
        }

        System.out.println(Arrays.toString(countArray));
        int j = 0;
        int k = 0;
        while(j <= 2){
            if(countArray[j] != 0 ){
                nums[k++] = j;
                countArray[j]--;
            } else {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

        SortColor sort = new SortColor();
        sort.sortColors(nums);
        //sort.sortColors(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
