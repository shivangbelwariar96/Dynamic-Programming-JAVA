package package1;

// https://www.geeksforgeeks.org/coin-change-dp-7/

public class CoinChange {

	public static void main(String[] args) {
		
		int arr[] = { 1,2,3 };
		
		int T[][] = new int[1000][1000];
		
		int i,j;
		
		for(i=0; i<1000; i++) {
			
			for(j=0; j<1000; j++) {
				
				T[i][j] = -1;
			}
		}
		
		int result = coinChangeSolutionMemoized(arr, 4, arr.length-1, T);
		
		System.out.println("Total ways = " + result);
	}
	
	public static int coinChangeSolutionMemoized(int arr[], int sum, int n, int T[][]) {
		
		if(n < 0) {
			
			return 0;
		}
		
		if(sum == 0) {
			
			return 1;
		}
		
		if(T[sum][n] != -1) {
			
			return T[sum][n];
		}
		
		if(arr[n] > sum) {
			
			return T[sum][n] = coinChangeSolutionMemoized(arr, sum, n-1, T);
		}
		
		// NOTE: VVVV IMPORTANT:
		// WHEN you have to sum (like find total number of ways etc..)
		// and there is a unlimited number of supply, do not use this condition:
		// coinChangeSolution(arr, sum-arr[n], n-1)
		// this will create redundant with coinChangeSolution(arr, sum-arr[n], n)
		// and the answer will be wrong
		return T[sum][n] = 
				coinChangeSolutionMemoized(arr, sum, n-1, T) 
				+ coinChangeSolutionMemoized(arr, sum-arr[n], n, T);
		
		
	}
	
	public static int coinChangeSolution(int arr[], int sum, int n) {
		
		if(n < 0) {
			
			return 0;
		}
		
		if(sum == 0) {
			
			return 1;
		}
		
		if(arr[n] > sum) {
			
			return coinChangeSolution(arr, sum, n-1);
		}
		
		
		// NOTE: VVVV IMPORTANT:
		// WHEN you have to sum (like find total number of ways etc..)
		// and there is a unlimited number of supply, do not use this condition:
		// coinChangeSolution(arr, sum-arr[n], n-1)
		// this will create redundant with coinChangeSolution(arr, sum-arr[n], n)
		// and the answer will be wrong
		return coinChangeSolution(arr, sum, n-1) 
				+ coinChangeSolution(arr, sum-arr[n], n);
		
		
	}
}
