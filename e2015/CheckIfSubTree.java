// Check if a tree is a sub tree of another tree

import java.util.*;
import java.lang.*;

public class CheckIfSubTree {
  public static void main (String args[]) {
    Node root1 = new Node (26);
    root1.left = new Node (10);
    root1.right = new Node (3);
    root1.left.left = new Node(4);
    root1.left.right = new Node (6);
    root1.left.left.right = new Node(30);
    root1.right.right = new Node (3);
    
    Node root2 = new Node (10);
    root2.left = new Node (4);
    root2.right = new Node (6);
    root2.left.right = new Node (30);
    
    System.out.println (checkSubTree(root1, root2));
  }
  
  public static boolean checkSubTree (Node root1, Node root2) {
    // perform pre-order traversal
    if (root1 == null || root2 == null)
      return false;
    
    if (root1.val == root2.val)
      return checkAgain (root1, root2);
    
    boolean left = checkSubTree (root1.left, root2);
    boolean right = checkSubTree (root1.right, root2);
    
    return (left | right);
  }
  
  public static boolean checkAgain (Node root1, Node root2) {
    if (root2 == null)
      return true;
    if (root1 == null)
      return false;
    if (root1.val != root2.val)
      return false;
    boolean left = checkAgain (root1.left, root2.left);
    boolean right = checkAgain (root1.right, root2.right);
    
    return (left & right);
  }
}
  

class Node {
  int val;
  Node left;
  Node right;
  
  public Node (int val) {
    this.val = val;
  }
}
