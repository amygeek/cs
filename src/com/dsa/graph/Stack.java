package com.dsa.graph;
import java.util.Arrays;
/**
 * Created by amyhu on 12/12/17.
 */
class Stack {
    private int top;
    private int[] st;
    private int size;
    public Stack( int s ) {
        top = -1;
        size = s;
        st = new int[s];
    }

    public void push(int v) {
        st[++top] = v;
    }
    public int pop() {
        return st[top--];
    }
    public boolean isFull () {
        return st.length == size;
    }
    public boolean isEmpty() {
        return top == -1;
    }

    public int peek() {
        return st[top];
    }

    public static void main(String[] args) {
        Stack stackX = new Stack(8);
        stackX.push(1);
        stackX.push(2);
        stackX.push(3);
        stackX.push(4);
        stackX.push(5);
        stackX.push(6);
        stackX.push(7);
        stackX.push(8);

        System.out.println(Arrays.toString(stackX.st));
        System.out.println(stackX.peek());
        System.out.println(stackX.isFull());
    }
}

