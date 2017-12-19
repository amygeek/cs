package com.dsa.StackQueue;
import java.util.*;
/**
 * Created by amyhu on 12/18/17.
 */
public class StackUsingQueue{
    Queue<Integer> queue1 = new ArrayDeque<Integer>();
    Queue<Integer> queue2 = new ArrayDeque<Integer>();

    void push(int data) {
        queue1.add(data);
    }

    boolean isEmpty() {
        return queue1.size() + queue2.size() == 0;
    }

    int pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("stack is empty");
        }

        while(queue1.size() > 1){
            queue2.add(queue1.remove());
        }

        int value = queue1.remove();

        swap_queues();

        return value;
    }

    void swap_queues() {
        Queue<Integer> queue3 = queue1;
        queue1 = queue2;
        queue2 = queue3;
    }
}

class StackUsingQueue2{

    Queue<Integer> queue1 = new ArrayDeque<Integer>();
    Queue<Integer> queue2 = new ArrayDeque<Integer>();

    void push(int data) {
        if(queue1.isEmpty()) {
            queue1.add(data);
        }
        else {
            queue2.add(data);
            while(!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }
            swap_queues();
        }
    }

    boolean isEmpty() {
        return queue1.size() + queue2.size() == 0;
    }

    int pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("stack is empty");
        }

        return queue1.remove();
    }

    void swap_queues() {
        Queue<Integer> queue3 = queue1;
        queue1 = queue2;
        queue2 = queue3;
    }
}