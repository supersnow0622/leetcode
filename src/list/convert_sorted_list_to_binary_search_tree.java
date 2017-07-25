package list;


/**
 * @Description:Given a singly linked list where elements are sorted in ascending order,
 *  convert it to a height balanced BST.
 * @author:王丽雪
 * @time:2017年6月22日下午8:40:47
 */
public class convert_sorted_list_to_binary_search_tree {

	public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
        	return null;
        if(head.next == null)
        	return new TreeNode(head.val);
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
        	pre = slow;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        TreeNode rootNode = new TreeNode(slow.val);
        pre.next = null;
        rootNode.left = sortedListToBST(head);
        rootNode.right = sortedListToBST(slow.next);
        
        return rootNode;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}

	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
