package dynamic_programming;

/**
 * @Description:链接：https://www.nowcoder.com/practice/2bdc44bb0186468b8d8c13ea5d3a9e58?tpId=46&tqId=29091&tPage=4&rp=4&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
来源：牛客网

Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
Below is one possible representation of s1 ="great":
    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.
For example, if we choose the node"gr"and swap its two children, it produces a scrambled string"rgeat".
    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that"rgeat"is a scrambled string of"great".
Similarly, if we continue to swap the children of nodes"eat"and"at", it produces a scrambled string"rgtae".
    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that"rgtae"is a scrambled string of"great".
Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * @author:王丽雪
 * @time:2017年2月21日下午8:28:24
 */
public class scramble_string {
	public boolean isScramble(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		if(s1.length() == 0)
			return true;
		if(s1.equals(s2))
			return true;
       boolean dp[][][] = new boolean[s1.length() + 1][s1.length() + 1][s1.length() + 1];       
       int len = s1.length();
       for(int i = 0; i < len; i++)
    	   for(int j = 0; j < len; j++){
    		   if(s1.charAt(i) == s2.charAt(j))
    			   dp[1][i][j] = true;
    	   }
       for(int k = 2; k <= len; k++){
    	   int last = len - k;
    	   for(int i = 0; i <= last; i++)
    		   for(int j = 0; j <= last; j++){
    			   boolean flag = false;
    			   for(int m = 1; m < k && !flag; m++){
    				   if((dp[m][i][j] && dp[k-m][m+i][m+j])||(dp[m][i][j+k-m] && dp[k-m][i+m][j])){
    					   dp[k][i][j] = true;
    					   flag = true;
    				   }
    			   }
    		   }
       }
       return dp[s1.length()][0][0];
    	   
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scramble_string s = new scramble_string();
		System.out.println(s.isScramble("ab","ba"));
	}

}
