package package1;

// https://www.geeksforgeeks.org/longest-bitonic-subsequence-dp-15/

public class LongestBitonicSubsequence {

	public static void main(String[] args) {
		
		int arr[] = {80, 60, 30, 40, 20, 10};
		
		int result = solution(arr);
		
		System.out.println("Longest Bitonic Subsequence = " + result);
	}
	
	public static int solution(int arr[]) {
		
		int LISright[] = new int[arr.length];
		int LISleft[] = new int[arr.length];
		
		// At least 1 will be the LIS (that element itself)
		for(int i=0; i<arr.length; i++) {
			
			LISleft[i] = 1;
			LISright[i] = 1;
		}
		
		for(int i=1; i<arr.length; i++) {
			
			for(int j=0; j<i; j++) {
				
				if(arr[j] < arr[i] && LISleft[j]+1 > LISleft[i]) {
					
					LISleft[i] = LISleft[j]+1;
				}
			}
		}
		
		for(int i=arr.length-2; i>=0; i--) {
			
			for(int j=arr.length-1; j>i; j--) {
				
				if(arr[j] < arr[i] && LISright[j]+1 > LISright[i]) {
					
					LISright[i] = LISright[j]+1;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			
			if(LISleft[i]+LISright[i] > max) {
				
				max = LISleft[i]+LISright[i];
			}
		}
		
		// Subtracting -1 as the peak element is calculated twice
		// once in LISright and once is LISleft
		return (max-1);
	}
}
