package find;

import java.util.*;

/**
 * @Description:Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,
Given:
start ="hit"
end ="cog"
dict =["hot","dot","dog","lot","log"]
As one shortest transformation is"hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length5.
Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年5月7日下午4:43:55
 */
public class word_ladder {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        int step = 1;
        Queue<String> q1 = new ArrayDeque<String>();
        Queue<String> q2 = new ArrayDeque<String>();
        q1.add(start);
        while(!q1.isEmpty()){
            String curStr = q1.poll();
            for(int i = 0; i < curStr.length(); i++){
                char[] s = curStr.toCharArray();
                for(char j = 'a'; j <= 'z';j++){
                    if(j == curStr.charAt(i)) continue;
                    s[i] = j;
                    String target = String.valueOf(s);
                    if(target.equals(end))
                        return step + 1;
                     
                    if(dict.contains(target)){
                        q2.add(String.valueOf(target));
                        dict.remove(target);
                    }
                }
            }
            if(q1.isEmpty()){
                Queue<String> tmp = q2;
                q2 = q1;
                q1 = tmp;
                step++;
            }
        }
        return 0;
    }
    
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
    	ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
    	HashMap<String, String> map = new HashMap<String, String>();
        Queue<String> queue1 = new ArrayDeque<String>();
//        Queue<String> queue2 = new ArrayDeque<String>();
        queue1.add(start);
        
        while(!queue1.isEmpty()){
        	String curStr = queue1.poll();
        	
        	for(int i = 0; i < curStr.length(); i++){
        		char[] chArr = curStr.toCharArray();
        		for(char j = 'a'; j <= 'z'; j++){
        			if(j == chArr[i]) continue;
        			chArr[i] = j;
        			String target = String.valueOf(chArr);
        			if(dict.contains(target)){
//        				queue2.add(String.valueOf(target));
        				queue1.add(String.valueOf(target));
        				dict.remove(target);
        				map.put(target, curStr);
        			}
        			if(target.equals(end)){
        				map.put(end, curStr);
        				ArrayList<String> listItem = new ArrayList<String>();
        				listItem.add(end);
        				String key = end;
        				while(!key.equals(start)){
        					String value = map.get(key);
        					listItem.add(value);
        					key = value;
        				}
        				Collections.reverse(listItem);
        				list.add(listItem);
        			}
        			
        		}
        	}
//        	if(queue1.isEmpty()){
//                Queue<String> tmp = queue2;
//                queue2 = queue1;
//                queue1 = tmp;
//            }
        }
        
        return list;
    }
    
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "hit";
		String end = "cog";
		HashSet<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		word_ladder w = new word_ladder();
		System.out.println(w.findLadders(start, end, set));
	}

}
