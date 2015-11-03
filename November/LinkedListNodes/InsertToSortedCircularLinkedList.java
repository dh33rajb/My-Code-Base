// 1. Insert an element in a sorted circular linked list.

// 2. Insert an element to a sorted circular linked list.


import java.util.*;
import java.lang.*;

class Solution {

  public static void main(String args[]) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(5);
    head.next.next.next.next = new Node(6);
    head.next.next.next.next.next = new Node(7);
    head.next.next.next.next.next.next = new Node(8);
    head.next.next.next.next.next.next.next = head.next.next.next;

    head = insertToSortedLinkedList (head, new Node(10));

    printNodes (head);
  }

  public static Node insertToSortedLinkedList(Node head, Node node) {
    // base case
    if (head == null || node == null)
      return null;
    
    // Case-1: If new node is to be inserted ahead of the head node
    if (node.val < head.val) {
      node.next = head;
      head = node;
      return head;
    }
    
    // Variables for case-3: pre saving them
    Node largestNode = head;
    boolean inserted = false;
    
    // Case-2: If new node is to be inserted between head and the tail/last (largest) node
    // generic case
    Node slow = head;
    Node fast = head;
    Node prev = null;
    do {
      if (node.val < slow.val) {
        prev.next = node;
        node.next = slow;
        inserted = true;
        break;
      }
      if (slow.val > largestNode.val)
        largestNode = slow;
      prev = slow;
      slow = slow.next;
      fast = fast.next != null ? fast.next.next : null;
    } while (fast!= null && fast != slow);
    
    if (fast == null)
      return head;
    
    Node neww = head;
    while (slow != neww) {
      if (node.val < slow.val) {
        prev.next = node;
        node.next = slow;
        inserted = true;
        break;
      }
      if (slow.val > largestNode.val)
        largestNode = slow;
      prev = slow;
      slow = slow.next;
      neww = neww.next;
    }
    
    // Case-3: If new node is to be inserted after the tail/last (largest) node in the loop
    if (!inserted) {
      System.out.println ("here");
      // insert after largest node
      Node temp = largestNode.next;
      largestNode.next = node;
      node.next = temp;
    }
    
    return head;
  }
  
  public static void printNodes (Node head) {
    Node slow = head;
    Node fast = head;
    do {
      System.out.println (":" + slow.val);
      slow = slow.next;
      fast = fast.next != null ? fast.next.next : null;
    } while (fast!= null && fast != slow);
    
    if (fast == null)
      return;
    
    Node neww = head;
    while (slow != neww) {
      System.out.println (":" + slow.val);
      slow = slow.next;
      neww = neww.next;
    }
  }
}

class Node {
  public int val;
  public Node next;
  public Node(int val) {
    this.val = val;
  }
}
