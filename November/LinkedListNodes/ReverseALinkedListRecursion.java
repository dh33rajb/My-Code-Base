// reverse a linked list recusion

import java.util.*;
import java.lang.*;

class Solution {
  private static Node tail = null;
  public static void main (String args[]) {
    Node head = new Node (1);
    head.next = new Node (2);
    head.next.next = new Node (3);
    head.next.next.next = new Node (4);
    head.next.next.next.next = new Node (5);
    head.next.next.next.next.next = new Node (6);
    head.next.next.next.next.next.next = new Node (7);
    
    reverseLinkedList (head);
    
    while (tail != null) {
      System.out.print (tail.val + "-");
      tail = tail.next;
    }
  }
  
  public static Node reverseLinkedList (Node head) {
    if (head == null)
      return head;
    Node next = reverseLinkedList (head.next);
    if (next == null)
      tail = head;
    else
      next.next = head;
    head.next = null;
    return head;
  }

}


class Node {
  int val;
  Node next;
  
  Node (int val) {
    this.val = val;
  }
}
