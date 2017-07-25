package dynamic_programming;

public class minimum_path_sum {
	public int minPathSum(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		int dp[][] = new int[m][n];
		dp[0][0] = grid[0][0];
		if(m == 1 && n == 1)
			return dp[0][0];
		for(int i = 1; i < m; i++)
			dp[i][0] = dp[i-1][0] + grid[i][0];
		for(int j = 1; j < n; j++)
			dp[0][j] = dp[0][j-1] + grid[0][j];
        for(int i = 1; i < m; i++)
        	for(int j =1; j < n; j++){
        		int left = dp[i][j-1] + grid[i][j];
        		int top = dp[i-1][j] + grid[i][j];
        		dp[i][j] = left > top ? top : left;
        	}
        return dp[m-1][n-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minimum_path_sum m = new minimum_path_sum();
		int[][] grid = new int[][]{{2,3,4,7},{6,8,2,4},{4,2,1,9}};
		System.out.println(m.minPathSum(grid));
	}

}
