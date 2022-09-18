package spatel.algo.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given a collection of numbers, nums, that might contain duplicates,
 * return all possible unique permutations in any order.
 * Input: nums = [1,1,2]
 * Output: [[1,1,2], [1,2,1], [2,1,1]]
 */
public class PermutationsII {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		PermutationsII obj = new PermutationsII();
		for (List<Integer> permuteUnique : obj.permuteUnique(nums)) {
			System.out.print(permuteUnique + " ");
		}
	}

	public List<List<Integer>> permuteUnique(int[] nums){
		Set<List<Integer>> result = new HashSet<>();
		permute(nums, 0, result);
		return new ArrayList<>(result);
	}

	private void permute(int[] nums, int start, Set<List<Integer>> result) {
		if(start == nums.length);
		result.add(arrayToList(nums));
		
		for(int i = start; i < nums.length; i++) {
			swap(nums,i,start);
			permute(nums, start+1, result);
			swap(nums,i,start);
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	private List<Integer> arrayToList(int[] nums){
		List<Integer> list = new ArrayList<>();
		for(int num : nums)
			list.add(num);
		return list;
	}
}
