// PERFECT CODE TO SEARCH AND DELETE NODES IN A BST --> ALL 3 CASES COVERED
// THIS CODE CONTAINS BOTH INSERT INTO AND DELETE NODES FROM A BST
/*
Input (Hardcoded):
------------------
int[] input = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
int [] deleteNodesArr = new int[] {5, 10};

Output:
------
Original BST - In Order: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]
BST after Deletion of Nodes - In Order: [1, 2, 3, 4, 6, 7, 8, 9, 11, 12, 13]
*/
// Search and Delete Nodes in a BST
//  THIS CODE CONATAINS BOTH INSERT INTO AND DELETE NODES FROM A BST

import java.util.*;
import java.lang.*;

public class DELETENodesBST {
  public static void main (String args[]) {
    // Step-1: Create a bst from input array
    int[] input = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    int [] deleteNodesArr = new int[] {5, 10};
    
    Node rootNode = null;
    rootNode = findValueAndInsertToBst (rootNode, input, 0, input.length-1);
    
    // Step-2: Verify the creation of binary tree: by inorder traversal
    System.out.print ("Original BST - In Order: ");
    List<Integer> inOrderList =  getInOrderTraversal(rootNode, new ArrayList<Integer>());
    System.out.println (inOrderList);
    
    // Step-3: Delete a couple of nodes from BST
    for (int i : deleteNodesArr)
      rootNode = findAndDeleteNodeFromBst (rootNode, i);
    
    // Step-4: Verify the deletion of nodes in the binary tree: by inorder traversal
    System.out.print ("BST after Deletion of Nodes - In Order: ");
    List<Integer> inOrderList2 =  getInOrderTraversal(rootNode, new ArrayList<Integer>());
    System.out.println (inOrderList2);
  }
  
  public static Node findValueAndInsertToBst (Node rootNode, int[] input, int startIndex, int endIndex) {
    if (endIndex < startIndex)
      return rootNode;
    int midIndex = (startIndex + endIndex)/2;
    rootNode = insertIntoBst (rootNode, input[midIndex]);
    rootNode = findValueAndInsertToBst (rootNode, input, startIndex, midIndex-1);
    rootNode = findValueAndInsertToBst (rootNode, input, midIndex+1, endIndex);
    return rootNode;
  }
  
  public static Node insertIntoBst (Node rootNode, int value) {
    if (rootNode == null)
      return new Node (value);
    if (value < rootNode.value)
      rootNode.leftChild = insertIntoBst (rootNode.leftChild, value);
    else
      rootNode.rightChild = insertIntoBst (rootNode.rightChild, value);
    return rootNode;
  }
  
  public static List<Integer> getInOrderTraversal (Node rootNode, List<Integer> list) {
    if (rootNode == null)
      return list;
    list = getInOrderTraversal (rootNode.leftChild, list);
    list.add (rootNode.value);
    list = getInOrderTraversal (rootNode.rightChild, list); 
    return list;
  }
  
  public static Node findAndDeleteNodeFromBst(Node rootNode, int value) {
    if (rootNode == null)
      return rootNode;
    if (value == rootNode.value) {
      // write delete logic here
      // Case-1: If node == leaf node ==> just delete it
      if (rootNode.leftChild == null && rootNode.rightChild == null)
        rootNode = null;
      // Case-2: If node has only one child ==> swap the child node for current node
      else if (rootNode.leftChild != null && rootNode.rightChild==null)
        rootNode = rootNode.leftChild;
      else if (rootNode.leftChild == null && rootNode.rightChild!= null)
        rootNode = rootNode.rightChild;
      // Case-3: If node == has both children ==> swap with largest (right most) of left sub tree
      else {
        int largestValueOfLeftSubTree = getLargestValueOfLeftSubTree(rootNode.leftChild);
        rootNode.leftChild = deleteLargestValueNodeOfLeftSubTree(rootNode.leftChild);
        rootNode.value = largestValueOfLeftSubTree;
      }
    }
    else if (value < rootNode.value)
      rootNode.leftChild = findAndDeleteNodeFromBst (rootNode.leftChild, value);
    else
      rootNode.rightChild = findAndDeleteNodeFromBst (rootNode.rightChild, value);
    return rootNode;
  }
  // this method is to GET VALUE OF largest node in right sub tree
  public static int getLargestValueOfLeftSubTree (Node rootNode) {
      if (rootNode.rightChild != null)
        return getLargestValueOfLeftSubTree (rootNode.rightChild);
      else
        return rootNode.value;
  }
  // this method is to DELETE largest node in right sub tree
  public static Node deleteLargestValueNodeOfLeftSubTree (Node rootNode) {
      if (rootNode.rightChild != null) {
         rootNode.rightChild = deleteLargestValueNodeOfLeftSubTree (rootNode.rightChild);
         return rootNode;
      }
      else {
        rootNode = rootNode.leftChild;
        return rootNode;
    }
  }
}


class Node {
  public int value;
  public Node leftChild;
  public Node rightChild;
  
  public Node (int value) {
    this.value =  value;
  }
}
