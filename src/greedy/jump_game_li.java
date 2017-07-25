package greedy;

import java.util.Arrays;

/**
 * @Description:Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
For example:
Given array A =[2,3,1,1,4]
The minimum number of jumps to reach the last index is2. (Jump1step from index 0 to 1, then3steps to the last index.)
 * @author:王丽雪
 * @time:2017年6月27日下午2:11:49
 */
public class jump_game_li {

	public int jump(int[] A) {
        int n = A.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 10000000);
        dp[0] = 0;
        for(int i = 1;i < n; i++){
        	for(int j = 0; j < i; j++){
        		if(j + A[j] >= i){
        			int tmp = dp[j] + 1;
        			dp[i] = dp[i] < tmp ? dp[j] : tmp;
        		}
        	}
        }
        return dp[n-1];
    }
	
	public boolean canJump(int[] A) {
		if(A == null || A.length == 0)
			return false;
		if(A.length == 1)
			return true;
		int n = A.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 10000000);
        dp[0] = 0;
        for(int i = 1;i < n; i++){
        	for(int j = 0; j < i; j++){
        		if(j + A[j] >= i){
        			int tmp = dp[j] + 1;
        			dp[i] = dp[i] < tmp ? dp[j] : tmp;
        		}
        	}
        }
        if(dp[n -1] == 10000000)
        	return false;
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jump_game_li j = new jump_game_li();
		j.canJump(new int[]{3,2,1,0,4});
	}

}
