/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode tail = null;
    public ListNode reverseList(ListNode head) {
        reverseListRecurse(head);
        return tail;
    }
    
    public ListNode reverseListRecurse (ListNode head) {
        if (head == null)
          return head;
        ListNode next = reverseList (head.next);
        if (next == null)
          tail = head;
        else
          next.next = head;
        head.next = null;
        return head;
    }
}
