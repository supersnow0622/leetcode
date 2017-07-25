package complexity;

/**
 * @Description:Given an array of integers, every element appears twice except for one. Find that single one.
Note: 
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年6月18日下午3:12:43
 */
public class single_number {
	
	public int singleNumber(int[] A) {
		if(A.length == 0)
			return 0;
		int num = A[0];
        for(int i = 1;i < A.length; i++){
        	num = num ^ A[i];
        }
        return num;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		single_number s = new single_number();
		System.out.println(s.singleNumber(new int[]{1}));
	}

}
