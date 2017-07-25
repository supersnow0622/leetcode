package tree;

/**
 * @Description:链接：https://www.nowcoder.com/practice/185a87cd29eb42049132aed873273e83?tpId=46&tqId=29051&tPage=2&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
来源：牛客网

Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path1->2->3which represents the number123.
Find the total sum of all root-to-leaf numbers.
For example,
    1
   / \
  2   3

The root-to-leaf path1->2represents the number12.
The root-to-leaf path1->3represents the number13.
Return the sum = 12 + 13 =25.
 * @author:王丽雪
 * @time:2017年2月11日上午8:56:57
 */
public class sum_root_to_left_numbers {
	public int total = 0;
    public int tmp = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        sumNumbers1(root);
        return total;
    }
    public void sumNumbers1(TreeNode root){
        if(root.left == null && root.right == null){
            total += (tmp * 10 + root.val);
        }
        tmp = tmp * 10 + root.val;
        if(root.left != null)
            sumNumbers1(root.left);
        if(root.right != null)
            sumNumbers1(root.right);
        tmp = tmp/10;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sum_root_to_left_numbers s = new sum_root_to_left_numbers();
		TreeNode node1 = new TreeNode(0);
		TreeNode node2 = new TreeNode(1);
		node1.left = node2;
		System.out.println(s.sumNumbers(node1));
	}
	
}
