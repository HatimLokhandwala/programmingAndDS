package LinkedList;

import java.util.List;

public class LinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;

    LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insertAtHead(final int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    public ListNode getHead() {
        return head;
    }

    // eg: 79-> 85 -> 1 - > 5 -> 700
    // eg: 79-> 85 -> 1 - > 5
    /**
     * Returns middle node of the given linked list.
     * @return
     */
    public ListNode determineMiddleNode() {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public ListNode findCycleStartIfExists() {
        ListNode meetingPoint = checkCycle();
        if (meetingPoint == null) {
            return null;
        }
        ListNode pointerOne = head;
        ListNode pointerTwo = meetingPoint;
        while (pointerOne == pointerTwo) {
            pointerOne = pointerOne.next;
            pointerTwo = pointerTwo.next;
        }
        return pointerOne;
    }

    private ListNode checkCycle() {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        return fast;
    }
}

