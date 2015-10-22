import java.io.*;
import java.util.*;

public class DeleteNodeLinkedList {
  public static void main(String[] args) {
    
    // Step-1: Define inputs
    Node node = new Node (0);
    node.next = new Node (1);
    node.next.next = new Node (2);
    node.next.next.next = new Node (3);
    node.next.next.next.next = new Node (4);
    node.next.next.next.next.next = new Node (5);
    
    int val = 3;
    
    // Step-2: core function invocation
    node = removeValue (node, val);
    
    // Step-3: print outputs
    while (node != null) {
      System.out.print (node.value + "-");
      node = node.next;
    }
  }
  
  public static Node removeValue (Node head, int value) {
    if (head == null)
      return head;
    Node prev = head;
    Node curr = head.next;
    
    while (curr != null) {
      if (curr.value == value)
        prev.next = curr.next;
      else
        prev = curr;
      curr = curr.next;
    }
    return head;
  }
}

class Node {
  int value;
  Node next;
  
  public Node (int value) {
    this.value = value;
  }
}
