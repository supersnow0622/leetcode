package list;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:Given a linked list and a value x, partition it such that all nodes less 
 * than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
For example,
Given1->4->3->2->5->2and x = 3,
return1->2->2->4->3->5.
 * @author:王丽雪
 * @time:2017年6月25日上午10:13:24
 */
public class partition_list {
	public ListNode partition(ListNode head, int x) {
		if(head==null)
			return null;
		ListNode dummy1 = new ListNode(0);
		ListNode dummy2 = new ListNode(0);
		ListNode curr1 = dummy1;
		ListNode curr2 = dummy2;
		while(head!=null){
			if(head.val < x){
				curr1.next = head;
				curr1 = curr1.next;
			}else{
				curr2.next = head;
				curr2 = curr2.next;
			}
			head = head.next;
		}
		curr2.next = null;
		curr1.next = dummy2.next; 
		return dummy1.next; 
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(6);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(1);
		ListNode node6 = new ListNode(2);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		partition_list p = new partition_list();
		p.partition(node1,3 );
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
