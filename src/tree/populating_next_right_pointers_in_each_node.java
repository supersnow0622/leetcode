package tree;

/**
 * @Description:链接：https://www.nowcoder.com/practice/fdbd05d647084fcf9be78444e231998b?tpId=46&tqId=29064&tPage=2&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
来源：牛客网

Given a binary tree
    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set toNULL.
Initially, all next pointers are set toNULL.
Note:
You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7

After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 * @author:王丽雪
 * @time:2017年2月25日下午8:28:52
 */
public class populating_next_right_pointers_in_each_node {
	public void connect(TreeLinkNode root) {
		if(root == null)
			return ;
        if(root.left != null && root.right != null)
        	root.left.next = root.right;
        if(root.next != null && root.right != null)
        	root.right.next = root.next.left;
       
        connect(root.left);
        connect(root.right);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode node1 = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		TreeLinkNode node4 = new TreeLinkNode(4);
		TreeLinkNode node5 = new TreeLinkNode(5);
		TreeLinkNode node6 = new TreeLinkNode(6);
		TreeLinkNode node7 = new TreeLinkNode(7);
		
//		node1.left = node2;
//		node1.right = node3;
//		node2.left = node4;
//		node2.right = node5;
//		node3.left =node6;
//		node3.right = node7;
		
		populating_next_right_pointers_in_each_node p = new populating_next_right_pointers_in_each_node();
		p.connect(node1);
		System.out.println();
	}
	static class TreeLinkNode {
		int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
}
