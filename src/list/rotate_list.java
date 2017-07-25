package list;


/**
 * @Description:Given a list, rotate the list to the right by k places, 
 * where k is non-negative.
For example:
Given1->2->3->4->5->NULLand k =2,
return4->5->1->2->3->NULL.
 * @author:王丽雪
 * @time:2017年6月22日下午9:27:13
 */
public class rotate_list {
	public ListNode rotateRight(ListNode head, int n) {
		if(head == null || n == 0)
			return head;
		int num = 1;
		ListNode cur = head;
		while(cur.next != null) {
			num++;
			cur = cur.next;
		}
		n %= num;
		if(n == 0)
			return head;
		cur.next = head;
		for(int i=0; i<num-n; i++) {
			cur = cur.next;
		}
		head = cur.next;
		cur.next = null;
		return head;
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
	
		rotate_list r = new rotate_list();
		ListNode node = r.rotateRight(node1, 8);
		System.out.println();
	}
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
}
