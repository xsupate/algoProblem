package spatel.algo.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public static void main(String[] args) {
         int num = 8;
         for(List<Integer> temp : getPascalsTriangle(num)) {
        	 System.out.println(temp);
         }
	}

	private static List<List<Integer>> getPascalsTriangle(int noRow) {
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> firstRow = new ArrayList<Integer>();
		firstRow.add(1);
		triangle.add(firstRow);
		
		for(int i = 1; i < noRow; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(1);
			List<Integer> prevRow = triangle.get(i-1);
			for(int j = 1; j < i; j++) {
				temp.add(prevRow.get(j) + prevRow.get(j-1));
			}
			temp.add(1);
			triangle.add(temp);
		}
		
		return triangle;
	}

}
