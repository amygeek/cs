package com.dsa.StackQueue;

import java.util.Stack;

// add item is O(1), remove items is O(n)
class QueueUsingStack {

    Stack<Integer> newestStack = new Stack<>(); //act as  back of the Queue
    Stack<Integer> oldestStack = new Stack<>(); // act as the front of the Queue

    public void push(int x) {  // push into newestStack
        newestStack.push(x);
    }

    public int peek() {
        if (oldestStack.isEmpty()) {
            moveItems(newestStack, oldestStack);
        }
        return oldestStack.peek(); // return the top element in oldestStack
    }

    boolean isEmpty() {
        return newestStack.size() + oldestStack.size() == 0;
    }

    public int pop() {
        if (oldestStack.isEmpty()) {
            moveItems(newestStack, oldestStack);
        }
        return oldestStack.pop(); // return the top element in oldestStack
    }

    public void moveItems(Stack<Integer> newestStack, Stack<Integer> oldestStack) {
        while (!newestStack.isEmpty()) {
            oldestStack.push(newestStack.pop()); // move all the elements from newestStack to oldestStack
        }
    }

    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();
        q.push(10);
        q.push(20);
        q.push(30);
        System.out.println("POP from Queue " + q.pop());

    }

}

// add item is O(n), remove items is O(1)
class QueueUsingStack2 {

    Stack<Integer> newestStack = new Stack<>(); //act as  back of the Queue
    Stack<Integer> oldestStack = new Stack<>(); // act as the front of the Queue

    public void push(int x) {  // push into newestStack
        while ( !oldestStack.isEmpty()) {
            newestStack.push(oldestStack.pop());
        }
        oldestStack.push(x);  //push the new item to the bottom of oldestStack

        while( !newestStack.isEmpty() ) {
            oldestStack.push(newestStack.pop() );
        }
    }

    public int peek() throws Exception {

        if(oldestStack.isEmpty()) {
            throw new Exception("queue is empty");
        }
        return oldestStack.peek(); // return the top element in oldestStack
    }

    public int pop() throws Exception {
        if(oldestStack.isEmpty()) {
            throw new Exception("queue is empty");
        }
        return oldestStack.pop(); // return the top element in oldestStack
    }

    public static void main(String[] args) throws Exception {
        QueueUsingStack2 q = new QueueUsingStack2();
        q.push(10);
        q.push(20);
        q.push(30);
        System.out.println("POP from Queue " + q.pop());

    }

}