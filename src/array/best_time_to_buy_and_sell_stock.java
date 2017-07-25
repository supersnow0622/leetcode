package array;


/**
 * @Description:Say you have an array for which the i th element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note: 
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * @author:王丽雪
 * @time:2017年6月13日下午5:25:43
 */
/**
 * @Description:
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年6月14日上午9:01:04
 */
/**
 * @Description:
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年6月14日上午9:01:07
 */
public class best_time_to_buy_and_sell_stock {
	/*Say you have an array for which the i th element is the price of a given stock on day i.
	 *Design an algorithm to find the maximum profit. You may complete at most two transactions.
     *Note: 
     *You may not engage in multiple transactions at the same time (ie, you must sell the stock 
     *before you buy again).
     *允许进行两次交易，即买入卖出，再买入卖出
	 */
	public int maxProfit3(int[] prices) {
		if(prices == null || prices.length == 0)
			return 0;
		int len = prices.length;
		int trade1[] = new int[len],trade2[] = new int[len];
		int min = prices[0],maxProfit = 0;
		for(int i = 1; i < len; i++){
			if(min > prices[i])
				min = prices[i];
			else{
				trade1[i] = prices[i] - min;
			}
			if(trade1[i] < maxProfit)
				trade1[i] = maxProfit;
			else 
				maxProfit = trade1[i];			
		}
		int max = prices[len - 1];maxProfit = 0;
		for(int i = len - 2; i >= 0; i--){
			if(max < prices[i])
				max = prices[i];
			else{
				trade2[i] = max - prices[i];
			}
			if(trade2[i] < maxProfit)
				trade2[i] = maxProfit;
			else 
				maxProfit = trade2[i];
		}
		max = Integer.MIN_VALUE;
		for(int i = 0; i < len; i++){
			max = Math.max(max, trade1[i]+trade2[i]);
		}
		return max;
    }
	/*Say you have an array for which the i th element is the price of a given stock on day i.
	 *Design an algorithm to find the maximum profit. You may complete as many transactions as
	 *you like (ie, buy one and sell one share of the stock multiple times). However, you may 
	 *not engage in multiple transactions at the same time (ie, you must sell the stock before
	 *you buy again).
	 * 允许进行任意多次交易
	 * */
	//动态规划解法
	public int maxProfit21(int[] prices) {
		if(prices == null || prices.length == 0)
			return 0;
		int dp[] = new int[prices.length];
		dp[0] = 0;
		for(int i = 1; i < prices.length; i++){
			int a = prices[i] - prices[i-1];
			a = a > 0 ? a + dp[i - 1] : dp[i - 1];
			dp[i] = a;
		}
		return dp[prices.length - 1];
	}
	//递归求解
	public int maxProfit22(int[] prices) {
		if(prices == null || prices.length == 0)
			return 0;
	    return findMaxProfit1(prices, 0, prices.length);
	}
	public int findMaxProfit1(int[] prices,int start,int n) {
		if(start >= n - 1)
			return 0;
		int max = 0;
	    for(int i = start;i < n - 1; i++){
	    	for(int j = i + 1; j < n; j++){
	    		int sub = findMaxProfit1(prices, j+1, n);
	    		max = Math.max(prices[j] - prices[i] + sub, max);
	    	}
	    }
	    return max;
	}
	
	/*Say you have an array for which the i th element is the price of a given stock on day i.
	 *If you were only permitted to complete at most one transaction (ie, buy one and sell one share 
     *of the stock), design an algorithm to find the maximum profit.
	 *只允许进行一次交易
	 * */
	public int maxProfit1(int[] prices) {
		if(prices == null || prices.length < 2)
			return 0;
        int dp[] = new int[prices.length];
        int min = prices[0],max = 0;
        for(int i = 1;i < prices.length; i++){
        	int tmp = prices[i] - min;
        	max = tmp > max ? tmp : max;
        	min = prices[i] < min ? prices[i] : min;
        }
        return max;
    }
	
	public static void main(String args[]){
		best_time_to_buy_and_sell_stock b = new best_time_to_buy_and_sell_stock();
//		b.maxProfit(new int[]{2,1,2,0,1});
		int max = b.maxProfit1(new int[]{2,1,2,0,1});
		System.out.println(max);
	}
}