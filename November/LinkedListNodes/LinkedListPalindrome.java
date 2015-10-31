import java.util.*;
import java.lang.*;

public class LinkedListPalindrome {

  public static void main(String args[]) {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(3);
    node.next.next.next = new ListNode(4);
    node.next.next.next.next = new ListNode(5);
    node.next.next.next.next.next = new ListNode(4);
    node.next.next.next.next.next.next = new ListNode(3);
    node.next.next.next.next.next.next.next = new ListNode(2);
    node.next.next.next.next.next.next.next.next = new ListNode(1);

    System.out.println(isPalindrome(node));
  }

  public static boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;
    // Step-1: Find middle element of the LinkedList
    ListNode middle = findMiddle(head);
    
    // move middle lement by one step ahead to overcome both odd & even list lengths
    middle = middle.next;
    
    // Step-2: Reverse the list from the middle element to the end.
    middle = reverseList(middle);

    // Step-3: Take two pointers --> one starts from start and other from (middle + 1) 
    // and compare values
    while (middle != null) {
      System.out.println (head.val + "--" + middle.val);
      if (head.val != middle.val) 
        return false;
      head = head.next;
      middle = middle.next;
    }

    return true;
  }

  public static ListNode findMiddle(ListNode head) {
    int count = 0;
    if (head == null || head.next == null) return head;

    ListNode slow = head;
    ListNode fast = head.next; // starting one step ahead of head

    while (fast != null && fast.next != null) {
      count++;
      slow = slow.next;
      fast = fast.next != null ? fast.next.next : null;
    }
    return slow;
  }

  public static ListNode reverseList(ListNode middle) {
    ListNode prev = null;
    while (middle != null) {
      ListNode next = middle.next;
      middle.next = prev;
      prev = middle;
      middle = next;
    }
    return prev;
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
    val = x;
  }
}
