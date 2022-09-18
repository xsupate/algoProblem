package spatel.algo.twopointer;

public class RemoveAllDuplicates {

	public static void main(String[] args) {
		int[] arr = {3, 2, 3, 6, 3, 10, 9, 3};
		//System.out.println("Size of arr after duplicate removal : " + removeAllDulicates(arr));
		System.out.println("Size of arr after removal of key : " + removeAllOccurenceOfK(arr, 3));
	}

	public static int removeAllDulicates(int[] arr) {
		int uniqueIndex = 0;
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i] != arr[i+1]) {
				arr[uniqueIndex++] = arr[i];
			}
		}
		arr[uniqueIndex] = arr[arr.length-1];
		return uniqueIndex+1;
	}
	
	public static int removeAllOccurenceOfK(int[] arr, int key) {
		int uniqueIndex = -1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != key) {
				arr[++uniqueIndex] = arr[i];
			}
		}
		return uniqueIndex > -1 ? uniqueIndex+1 : 0;
	}
}
