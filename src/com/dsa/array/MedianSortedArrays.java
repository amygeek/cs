package com.dsa.array;

/**
 * Median of Two Sorted Arrays
 */
public class MedianSortedArrays {

    /*
    Complexity Analysis

    Time complexity: O(log(min(m,n))).
    At first, the searching range is [0, m][0,m]. And the length of this searching range will be reduced
    by half after each loop. So, we only need log(m) loops. Since we do constant operations in each loop,
    so the time complexity is O(log(m)). Since m ≤ n, so the time complexity is O(log(min(m,n))).

    Space complexity: O(1).
    We only need constant memory to store 99 local variables, so the space complexity is O(1).
     */
    static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = iMin + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = iMax - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int a[] = {5, 7, 9, 11, 15};
        int b[] = {1, 8};

        double median = findMedianSortedArrays( a, b);
        System.out.println(median);
    }
}