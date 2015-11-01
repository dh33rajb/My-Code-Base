// BINARY TREE TO DOUBLY LINKED LIST - MY BEST
// 1) IN-PLACE FLATTEN BINARY TREE TO SINGLY LINKED LIST
// 2) REVERSE SINGLY LINKED LIST TO MAKE IT DOUBLY LINKED LIST

import java.util.*;
import java.lang.*;

class BinaryTreeToDoublyLinkedListTwo {
  
  private static Node prev = null;
  public static void main (String args[]) {
    // Step-1: Populate inputs
    Node root = new Node (1);
    root.left = new Node (2);
    root.right = new Node (5);
    root.left.left = new Node (3);
    root.left.right = new Node (4);
    root.right.right = new Node (6);
    
    // Step-2: Flatten Binary tree to Singly linked list
    flatten (root);
    Node head = root;
    
    // Step-3: Convery Singly linked list to doubly linked list (Reverse a linked list logic)
    prev = null;
    Node tail = singlyToDoublyList (root);
    
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
  
  public static  void flatten(Node root) {
    if (root == null)
      return;
    
    flatten (root.right);
    flatten (root.left);
    
    root.left = null;
    root.right = prev;
    prev = root; 
  }
  
  public static Node singlyToDoublyList (Node root) {
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
