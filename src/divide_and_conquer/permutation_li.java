package divide_and_conquer;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * @Description:Given a collection of numbers that might contain duplicates, return all possible unique permutations.
For example,
[1,1,2]have the following unique permutations:
[1,1,2],[1,2,1], and[2,1,1].

 * @author:王丽雪
 * @time:2017年7月19日下午7:57:36
 */
public class permutation_li {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        
        if(num == null || num.length == 0){
        	return list;
        }
        
        Arrays.sort(num);
        boolean[] visit = new boolean[num.length];
        ArrayList<Integer> listItem = new ArrayList<Integer>();
        permute(list,listItem,visit,num);
        return list;
    }
	public void permute(ArrayList<ArrayList<Integer>> rst,ArrayList<Integer> listItem,boolean[] visit,int[] num){
		if(listItem.size() == num.length)
			rst.add(new ArrayList<Integer>(listItem));
		for(int i = 0;i < num.length; i++){
			if(visit[i] || (i != 0 && num[i] == num[i-1] && !visit[i-1])){
				continue;
			}
			visit[i] = true;
			listItem.add(num[i]);
			permute(rst, listItem, visit, num);
			listItem.remove(listItem.size()-1);
			visit[i] = false;
		}
		
	}
	
	
	public static void main(String args[]){
		permutation_li permutation_li = new permutation_li();
		permutation_li.permuteUnique(new int[]{1,1,2});
	}
}
