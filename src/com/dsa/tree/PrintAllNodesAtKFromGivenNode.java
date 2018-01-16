package com.dsa.tree;

public class PrintAllNodesAtKFromGivenNode {

    public void printAllNodes(Node root, int node, int distance) {
        int pathLen = Pathlength(root, node) - 1;

        Path(root, node, pathLen, distance);
    }

    public void print(Node root, int node, Node prev, int k, boolean searchingDown) {
        if (root != null) {
            if (k == 0 && root.data != node) {
                System.out.print(" " + root.data);
            }
            if (searchingDown) {
                print(root.left, node, prev, --k, searchingDown);
                print(root.right, node, prev, k, searchingDown);
            } else {
                if (root.left != prev) {
                    print(root.left, node, prev, --k, searchingDown);
                }
                if (root.right != prev) {
                    print(root.right, node, prev, --k, searchingDown);
                }
            }
        }
    }

    public Node Path(Node root, int node, int k, int distance) {

        if (root == null) {
            return null;
        }

        Node x = null;
        if (root.data == node || (x = Path(root.left, node, k - 1, distance)) != null || (x = Path(root.right, node, k - 1, distance)) != null) {
            if (k == 0) {
                print(root, node, x, distance - k, true);
            } else {
                print(root, node, x, distance - k, false);
            }

            return root;
        }
        return null;
    }

    public int Pathlength(Node root, int n1) {
        if (root != null) {
            int x = 0;
            if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0 || (x = Pathlength(root.right, n1)) > 0) {
                return x + 1;
            }
        }
        return 0;
    }
    /*
             1
           /   \
          2      3
        /   \     \
       4     5     8
      /    /  \
     9    6    7
                \
               10
               /
             11
    Nodes at distance '3' from Node '5' are :  11 9 3
    x = 2,
    Nodes which are at distance 2 considering 2 as root. You will get 9. Don't check the direction of node 5
    x = 1,
    Nodes which are at distance 1 considering 1 as root. You will get 3. Don't check the direction of node 2
    x = 3
    print all nodes which are at distance 3 considering 5 as rot. You will get 11
    */
    public static void main(String[] args) throws java.lang.Exception {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(9);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.left.right.right.right = new Node(10);
        root.left.right.right.right.left = new Node(11);
        root.right.right = new Node(8);
        PrintAllNodesAtKFromGivenNode i = new PrintAllNodesAtKFromGivenNode();
        System.out.print("Nodes at distance '3' from Node '5' are : ");
        i.printAllNodes(root, 5, 3);
    }
}

