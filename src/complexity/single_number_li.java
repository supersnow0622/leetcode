package complexity;

/**
 * @Description:输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，
 * 输出两个数的乘积最小的。
 * @author:王丽雪
 * @time:2017年6月19日下午7:30:02
 */
public class single_number_li {
	public int singleNumber(int[] A) {
       int result = 0;
       for(int i = 0;i < 32; i++){
    	   int bits = 0;
    	   for(int j = 0; j < A.length; j++){
    		   bits = bits + (A[j] >> i & 1); 
    	   }
    	   result = result | (bits % 3) << i;
       }
       return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		single_number_li s = new single_number_li();
		System.out.println(s.singleNumber(new int[]{0,1,0,1,0,1,99}));
	}

}
