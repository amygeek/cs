package com.dsa.array;
import java.util.ArrayDeque;

public class find_max_sliding_window {

    public static void find_max( int[] array,int window_size) {

        if(array.length < window_size) {
            return;
        }

        ArrayDeque<Integer> window = new ArrayDeque<Integer>();

        //find out max for the first window
        for(int i=0 ; i<window_size ; i++) {

            while(!window.isEmpty()
                    && array[i] >= array[window.peekLast()] ) {
                window.removeLast();
            }

            window.addLast(i);
        }

        System.out.print(array[window.peekFirst()] + ", ");

        for(int i= window_size; i<array.length; i++) {

            //remove all numbers that are smaller than current number
            //from the tail of queue
            while(!window.isEmpty()
                    && array[i] >= array[window.peekLast()]) {
                window.removeLast();
            }

            //remove first number if it doesn't fall in the window anymore
            if(!window.isEmpty()
                    && window.peekFirst() <= i - window_size) {
                window.removeFirst();
            }

            window.addLast(i);

            System.out.print(array[window.peekFirst()] + ", ");
        }
    }

    public static void main ( String[] args) {
        int[] arr = {-4, 2, -5, 1, -1, 6};
        int wSize = 3;

        find_max(arr, wSize);
    }

}
