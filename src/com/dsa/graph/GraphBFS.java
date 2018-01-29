package com.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

class GraphNode {
    int dest;
    GraphNode next;

    public GraphNode(int d) {
        dest = d;
        next = null;
    }
}

class adjList {
    GraphNode head;
}

class GraphBFS {
    int V;
    adjList[] array;

    public GraphBFS(int V) {
        this.V = V;
        array = new adjList[V]; // linked lists = number of Nodes in Graph

        for (int i = 0; i < V; i++) {
            array[i] = new adjList();
            array[i].head = null;
        }
    }

    public void addEdge(int src, int dest) {
        GraphNode n = new GraphNode(dest);
        n.next = array[src].head;
        array[src].head = n;
    }

    public void BFS(int startVertex) {
        boolean[] visited = new boolean[V];
        Queue<Integer> s = new LinkedList<Integer>();

        s.add(startVertex);
        while (s.isEmpty() == false) {
            int n = s.poll();
            System.out.print(" " + n);
            visited[n] = true;
            GraphNode head = array[n].head;
            while (head != null) {
                if (visited[head.dest] == false) {
                    s.add(head.dest);
                    visited[head.dest] = true;
                }
                head = head.next;
            }
        }
    }

    public static void main(String args[]) {
        GraphBFS g = new GraphBFS(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(2, 3);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(4, 5);
        g.BFS(0);

    }
}
