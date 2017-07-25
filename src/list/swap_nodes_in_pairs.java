package list;

import java.util.HashMap;

/**
 * @Description:Given a linked list, swap every two adjacent nodes and return its head.
For example,
Given1->2->3->4, you should return the list as2->1->4->3.
Your algorithm should use only constant space. You may not modify the values in the list, 
only nodes itself can be changed.
 * @author:王丽雪
 * @time:2017年6月27日上午11:46:28
 */
public class swap_nodes_in_pairs {
	public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null && cur.next != null){
        	pre.next = cur.next;
        	cur.next = cur.next.next;
        	pre.next.next = cur;
        	pre = cur;
        	cur = cur.next;
        }
        
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

//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
//		node5.next = node6;
		
		swap_nodes_in_pairs s = new swap_nodes_in_pairs();
		s.swapPairs(node1);
	}
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
}
