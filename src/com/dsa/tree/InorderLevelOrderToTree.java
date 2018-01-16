package com.dsa.tree;

/**
 * int[] inOrder = { 4, 2, 5, 1, 6, 3, 7 };

 int[] levelOrder = { 1, 2, 3, 4, 5, 6, 7 };

 inorder[] = {4,2,5}, leftlevelorder[] = {2,4,5}
 inorder[] ={6,3,7}, rightlevelorder[] = {3,6,7}
 Last element in the levelorder [] will be the root of the tree, here it is 1.
 Now the search element 1 in inorder[], say you find it at position i, once you find it, make note of elements which are left to i (this will construct the leftsubtree) and elements which are right to i ( this will construct the rightSubtree).
 Suppose in previous step, there are X number of elements which are left of ‘i’ (which will construct the leftsubtree), but these X elements will not be in the consecutive in levelorder[] so we will extract these elements from levelorder[] by maintaining their sequence and store it in an array say newLeftLevel[].
 Similarly if there are Y number of elements which are right of ‘i’ (which will construct the rightsubtree), but these Y elements will not be in the consecutive in levelorder[] so we will extract these elements from levelorder[] by maintaining their sequence and store it in an array say newRightLevel[].
 From previous two steps construct the left and right subtree and link it to root.left and root.right respectively by making recursive calls using newLeftLevel[] and newRightLevel[].
 */
public class InorderLevelOrderToTree {

    public Node makeBTree(int[] inorder, int[] levelOrder, int iStart, int iEnd) {
        if (iStart > iEnd) {
            return null;
        }
        int rootVal = levelOrder[0];
        Node root = new Node(rootVal);
        if (iStart == iEnd) {
            return root;
        }
        int index = findIndex(inorder, rootVal, iStart, iEnd);

        int[] newleftLevel = newLevelOrder(inorder, levelOrder, iStart,
                index - 1);
        int[] newrighttLevel = newLevelOrder(inorder, levelOrder, index + 1,
                iEnd);

        root.left = makeBTree(inorder, newleftLevel, iStart, index - 1);
        root.right = makeBTree(inorder, newrighttLevel, index + 1, iEnd);

        return root;
    }

    public int[] newLevelOrder(int[] inorder, int[] levelOrder, int iStart,
                               int iEnd) {
        int[] newlevel = new int[iEnd - iStart + 1];
        int x = 0;
        for (int i = 0; i < levelOrder.length; i++) {
            if (findIndex(inorder, levelOrder[i], iStart, iEnd) != -1) {
                newlevel[x] = levelOrder[i];
                x++;
            }
        }
        return newlevel;
    }

    public int findIndex(int[] inorder, int value, int iStart, int iEnd) {
        int x = -1;
        for (int i = iStart; i <= iEnd; i++) {
            if (value == inorder[i]) {
                x = i;
            }
        }
        return x;
    }

    public void printINORDER(Node root) {
        if (root != null) {
            printINORDER(root.left);
            System.out.print("  " + root.data);
            printINORDER(root.right);
        }
    }

    public static void main(String args[]) {
        int[] inOrder = { 4, 2, 5, 1, 6, 3, 7 };
        int[] levelOrder = { 1, 2, 3, 4, 5, 6, 7 };
        InorderLevelOrderToTree i = new InorderLevelOrderToTree();
        Node x = i.makeBTree(inOrder, levelOrder, 0, inOrder.length - 1);
        System.out.println("inorder traversal of constructed tree : ");
        i.printINORDER(x);
    }
}

