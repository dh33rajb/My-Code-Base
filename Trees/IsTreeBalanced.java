// MY PERFECT SOLUTION TO CHECK IF TREE IS BALANCED
/*
I have written two methods 1) To form a normal completebinary tree 2) to form a bst with the input data. 
For the given sorted input,the binary tree formed is always a complete binary tree with best height, and the bst is
formed with max height (linkedlist).

Input:
1 2 3 4 5 6 7 8 9 10 11

Output:
1-2-3-4-5-6-7-8-9-10-11-
Height of node 11 is 0
Height of node 10 is 1
Height of node 9 is 2
Height of node 8 is 3
Height of node 7 is 4
Height of node 6 is 5
Height of node 5 is 6
Height of node 4 is 7
Height of node 3 is 8
Height of node 2 is 9
Tree is not height balanced
*/

import java.util.*;
import java.lang.*;

public class IsTreeBalanced {
    public static void main (String args[]) {
        
        Node rootNode = null;
        
        // Step-1: Read inputs and form a tree
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextInt()) {
            // rootNode = insertIntoCompleteBinaryTree (rootNode, scanner.nextInt());
            rootNode = insertIntoBinarySearchTree (rootNode, scanner.nextInt());
            
        }
        
        // Step-2: Check the formation of a binary tree
        printLevelOrderTraversal (rootNode);
        System.out.println();
        
        // Step-3: Find if the tree is height balanced
        boolean isBalanced = isTreeHeightBalanced (rootNode);
        if (isBalanced)
            System.out.println ("Tree is height balanced");
        else
            System.out.println ("Tree is not height balanced");
    }
    
    // Simple way to form a Binary Tree (inserting into binary tree)
    public static Node insertIntoCompleteBinaryTree(Node rootNode, int value) {
        if (rootNode == null) {
            rootNode = new Node (value);
            return rootNode;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add (rootNode);
        while (!queue.isEmpty()) {
            Node peekedNode = queue.peek();
            if (peekedNode.leftChild == null) {
                peekedNode.leftChild = new Node (value);
                break;
            } else if (peekedNode.rightChild == null) {
                peekedNode.rightChild = new Node (value);
                break;
            } else {
                queue.add (peekedNode.leftChild);
                queue.add (peekedNode.rightChild);
                queue.remove();
            }
        }
        return rootNode;
    }
    
    public static Node insertIntoBinarySearchTree (Node rootNode, int value) {
        if (rootNode == null) {
            rootNode = new Node (value);
            return rootNode;
        }
        if (value < rootNode.value)
            rootNode.leftChild = insertIntoBinarySearchTree (rootNode.leftChild, value);
        else
            rootNode.rightChild = insertIntoBinarySearchTree (rootNode.rightChild, value);
        return rootNode;
    }
    
    // Simple way to display Level-Order elements
    public static void printLevelOrderTraversal (Node rootNode) {
        if (rootNode == null)
            return;
        Queue <Node> queue = new LinkedList <Node>();
        queue.add (rootNode);
        
        while (!queue.isEmpty()) {
            Node poppedNode = queue.remove ();
            System.out.print (poppedNode.value + "-");
            if (poppedNode.leftChild!=null)
                queue.add (poppedNode.leftChild);
            if (poppedNode.rightChild!=null)
                queue.add (poppedNode.rightChild);
        }
    }
    
    // Simple way to check if tree is height balanced
    public static boolean isTreeHeightBalanced (Node rootNode) {
        if (rootNode == null)
            return true;

        int leftHeight = findHeightOfTree (rootNode.leftChild);
        int rightHeight = findHeightOfTree (rootNode.rightChild);
        
        if (Math.abs (leftHeight - rightHeight) > 1)
            return false;
        else
            return (isTreeHeightBalanced(rootNode.leftChild) && isTreeHeightBalanced(rootNode.rightChild));
    }
    
    public static int findHeightOfTree (Node rootNode) {
        if (rootNode == null)
            return 0;
        int leftHeight = 0;
        int rightHeight = 0;
        if (rootNode.leftChild!= null)
            leftHeight = findHeightOfTree (rootNode.leftChild) + 1;
        if (rootNode.rightChild != null)
            rightHeight = findHeightOfTree (rootNode.rightChild) + 1;
        System.out.println ("Height of node " + rootNode.value + " is " + Math.max (leftHeight, rightHeight));
        return Math.max (leftHeight, rightHeight);
    }
}

class Node {
    public int value;
    public Node leftChild;
    public Node rightChild;
    
    public Node (int value) {
        this.value = value;
    }
}
