package list;

/**
 * @Description:Given a sorted linked list, delete all duplicates such that each element 
 * appear only once.
For example,
Given1->1->2, return1->2.
Given1->1->2->3->3, return1->2->3.
 * @author:王丽雪
 * @time:2017年6月25日上午10:07:29
 */
public class remove_duplicates_from_sorted_list {
	//重复的保留一个
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)
			return head;
        ListNode cur = head;
        int value = head.val;
        while(cur != null && cur.next != null){
        	ListNode nex = cur.next;
        	while(nex != null && value == nex.val){
        		cur.next = nex.next;
        		nex = cur.next;
        	}
        	
        	if(nex == null)
        		return head;
    		cur = cur.next;
    		value = cur.val;
        }
		return head;
    }
	//只要重复全部删除
	public ListNode deleteDuplicates1(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode newHead = new ListNode(head.val-1);
		newHead.next = head;
		ListNode cur = head;
		ListNode last = newHead;
		while(cur != null&&cur.next != null){
			 if(cur.val != cur.next.val){
				 last = cur;
			 }else{
				 while(cur.next != null&&cur.val == cur.next.val)
					 cur = cur.next;
				 last.next = cur.next;
			 }
			 cur = cur.next;
		}
		return newHead.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(2);
		ListNode node6 = new ListNode(3);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		remove_duplicates_from_sorted_list r = new remove_duplicates_from_sorted_list();
		r.deleteDuplicates(node6);
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
