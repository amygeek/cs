package com.dsa.backtracking;

import java.util.Arrays;
/*
    how to place queens on an ordinary chess board so that none of them can hit any other in one move

    This earlier approach we have seen solution matrix, at every row we have only one entry as 1 and rest of the entries are 0. Solution matrix takes O(N2) space. We can reduce it to O(N). We will solve it by taking one dimensional array and consider solution[1] = 2 as “Queen at 1st row is placed at 2nd column.

    result[i]=j means queen at i-th row is placed at j-th column.

    Check if Queens placed at (x1, y1) and (x2,y2) are safe

    x1==x2 means same rows,
    y1==y2 means same columns
    |x2-x1|==|y2-y1| means they are placed in diagonals.
 */
public class NQueens {
    static int[] result; // this array will store the result

    // result[i]=j; means queen at i-th row is placed at j-th column.
    // Queens placed at (x1, y1) and (x2,y2)
    // x1==x2 means same rows, y1==y2 means same columns, |x2-x1|==|y2-y1| means
    // they are placed in diagonals.
    public boolean canPlace(int x2, int y2) {
        // This function will check if queen can be placed (x2,y2), or we can
        // say that Can queen at x2 row is placed at y2 column.
        // for finding the column for x2 row, we will check all the columns for
        // all the rows till x2-1.
        for (int i = 0; i < x2; i++) {
            //result[i] == y2 => columns are same
            //|i - x2| == |result[i] - y2| => in diagonals.
            if ((result[i] == y2)
                    || (Math.abs(i - x2) == Math.abs(result[i] - y2))) {
                return false;
            }
        }
        return true;
    }
    public void placeQueens(int x, int size) {
        for (int i = 0; i < size; i++) {
            //check if queen at xth row can be placed at i-th column.
            if (canPlace(x, i)) {
                result[x] = i; // place the queen at this position.
                if (x == size - 1) {
                    System.out.println("Order of " + size + " queens"
                            + Arrays.toString(result));
                }
                placeQueens(x + 1, size);
            }
        }
    }
    public static void main(String[] args) {
        int n = 6;
        result = new int[n];
        NQueens i = new NQueens();
        i.placeQueens(0, n);
    }
}
