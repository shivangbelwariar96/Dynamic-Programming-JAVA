package package1;

// https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int lis = LIS(arr);
		
		System.out.println("LIS = " + lis);
	}
	
	public static int LIS(int arr[]) {
		
		int i, j;
		
		int lisArr[] = new int[arr.length];
		
		for(i=0; i<lisArr.length; i++) {
			
			lisArr[i] = 1;
		}
		
		for(i=1; i<arr.length; i++) {
			
			for(j=0; j<i; j++) {
				
				if(arr[j] < arr[i] && (lisArr[j]+1 > lisArr[i])) {
					
					lisArr[i] = lisArr[j]+1;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for(i=0; i<lisArr.length; i++) {
			
			if(lisArr[i] > max) {
				max = lisArr[i];
			}
		}
		
		return max;
	}
}
