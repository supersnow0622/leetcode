package greedy;

import java.util.Stack;

/**
 * @Description:Given a 2D binary matrix filled with 0's and 1's, 
 * find the largest rectangle containing all ones and return its area.
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年7月12日上午10:32:15
 */
public class maximal_rectangle {
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        	return 0;
        int m = matrix.length,n = matrix[0].length;
        int max = 0;
        int[] h = new int[n];
        for(int i = 0;i < m; i++){
        	for(int j = 0; j < n; j++){
        		if(matrix[i][j] == '1')
        			h[j]++;
        		else 
        			h[j] = 0;
        	}
        	max = Math.max(max, largestRectangleArea(h)); 
        }
       return max;
    }
	
	public int largestRectangleArea(int height[]){
		if(height == null || height.length == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int index = 0,max = 0;
		while(index < height.length){
			if(stack.isEmpty() || height[stack.peek()] <= height[index])
				stack.push(index++);
			else{
				int cur = stack.pop();
				int pre = stack.isEmpty() ? -1 : stack.peek();
				int area = height[cur] * (index - pre - 1);
				max = Math.max(max, area);
			}
		}
		while(!stack.isEmpty()){
			int cur = stack.pop();
			int pre = stack.isEmpty() ? -1 : stack.peek();
			int area = height[cur] * (index - pre - 1);
			max = Math.max(max, area);
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maximal_rectangle maximal_rectangle = new  maximal_rectangle();
		char matrix[][] = new char[][]{{'0','1','0','1','0','0'},
				{'0','1','1','0','0','1'},
				{'1','1','1','0','1','0'},
				{'0','0','0','0','0','1'}
				};
		maximal_rectangle.maximalRectangle(matrix);
	}

}
