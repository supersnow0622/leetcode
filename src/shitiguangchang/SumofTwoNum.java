package shitiguangchang;

import java.util.ArrayList;


public class SumofTwoNum {

	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(array.length == 0)
			return list;
        int low = 0;
        int high = array.length - 1;
        int min = Integer.MAX_VALUE;
        int a = 0, b = 0;
        while(low < high){
        	if(array[low] + array[high] < sum){
        		low++;
        	}else if(array[low] + array[high] > sum){
        		high--;
        	}else{
        		int tmp = array[low] * array[high];
        		if(min > tmp){
        			min = tmp;
        			a = array[low];
        			b = array[high];
        		}
        		low++;
        	}
        }
        
        if(a + b == sum){
        	list.add(a);list.add(b);
        }
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumofTwoNum sumofTwoNum = new SumofTwoNum();
		ArrayList<Integer> list = sumofTwoNum.FindNumbersWithSum(new int[]{},0);
		System.out.println();
	}

}
