package spatel.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfInteger {
	List<List<Integer>> result1 = new ArrayList<>();

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		for (List<Integer> list : generatePermutation(nums)) {
			System.out.println(list);
		}
	}

	public static List<List<Integer>> generatePermutation(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		boolean[] freq = new boolean[nums.length];
		generatePermutation(nums, result, new ArrayList<Integer>(), freq);
		return result;
	}

	private static void generatePermutation(int[] nums, List<List<Integer>> result, List<Integer> curr,
			boolean[] freq) {
		if (curr.size() == nums.length) {
			result.add(new ArrayList<>(curr));
		}

		for (int i = 0; i < nums.length; i++) {
			if (!freq[i]) {
				freq[i] = true;
				curr.add(nums[i]);
				generatePermutation(nums, result, curr, freq);
				curr.remove(curr.size() - 1);
				freq[i] = false;
			}
		}
	}

	/*
	 * Below methods are another solution of permutations
	 */
	public List<List<Integer>> permute(int[] nums) {
		permute(nums, new ArrayList<Integer>());
		return result1;
	}

	private void permute(int[] nums, List<Integer> permute) {
		if (permute.size() == nums.length) {
			result1.add(new ArrayList<>(permute));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!permute.contains(nums[i])) {
				permute.add(nums[i]);
				permute(nums, permute);
				permute.remove(permute.size()-1);
			}
		}
	}
}
