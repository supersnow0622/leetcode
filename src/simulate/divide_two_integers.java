package simulate;



/**
 * @Description:
Divide two integers without using multiplication, division and mod operator.
 * @author:王丽雪
 * @time:2017年7月12日上午10:30:56
 */
public class divide_two_integers {
	public int divide(int dividend, int divisor) {
		boolean isPos = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ;
		long dd = Math.abs((long)dividend);
		long dv = Math.abs((long)divisor);
		long digits = 1;
		while(dv < dd){
			dv <<= 1;
			digits <<= 1;
		}
		
		int res = 0;
		while(dd >= Math.abs((long)divisor)){
			while(dd >= dv){
				dd -= dv;
				res += digits;
			}
			dv >>= 1;
			digits >>= 1;
		}
		return isPos ? res : -res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		divide_two_integers divide_two_integers = new divide_two_integers();
		divide_two_integers.divide(Integer.MAX_VALUE, 1);
		System.out.println(123234324/453);
	}

}
