package list;


/**
 * @Description:Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example:
Given1->2->3->4->5->NULL, m = 2 and n = 4,
return1->4->3->2->5->NULL.
Note: 
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 * @author:王丽雪
 * @time:2017年6月27日下午12:32:00
 */
public class reverse_linked_list_li {
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode pre = newHead,cur = head;
		for(int i = 1; i < m; i++){
			pre = cur;
			cur = cur.next;
		}
		int len = n - m;
		for(int i = 0; i < len; i++){
			ListNode tmp = cur.next;
			cur.next = tmp.next;
			tmp.next = pre.next;
			pre.next = tmp;
		}
		return newHead.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		reverse_linked_list_li r = new reverse_linked_list_li();
		ListNode node = r.reverseBetween(node1, 2, 5);
		System.out.println();
	}
	private static class ListNode{
		int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
}
