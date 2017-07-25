package array;


/**
 * @Description:There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 *  The overall run time complexity should be O(log (m+n)).
 * @author:����ѩ
 * @time:2017��6��27������1:55:13
 */
public class median_two_sorted_arrays {
	
	public double findMedianSortedArrays(int A[], int B[]) {
        double median_fir = 0;
        int m = A.length, n = B.length;
        if (A == null || B == null || m + n == 0) {
            return 0;
        }
        int indexA = 0, indexB = 0;
        while (indexA + indexB != (m + n + 1) / 2) {// ֻ��Ҫ�ϲ���������м�λ���ɣ�
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
        
        if ((m + n) % 2 == 1)// ���Ԫ�ظ���Ϊ���������м�ֵ��Ϊmedian
            return median_fir;
        else {// ������������һ��A��B�н�С����
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

        String str2 = "���첻����";
        System.out.println(str2.intern() == str2);
    
	}

}
