package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

 /**
 * @Description:Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
For example:
Given binary tree{3,9,20,#,#,15,7},
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年5月23日上午8:37:42
 */
public class binary_tree_level_order_traversal_li {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> totalList = new ArrayList<ArrayList<Integer>>();
		if(root == null)
			return totalList;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        queue.add(root);
        int in = 1,out = 0,last = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!queue.isEmpty()){
        	TreeNode node = queue.poll();
        	out++;
        	list.add(node.val);
        	if(node.left != null){
        		queue.add(node.left);
        		in++;
        	}
        	if(node.right != null){
        		queue.add(node.right);
        		in++;
        	}
        	if(out == last){
        		last = in;
        		ArrayList<Integer> list1 = (ArrayList<Integer>) list.clone();
        		stack.add(list1);
        		list.clear();
        	}
        }
       
        while(!stack.isEmpty()){
        	totalList.add(stack.pop());
        }
        return totalList;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);

		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		
		binary_tree_level_order_traversal_li b = new binary_tree_level_order_traversal_li();
		ArrayList<ArrayList<Integer>> totalList = b.levelOrderBottom(node1);
	}

}
