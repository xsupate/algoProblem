package spatel.algo.dynamicprogramming;

public class HouseRobber {
    static Integer[] dp;
	public static void main(String[] args) {
		int nums[] = {2,7,9,3,1};
		System.out.println("total amount " + rob(nums));
	}

	public static int rob(int[] nums) {
		dp = new Integer[nums.length];
		return robs(nums, nums.length-1);
	}

	private static int robs(int[] nums, int i) {
		if(i < 0) 
		    return 0;
		
		if(dp[i] != null) 
			return dp[i];
		
		dp[i] = Math.max(robs(nums, i-1), robs(nums, i-2)+ nums[i]);

		return dp[i];
	}
}
