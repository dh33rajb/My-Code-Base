// THSI IS ONLY FOR A BST, NOT A BINARY TREE

/* 
Input: pre-ordered array of a BST: 10, 5, 1, 7, 40, 50
------

Output: BST (prove by displaying in-order and level-order traversal)
------
1-5-7-10-40-50- (In-order)
10-5-40-1-7-50- (Level-order)
*/

import java.util.*;
import java.lang.*;

// public class BinarySearchTreeFromPreOrderTraversal
public class BSTFromPreOrderTraversal {
  public static void main (String args[]) {
    int [] input = new int [] {10, 5, 1, 7, 40, 50};
    // Step-1: Populate BST
    Node rootNode = null;
    for (int i : input)
      rootNode = populateBstFromArray (rootNode, i);
    
    // Step-2: Print in-order traversal to prove reconstruction of BST
    printInOrderTraversal (rootNode);
    System.out.println();
    // Step-3: Print level-order traversal to prove reconstruction of BST
    printLevelOrderTraversal(rootNode);
  }
  
  public static Node populateBstFromArray (Node rootNode, int value) {
    if (rootNode == null)
      rootNode = new Node (value);
    else if (value < rootNode.value)
      rootNode.leftChild = populateBstFromArray (rootNode.leftChild, value);
    else if (value > rootNode.value)
      rootNode.rightChild = populateBstFromArray (rootNode.rightChild, value);
    return rootNode;
  }
  
  public static void printInOrderTraversal (Node rootNode) {
    if (rootNode == null)
      return;
    printInOrderTraversal (rootNode.leftChild);
    System.out.print (rootNode.value + "-");
    printInOrderTraversal (rootNode.rightChild);
  }
  
  public static void printLevelOrderTraversal (Node rootNode) {
    if (rootNode == null)
      return;
    Queue <Node> queue = new LinkedList<Node>();
    queue.add (rootNode);
    
    while (!queue.isEmpty()) {
      Node poppedNode = queue.remove();
      if (poppedNode.leftChild!=null)
        queue.add (poppedNode.leftChild);
      if (poppedNode.rightChild != null)
        queue.add (poppedNode.rightChild);
      System.out.print(poppedNode.value + "-");
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
