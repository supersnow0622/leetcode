package dynamic_programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * @Description:Given a string s and a dictionary of words dict, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given s ="leetcode",dict =["leet", "code"].
 * Return true because"leetcode"can be segmented as"leet code".
 * @author:王丽雪
 * @time:2017年2月11日下午3:58:37
 */
public class word_break {
	public boolean wordBreak(String s, Set<String> dict) {
		if(dict == null || dict.size() == 0 || s == null || s.length() == 0)
			return false;
        int dp[][] = new int[200][200];
        int len = s.length();
        for(int j = 0; j < len; j++)
        	for(int i = 0; i <= j; i++){
        		String sub = s.substring(i, j+1);
        		if(dict.contains(sub))
        			dp[i][j] = 1;
        	}
        
        for(int j = 1; j < len; j++)
        	for(int i = 0; i <= j; i++)
        		for(int k = i; k < j; k++)
        		{
        			if(dp[i][k] != 0 && dp[k+1][j] != 0)
        				dp[i][j] = dp[i][k] + dp[k+1][j];
        		}
        		
        if(dp[0][len-1] != 0)
        	return true;
        return false;
    }
	public boolean wordBreak1(String s, Set<String> dict) {
		boolean dp[] = new boolean[s.length() + 1];//dp[i]表示s从第i个位置到最后组成的单词是否在字典中
		Arrays.fill(dp, false);
		dp[s.length()] = true;
		for(int i = s.length() - 1;i >= 0; i--){
			for(int j = i; j < s.length(); j++){
				String str = s.substring(i,j+1);
				if(dict.contains(str) && dp[j+1]){
					dp[i]=true;
					break;
				}
			}
		}
		return dp[0];
	}
	public boolean wordBreak2(String s, Set<String> dict) {
		boolean dp[] = new boolean[s.length() + 1];//dp[i]表示s从第0个位置到第i个位置组成的单词是否在字典中
		Arrays.fill(dp, false);
		if(dict.contains(s.subSequence(0, 1)))
			dp[0] = true;
		for(int i = 1;i < s.length(); i++){
			for(int j = 0; j <= i; j++){
				String str = s.substring(j,i+1);
				if(j == 0 && dict.contains(str)){
					dp[i] = true;
					break;
				}else if(j != 0 && dp[j-1] && dict.contains(str)){
					dp[i]=true;
					break;
				}
			}
		}
		return dp[s.length()-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ab";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
//		dict.add("aa");
//		dict.add("aaa");
//		dict.add("aaaa");
//		dict.add("aaaaa");
//		dict.add("aaaaaa");
//		dict.add("aaaaaaa");
//		dict.add("aaaaaaaa");
//		dict.add("aaaaaaaaa");
//		dict.add("aaaaaaaaaa");
		word_break w = new word_break();
		System.out.println(w.wordBreak2(s, dict));
	}

}
