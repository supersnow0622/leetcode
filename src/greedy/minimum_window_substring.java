package greedy;

import java.util.HashMap;

public class minimum_window_substring {
	
	public String minWindow(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0;i < T.length(); i++){
        	if(map.containsKey(T.charAt(i)))
        		map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
        	else
        		map.put(T.charAt(i), 1);
        }
        int count = 0,start = 0,cap = Integer.MAX_VALUE;
        String sub = "";
        for(int i = 0; i < S.length(); i++){
        	char ch = S.charAt(i);
        	if(map.keySet().contains(ch)){
        		map.put(ch, map.get(ch) - 1);
        		if(map.get(ch) >= 0)
        			count++;
        		
        		while(count == T.length()){
        			if(map.containsKey(S.charAt(start))){
	        			if(i - start + 1 < cap){
	        				cap = i - start + 1;
	        				sub = S.substring(start,i+1);
	        			}
        			
        				map.put(S.charAt(start), map.get(S.charAt(start)) + 1);
        				if(map.get(S.charAt(start)) > 0)
        					count--;
        			}
        			start++;
        		}
        	}
        }
        
        return sub;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minimum_window_substring m = new minimum_window_substring();
		m.minWindow("", "");
	}

}
