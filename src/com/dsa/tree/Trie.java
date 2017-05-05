package com.dsa.tree;
import java.util.*;

public class Trie {
    char c;
    Trie[] children;
    boolean word;

    public Trie() {
        this.c = 0;
        this.children = new Trie[26];
        this.word = false;
    }

    public void add(String s) {
        if(s.isEmpty()) {
            this.word = true;
            return;
        }

        char letter = s.charAt(0);
        int index = letter - 'a'; // a is ASCI 97

        if(this.children[index] == null) {
            this.children[index] = new Trie();
            this.children[index].c = letter;

        }

        this.children[index].add(s.substring(1));
    }

    public boolean isWord(String s) {
        if(s.isEmpty()) {
            return this.word;
        }
        int index = s.charAt(0) - 'a';
        if(this.children[index] == null) {
            return false;
        }
        return this.children[index].isWord(s.substring(1));
    }

    public void words(List<String> w, Stack<Character> st) {
        if(c != 0)
            st.push(c);
        if(word) {
            StringBuilder s = new StringBuilder();
            for(char character : st) {
                s.append(character);
            }
            w.add(s.toString());
        }
        for(int i = 0; i < 26; i++) {
            if(children[i] != null) {
                children[i].words(w, st);
            }
        }
        if(!st.isEmpty())
            st.pop();
    }

    public List<String> words() {
        List<String> w = new LinkedList<>();
        Stack<Character> st = new Stack<>();
        words(w, st);
        return w;
    }

    public static void main(String[] args) {
        Trie ob = new Trie();
        ob.add("trie");
        ob.add("try");
        ob.add("apples");
        ob.add("mangoes");
        ob.add("tango");
        ob.add("train");
        System.out.println(ob.words());
    }
}