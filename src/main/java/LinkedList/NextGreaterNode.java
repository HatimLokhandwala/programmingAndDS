package LinkedList;

import java.util.Stack;

/**
 * Given a linked list, for each node compute the next larger node
 * For node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest possible choice.
 * If such a j does not exist, the next larger value is 0.
 * Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
 * Eg:  i/p : [2,1,5]
 *      o/p : [5,5,0]
 */
public class NextGreaterNode {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    private class Node{
        int index;
        int value;
        Node(int index, int value) {
            this.value = value;
            this.index = index;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode current = head;
        int size = 0;
        while(current != null) {
            current = current.next;
            size++;
        }
        int[] arr = new int[size];
        Stack<Node> st = new Stack<Node>();
        int count = 0;
        current = head;
        while(current != null) {
            while(!st.empty() && st.peek().value < current.val) {
                Node stTop = st.pop();
                arr[stTop.index] = current.val;
            }
            st.push(new Node(count, current.val));
            current = current.next;
            count++;
        }
        while(!st.isEmpty()) {
            Node stTop = st.pop();
            arr[stTop.index] = 0;
        }
        return arr;
    }
}
