// Level order traversal in spiral form

// POSTING IT HERE FOR LEARNING A LESSON

import java.util.*;
import java.lang.*;

public class FailedSpiralLevelOrder {
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
        
        // Step-3: Print Spiral Level Order
        System.out.println ("\nSpiral Level Order Print: ");
        printSpiralLevelOrder (rootNode);
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
    
    public static void printSpiralLevelOrder (Node rootNode) {
        if (rootNode == null)
            return;
        Queue<Node> queue = new LinkedList<Node>(); 
        queue.add (rootNode);
        while (queue.size() >0) {
            Node poppedNode = queue.poll();
            System.out.print (poppedNode.value + " ");
            if (poppedNode.flag) {
                if (poppedNode.leftChild!=null) {
                    poppedNode.leftChild.flag = !poppedNode.flag;
                    queue.add (poppedNode.leftChild);
                }
                if (poppedNode.rightChild!=null) {
                    poppedNode.rightChild.flag = !poppedNode.flag;
                    queue.add (poppedNode.rightChild);
                }
            } else {
                if (poppedNode.rightChild!=null) {
                    poppedNode.rightChild.flag = !poppedNode.flag;
                    queue.add (poppedNode.rightChild);
                }
                if (poppedNode.leftChild!=null) {
                    poppedNode.leftChild.flag = !poppedNode.flag;
                    queue.add (poppedNode.leftChild);
                }
            }
        }
        
        
    }
}
class Node {
    public int value;
    public boolean flag;
    public Node leftChild;
    public Node rightChild;
    public Node (int value) {
        this.value = value;
        this.flag= true;
    }
}
