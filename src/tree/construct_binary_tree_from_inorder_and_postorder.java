package tree;

/**
 * @Description:根据中序和后序遍历构造二叉树
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年6月28日下午8:40:25
 */
public class construct_binary_tree_from_inorder_and_postorder {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
        	return null;
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
	public TreeNode buildTree(int[] inorder, int start1,int end1,int[] postorder,int start2,int end2) {
        TreeNode root = new TreeNode(postorder[end2]);
        
        if(start1 == end1 && start2 == end2 && inorder[start1] == postorder[start2])
        	return root;
        
        int rootInOrder = start1;
        while(rootInOrder < end1 && inorder[rootInOrder] != postorder[end2]){
        	rootInOrder++;
        }
        int length = rootInOrder - start1;
        if(length > 0)
        	root.left = buildTree(inorder, start1, rootInOrder - 1, postorder, start2 , start2 + length - 1);
        if(end1 - rootInOrder > 0)
        	root.right = buildTree(inorder, rootInOrder + 1, end1, postorder, start2 + length, end2 - 1);
        return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		construct_binary_tree_from_inorder_and_postorder c = new construct_binary_tree_from_inorder_and_postorder();
		TreeNode rootNode = c.buildTree(new int[]{1,2,3},new int[]{3,2,1});
		System.out.println();
	}

}
