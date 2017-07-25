package tree;

public class path_sum {
	public boolean flag = false;
	public boolean hasPathSum(TreeNode root, int sum) {
        pathSum(root,sum,0);
        return flag;
    }
	public void pathSum(TreeNode root, int sum,int curSum){
		if(root == null)
			return ;
		curSum += root.val;
		if(root.left == null && root.right == null){
			if(sum == curSum)
				flag = true;
		}
		if(root.left != null)
			pathSum(root.left,sum,curSum);
		if(root.right != null)
			pathSum(root.right,sum,curSum);
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(11);
		TreeNode node5 = new TreeNode(13);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(2);
		TreeNode node9 = new TreeNode(1);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;
		node4.left = node7;
		node4.right = node8;
		node6.right = node9;
		
		path_sum p = new path_sum();
		System.out.println(p.hasPathSum(node1, 27));
	}
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}
