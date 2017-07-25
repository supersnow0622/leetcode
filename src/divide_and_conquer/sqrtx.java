package divide_and_conquer;


public class sqrtx {
	public int sqrt(int x) {
		int low = 0;
		int high = x;
		while(low <= high){
			long mid = (low + high)/2;
			if(mid * mid == x)
				return (int) mid;
			else if(mid * mid < x)
				low = (int) (mid+1);
			else 
				high = (int) (mid - 1);
		}
		return high;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sqrtx sqrtx = new sqrtx();
		sqrtx.sqrt(2);
	}

}
