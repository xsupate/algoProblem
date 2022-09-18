package spatel.algo.bitmanipulation;

public class ReverseBits {

	public static void main(String[] args) {
		int n = 43261596;
		System.out.println(reverseBits(n));

	}

	public static int reverseBits(int n) {
		int result = 0;
		for(int i = 0; i < 32; i++) {
			int lsb = n&1;
			int reverselsb = lsb << ( 31-i);
			result = result|reverselsb;
			n = n >> 1;
		}
		
		return result;
	}
}
