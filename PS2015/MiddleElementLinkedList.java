import java.io.*;
import java.util.*;

public class MiddleElementLinkedList {
  public static void main(String[] args) {
    
    // Step-1: Define inputs
    Node head = new Node (0);
    head.next = new Node (1);
    head.next.next = new Node (2);
    head.next.next.next = new Node (3);
    head.next.next.next.next = new Node (4);
    head.next.next.next.next.next = new Node (5);
    head.next.next.next.next.next.next = new Node (6);
    head.next.next.next.next.next.next.next = new Node (7);
    head.next.next.next.next.next.next.next.next = new Node (8);
   
    // Step-2: core function invocation
    Node middle = findMiddle (head);
    
    System.out.println (middle!=null?middle.value:null);
  }
  
  public static Node findMiddle (Node head) {
    if (head == null)
      return head;
    Node fast = head;
    Node slow = head;
    
    while (fast!= null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      // System.out.println (fast.value + "-" + slow.value);
    }
    return slow;
  }
}

class Node {
  int value;
  Node next;
  
  public Node (int value) {
    this.value = value;
  }
}
