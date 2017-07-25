package simulate;

import java.util.ArrayList;


/**
 * @Description:Given numRows, generate the first numRows of Pascal's triangle.
For example, given numRows = 5,
Return
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * @author:王丽雪
 * @time:2017年6月16日下午1:52:19
 */
public class pascals_triangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if(numRows <= 0)
			return list;
		ArrayList<Integer> listItem1 = new ArrayList<Integer>();
		listItem1.add(1);
		list.add(listItem1);
        if(numRows == 1){
        	return list;
        }
        ArrayList<Integer> listItem2 = new ArrayList<Integer>();
        listItem2.add(1);
        listItem2.add(1);
        list.add(listItem2);
        if(numRows == 2)
        	return list;
        for(int i = 3; i <= numRows; i++){
        	ArrayList<Integer> listItem = new ArrayList<Integer>();
        	listItem.add(1);
        	ArrayList<Integer> lastList = list.get(list.size() - 1);
        	for(int j = 1; j < lastList.size(); j++){
        		listItem.add(lastList.get(j-1)+lastList.get(j));
        	}
        	listItem.add(1);
        	list.add(listItem);
        }
        return list;
    }
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if(rowIndex < 0)
			return result;
		ArrayList<Integer> listItem1 = new ArrayList<Integer>();
		listItem1.add(1);
		list.add(listItem1);
        if(rowIndex == 0){
        	return listItem1;
        }
        ArrayList<Integer> listItem2 = new ArrayList<Integer>();
        listItem2.add(1);
        listItem2.add(1);
        list.add(listItem2);
        if(rowIndex == 1)
        	return listItem2;
        for(int i = 2; i <= rowIndex; i++){
        	ArrayList<Integer> listItem = new ArrayList<Integer>();
        	listItem.add(1);
        	ArrayList<Integer> lastList = list.get(list.size() - 1);
        	for(int j = 1; j < lastList.size(); j++){
        		listItem.add(lastList.get(j-1)+lastList.get(j));
        	}
        	listItem.add(1);
        	list.add(listItem);
        }
        return list.get(rowIndex);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pascals_triangle p = new pascals_triangle();
		ArrayList<Integer> list = p.getRow(3);
		System.out.println();
		
	}

}
