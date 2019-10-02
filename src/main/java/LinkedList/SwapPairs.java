package LinkedList;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        //recursive solution
        if(head == null || head.next ==null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = head.next;
        cur.next = next.next;
        ListNode temp = next.next;
        next.next = cur;
        cur.next = swapPairs(temp);
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
