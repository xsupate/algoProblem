package spatel.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		for(List<Integer> list : generateSubsets(nums)) {
			System.out.println(list);
		}
	}

	public static List<List<Integer>> generateSubsets(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		generateSubsets(nums, result, new ArrayList<Integer>(), 0);
		return result;
	}

	private static void generateSubsets(int[] nums, List<List<Integer>> result, List<Integer> curr, int start) {
		result.add(new ArrayList<>(curr));
		for(int i = start; i < nums.length; i++) {
			curr.add(nums[i]);
			generateSubsets(nums, result, curr, i+1);
			curr.remove(curr.size()-1);
		}	
	}
}
