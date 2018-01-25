package com.dsa.dp;

/*
Print all the paths from left top corner to right bottom corner in two dimensional array.
As we need to explore all the paths from top left corner to bottom right corner, we will either travel down OR travel right.
so every time either we increase the row or column.

Recursion is the key here.
Take the rows count and column counts say rowCount and colCount respectively
Take currentRow =0 and currentColumn =0 and path =””
Call printAll(currentRow, currentcolumn,path)
Add array[0][0] to the path.
Call recursively printAll(currentRow+1, currentcolumn,path)
Call recursively printAll(currentRow, currentcolumn+1,path)
Base Case 1: when currentRow = rowCount-1(because array index starts with 0) , print the rest of the columns, return
Base Case 2: when currentcolumn = colCount-1(because array index starts with 0) , print the rest of the rows, return
 */
public class PrintAllPathIn2DArray {

    int rowCount;
    int colCount;
    int[][] arr;

    public PrintAllPathIn2DArray(int arr[][]) {
        this.arr = arr;
        rowCount = arr.length;
        colCount = arr[0].length;
    }

    public void printAll(int currentRow, int currentColumn, String path) {
        if (currentRow == rowCount - 1) {
            for (int i = currentColumn; i < colCount; i++) {
                path += "-" + arr[currentRow][i];
            }
            System.out.println(path);
            return;
        }
        if (currentColumn == colCount - 1) {
            for (int i = currentRow; i <= rowCount - 1; i++) {
                path += "-" + arr[i][currentColumn];
            }
            System.out.println(path);
            return;
        }
        path = path + "-" + arr[currentRow][currentColumn];
        printAll(currentRow + 1, currentColumn, path);
        printAll(currentRow, currentColumn + 1, path);
        //	printAll(currentRow + 1, currentColumn + 1, path);
    }

    public static void main(String args[]) {

        int[][] a = {{ 1, 2, 3 },
                     { 4, 5, 6 } };
        PrintAllPathIn2DArray p = new PrintAllPathIn2DArray( a );
        p.printAll(0, 0, "");
    }

}
