package dynamic_programming;

public class distinct_subsequences {
	public int numDistinct(String S, String T) {
		if(((S == null || S.equals("")) && (T == null || T.equals(""))) || S.length() < T.length())
			return 0;
		if(!S.equals("") && T.equals(""))
			return 1;
        int dp[][] = new int[S.length()][T.length()];
        char ch = T.charAt(0);
        int count = 0;
        for(int i = 0; i < S.length(); i++){
        	if(S.charAt(i) == ch){
        		count++;
        		dp[i][0] = count;
        	}else{
        		dp[i][0] = count;
        	}
        }
        	
        for(int i = 1; i < S.length(); i++){
        	for(int j = 1; j <= i && j < T.length(); j++){
        		if(S.charAt(i) == T.charAt(j))
        			dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
        		else
        			dp[i][j] = dp[i-1][j];
        	}
        }
        return dp[S.length()-1][T.length()-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		distinct_subsequences d = new distinct_subsequences();
		System.out.println(d.numDistinct("rabb",""));
	}

}
