package LinkedList;

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
*/

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //recursive
        if(head == null || head.next == null) {
            return head;
        }
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public ListNode reverseListIterative(ListNode head) {
         ListNode prev = null;
         ListNode iter = head;
         while(iter != null) {
             ListNode next = iter.next;
             iter.next = prev;
             prev = iter;
             iter = next;
         }
         return prev;
    }
}



