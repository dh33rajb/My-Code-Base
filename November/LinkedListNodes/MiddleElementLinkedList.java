// find middle element in a linkedlist
import java.util.*;
import java.lang.*;

public class MiddleElementLinkedList {
  public static void main (String args[]) {
    Node node = new Node (1);
    node.next = new Node (2);
    node.next.next = new Node (3);
    node.next.next.next = new Node (4);
    node.next.next.next.next = new Node (5);
    node.next.next.next.next.next = new Node (6);
    node.next.next.next.next.next.next = new Node (7);
    node.next.next.next.next.next.next.next = new Node (8);
    
    System.out.println (middleElement (node).val);
  }
  public static Node middleElement (Node head) {
    if (head == null || head.next == null)
      return head;

    Node slow = head;
    Node fast = head.next; // starting one step ahead of head

    while (fast != null) {
      slow = slow.next;
      fast = fast.next != null? fast.next.next : null;
    }
    return slow;
  }
}



class Node  {
  public int val;
  public Node next;
  public Node (int val) {
    this.val = val;
  }
}
