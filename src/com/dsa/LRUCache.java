package com.dsa;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.ListIterator;

class LinkedListNode {
    int data;
    int key;
    LinkedListNode prev;
    LinkedListNode next;

    LinkedListNode( int k, int d ) {
        key = k;
        data = d;
        prev = null;
        next = null;

    }
}
public class LRUCache {
    int capacity;

    //LinkedListNode holds key and value pairs
    HashMap<Integer,LinkedListNode> cache;
    LinkedList<LinkedListNode> cache_vals;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer,LinkedListNode>(capacity);
        cache_vals = new LinkedList<LinkedListNode>();
    }

    int get(int key) {
        LinkedListNode node = cache.get(key);

        if(node == null){
            return -1;
        }
        else {
            cache_vals.remove(node);
            cache_vals.addLast(node);
            return node.data;
        }
    }

    void set(int key, int value) {
        LinkedListNode node = cache.get(key);

        if(node == null){
            evict_if_needed();
            node = new LinkedListNode(key, value);
            cache_vals.addLast(node);
            cache.put(key, node);
        }
        else {
            node.data = value;
            cache_vals.remove(node);
            cache_vals.addLast(node);
        }
    }

    void evict_if_needed(){
        if(cache_vals.size() >= capacity) {
            LinkedListNode node = cache_vals.remove();
            cache.remove(node.key);
        }
    }

    void print() {
        ListIterator<LinkedListNode> iterator = cache_vals.listIterator(0);
        while(iterator.hasNext()){
            LinkedListNode node = iterator.next();
            System.out.print(node.key + ":" +node.data + ", ");
        }
        System.out.println("");
    }
    public static void main (String[] args) {
        LRUCache c = new LRUCache(4);
        c.set(1, 1);
        c.set(2, 2);
        c.set(3, 3);
        c.set(4, 4);
        c.print();
        c.set(5, 5);
        c.print();
        c.get(2);
        c.print();
        c.get(5);
        c.print();
    }
}
