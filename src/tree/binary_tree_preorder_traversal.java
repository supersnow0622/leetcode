package tree;

import java.util.ArrayList;
import java.util.Stack;


/**
 * @Description:非递归前序、中序、后序遍历二叉树
 * @author:王丽雪
 * @time:2017年2月25日下午7:11:43
 */
public class binary_tree_preorder_traversal {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.isEmpty()){
        	while(root != null){
        		stack.add(root);
        		list.add(root.val);
        		root = root.left;
        	}
        	root = stack.pop();
        	root = root.right;
        }
        return list;
	}
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.isEmpty()){
        	while(root != null){
        		stack.push(root);
        		root = root.left;
        	}
        	root = stack.pop();
        	list.add(root.val);
        	root = root.right;
        }
        return list;
	}
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(root == null)
			return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode curNode ,preNode = null;
        while(!stack.isEmpty()){
        	curNode = stack.peek();
        	if((curNode.left == null && curNode.right == null) || (preNode != null && (preNode == curNode.left || preNode == curNode.right))){
        		list.add(curNode.val);
        		stack.pop();
        		preNode = curNode;
        	}
        	else{
        		if(curNode.right != null)
        			stack.push(curNode.right);
        		if(curNode.left != null)
        			stack.push(curNode.left);
        	}
        }
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
//		node1.left = node4;
//		node4.right = node7;
//		node7.left = node6;
//		node7.right = node5;
//		node5.left = node2;
//		node5.right = node3;
		
		binary_tree_preorder_traversal b = new binary_tree_preorder_traversal();
		ArrayList<Integer> list = b.preorderTraversal(null);
		for(int i = 0; i < list.size();i++){
			
		}
	}
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}
