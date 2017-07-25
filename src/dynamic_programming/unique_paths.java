package dynamic_programming;

public class unique_paths {
	public int uniquePaths(int m, int n) {
		if(m == 0 || n == 0)
			return 0;
		if(m == 1 || n == 1)
			return 1;
		int dp[][] = new int[m][n];
		for(int i = 0; i < m; i++)
			dp[i][0] = 1;
		for(int j = 0; j < n; j++)
			dp[0][j] = 1;
		for(int i = 1; i < m; i++)
			for(int j = 1; j < n; j++){
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		return dp[m-1][n-1];
    }
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int dp[][] = new int[m][n];
		if(obstacleGrid[0][0] == 0)
			dp[0][0] = 1;
		else{ 
			dp[0][0] = 0;
			return 0;
		}
		for(int i = 1; i < m; i++){
			if(obstacleGrid[i][0] == 0 && dp[i-1][0] != 0){
				dp[i][0] = 1;
			}else
				dp[i][0] = 0;
		}
		for(int j = 1; j < n; j++){
			if(obstacleGrid[0][j] == 0 && dp[0][j-1] != 0)
				dp[0][j] = 1;
			else 
				dp[0][j] = 0;
		}
		for(int i = 1; i < m; i++)
			for(int j = 1; j < n; j++){
				dp[i][j] = 0;
				if(obstacleGrid[i][j] != 1){
					if(obstacleGrid[i-1][j] != 1)
						dp[i][j] += dp[i-1][j];
					if(obstacleGrid[i][j-1] != 1)
						dp[i][j] += dp[i][j-1];
				}
				
			}
		return dp[m-1][n-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		unique_paths u = new unique_paths();
		System.out.println(u.uniquePaths(2, 3));
		System.out.println(u.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
	}

}
