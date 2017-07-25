package dynamic_programming;

public class decode_ways {
	public int numDecodings(String s) {
		if(s == null || s.length() == 0)
			return 0;
        int dp[] = new int[s.length()];
        if(s.charAt(0) == '0')
        	return 0; 
        	dp[0] = 1;
        if(s.length() >= 2){
        	if(s.charAt(0) > '2' && s.charAt(1) == '0')
        		dp[1] = 0;
        	else if(s.charAt(0) > '2' || (s.charAt(0) == '2' && s.charAt(1) > '6') || s.charAt(1) == '0')
	        	dp[1] = 1;
	        else 
	        	dp[1] = 2;
	        for(int i = 2; i < s.length(); i++){
	        	if(dp[i-1] == 0)
	        		return 0;
	        	char pre = s.charAt(i-1);
	        	char cur = s.charAt(i);
	        	if(dp[0] != 0){       	
		        	if(pre != '0' && cur != '0'){
		        		if(pre > '2' || pre == '2' && cur > '6')
		        			dp[i] = dp[i-1];
		        		else 
		        			dp[i] = dp[i - 1] + dp[i - 2];
		        	}else if(pre != '0' && cur == '0'){
		        		if(pre < '3')
		        			dp[i] = dp[i-2];
		        		else
		        			dp[i] = 0;
		        	}else if(pre == '0' && cur != '0'){
		        		dp[i] = dp[i-2];
		        	}else {
		        		dp[i] = 0;
		        	}
	        	}else{
	        		dp[i] = 0;
	        	}
	        }
        }
        return dp[s.length() - 1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		decode_ways d = new decode_ways();
		System.out.println(d.numDecodings("301"));
	}

}
