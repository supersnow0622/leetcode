package array;
import java.util.HashSet;

/**
 * @Description:Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
For example,
Given[100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
Your algorithm should run in O(n) complexity.

 * @author:王丽雪
 * @time:2017年6月13日下午5:26:23
 */
public class longest_consecutive_sequence {
	public int longestConsecutive(int[] num) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0 ;i < num.length; i++){
			set.add(num[i]);		
		}
		int max = 1;
		for(int n : num){
			if(set.remove(n)){
				int val_small = n - 1;
				int val_big = n + 1;
				int sum = 1;
				while(set.remove(val_small)){
					val_small--;
					sum++;
				}
				while(set.remove(val_big)){
					val_big++;
					sum++;
				}
				if(sum > max)
					max = sum;
			}
		}
		return max;
    }
	public static void main(String args[]){
		longest_consecutive_sequence longest_consecutive_sequence = new longest_consecutive_sequence();
		longest_consecutive_sequence.longestConsecutive(new int[]{100,4,200,3,2,1,9,10,11,13,14,12});
		System.out.println();
	}
}
