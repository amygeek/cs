package com.dsa.tree;

public class BTreefromInorderPreorder {

    public static int pIndex=0;

    public Node makeBTree(int [] inOrder, int [] preOrder, int start, int end ){

        if ( start > end ){
            return null;
        }
        Node root = new Node( preOrder[pIndex] );
        pIndex++;

        if( start == end ){
            return root;
        }
        int index = getInorderIndex(inOrder, start, end, root.data);
        root.left = makeBTree(inOrder,preOrder,start, index-1);
        root.right = makeBTree(inOrder,preOrder,index+1, end);

        return root;
    }
    public int getInorderIndex(int [] inOrder, int start, int end, int data){

        for (int i=start;i<=end;i++) {
            if( inOrder[i] == data ){
                return i;
            }
        }
        return -1;
    }
    public void printInOrder(Node root){
        if(root!=null){
            printInOrder(root.left);
            System.out.print("  " + root.data);
            printInOrder(root.right);
        }
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        int [] inOrder = {2,5,6,10,12,14,15};
        int [] preOrder = {10,5,2,6,14,12,15};

        BTreefromInorderPreorder i = new BTreefromInorderPreorder();

        Node x = i.makeBTree(inOrder, preOrder, 0, inOrder.length-1);

        System.out.println("Constructed Tree : ");
        i.printInOrder(x);
    }
}
