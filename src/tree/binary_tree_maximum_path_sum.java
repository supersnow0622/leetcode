package tree;


/**
 * @Description:链接：https://www.nowcoder.com/practice/da785ea0f64b442488c125b441a4ba4a?tpId=46&tqId=29056&tPage=2&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
来源：牛客网

Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree.
For example:
Given the below binary tree,
       1
      / \
     2   3

Return 6.
 * @author:王丽雪
 * @time:2017年2月11日上午8:57:26
 */
public class binary_tree_maximum_path_sum {
	private int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
        if (root == null)
        	return 0;

        fun(root);
        return max;
    }
	public int fun(TreeNode root){
		if(root == null) return 0;
		int left = fun(root.left);
		int right = fun(root.right);
		int curmax = root.val;
		if(left > 0)
			curmax += left;
		if(right > 0)
			curmax += right;
		if(max < curmax)
			max = curmax;
		return Math.max(root.val, Math.max(root.val + left,root.val+right));		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(-1);
		TreeNode node3 = new TreeNode(-2);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(10);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		binary_tree_maximum_path_sum b = new binary_tree_maximum_path_sum();
		System.out.println(b.maxPathSum(node1));
	}

}
