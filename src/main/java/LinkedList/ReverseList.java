package LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hatim.lokhandwala on 27/05/19.
 */

public class ReverseList {
		static ListNode head = null, tail = null;

		//recursive
		static ListNode reverseListUtil(ListNode head, ListNode current) {
			if(current == null) {
				return null;
			}

			ListNode res = reverseListUtil(head, current.next);
			if (res == null) {
				head = current;
			} else {
				res.next = current;
			}
			return current;
		}
		public static ListNode reverseList() {
			ListNode current = head;
			ListNode res = reverseListUtil(head,current);
			res.next = null;
			return head;
		}


		static void addNode(int val){
			ListNode l = new ListNode(val);
			if(head == null) head = l;
			if(tail == null) {
				tail = l;
			} else {
				tail.next = l;
				tail = l;
			}
		}

		static void printList(){
			ListNode temp  = head;
			while(temp != null) {
				System.out.print(temp.val + " ");
				temp = temp.next;
			}
		}

	public static void main(String[] args) {
		addNode(1);
		addNode(2);
		addNode(3);
		addNode(4);
		addNode(5);
		List<Integer> l  = new ArrayList<>();
		l.remove(1);
//		l.add()
		printList();
		reverseList();
		printList();
	}
}
