// http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
// Max Sum Path Binary Tree
/*
Input (hardcoded):
------
-1, 2, 3, 4, 5, 6, 7, -8, -9

Output:
-------
Original Binary tree - Level Order: 
[-1, 2, 3, 4, 5, 6, 7, -8, -9]
Max sum path list is: [-1, 3, 7] and sum is: 9
*/

import java.util.*;
import java.lang.*;

public class MaxSumPathBinaryTree {
  public static void main (String args[]) {
    // Step-1: define a complete binary tree
    int[] input = new int[] {-1, 2, 3, 4, 5, 6, 7, -8, -9};
    Node rootNode = null;
    for (int i : input)
      rootNode = inserIntoBinaryTree (rootNode, i);

    // Step-2: check if binary tree is formed well - level order traversal
    System.out.println ("Original Binary tree - Level Order: ");
    List<Integer> levelOrderList =  getLevelOrderTraversal(rootNode, new ArrayList<Integer>());
    System.out.println (levelOrderList);
    
    // Step-3: compute max sum path for all nodes
    List<Integer> maxSumPathList = computeMaxSumPathForAllNodes(rootNode, new ArrayList<Integer>());
    int sum=0;
    for (int i: maxSumPathList)
      sum = sum + i;
    System.out.println ("Max sum path list is: " + maxSumPathList + " and sum is: " + sum);
  }
  
public static Node inserIntoBinaryTree (Node rootNode, int value) {
    if (rootNode == null)
      return new Node (value);
    Queue <Node> queue = new LinkedList<Node> ();
    queue.add (rootNode);
    while (!queue.isEmpty()) {
      Node peekNode = queue.peek();
      if (peekNode.leftChild == null) {
        peekNode.leftChild = new Node (value);
        return rootNode;
      }
      else if (peekNode.rightChild == null) {
        peekNode.rightChild = new Node (value);
        return rootNode;
      }
      else {
        Node poppedNode = queue.remove();
        queue.add(poppedNode.leftChild);
        queue.add (poppedNode.rightChild);
        
      }
    }
    return rootNode;
  }
  
  public static List<Integer> getLevelOrderTraversal (Node rootNode, List<Integer> levelOrderList) {
    if (rootNode == null)
      return levelOrderList;
    Queue<Node> queue = new LinkedList<Node> ();
    queue.add (rootNode);
    
    while(!queue.isEmpty()) {
      Node poppedNode = queue.poll();
      levelOrderList.add(poppedNode.value);
      if (poppedNode.leftChild != null)
        queue.add (poppedNode.leftChild);
      if (poppedNode.rightChild != null)
      queue.add (poppedNode.rightChild);
    }
    return levelOrderList;
  }
  
  public static List<Integer> computeMaxSumPathForAllNodes (Node rootNode, List<Integer> list) {
    if (rootNode == null)
      return list;
    list.add (rootNode.value);
    
    List<Integer> leftList = new ArrayList<Integer> ();
    leftList.addAll(list);
    leftList = computeMaxSumPathForAllNodes (rootNode.leftChild, leftList);
    int leftSum = 0;
    for (int i : leftList)
      leftSum = leftSum + i;
    
    List<Integer> rightList = new ArrayList<Integer> ();
    rightList.addAll(list);
    rightList = computeMaxSumPathForAllNodes (rootNode.rightChild, rightList);
    int rightSum = 0;
    for (int i : rightList)
      rightSum = rightSum + i;
    
    if(leftSum > rightSum)
      return leftList;
    else
      return rightList;
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
