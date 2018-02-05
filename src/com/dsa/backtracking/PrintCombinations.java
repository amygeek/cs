package com.dsa.backtracking;

/*
Print all combinations of points that can compose a given number
3.5
You can win three kinds of basketball points, 1 point, 2 points, and 3 points. Given a total score n, print out
all the combination to compose n.
For n = 1, the program should print following:
1

For n = 2, the program should print following:
1 1
2

For n = 3, the program should print following:
1 1 1
1 2
2 1
3

For n = 4, the program should print following:
1 1 1 1
1 1 2
1 2 1
1 3
2 1 1
2 2
3 1

and so on ...
Algorithm:

At first position we can have three numbers 1 or 2 or 3.
First put 1 at first position and recursively call for n-1.
Then put 2 at first position and recursively call for n-2.
Then put 3 at first position and recursively call for n-3.
If n becomes 0 then we have formed a combination that compose n, so print the current combination.
 */
class PrintCombinations {
    // Function prints all combinations of numbers 1, 2, ...MAX_POINT
    // that sum up to n.
    // i is used in recursion keep track of index in arr[] where next
    // element is to be added. Initital value of i must be passed as 0
    static void printCompositions(int arr[], int n, int i)
    {
        int MAX_POINT = 3;
        if (n == 0)
        {
            printArray(arr, i);
        }
        else if(n > 0)
        {
            for (int k = 1; k <= MAX_POINT; k++)
            {
                arr[i]= k;
                printCompositions(arr, n-k, i+1);
            }
        }
    }

    // Utility function to print array arr[]
    static void printArray(int arr[], int m)
    {
        for (int i = 0; i < m; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    // Driver program
    public static void main (String[] args)
    {
        int n = 5;
        int size = 100;
        int[] arr = new int[size];
        System.out.println("Different compositions formed by 1, 2 and 3 of "+ n + " are");
        printCompositions(arr, n, 0);
    }
}