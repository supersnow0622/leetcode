package string;

import java.util.ArrayList;

/**
 * @Description:Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
For example, given s ="aab",
Return
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年5月6日下午8:17:33
 * @result:100%
 */
public class palindrome_partitioning {
	ArrayList<ArrayList<String>> allList = new ArrayList<ArrayList<String>>();
	public ArrayList<ArrayList<String>> partition(String s) {
		find(new ArrayList<String>(), s);
		
		for(int i = 0;i < allList.size(); i++){
			for(int j = 0; j < allList.get(i).size(); j++){
				System.out.print(allList.get(i).get(j) + " ");
			}
			System.out.println();
		}
		return allList;
    }
	
	public void find(ArrayList<String> list,String s){
		if(s.length() == 1){
			String tmp = ""+s.charAt(0);
			list.add(tmp);
			allList.add(new ArrayList<String>(list));
			list.remove(list.size() - 1);
			return;
		}
		for(int i = 1; i <= s.length(); i++){
			String tmp = s.substring(0,i);
			if(isPalindrome(tmp)){
				if(tmp.equals(s)){
					list.add(tmp);
					allList.add(new ArrayList<String>(list));
					list.remove(list.size() - 1);
				}else{
					list.add(tmp);
					find(list, s.substring(i));
					list.remove(list.size() - 1);
				}
			}
		}
	}
	
	public boolean isPalindrome(String s){
		if(s.length() == 1)
			return true;
		for(int i = 0,j = s.length() - 1; i < j;i++,j--){
			if(s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		palindrome_partitioning p = new palindrome_partitioning();
		p.partition("abaccdaccad");
		
	}

}
