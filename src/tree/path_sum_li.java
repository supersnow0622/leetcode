package tree;

import java.util.ArrayList;

import tree.path_sum.TreeNode;

public class path_sum_li {
	public ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	public int count = 0;
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		int listItem[] = new int[100];
        pathSum1(root, sum, 0, listItem);
		return list;
    }
	public void pathSum1(TreeNode root, int sum,int curSum,int[] listItem){
		if(root == null)
			return ;
		curSum += root.val;
		listItem[count] = root.val;
		if(root.left == null && root.right == null){
			if(sum == curSum){
				ArrayList<Integer> copyListItem = new ArrayList<Integer>();
				for(int i = 0; i <= count; i++)
					copyListItem.add(listItem[i]);
				list.add(copyListItem);
			}
			return;
		}
		else if(root.right == null){
			count++;
			pathSum1(root.left,sum,curSum,listItem);
			count--;
		}
		else if(root.left == null){
			count++;
			pathSum1(root.right,sum,curSum,listItem);
			count--;
		}
		else{
			count++;
			pathSum1(root.left,sum,curSum,listItem);
			count--;
			count++;
			pathSum1(root.right,sum,curSum,listItem);
			count--;			
		}
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
		TreeNode node9 = new TreeNode(5);
		TreeNode node10 = new TreeNode(1);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;
		node4.left = node7;
		node4.right = node8;
		node6.left = node9;
		node6.right = node10;
		
		path_sum_li p = new path_sum_li();
		ArrayList<ArrayList<Integer>> list = p.pathSum(node1, 22);
		for(int i = 0; i < list.size(); i++){
			
		}
	}

}
