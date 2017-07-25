package string;

public class implement_strstr {
	public void getNext(String T,int next[]){
		if(T == null || T.toString().equals(""))
			return;
		next[0] = 0;	
		int j = 1,k;
		while(j < T.length()){
			k = next[j-1];
			while(k != 0 && T.charAt(j-1) != T.charAt(k))
				k = next[k];
			if(k == 0 && T.charAt(k) != T.charAt(j-1))
				next[j] = 0;
			else 
				next[j] = j == 1 ? 0 : k + 1;
			j++;
		}
		next[0] = -1;
	}
	public String strStr(String haystack, String needle) {
		if(haystack == null || needle == null)
			return null;
        int next[] = new int[needle.length()];
        getNext(needle, next);
        int i = 0,j = 0;
		while(i < haystack.length() && j < needle.length()){
			if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
				i++;
				j++;
			}else{
				j = next[j];
			}
		}
		if(i == haystack.length() && j < needle.length())
			return null;
		return haystack.substring(i - needle.length());
    }
}
