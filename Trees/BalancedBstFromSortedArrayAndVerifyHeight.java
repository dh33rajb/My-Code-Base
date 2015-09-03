// Given a sorted array of elements, form a Binary Search Tree

/*
Input:
1 2 3 4 5 6 7 8 9 10 11

Output:
In-order traversal:
1-2-3-4-5-6-7-8-9-10-11-
The height of tree is: 3
*/

import java.util.*;
import java.lang.*;

public class BalancedBstFromSortedArrayAndVerifyHeight {
    public static void main (String args[]) {
        
        List<Integer> inputList = new ArrayList<Integer>();
        // Step-1: Read inputs
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextInt()) {
            inputList.add (scanner.nextInt());
        }
        Node rootNode = null;
        // Step-2: Insert to tree
        rootNode = insertToBst (rootNode, inputList, 0, inputList.size() -1);
        
        // Step-3: In-Order Traversal to show sorted order of the list
        System.out.println ("In-order traversal:");
        printInorderTraversal(rootNode);
        System.out.println();
        
        // Step-4: find the height of the tree to prove the tree is balanced
        int heightOfTree = findHeightOfTree(rootNode);
        System.out.println ("The height of tree is: " + heightOfTree);
    }
    
    public static Node insertToBst(Node rootNode, List<Integer> inputList, int startIndex, int endIndex) {
        if (endIndex < startIndex)
            return rootNode;
        int midIndex = ((startIndex + endIndex) /2);
        rootNode = new Node (inputList.get (midIndex));
        rootNode.leftChild = insertToBst (rootNode.leftChild, inputList, startIndex, midIndex-1);
        rootNode.rightChild = insertToBst (rootNode.rightChild, inputList, midIndex+1, endIndex);
        return rootNode;
    }
    
    public static void printInorderTraversal (Node rootNode) {
        if (rootNode==null)
            return;
        printInorderTraversal (rootNode.leftChild);
        System.out.print (rootNode.value + "-");
        printInorderTraversal (rootNode.rightChild);
    }
    
    public static int findHeightOfTree (Node rootNode) {
        if (rootNode == null)
            return -1;
        int leftHeight = findHeightOfTree (rootNode.leftChild) + 1;
        int rightHeight =  findHeightOfTree (rootNode.rightChild) + 1;
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
