package LinkedList;

/*
 * Given a linked list, swap the node in pairs, not by swapping the data but through swapping pointers
 * Eg:  Input  1 --> 2 --> 3 --> 4 --> null
 * 		Output 2 --> 1 --> 4 --> 3 --> null
 *
 *      Input  1 --> 2 --> 3 --> null
 *      Output 2 --> 1 --> 3 --> null
 * Below are two approaches to do the above swapping
 * - iterative
 * - recursive
*/

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        //recursive solution
        if(head == null || head.next ==null) {
            return head;
        }
        ListNode next = head.next;
        ListNode nextNext = next.next;
        next.next = head;
        head.next = swapPairs(nextNext);
        return next;
    }

    public ListNode swapPairsIterative(ListNode head) {
         if(head == null || head.next == null) {
             return head;
         }
         ListNode iter = head;
         ListNode newHead = head.next;
         ListNode prev = new ListNode(0);
         while(iter != null && iter.next != null) {
             ListNode next = iter.next;
             ListNode nextNext = iter.next.next;
             iter.next = nextNext;
             next.next = iter;
             prev.next = next;
             prev = iter;
             iter = nextNext;
         }
         return newHead;
    }
}
