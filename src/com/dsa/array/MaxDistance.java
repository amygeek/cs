package com.dsa.array;


public class MaxDistance {

    /* Utility Functions to get max and minimum of two integers */
    int max(int x, int y) {
        return x > y ? x : y;
    }

    int min(int x, int y) {
        return x < y ? x : y;
    }

    //Time Complexity: O(n^2)
    int maxIndexDiff0 (int arr[], int n) {
        int maxDiff = -1;
        int i, j;

        for (i = 0; i < n; ++i)
        {
            for (j = n - 1; j > i; --j)
            {
                if (arr[j] > arr[i] && maxDiff < (j - i))
                    maxDiff = j - i;
            }
        }

        return maxDiff;
    }
    /*
    Time Complexity: O(n)
    Auxiliary Space: O(n)
     */
    int maxIndexDiff(int arr[], int n)
    {
        int maxDiff;
        int i, j;

        int rightMax[] = new int[n];
        int leftMin[] = new int[n];

        /* Construct leftMin[] such that leftMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        leftMin[0] = arr[0];
        for (i = 1; i < n; ++i) {
            leftMin[i] = min(arr[i], leftMin[i - 1]);
        }


        /* Construct rightMax[] such that rightMax[j] stores the maximum value from (arr[j], arr[j+1], ..arr[n-1]) */
        rightMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j) {
            rightMax[j] = max(arr[j], rightMax[j + 1]);
        }


        /* Traverse both arrays from left to right to find optimum j - i This process is similar to merge() of MergeSort */
        i = 0; j = 0; maxDiff = -1;
        while (j < n && i < n) {
            if (leftMin[i] < rightMax[j]) {
                maxDiff = max(maxDiff, j - i);
                j = j + 1;
            } else {
                i = i + 1;
            }

        }

        return maxDiff;
    }

    /* Driver program to test the above functions */
    public static void main(String[] args) {
        MaxDistance max = new MaxDistance();
        int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
        int n = arr.length;
        int maxDiff = max.maxIndexDiff(arr, n);
        System.out.println(maxDiff);
    }
}