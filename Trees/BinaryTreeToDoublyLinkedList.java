// Binary Tree to Doubly Linked List

/*
Input:
1 2 3 4 5 6 7 8 9

Output:
Level order print of Tree: 
1 2 3 4 5 6 7 8 9 
Forward Dll / In-order print of Tree: 
8 4 9 2 5 1 6 3 7 
Backward Dll print of Tree: 
7 3 6 1 5 2 9 4 8
*/
import java.util.*;
import java.lang.*;

public class BinaryTreeToDoublyLinkedList {
    public static void main (String args[]) {
        Node rootNode = null;
        
        // Step-1: Read Inputs
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextInt()) {
            rootNode = insertIntoTree (rootNode, scanner.nextInt());
        }
        // Step-2: Check if Input Tree is properly formed
        System.out.println ("Level order print of Tree: ");
        printLevelOrderTraversalOutput (rootNode);
        System.out.println();
        
        // Step-3: In-order traversal and populate Forward Stack and prev nodes
        final Stack<Node> fStack = new Stack<Node>();
        rootNode = inOrderPopulateForwardNode (rootNode, fStack);
        
        // Step-4: Reverse in-order traversal and populate Backward Stack and next nodes
        final Stack<Node> bStack = new Stack<Node>();
        rootNode = revInOrderPopulateBackwardNode (rootNode, bStack);
        
        // Step-5: Verify DLL
        System.out.println ("Forward Dll / In-order print of Tree: ");
        printForwardDll(findLeftMostNode(rootNode));
        System.out.println();
        System.out.println ("Backward Dll print of Tree: ");
        printBackwardDll(findRightMostNode(rootNode));
    }
    
    public static Node insertIntoTree (Node rootNode, int value) {
        if (rootNode == null) {
            rootNode = new Node (value);
            return rootNode;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            Node poppedNode = queue.remove();
            if (poppedNode.leftChild!=null)
                queue.add(poppedNode.leftChild);
            else {
                poppedNode.leftChild = new Node (value);
                break;
            }
            if (poppedNode.rightChild!=null)
                queue.add(poppedNode.rightChild);
            else {
                poppedNode.rightChild = new Node (value);
                break;
            }
        }
        return rootNode;
    }
    
    public static void printLevelOrderTraversalOutput (Node rootNode) {
        if (rootNode == null)
            return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add (rootNode);
        
        while (!queue.isEmpty()) {
            Node poppedNode = queue.remove();
            System.out.print (poppedNode.value + " ");
            if (poppedNode.leftChild != null)
                queue.add (poppedNode.leftChild);
            if (poppedNode.rightChild != null)
                queue.add (poppedNode.rightChild);
        }
    }
    
    public static Node inOrderPopulateForwardNode (Node rootNode, Stack<Node> stack) {
        if (rootNode==null)
            return rootNode;
        if (rootNode.leftChild!=null)
            inOrderPopulateForwardNode (rootNode.leftChild, stack);
        if (!stack.empty())
            rootNode.prevNode = stack.pop();
        stack.push(rootNode);
        if (rootNode.rightChild!=null)
            inOrderPopulateForwardNode (rootNode.rightChild, stack);
        return rootNode;
    }
    
    public static Node revInOrderPopulateBackwardNode (Node rootNode, Stack<Node> stack) {
        if (rootNode==null)
            return rootNode;
        if (rootNode.rightChild!=null)
            revInOrderPopulateBackwardNode (rootNode.rightChild, stack);
        if (!stack.empty())
            rootNode.nextNode = stack.pop();
        stack.push(rootNode);
        if (rootNode.leftChild!=null)
            revInOrderPopulateBackwardNode (rootNode.leftChild, stack);
        return rootNode;
    }
    
    public static void printForwardDll(Node rootNode) {
        if (rootNode == null)
            return;
        System.out.print (rootNode.value + " ");
        printForwardDll (rootNode.nextNode);
    }
    
    public static Node findLeftMostNode (Node rootNode) {
        if (rootNode == null)
            return rootNode;
        if (rootNode.leftChild != null)
            return findLeftMostNode (rootNode.leftChild);
        else
            return rootNode;
    }
    
    public static void printBackwardDll(Node rootNode) {
        if (rootNode == null)
            return;
        System.out.print (rootNode.value + " ");
        printBackwardDll (rootNode.prevNode);
    }
    
    public static Node findRightMostNode (Node rootNode) {
        if (rootNode == null)
            return rootNode;
        if (rootNode.rightChild != null)
            return findRightMostNode (rootNode.rightChild);
        else
            return rootNode;
    }
}

class Node {
    public int value;
    public Node leftChild;
    public Node rightChild;
    
    public Node prevNode;
    public Node nextNode;
    
    public Node (int value) {
        this.value = value;
    }
}
