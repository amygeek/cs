package com.dsa.graph;

/**
 * Created by amyhu on 12/12/17.
 */
public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];    //list of vertices
    private int adjMat[][];         //adjacency matrix
    private int nVerts;             //current number of vertices
    private Stack theStack;
    private Queue theQueue;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int i=0; i<MAX_VERTS; i++) {
            for(int j=0; j<MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
        theStack = new Stack(20);
        theQueue = new Queue(20);
    }

    public void addVertex( char lab ) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge( int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex( int v ) {
        System.out.println(vertexList[v].label);
    }

    public void dfs() {
        vertexList[0].wasVisited = true;   //start at vertex 0
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            //get unvisited vertex adjacent on the top of stack
            int v = getAdjUnvisitedVertex(theStack.peek());

            if ( v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        //stack is empty, so we are done, reset the flags
        for(int i=0; i<nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void bfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.enqueue(0);

        while( !theQueue.isEmpty()) {
            int v1 = theQueue.dequeue();
            int v2 = getAdjUnvisitedVertex(v1);

            while( v2 != -1) {
                vertexList[2].wasVisited = true;
                displayVertex(v2);
                theQueue.enqueue(v2);
            }
        }

        for(int i=0; i<nVerts; i++) {
            vertexList[i].wasVisited = false;
        }

    }
    public int getAdjUnvisitedVertex(int v) {
        for(int j=0; j<nVerts; j++) {
            if (adjMat[v][j] == 1 && vertexList[j].wasVisited = false) {
                return j;
            }
        }
        return  -1;
    }

    public static void main (String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');    //0
        theGraph.addVertex('B');    //1
        theGraph.addVertex('C');    //2
        theGraph.addVertex('D');    //3
        theGraph.addVertex('E');    //4

        theGraph.addEdge(0, 1);     //AB
        theGraph.addEdge(1, 2);     //BC
        theGraph.addEdge(0, 3);     //AD
        theGraph.addEdge(3, 4);     //DE

        System.out.println("Visits DFS: ");
        theGraph.dfs();
        System.out.println();
        System.out.println("Visits BFS: ");
        theGraph.bfs();

    }
}
