package array;


/**
 * @Description:There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 *  The overall run time complexity should be O(log (m+n)).
 * @author:王丽雪
 * @time:2017年6月27日下午1:55:13
 */
public class median_two_sorted_arrays {
	
	public double findMedianSortedArrays(int A[], int B[]) {
        double median_fir = 0;
        int m = A.length, n = B.length;
        if (A == null || B == null || m + n == 0) {
            return 0;
        }
        int indexA = 0, indexB = 0;
        while (indexA + indexB != (m + n + 1) / 2) {// 只需要合并到数组的中间位即可，
            int a = (indexA == m) ? Integer.MAX_VALUE : A[indexA];
            int b = (indexB == n) ? Integer.MAX_VALUE : B[indexB];
            if (a < b) {
                median_fir = a;
                indexA++;
            } else {
                median_fir = b;
                indexB++;
            }
          
        }
        
        if ((m + n) % 2 == 1)// 如果元素个数为奇数，则中间值即为median
            return median_fir;
        else {// 否则，再往后找一个A、B中较小的数
            int temp_a = (indexA == m) ? Integer.MAX_VALUE : A[indexA];
            int temp_b = (indexB == n) ? Integer.MAX_VALUE : B[indexB];
            double median_sec = (temp_a < temp_b) ? temp_a : temp_b;
            return (median_fir + median_sec) / 2;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		median_two_sorted_arrays m = new median_two_sorted_arrays();
		System.out.println(m.findMedianSortedArrays(new int[]{1}, new int[]{1}));
		

		String str1 = new StringBuilder("ja").append("va").toString();
        System.out.println(str1.intern() == str1);

        String str2 = "倚天不屠龙";
        System.out.println(str2.intern() == str2);
    
	}

}
