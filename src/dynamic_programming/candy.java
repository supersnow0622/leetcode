package dynamic_programming;

import java.util.Arrays;


/**
 * @Description:There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * @author:王丽雪
 * @time:2017年2月12日下午2:54:30
 */
public class candy {

	public int candy(int[] ratings) {
		if(ratings == null || ratings.length == 0)
			return 0;
		int dp[] = new int[ratings.length];
		Arrays.fill(dp, 1);
        for(int i = 1; i < ratings.length; i++){
        	if(ratings[i] > ratings[i-1]){
        		dp[i] = dp[i-1] + 1;        	
        	}
        }
        for(int i = ratings.length-1; i > 0; i--){
        	if(ratings[i] < ratings[i-1] && dp[i] >= dp[i-1])
        		dp[i-1] = dp[i] + 1;
        }
        int sum = 0;
        for(int i = 0; i < ratings.length; i++)
        	sum += dp[i];
        return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		candy c = new candy();
		System.out.println(c.candy(new int[]{2,4,7,3,9,2,4}));
	}

}
