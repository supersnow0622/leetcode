package greedy;

//求连续最大子序列和
public class maximum_subarray {
	
	public int maxSubArray(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		int n = A.length;
		int max = A[0];
		int dp[] = new int[n];
		dp[0] = A[0];
		for(int i = 1; i < n; i++){
			if(dp[i - 1] > 0){
				dp[i] = dp[i - 1] + A[i];
			}else {
				dp[i] = A[i];
			}
			if(max < dp[i])
				max = dp[i];
		}
		
		return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maximum_subarray m = new maximum_subarray();
		m.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
	}

}
