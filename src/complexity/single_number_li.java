package complexity;

/**
 * @Description:����һ����������������һ������S���������в������������ǵ����ǵĺ�������S������ж�����ֵĺ͵���S��
 * ����������ĳ˻���С�ġ�
 * @author:����ѩ
 * @time:2017��6��19������7:30:02
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
