package spatel.algo.arrays;

public class MinimumSubArrayLen {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		int target = 11;
		System.out.println("Miminum length is " + minSubArrayLen(target, nums));

	}

	public static int minSubArrayLen(int target, int[] nums) {
		int start = 0;
		int sum = 0, minSize = Integer.MAX_VALUE;
		for (int j = 0; j < nums.length; j++) {
			sum = sum + nums[j];
			while (sum >= target) {
				minSize = Math.min(minSize, j - start + 1);
				sum = sum - nums[start];
				start++;
			}
		}
		return minSize != Integer.MAX_VALUE ? minSize : 0;
	}
}
