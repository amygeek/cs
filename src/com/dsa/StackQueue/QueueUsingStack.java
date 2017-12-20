package com.dsa.StackQueue;

import java.util.Stack;
/**
 * Created by amyhu on 12/18/17.
 */

public class QueueUsingStack{

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    void enqueue(int data) {
        stack1.push(data);
    }

    boolean isEmpty() {
        return stack1.size() + stack2.size() == 0;
    }

    int dequeue() throws Exception {
        if(isEmpty()) {
            throw new Exception("queue is empty");
        }

        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}

class QueueUsingStack2{

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    void enqueue(int data) {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(data);

        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    boolean isEmpty() {
        return stack1.size() + stack2.size() == 0;
    }

    int dequeue() throws Exception {
        if(isEmpty()) {
            throw new Exception("queue is empty");
        }

        return stack1.pop();
    }
}