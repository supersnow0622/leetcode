package tree;

/**
 * @Description:根据前序和中序遍历构造二叉树
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年6月28日下午8:40:45
 */
public class construct_binary_tree_from_preorder_and_inorder {
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
        	return null;
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
	public TreeNode buildTree(int[] preorder,int start1,int end1,int[] inorder,int start2,int end2){
		TreeNode rootNode = new TreeNode(preorder[start1]);
		
		if(start1 == end1 && start2 == end2 && preorder[start1] == inorder[start2])
			return rootNode;
		
		int rootInorder = start2;
		while(rootInorder < end2 && preorder[start1] != inorder[rootInorder]){
			rootInorder++;
		}
		int length = rootInorder - start2;
		if(length > 0)
			rootNode.left = buildTree(preorder, start1 + 1, start1 + length, inorder, start2, rootInorder-1);
		if(end2 - rootInorder > 0)
			rootNode.right = buildTree(preorder, start1 + length + 1, end1, inorder, rootInorder + 1, end2);
		
		return rootNode;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int length = 7;
		int[] preOrder = new int[]{1, 2, 4, 5, 3, 6, 7};
		int[] inOrder = new int[]{4, 2, 5, 1, 6, 3, 7};
		try {
			construct_binary_tree_from_preorder_and_inorder c = new construct_binary_tree_from_preorder_and_inorder();
			TreeNode root = c.buildTree(preOrder,inOrder);
//			levelOrder(root);
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
