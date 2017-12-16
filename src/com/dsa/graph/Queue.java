package com.dsa.graph;

/**
 * Created by amyhu on 12/12/17.
 */
class Queue {
    private int[] q;
    private int front;
    private int rear;
    private int size;
    public Queue( int s ) {
        front = 0;
        rear = -1;
        size = s;
    }
    public void enqueue( int v ) {
        if ( rear == size - 1 ) {
            rear = -1;
        }
        q[++rear] = v;
    }
    public int dequeue() {
        int temp = q[front++];
        if ( front == size ) {
            front = 0;
        }
        return temp;
    }
    public boolean isEmpty() {
        return (front == rear + 1) || (front + size - 1 == rear );
    }

}

