// Binary Tree - Level order traversal
import java.util.*;
import java.lang.*;

class BstFromSortedArray {
  
  private static Node prev = null;
  public static void main (String args[]) {
    // Step-1: Populate inputs
    int[] input = new int[] {4, 5, 8, 9, 10, 15, 16, 25, 42};
    Node root = insertIntoBstOne (input);
    printInOrderTraversal(root);
  }
  
  public static Node insertIntoBstOne (int[] input) {
    if (input == null || input.length == 0)
      return null;
    else {
      Node root = null;
      return insertIntoBstTwo (root, input, 0, input.length - 1);
    }
  }
  
  public static Node insertIntoBstTwo (Node root, int[] input, int start, int end) {
    if (start > end)
      return root;
    int mid = (start+end)/2;
    
    root = insertIntoBstThree (root, input[mid]);
    
    insertIntoBstTwo (root, input, start, mid-1);
    insertIntoBstTwo (root, input, mid+1, end);
    return root;
  }
  
  public static Node insertIntoBstThree (Node root, int val) {
    if (root == null)
      root = new Node (val);
    else if (val < root.val)
      root.left = insertIntoBstThree (root.left, val);
    else
      root.right = insertIntoBstThree (root.right, val);
    return root;
  }
  
  // print in-order traversal
  public static void printInOrderTraversal (Node root) {
    if (root == null)
      return;
    printInOrderTraversal (root.left);
    System.out.print (root.val + "-");
    printInOrderTraversal (root.right); 
  }
}

class Node {
  public int val;
  public Node left;
  public Node right;
  
  public Node (int val) {
    this.val = val;
  }
}
