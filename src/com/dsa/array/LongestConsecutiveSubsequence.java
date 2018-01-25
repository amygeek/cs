package com.dsa.array;

import java.util.HashSet;

/**
 * Find longest consecutive subsequence in unsorted array.
 *
 Time complexity : O(n).

 Although the time complexity appears to be quadratic due to the while loop nested within the for loop,
 closer inspection reveals it to be linear. Because the while loop is reached only when currentNum marks
 the beginning of a sequence (i.e. currentNum-1 is not present in nums), the while loop can only run
 for nn iterations throughout the entire runtime of the algorithm. This means that despite looking
 like \mathcal{O}(n*n)O(n∗n) complexity, the nested loops actually run in O(n + n) =O(n) time.
 All other computations occur in constant time, so the overall runtime is linear.

 Space complexity : O(n).
 */
public class LongestConsecutiveSubsequence {
    public int longestConsecutive(int[] arr) {

        HashSet<Integer> set = new HashSet<Integer>();

        int n = arr.length;
        int max = 1;

        // Hash all the array elements
        for (int i=0; i<n; ++i) {
            set.add(arr[i]);
        }
        // check each possible sequence from the start
        // then update optimal length
        for (int i=0; i<n; ++i) {
            // if current element is the starting
            // element of a sequence
            if ( !set.contains( arr[i] - 1 ) ) {
                // Then check for next elements in the
                // sequence
                int j = arr[i];
                while (set.contains(j)) {
                    j++;
                }

                // update  optimal length if this length
                // is more
                if ( max < j - arr[i] ) {
                    max = j - arr[i];
                }

            }
        }
        return max;
    }

    public static void main(String args[]) {
        LongestConsecutiveSubsequence lcs = new LongestConsecutiveSubsequence();
        int[] input = {100, 4, 200, 1, 3, 2};
        System.out.println(lcs.longestConsecutive(input));
    }
}