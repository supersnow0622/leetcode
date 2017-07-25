package string;

import java.util.HashMap;
import java.util.Map;

public class longest_substring_without_repeating_characters {
	
	public int lengthOfLongestSubstring(String s) {
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		int maxLen = 0;
		int start = 0;
		for(int i = 0; i < s.length(); i++){
			Character ch = new Character(s.charAt(i));
			if(!map.containsKey(ch)){
				map.put(ch, i);
			}else{
				int end = map.get(ch) ;
				maxLen = map.size() > maxLen ? map.size() : maxLen;
				for(int j = start; j <= end; j++)
					map.remove(s.charAt(j));
				start = end + 1;
				map.put(ch, i);
			}
		}
		maxLen = map.size() > maxLen ? map.size() : maxLen;
		return maxLen;	
    }
	public static void main(String args[]){
		longest_substring_without_repeating_characters l = new longest_substring_without_repeating_characters();
		System.out.println(l.lengthOfLongestSubstring("qopubjguxhxdipfzwswybgfylqvjzhar"));
	}
}
