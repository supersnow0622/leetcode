package list;


/**
 * @Description:Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.
For example,
Given this linked list:1->2->3->4->5
For k = 2, you should return:2->1->4->3->5
For k = 3, you should return:3->2->1->4->5

 * @author:王丽雪
 * @time:2017年6月27日下午1:00:08
 */
public class reverse_nodes_in_k_group {
	
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        ListNode pre = dummy,cur = head,p = head;
        while(p != null){
        	count++;
        	p = p.next;
        	if(count == k){
        		reverse(pre, cur, k);
        		pre = cur;
        		cur = p;
        		count = 0;
        	}
        }
        	
        return dummy.next;
    }
	
	public void reverse(ListNode pre,ListNode cur,int k){
		for(int i = 1;i < k; i++){
			ListNode tmp = cur.next;
			cur.next = tmp.next;
			tmp.next = pre.next;
			pre.next = tmp;
		}
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
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
//		node5.next = node6;
		
		reverse_nodes_in_k_group r = new reverse_nodes_in_k_group();
		r.reverseKGroup(null, 3);
	}
	static class ListNode{
		int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
}
