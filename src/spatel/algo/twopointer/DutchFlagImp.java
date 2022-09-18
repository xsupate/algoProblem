package spatel.algo.twopointer;

public class DutchFlagImp {

	public static void main(String[] args) {	
       int[] arr = {1, 1, 2, 2, 0, 1, 2, 0};
       sort(arr);
       for(int i : arr)
    	   System.out.print(i + " ");
	}

	public static void sort(int[] arr) {
		int low = 0, high = arr.length-1;
		int i = 0;
		while(i <= high) {
			if(arr[i] == 0) {
				swap(arr, low, i);
				low++;
				i++;
			}else if(arr[i] == 1) {
				i++;
			}else {
				swap(arr, high, i);
				high--;
			}
		}
	}

	private static void swap(int[] arr, int low, int i) {
		int temp = arr[low];
		arr[low] = arr[i];
		arr[i] = temp;
	}
}
