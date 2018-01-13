package com.dsa.array;

public class PrintDiagonalMatrix {

    public static void print(int [][] a){
        
        int n = a.length;

        //print first half
        int row =0;
        int col;

        while( row < n ){
            col =0;
            int rowTemp = row;
            while( rowTemp >= 0 ){
                System.out.print(a[rowTemp][col] + " ");
                rowTemp--;
                col++;
            }
            System.out.println();
            row++;
        }

        //print second half
        col = 1;

        while( col < n ){
            int colTemp = col;
            row = n-1;
            while( colTemp <= n-1 ) {
                System.out.print(a[row][colTemp] + " ");
                row--;
                colTemp++;
            }
            System.out.println();
            col++;
        }

    }

    public static void main(String[] args) {
        int [][] a = {{1,  2, 3, 4},
                      {5,  6, 7, 8},
                      {9, 10,11,12},
                      {13,14,15,16}};
        print(a);
    }
}
