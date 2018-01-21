package com.dsa.array;

//O(n) time and O(1) space complexity.
/*
Rearrange Positive and Negative Numbers of an Array so that one side you have positive numbers
and other side with negative Integers without changing their respective order.

Example : Input :  1 -2 3 -4 5 -6 7 -8 9 -10

ReArranged Output :  -2 -4 -6 -8 -10 1 3 5 7 9

This approach is similar to merge sort.
Divide the array into two half, Solve them individually and merge them.
Tricky part is in merging.
Merging: (Negative on left side and positives on the right side)

Navigate the left half of array till you won’t find a positive integer and reverse the array after that point.(Say that part is called ‘A’)
Navigate the right half of array till you won’t find a positive integer and reverse the array before that point. (Say that part is called ‘B’)
Now reverse the those parts from both the array (A and B)
 */
public class RearrageArrayPositiveNegative {
    int[] arr;

    public RearrageArrayPositiveNegative(int[] arr) {
        this.arr = arr;
    }

    public void sort(int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;
        sort(low, mid);
        sort(mid + 1 , high);
        merge(low, mid, high);

    }

    public void merge(int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        while (i <= mid && arr[i] < 0) {
            i++;
        }

        while (j <= high && arr[j] < 0) {
            j++;
        }

        reverse(i, mid);
        reverse(mid + 1, j - 1);
        reverse(i, j - 1);
    }

    public void reverse(int x, int y) {
        while (y > x) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
            x++;
            y--;
        }
    }

    public void display() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public static void main(String args[]) {
        int[] a = { 1, -2, -3, -4, 5, -6, 7, -8, 9, -10, -11, -12, 20 };
        RearrageArrayPositiveNegative r = new RearrageArrayPositiveNegative(a);
        System.out.print("Input : ");
        r.display();
        r.sort(0, a.length - 1);
        System.out.println("");
        System.out.print("ReArranged Output : ");
        r.display();
    }
}
