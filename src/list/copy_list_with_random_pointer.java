package list;
/**
 * @Description:A linked list is given such that each node contains an additional random pointer
 *  which could point to any node in the list or null.
Return a deep copy of the list.
 * @author:王丽雪
 * @time:2017年6月22日下午8:13:57
 */
public class copy_list_with_random_pointer {

	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null)
			return null;
		
		RandomListNode cur = head;
		while(cur != null && cur.next != null){
			RandomListNode tmp = new RandomListNode(cur.label);
			tmp.next = cur.next;
			cur.next = tmp;
			cur = cur.next.next;
		}
		RandomListNode tmp = new RandomListNode(cur.label);
		tmp.next = cur.next;
		cur.next = tmp;
		
		cur = head;
		while(cur != null && cur.next != null){
			if(cur.random != null)
				cur.next.random = cur.random.next;
			cur = cur.next.next;
		}
		
		cur = head;
		RandomListNode randomHead = cur.next;
		RandomListNode newCur = randomHead;
		cur = head;
		while(cur != null && cur.next != null){
			cur.next = cur.next.next;
			if(cur.next == null)
				newCur.next = null;
			else 
				newCur.next = cur.next.next;			
			cur = cur.next;
			newCur = newCur.next;
		}
		return randomHead;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		node1.next = node2;
		RandomListNode node3 = new RandomListNode(3);
		node2.next = node3;
		RandomListNode node4 = new RandomListNode(4);
		node3.next = node4;
		RandomListNode node5 = new RandomListNode(5);
		node4.next = node5;
		RandomListNode node6 = new RandomListNode(6);
		node5.next = node6;
		
		node1.random = node3;
		node2.random = node4;
		node3.random = node1;
		node4.random = node5;
		node5.random = null;
		node6.random = node5;
		
		copy_list_with_random_pointer c = new copy_list_with_random_pointer();
		RandomListNode listNode = c.copyRandomList(node1);
		System.out.println();
	}
	
	static class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
    };

}
