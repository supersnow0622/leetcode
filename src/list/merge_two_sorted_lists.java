package list;

import java.util.ArrayList;



/**
 * @Description:Merge two sorted linked lists and return it as a new list. The new list should be made by splicing
 *  together the nodes of the first two lists.
 * @author:王丽雪
 * @time:2017年6月22日下午9:32:01
 */
public class merge_two_sorted_lists {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head= new ListNode(0);
		ListNode p = head;
		while(l1!=null&&l2!=null){
			if(l1.val<=l2.val){
				p.next=l1;
				l1=l1.next;
			}else{
				p.next=l2;
				l2= l2.next;
			}
			p=p.next;
		}
		if(l1!=null){
			p.next=l1;
		}
		if(l2!=null){
			p.next=l2;
		}
		return head.next;
    }
	//Merge k sorted linked lists and return it as one sorted list. 
	//Analyze and describe its complexity.
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0)
        	return null;
        ListNode head = lists.get(0);
        for(int i = 1;i < lists.size(); i++){
        	head = mergeTwoLists(head, lists.get(i));
        }
        return head;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(7);
		ListNode node5 = new ListNode(9);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		ListNode node21 = new ListNode(2);
		ListNode node22 = new ListNode(4);
		ListNode node23 = new ListNode(6);
		ListNode node24 = new ListNode(8);
		ListNode node25 = new ListNode(10);
		
		node21.next = node22;
		node22.next = node23;
		node23.next = node24;
		node24.next = node25;
		
		merge_two_sorted_lists m = new merge_two_sorted_lists();
		ListNode node = m.mergeTwoLists(node1,node21);
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
