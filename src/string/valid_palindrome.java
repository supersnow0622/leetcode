package string;

import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.FutureTask;

public class valid_palindrome {
	public boolean isPalindrome(String s) {
		if(s == null || s.equals(""))
			return true;
		int i = 0,j = s.length() - 1;
		for(;i < j; i++,j--){
			char a = s.charAt(i);
			char b = s.charAt(j);
			while(i < j && !isAlp(a)){
				i++;
			}
			while(i < j && !isAlp(b)){
				j--;
			}
			if(i < j && a != b && a + 32 != b && b + 32 != a){
				return false;
			}
		}
		return true;
    }
	public boolean isAlp(char a){
		if((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z') || (a >= '0' && a <= '9'))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		valid_palindrome v = new valid_palindrome();
//		System.out.println(v.isPalindrome(",."));
		String uploadFileName = String.valueOf(new Date().getTime());
		System.out.println(uploadFileName);
		System.out.println(String.valueOf(new Date().getTime()));
	}

}