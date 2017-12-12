package com.dsa.graph;

/**
 * Created by amyhu on 12/12/17.
 */
public class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}
