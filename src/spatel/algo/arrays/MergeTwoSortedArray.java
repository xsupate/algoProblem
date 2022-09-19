package spatel.algo.arrays;
/*
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * 
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 
 * Output: [1,2,2,3,5,6]
 */
public class MergeTwoSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, index = 0;
        int[] result = new int[m+n];
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                result[index++] = nums1[i++];
            }else{
                result[index++] = nums2[j++];
            }
        }
        
        while(i < m){
            result[index++] = nums1[i++];
        }
        
        while(j < n){
             result[index++] = nums2[j++];
        }
        
        index = 0;
        for(; index < m+n; index++){
            nums1[index] = result[index];
        }
    }
}
