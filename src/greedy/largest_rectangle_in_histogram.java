/**
 * 
 */
package greedy;

import java.util.Stack;

/**
 * @Description:
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年7月11日下午9:35:59
 */
public class largest_rectangle_in_histogram {

	public int largestRectangleArea(int[] height) {
		if(height == null || height.length == 0)
			return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int index = 0;
        while(index < height.length){
	        if(stack.isEmpty() || height[stack.peek()] <= height[index]){
	        	stack.push(index++);
	        }
	        else{
	        	int cur = stack.pop();
	        	int pre = stack.isEmpty() ? -1 : stack.peek();
	        	int area = height[cur] * (index - pre - 1);
	        	max = Math.max(area, max);
	        }
        }
        while(!stack.isEmpty()){
        	int cur = stack.pop();
        	int pre = stack.isEmpty() ? -1 : stack.peek();
        	int area = height[cur] * (index - pre - 1);
        	max = Math.max(area, max);
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		largest_rectangle_in_histogram largest_rectangle_in_histogram = new largest_rectangle_in_histogram();
		largest_rectangle_in_histogram.largestRectangleArea(new int[]{2,1,5,6,2,3});
	}

}
