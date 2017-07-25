package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class gray_code {
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(n == 0){
			list.add(0);
			return list;
		}
			
		List<String> dp[] = new ArrayList[n+1];
		dp[1] = new ArrayList<String>();
		dp[1].add("0");dp[1].add("1");
		for(int i = 2; i <= n; i++){
			dp[i] = new ArrayList<String>();
			int size = dp[i-1].size();
			for(int j = 0; j < size; j++){
				String s = "0" + dp[i-1].get(j);
				dp[i].add(s);
			}
			for(int j = size-1; j >= 0; j--){
				String s = "1" + dp[i-1].get(j);
				dp[i].add(s);
			}
		}
		
		for(int i = 0; i < dp[n].size(); i++){
			Integer integer = Integer.parseInt(dp[n].get(i),2);
			list.add(integer);
		}
		return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gray_code g = new gray_code();
		ArrayList<Integer> list = g.grayCode(0);
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}

}
