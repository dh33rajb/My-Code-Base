import java.io.*;
import java.util.*;

public class CycleInLinkedList {
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
    head.next.next.next.next.next.next.next.next = head.next.next.next.next;
   
    // Step-2: core function invocation
    Node cycleNode = findCycleNode (head);
    
    System.out.println (cycleNode!=null?cycleNode.value:null);
  }
  
  public static Node findCycleNode (Node head) {
    if (head == null)
      return head;
    Node slow = head.next;
    Node fast = head.next.next;
    
    while (fast != slow) {
      slow = slow.next;
      fast = fast.next.next;
    }
    
    Node cycle = head;
    
    while (cycle != slow) {
      cycle = cycle.next;
      slow = slow.next;
    }
    return cycle;
  }
}

class Node {
  int value;
  Node next;
  
  public Node (int value) {
    this.value = value;
  }
}
