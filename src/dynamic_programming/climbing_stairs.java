package dynamic_programming;

public class climbing_stairs {
	public int climbStairs(int n) {
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
	    int dp[] = new int[n+1];
	    dp[1] = 1;
	    dp[2] = 2;
	    for(int i = 3; i <= n; i++)
	    	dp[i] = dp[i-1] + dp[i-2];
	    return dp[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		climbing_stairs c = new climbing_stairs();
		System.out.println(c.climbStairs(4));
	}

}
