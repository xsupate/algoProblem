package spatel.algo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArray {

	public static void main(String[] args) {
		int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
		for(int num : intersectionUsingSorting(nums1, nums2))
			System.out.print(num + " ");
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
         List<Integer> list = new ArrayList<>();
         Map<Integer, Integer> map = new HashMap<>();
         for(int num : nums1) {
        	 map.put(num, map.getOrDefault(num, 0)+1);
         }
         
         for(int num : nums2) {
        	 if(map.keySet().contains(num)) {
        		if(map.get(num) == 1) {
        			map.remove(num);
        		}else {
        			map.put(num, map.get(num)-1);
        		}
        		list.add(num);
        	 }
         }
         
         return list.stream().mapToInt(s -> s).toArray();
	}
	
	public static int[] intersectionUsingSorting(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0;
        
        while(i < nums1.length && j < nums2.length) {
        	if(nums1[i] == nums2[j]) {
        		list.add(nums1[i]);
        		i++;
        		j++;
        	}else if(nums1[i] < nums2[j]) {
        		i++;
        	}else {
        		j++;
        	}
        }
        
        return list.stream().mapToInt(s -> s).toArray();
	}
}
