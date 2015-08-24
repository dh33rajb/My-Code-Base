// Convert Binary Tree to Mirror Tree
/*
Input:
1 4 5 6 7 2 8 9 3

Output:
Given Tree: 
1 2 3 4 5 6 7 8 9 
Mirror Tree: 
9 8 7 6 5 4 3 2 1 
*/
import java.util.*;
import java.lang.*;

public class MirrorTree {
    public static void main (String args[]) {
        Node rootNode = null;
        // Step-1: Read inputs
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            rootNode = insertIntoTree (rootNode, value);
        }
        // Step-2: Check Tree population
        System.out.println ("Given Tree: ");
        printInOrderTraversal (rootNode);
        
        // Step-3: Convert tree into Mirror tree
        rootNode = convertToMirrorTree(rootNode);
        
        // Step-4: Check Tree population
        System.out.println ("\nMirror Tree: ");
        printInOrderTraversal (rootNode);
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
    
    public static Node convertToMirrorTree (Node rootNode) {
        if (rootNode == null)
            return rootNode;
        Node tempNode = rootNode.leftChild;
        rootNode.leftChild = rootNode.rightChild;
        rootNode.rightChild = tempNode;
        
        convertToMirrorTree (rootNode.leftChild);
        convertToMirrorTree (rootNode.rightChild);
        return rootNode;
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
