package com.dsa.graph;

/**
 * Created by amyhu on 12/12/17.
 */
class Queue {

    private int[] data;
    private int front;
    private int rear;
    private int size;

    public Queue( int s ) {
        front = -1;
        rear = -1;
        size = s;
        data = new int[size];
    }
    public void enqueue( int v ) {
        if ( isFull() ) {
            throw new IllegalArgumentException("It is full");
        } else {

            if ( front == -1 ) {
                rear = 0;
                front = 0;
            } else {
                rear =( rear + 1) % size;
            }
            data[rear] = v;
        }

    }
    public int dequeue() {
        if ( isEmpty() ) {
            throw new IllegalArgumentException("It is empty");
        } else if (front == rear ){
            int item = data[front];
            front = -1;
            rear = -1;
            return item;

        } else {
            int item = data[front];
            front = (front + 1 ) % size;
            return item;
        }
    }
    public boolean isEmpty() {
        return front == -1;
    }
    public boolean isFull() {
        return front == ( rear + 1 ) % size;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NullPointerException("It is empty");
        } else {
            return data[front];
        }
    }

    public static void main (String[] args) {
        Queue  q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println("is it full: " + q.isFull());
        System.out.println("dequeue " + q.dequeue());
        System.out.println("is it full: " + q.isFull());
        q.enqueue(6);
        System.out.println("is it full: " + q.isFull());
        System.out.println("front element: " + q.peek());
    }
}
