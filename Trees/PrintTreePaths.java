// Given a binary tree, print out all of its root-to-leaf paths one per line.
/*
Input: 5 3 2 4 1 7 6 8 9 
Output:
Given tree: 
1 2 3 4 5 6 7 8 9 
All paths of the given tree: 
[5, 3, 2, 1]
[5, 3, 4]
[5, 7, 6]
[5, 7, 8, 9]
*/
import java.util.*;
import java.lang.*;

public class PrintTreePaths {
    public static void main (String args[]) {
        Node rootNode = null;
        // Step-1: Read inputs and form a tree
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            rootNode = insertIntoTree (rootNode, value);
        }
        
        // Step-2: Check Tree population
        System.out.println ("Given tree: ");
        printInOrderTraversal (rootNode);
        
        // Step-3: Print all paths
        System.out.println ("\nAll paths of the given tree: ");
        printAllPaths (rootNode, new ArrayList<Integer>());
    }
    
    public static Node insertIntoTree (Node rootNode, int value) {
        if (rootNode == null)
            rootNode = new Node (value);
        else if (value <= rootNode.value)
            rootNode.leftChild = insertIntoTree (rootNode.leftChild, value);
        else
            rootNode.rightChild = insertIntoTree (rootNode.rightChild, value);
        return rootNode;
    }
    
    public static void printInOrderTraversal (Node rootNode) {
        if (rootNode==null)
            return;
        printInOrderTraversal (rootNode.leftChild);
        System.out.print (rootNode.value + " ");
        printInOrderTraversal (rootNode.rightChild);
    }
    
    public static void printAllPaths(Node rootNode, List<Integer> path) {
        if (rootNode == null) {
            return;
        } else if (rootNode.leftChild == null && rootNode.rightChild == null) {
            path.add (rootNode.value);
            System.out.println (path);
            return;
            } else {
            path.add (rootNode.value);
            List<Integer> leftPath = new ArrayList<Integer>();
            leftPath.addAll (path);
            List<Integer> rightPath = new ArrayList<Integer>();
            rightPath.addAll (path);
            printAllPaths (rootNode.leftChild, leftPath);
            printAllPaths (rootNode.rightChild, rightPath);
        }
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
