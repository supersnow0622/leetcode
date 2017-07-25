package list;


/**
 * @Description:Given a singly linked list L: L 0→L 1→…→L n-1→L n,
reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
You must do this in-place without altering the nodes' values.
For example,
Given{1,2,3,4}, reorder it to{1,4,2,3}.
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年6月29日上午9:27:23
 */
public class reorder_list {
	public static void reorderList(ListNode head) {
		if(head != null && head.next != null && head.next.next != null){
			ListNode slow = head;
			ListNode fast = head;
			while(fast.next != null && fast.next.next != null){
				slow = slow.next;
				fast = fast.next.next;
			}
			ListNode pre = slow.next;
			ListNode cur = pre.next;
			while(cur != null){
				ListNode next = cur.next;
				pre.next = cur.next;
				cur.next = slow.next;
				slow.next = cur;
				
				cur = pre.next;
			}
			
			ListNode root = head;
			while(slow.next != null && slow.next.next != null){
				cur = slow.next;
				slow.next = slow.next.next;
				cur.next = root.next;
				root.next = cur;
				root = root.next.next;
			}
			root = head;
		}
		
    }
	
	public static void main(String args[]){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		ListNode node4 = new ListNode(4);
		node3.next = node4;
		ListNode node5 = new ListNode(5);
		node4.next = node5;
		ListNode node6 = new ListNode(6);
		node5.next = node6;
		ListNode node7 = new ListNode(7);
		node6.next = node7;
//		ListNode node8 = new ListNode(8);
//		node7.next = node8;
		reorderList(node1);
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
