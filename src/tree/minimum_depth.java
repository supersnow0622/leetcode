package tree;

 /**
 * @Description:Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from 
 * the root node down to the nearest leaf node.
 * @author:王丽雪
 * @time:2017年2月10日下午9:02:06
 */
public class minimum_depth {
	
	public int run(TreeNode root){
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		int l = 0,r = 0;
		if(root.left != null)
			l = 1 + run(root.left);
		if(root.right != null)
			r = 1 + run(root.right);
		if(l == 0)
			return r;
		else if(r == 0)
			return l;
		else 
			return l > r ? r : l;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minimum_depth m = new minimum_depth();
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		
		
//		node1.left = node2;
//		node2.left = node3;
//		node2.right = node4;
//		node3.left = node5;
		
//		node1.left = node2;
//		node1.right = node3;
//		node2.left = node4;
//		node2.right = node5;
		
		node1.left = node2;
		node2.left = node3;
		node3.left = node4;
		node4.left = node5;
		
//		node1.left = node2;
//		node1.right = node3;
//		node2.right = node4;
//		node3.left = node5;
//		node3.right = node6;
//		node4.left = node7;
//		node5.left = node8;
		
		System.out.println(m.run(node1));
	}

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}