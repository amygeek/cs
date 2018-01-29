package com.dsa.tree;

/*
Find the Lowest Common Ancestor of two given nodes in a Binary Tree
In a given binary tree, The lowest common ancestor of two nodes n1 and n2 will be a node X
such that node X will be the lowest node who has n1 and n2 as its descendants.

Start will the root.
If root matches with any of the given nodes (n1, n2) then return root as Lowest Common Ancestor.
IF not then make recursive callas to left subtree and right subtree for the search of the nodes n1 and n2.
Now both the nodes (n1 and n2) will be in the left subtree of the current visiting node OR it will be in the right subtree of current visiting OR n1 and n2 will be in each side of current visiting node.
If you find a node which has one node in its left subtree and one node in its right subtree than this node will be our lowest common ancestor.
If both the nodes (n1 and n2) will be in the left subtree of the current visiting node then go left
If both the nodes (n1 and n2) will be in the right subtree of the current visiting node then go right.
 */
public class LowestCommonAncestorBT {

    static boolean v1 = false, v2 = false;

    /*
    Time complexity of the above solution is O(n) as the method does a simple tree traversal in bottom up fashion.
    Note that the above method assumes that keys are present in Binary Tree. If one key is present and other is absent,
    then it returns the present key as LCA (Ideally should have returned NULL)
     */
    public Node findLCA(Node root, Node n1, Node n2){

        if(root==null){
            return null;
        }else{

            if(root.data==n1.data||root.data==n2.data){
                return root;
            }
            Node left = findLCA(root.left, n1, n2);
            Node right = findLCA(root.right, n1, n2);

            if ( left!=null && right!=null){
                return root;
            }
            if(left!=null){
                return left;
            }else if(right!=null){
                return right;
            }
            return null;
        }
    }

    /*
    extend this method to handle all cases by passing two boolean variables v1 and v2. v1 is set as true
    when n1 is present in tree and v2 is set as true if n2 is present in tree.
    If one key is present and other is absent, it returned NULL)
     */
    Node findLCA2(Node root, Node n1, Node n2) {
        // Initialize n1 and n2 as not visited
        v1 = false;
        v2 = false;

        // Find lca of n1 and n2 using the technique discussed above
        Node lca = findLCAUtil(root, n1, n2);

        // Return LCA only if both n1 and n2 are present in tree
        if (v1 && v2)
            return lca;

        // Else return NULL
        return null;
    }

    public Node findLCAUtil(Node node, Node n1, Node n2) {
        // Base case
        if (node == null)
            return null;

        // If either n1 or n2 matches with root's key, report the presence
        // by setting v1 or v2 as true and return root (Note that if a key
        // is ancestor of other, then the ancestor key becomes LCA)
        if (node.data == n1.data)
        {
            v1 = true;
            return node;
        }
        if (node.data == n2.data)
        {
            v2 = true;
            return node;
        }

        // Look for keys in left and right subtrees
        Node left = findLCAUtil(node.left, n1, n2);
        Node right = findLCAUtil(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left != null && right != null)
            return node;

        // Otherwise check if left subtree or right subtree is LCA
        return (left != null) ? left : right;
    }

    /*
              1
            /   \
           2      3
         /  \    / \
        4    5  6   7
       / \  / \
      8  9 10 11

     */
    public static void main (String[] args) throws java.lang.Exception {
        Node root  = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        Node n3 = new Node(5);
        root.left.right = n3;
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node n1 = new Node(4);
        root.left.left.left = n1;
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        Node n2 = new Node(11);
        root.left.right.right = n2 ;

        LowestCommonAncestorBT i = new LowestCommonAncestorBT();
        Node x = i.findLCA2(root,n1,n3);
        //Lowest Common Ancestor (8, 30 ) is 2
        System.out.println("Lowest Common Ancestor ("+n1.data+", "+ n2.data +" ) is " + x.data);
        x = i.findLCA(root,n2,n3);
        //Lowest Common Ancestor (11, 5 ) is 5
        System.out.println("Lowest Common Ancestor ("+n2.data+", "+ n3.data +" ) is " + x.data);
    }
}

