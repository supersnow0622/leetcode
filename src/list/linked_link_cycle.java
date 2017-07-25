package list;

import java.util.ArrayList;


/**
 * @Description:Given a linked list, determine if it has a cycle in it.�жϸ������������Ƿ���ڻ�
Follow up:
Can you solve it without using extra space?
 * @author:����ѩ
 * @time:2017��6��16������2:18:46
 */
public class linked_link_cycle {
	public boolean hasCycle(ListNode head) {
		if(head == null)
			return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
        	fast = fast.next.next;
        	slow = slow.next;
        	if(fast == slow)
        		return true;
        }
        return false;
    }
	//�ҳ������б��еĻ���ʼ�ĵط�
	public ListNode detectCycle(ListNode head) {
		if(head == null)
			return null;
        ListNode fast = head;
        ListNode slow = head;
        ArrayList<ListNode> visited = new ArrayList<ListNode>();
        while(fast != null && fast.next != null){
        	fast = fast.next.next;
        	slow = slow.next;
        	if(fast == slow){
        		ListNode cur = head;
        		while(cur != null){
        			if(visited.contains(cur))
        				return cur;
        			else
        				visited.add(cur);
        			cur = cur.next;
        		}
        		break;
        	}
        }
        return null;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListNode node3 = new ListNode(0);
		node2.next = node3;
		ListNode node4 = new ListNode(-4);
		node3.next = node4;
//		ListNode node5 = new ListNode(5);
//		node4.next = node5;
		
		node4.next = node1;
		
		linked_link_cycle l = new linked_link_cycle();
 		l.detectCycle(node1);
	}

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
    }
}
