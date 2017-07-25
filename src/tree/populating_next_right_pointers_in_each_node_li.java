package tree;

import tree.populating_next_right_pointers_in_each_node.TreeLinkNode;

/**
 * @Description:链接：https://www.nowcoder.com/practice/f18bc13a954f4389900b56e545feca6e?tpId=46&tqId=29063&tPage=2&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
来源：牛客网

Follow up for problem "Populating Next Right Pointers in Each Node".
What if the given tree could be any binary tree? Would your previous solution still work?
Note:
You may only use constant extra space.

For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7

After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 * @author:王丽雪
 * @time:2017年2月25日下午8:28:18
 */
public class populating_next_right_pointers_in_each_node_li {
	public void connect(TreeLinkNode root) {
		if(root == null)
			return ;
		TreeLinkNode populating_node = null;
        if(root.left != null && root.right != null){
        	root.left.next = root.right;
        	populating_node = root.right;
        }else if(root.left != null){
        	populating_node = root.left;
        }else if(root.right != null){
        	populating_node = root.right;
        }
        if(root.next != null && populating_node != null){
	        TreeLinkNode curRoot = root.next;
	    	while(curRoot != null){
	    		if(curRoot.left != null){
	    			populating_node.next = curRoot.left;
	    			break;
	    		}else if(curRoot.right != null){
	    			populating_node.next = curRoot.right;
	    			break;
	    		}else{
	    			curRoot = curRoot.next;
	    		}
	    	}
        }
        connect(root.right);
        connect(root.left);
        
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
		TreeLinkNode node8 = new TreeLinkNode(8);
		TreeLinkNode node9 = new TreeLinkNode(9);
		TreeLinkNode node10 = new TreeLinkNode(10);
		TreeLinkNode node11 = new TreeLinkNode(11);
		TreeLinkNode node12 = new TreeLinkNode(12);
		TreeLinkNode node13 = new TreeLinkNode(13);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right =node7;
		node4.left = node8;
		node5.left = node9;
		node5.right = node10;
		node7.left = node11;
		node7.right = node12;
		node10.left = node13;
		
		populating_next_right_pointers_in_each_node_li p = new populating_next_right_pointers_in_each_node_li();
		p.connect(node1);
		System.out.println();
	}

}
