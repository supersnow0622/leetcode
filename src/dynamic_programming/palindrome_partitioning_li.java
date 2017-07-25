package dynamic_programming;

/**
 * @Description:Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
For example, given s ="aab",
Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年5月4日下午8:50:05
 * @result：100%
 */
public class palindrome_partitioning_li {
	
	public int minCut(String s) {
        int dp[] = new int[s.length()];
        dp[0] = 0;
        int len = s.length();
        for(int i = 1; i < len; i++){
        	if(isPalindrome(s.substring(0,i+1))){
        		dp[i] = 0;
        		continue;
        	}else
        		dp[i] = i;
        	for(int j = 0; j <= i; j++){
        		String sub = s.substring(j,i+1);
        		if(isPalindrome(sub)){
        			int tmp = 0;
        			if(j != 0){
        				tmp = dp[j-1];
        			}
        			if(dp[i] > tmp + 1)
        				dp[i] = tmp + 1;
        		}else{
        			int tmp = 0;
        			if(j != 0){
        				tmp = dp[j-1];
        			}
        			if(dp[i] > tmp + i - j + 1 )
        				dp[i] = tmp + i - j + 1 ;
        		}
        	}
        }
        return dp[s.length() - 1];
    }
	
	public boolean isPalindrome(String s){
		boolean flag = true;
		for(int i = 0,j = s.length() - 1;i < j;i++,j--){
			if(s.charAt(i) != s.charAt(j))
				return false;
		}
		return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		palindrome_partitioning_li p = new palindrome_partitioning_li();
		p.minCut("abaccdacca");
	}

}
