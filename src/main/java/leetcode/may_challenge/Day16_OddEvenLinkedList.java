package leetcode.may_challenge;

/*	Link: https://leetcode.com/problems/odd-even-linked-list/
 * 	Given a singly linked list, group all odd nodes together followed by the even nodes. 
 * 	Please note here we are talking about the node number and not the value in the nodes.
	You should try to do it in place. The program should run in O(1) space complexity and O(nodes) 
	time complexity.

	Example 1:
	Input: 1->2->3->4->5->NULL
	Output: 1->3->5->2->4->NULL

	Example 2:
	Input: 2->1->3->5->6->4->7->NULL
	Output: 2->3->6->7->1->5->4->NULL

	Note:
	The relative order inside both the even and odd groups should remain as it was in the input.
	The first node is considered odd, the second node even and so on ...
 */
public class Day16_OddEvenLinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode oddHead;
		ListNode evenHead;
		ListNode currOdd, currEven;
		
		currOdd = oddHead = head;
		currEven = evenHead = head.next;

		while (currEven != null && currEven.next != null) {
			currOdd.next = currOdd.next.next;
			currOdd = currOdd.next;

			currEven.next = currEven.next.next;
			currEven = currEven.next;
		}
		
		if (currEven != null) {
			currEven.next = null;
		}
		
		currOdd.next = evenHead;
		return oddHead;
	}
}
