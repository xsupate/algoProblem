package spatel.algo.dynamicprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Triangle {
    static Map<String, Integer> map = new HashMap<>();
	public static void main(String[] args) {
		
	}

	public static int minimumTotal(List<List<Integer>> triangle) {
		return minimumTotal(triangle, 0, 0);
    }
	
	private static int minimumTotal(List<List<Integer>> triangle, int row, int col) {
        if(row >= triangle.size()) {
        	return 0;
        }
        
        String key = row+"|"+col;
        
        if(map.get(key) == null) {
        	map.put(key, Math.min(minimumTotal(triangle, row+1, col), minimumTotal(triangle, row+1, col+1))
        			+ triangle.get(row).get(col));
        	return map.get(key);
        }else {
        	return map.get(key);
        }
    }
}
