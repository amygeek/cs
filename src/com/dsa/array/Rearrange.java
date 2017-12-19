package com.dsa.array;

/**
 * Created by amygeek on 12/15/17.
 */
class Rearrange
{
    // Function to rearrange the array such that every second element
    // of the array is greater than its left and right elements
    public static void rearrangeArray(int arr[], int n)
    {
        int temp;

        // start from second element and increment index
        // by 2 for each iteration of loop
        for (int i = 1; i < n; i += 2)
        {
            // If the prev element is greater than current element,
            // swap the elements
            if (arr[i - 1] > arr[i])
            {
                temp = arr[i - 1];
                arr[i - 1] =  arr[i];
                arr[i] = temp;
            }

            // if next element is greater than current element,
            // swap the elements
            if (i + 1 < n && arr[i + 1] > arr[i])
            {
                temp = arr[i + 1];
                arr[i + 1] =  arr[i];
                arr[i] = temp;
            }
        }
    }

    // main function
    public static void main (String[] args)
    {
        int A[] = { 9, 6, 8, 3, 7 };
        int n = A.length;

        rearrangeArray(A, n);

        // print output array
        for (int i = 0; i < n; i++)
            System.out.print(A[i] + " ");
    }
}
