// Level order traversal in spiral form
/*
Input:
5 3 2 4 1 7 6 8 9
Output:
Given tree (In-order): 
1 2 3 4 5 6 7 8 9 
Hight of tree: 4
Spiral Level Order Print: 
5 3 7 8 6 4 2 1 9 
*/
import java.util.*;
import java.lang.*;

public class SpiralLevelOrder {
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
        
        // Step-4: Find hight of the tree
        int height = findHightOfTree(rootNode, 0);
        System.out.println ("\nHight of tree: " + height);
        
        // Step-3: Print Spiral Level Order
        System.out.println ("Spiral Level Order Print: ");
        boolean flag=false;
        for (int i=1; i <= height; i++) {
            printSpiralLevelOrder (rootNode, i, flag);
            flag = !flag;
        }
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
    
    public static int findHightOfTree (Node rootNode, int hight) {
        if (rootNode == null)
            return hight;
        int leftHight = findHightOfTree (rootNode.leftChild, (hight+1));
        int rightHight = findHightOfTree (rootNode.rightChild, (hight+1));
        hight = Math.max (leftHight, rightHight);
        return hight;
    }
    
    public static void printSpiralLevelOrder (Node rootNode, int level, boolean flag) {
        if (rootNode == null)
            return;
        else if (level == 1)
            System.out.print (rootNode.value + " ");
        if (flag) {
            printSpiralLevelOrder (rootNode.leftChild, (level-1), flag);
            printSpiralLevelOrder (rootNode.rightChild, (level-1), flag);
        } else {
            printSpiralLevelOrder (rootNode.rightChild, (level-1), flag);
            printSpiralLevelOrder (rootNode.leftChild, (level-1), flag);
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
