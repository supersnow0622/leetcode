package dynamic_programming;

import java.util.ArrayList;

public class triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		for(int i = triangle.size()-2; i >= 0; i--)
			for(int j = 0;j <= i; j++){
				int min = triangle.get(i+1).get(j) > triangle.get(i+1).get(j+1) ? triangle.get(i+1).get(j+1):triangle.get(i+1).get(j);
				triangle.get(i).set(j, min + triangle.get(i).get(j));
			}
		return triangle.get(0).get(0);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
