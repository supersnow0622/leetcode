package list;


/**
 * @Description:You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 * @author:王丽雪
 * @time:2017年6月27日下午1:54:20
 */
public class add_two_numbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		ListNode head = new ListNode(0);
		ListNode p = head;
		int value = 0;
		while(l1 != null || l2 != null || value != 0){
			if(l1 != null){
				value += l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				value += l2.val;
				l2 = l2.next;
			}
			p.next = new ListNode(value % 10);
			p = p.next;
			value = value / 10;
		}
		return head.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		
		node1.next = node2;
		node2.next = node3;
		
		
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(4);
		
		node4.next = node5;
		node5.next = node6;
		
		add_two_numbers a = new add_two_numbers();
		a.addTwoNumbers(node1, node4);
		
	}
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
}
