/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      if (headA == null || headB == null)
        return null;
      
      int lengthA = 0;
      int lengthB = 0;
      
      // find length of list A
      ListNode tempA = headA;
      while (tempA != null) {
        lengthA++;
        tempA = tempA.next;
      }
      // find length of list B
      ListNode tempB = headB;
      while (tempB != null) {
        lengthB++;
        tempB = tempB.next;
      }
      // if list 1 is > list 2, advance list 1 by the difference
      if (lengthA > lengthB) {
        int advance = lengthA - lengthB;
        while (advance > 0) {
          headA = headA.next;
          advance--;
        }
      }
      // if list 2 is > list 1, advance list 2 by the difference
      else if (lengthB > lengthA) {
        int advance = lengthB - lengthA;
        while (advance > 0) {
          headB = headB.next;
          advance--;
        }
      }
      System.out.println (headA.val + "-" + headB.val);
      
      // find intersection
      while (headA != null || headB != null) {
        if (headA == headB)
          return headA;
        headA = headA.next;
        headB = headB.next;
      }
      return null;
    }
}
