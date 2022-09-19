package spatel.algo.arrays;

/*
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in 
 * a cycle which does not include 1. Those numbers for which this process ends in 1 are happy.
 * 
 * Input: n = 19 , Output: true
 * Input: n = 2  , Output: false
 */
public class HappyNumber {
	public boolean isHappy(int n) {
		int slow = n, fast = n;
		do {
			slow = squareSum(slow);
			fast = squareSum(squareSum(fast));
		} while (slow != fast);

		return slow == 1;
	}

	private int squareSum(int n) {
		int sum = 0;

		return sum;
	}
}
