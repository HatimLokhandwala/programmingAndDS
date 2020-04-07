package LinkedList;

/*
 * Given a linked list, reverse the linked list
 * Eg:  Input  1 --> 2 --> 3 --> 4 --> null
 * 		Output 4 --> 3 --> 2 --> 1 --> null
 * Below are two approaches to reverse the linked list
 * - iterative
 * - recursive
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



