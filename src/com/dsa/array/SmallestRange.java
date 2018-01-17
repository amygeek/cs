package com.dsa.array;
import java.util.PriorityQueue;
import java.util.Arrays;

/*
You have k lists of sorted inte­gers. Find the small­est range that includes at least one num­ber from each of the k lists.
Time complexity : O(n∗log(m)). Heapification of m elements requires O(log(m)) time.
This step could be done for all the elements of the given lists in the worst case. Here, nn refers to the total number of elements in all the lists. mm refers to the total number of lists.

Space complexity : O(m). nextnext array of size m is used. A MinHeap with m elements is also used.
 */
public class SmallestRange {

    
    static int[] findSmallestRange(int[][] nums) {
        int minx = 0, miny = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] next = new int[nums.length];
        boolean flag = true;
        PriorityQueue < Integer > min_queue = new PriorityQueue < Integer > ((i, j) -> nums[i][next[i]] - nums[j][next[j]]);
        for (int i = 0; i < nums.length; i++) {
            min_queue.offer(i);
            max = Math.max(max, nums[i][0]);
        }
        for (int i = 0; i < nums.length && flag; i++) {
            for (int j = 0; j < nums[i].length && flag; j++) {
                int min_i = min_queue.poll();
                if (miny - minx > max - nums[min_i][next[min_i]]) {
                    minx = nums[min_i][next[min_i]];
                    miny = max;
                }
                next[min_i]++;
                if (next[min_i] == nums[min_i].length) {
                    flag = false;
                    break;
                }
                min_queue.offer(min_i);
                max = Math.max(max, nums[min_i][next[min_i]]);
            }
        }
        return new int[] { minx, miny};
    }
    
    public static void main(String[] args) {
        int[][] setOfArr = new int[3][];
        setOfArr[0] = new int[] { 3, 10, 15, 24 };
        setOfArr[1] = new int[] { 0, 1, 2, 20 };
        setOfArr[2] = new int[] { 1, 18, 21, 30 };

        SmallestRange m = new SmallestRange();
        int[] range = m.findSmallestRange(setOfArr);
        System.out.println("Smallest Range is: " + Arrays.toString(range));
    }
}
