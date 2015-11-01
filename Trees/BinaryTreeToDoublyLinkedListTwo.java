// Binary Tree - Level order traversal
import java.util.*;
import java.lang.*;

class BinaryTreeToDoublyLinkedListTwo {
  
  private Node prev = null;
  public static void main (String args[]) {
    // driver method
    Node root = new Node (1);
    root.left = new Node (2);
    root.right = new Node (5);
    root.left.left = new Node (3);
    root.left.right = new Node (4);
  
    root.right.right = new Node (6);
    
    BinaryTreeToDoublyLinkedListTwo s = new BinaryTreeToDoublyLinkedListTwo ();
    
    s.flatten (root);
    Node head = root;
    
    s.prev = null; // need a prev variable for this too, so resetting
    Node tail = s.singlyToDoublyList (root);
    
    while (head != null) {
      System.out.print (head.val + "-");
      head = head.right;
    }
    System.out.println ();
    
    while (tail != null) {
      System.out.print (tail.val + "-");
      tail = tail.left;
    }
  }
  
  public void flatten(Node root) {
    if (root == null)
      return;
    
    flatten (root.right);
    flatten (root.left);
    
    root.left = null;
    root.right = prev;
    prev = root; 
  }
  
  public Node singlyToDoublyList (Node root) {
    if (root == null)
      return null;
    while (root != null) {
      root.left = prev;
      prev = root;
      root = root.right;
    }
    return prev;
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
