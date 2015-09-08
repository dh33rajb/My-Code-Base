// LastCommonAncestorBst.java
/*
Input (hardcoded):
-----------------
int[] input = new int[] {1,2,3,4,5,6,7,8,9,10,11};
int nodeOneValue = 8;
int nodeTwoValue = 11;

Output:
------
1-2-3-4-5-6-7-8-9-10-11- ===> Level-order traversal
[1, 2, 4, 8] ==> Path to node one
[1, 2, 5, 11] ==> path to node two
2 ==> Common ancestor
*/

import java.util.*;
import java.lang.*;

public class Solution {
  public static void main (String args[]) {
    
    // Step-1: Define inputs
    int[] input = new int[] {1,2,3,4,5,6,7,8,9,10,11};
    int nodeOneValue = 8;
    int nodeTwoValue = 11;
    
    // Step-2: Define a tree with the array placed in level order
    Node rootNode = null;
    rootNode = populateBinaryTree (rootNode, input);
    
    // Step-3: Check if tree is populated fine
    printLevelOrderTraversal(rootNode);
    System.out.println ();
    
    // Step-4: Find last common ancestor
    int commonNode = findLastCommonAncestor (rootNode, nodeOneValue, nodeTwoValue);
    System.out.println (commonNode);
  }
  
  public static Node populateBinaryTree (Node rootNode, int[] input) {
    if (input.length == 0)
      return rootNode;
    int index= 0;
    rootNode = new Node (input[index++]);
    Queue <Node> queue = new LinkedList<Node>();
    queue.add (rootNode);
    while (index <input.length) {
      Node peekNode = queue.peek();
      if (peekNode.leftChild == null)
        peekNode.leftChild = new Node (input[index++]);
      else if (peekNode.rightChild == null)
        peekNode.rightChild = new Node (input[index++]);
      else {
        Node poppedNode = queue.remove();
        queue.add (poppedNode.leftChild);
        queue.add (poppedNode.rightChild);
      }
    }
    return rootNode;
  }
  
  public static void printLevelOrderTraversal(Node rootNode) {
    if (rootNode == null)
      return;
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(rootNode);
    while (queue.size() > 0) {
      Node pollNode = queue.poll();
      System.out.print(pollNode.value + "-");
      if (pollNode.leftChild != null)
          queue.add(pollNode.leftChild);
      if (pollNode.rightChild != null)
          queue.add(pollNode.rightChild);
    }
  }
  
  public static int findLastCommonAncestor (Node rootNode, int nodeOneValue, int nodeTwoValue) {
    if (rootNode == null)
      return 0;
    List<Integer> pathToNodeOne = new ArrayList<Integer>();
    List<Integer> pathToNodeTwo = new ArrayList<Integer>();
    pathToNodeOne = fetchPathToNode (rootNode, pathToNodeOne, nodeOneValue);
    pathToNodeTwo = fetchPathToNode (rootNode, pathToNodeTwo, nodeTwoValue);
    System.out.println(pathToNodeOne);
    System.out.println(pathToNodeTwo);
    int count= 0;
    while (count < Math.min(pathToNodeOne.size(), pathToNodeTwo.size()) && pathToNodeOne.get(count) == pathToNodeTwo.get(count)) {
      count++;
    }
    return pathToNodeOne.get(--count);
  }
  
  public static List<Integer> fetchPathToNode (Node rootNode, List<Integer> list, int nodeValue) {
    if (rootNode == null)
      return list;
    if (rootNode.value == nodeValue) {
      list.add(rootNode.value);
      return list;
    }
    list.add (rootNode.value);
    
    List<Integer> leftList = new ArrayList<Integer>();
    leftList.addAll(list);
    leftList = fetchPathToNode (rootNode.leftChild, leftList, nodeValue);
    
    List<Integer> rightList = new ArrayList<Integer>();
    rightList.addAll(list);
    rightList = fetchPathToNode (rootNode.rightChild, rightList, nodeValue);
    
    if (leftList.get(leftList.size()-1) == nodeValue)
      return leftList;
    else if (rightList.get(rightList.size()-1) == nodeValue)
      return rightList;
    return list;
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
