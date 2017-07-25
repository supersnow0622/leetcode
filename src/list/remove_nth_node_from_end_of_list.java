package list;


/**
 * @Description:Given a linked list, remove the n th node from the end of list and return its head.
For example,
   Given linked list: 1->2->3->4->5, and n = 2.
   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note: 
Given n will always be valid.
Try to do this in one pass.
 * @author:王丽雪
 * @time:2017年6月27日下午12:28:17
 */
public class remove_nth_node_from_end_of_list {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        int count = 1;
        while(count < n){
        	fast = fast.next;
        	count++;
        }
        while(fast.next != null){
        	slow = slow.next;
        	fast = fast.next;
        }
    
        slow.next = slow.next.next;
        return dummy.next;
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
		
		remove_nth_node_from_end_of_list r = new remove_nth_node_from_end_of_list();
		r.removeNthFromEnd(node1, 6);
	}
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
}
