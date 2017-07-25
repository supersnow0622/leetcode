package dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence 
 * where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given　s ="catsanddog",dict =["cat", "cats", "and", "sand", "dog"].
 * A solution is["cats and dog", "cat sand dog"].
 * @author:王丽雪
 * @time:2017年2月12日下午2:53:12
 */
public class word_break_li {
	ArrayList<String> path = new ArrayList<String>();
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
        List<String> dp[] = new ArrayList[s.length() + 1];
        dp[0] = new ArrayList<String>();
        for(int i = 0; i < s.length(); i++)
        {
        	if(dp[i] == null) continue;
        	for(String word: dict){
        		int len = word.length();
        		if(i + len > s.length()) continue;
        		
        			String sub = s.substring(i,i+len);
        			if(word.equals(sub)){
        				if(dp[i + len] == null)
        					dp[i + len] = new ArrayList<String>();
        				dp[i + len].add(word);
        			}	
        		
        	}
        	
        } 
        if(dp[s.length()] != null) dfs(dp,s.length(),new ArrayList<String>());
        return path;
    }
	
	public void dfs(List<String> dp[],int end,ArrayList<String> tmp){
		if(end <= 0){
			String p = tmp.get(tmp.size()-1);
			for(int i = tmp.size()-2; i >= 0; i--)
				p += " " + tmp.get(i);
			path.add(p);
			return;
		}
		
		for(String word:dp[end]){
			tmp.add(word);
			dfs(dp,end-word.length(),tmp);
			tmp.remove(tmp.size()-1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaaaaaa";
		Set<String> dict = new HashSet<String>();
		dict.add("aaaa");
		dict.add("aa");
		dict.add("a");
//		dict.add("sand");
//		dict.add("dog");
		
		word_break_li w = new word_break_li();
		ArrayList<String> path = w.wordBreak(s, dict);
		for(int i = 0; i < path.size(); i++)
			System.out.println(path.get(i));
	}

}
