package package1;

// https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/


public class MinimumCoinsMakeGivenValue {
	
//	Given a value V, if we want to make a change for V cents, and we have an 
//	infinite supply of each of C = { C1, C2, .., Cm} valued coins, 
//	what is the minimum number of coins to make the change? 
//	If it’s not possible to make a change, print -1.
	
	static int flag = 0;
	
	
public static int minCoinsMemoized(int arr[], int value, int index, int T[][]) {
		
		if(value < 0) {
			
			// DO NOT RETURN Integer.MAX_VALUE as otherwise it will overflow and results will be unexpected
			return 9999;
		}
		
		if(value == 0) {
			
			// making flag as 1 to know that the change exists
			flag = 1;
			return 0;
		}
		
		if(index < 0) {
			
			// DO NOT RETURN Integer.MAX_VALUE as otherwise it will overflow and results will be unexpected
			return 9999;
		}
		
		if(arr[index] <= value) {
			
			if(T[index][value] != -1){
				
				return T[index][value];
			}
			else {
				
				T[index][value] = Integer.min(1+minCoinsMemoized(arr, value-arr[index], index, T), 
						Integer.min(1+minCoinsMemoized(arr, value-arr[index], index-1, T), 
								minCoinsMemoized(arr, value, index-1, T)));
				
				return T[index][value];
			}
			
			
		}
		else {
			
			if(T[index][value] != -1){
				
				return T[index][value];
			}
			else {
				
				T[index][value] = minCoins(arr, value, index-1);
				return T[index][value];
			}
		}
	}
	
	
	public static int minCoins(int arr[], int value, int index) {
		
		if(value < 0) {
			
			// DO NOT RETURN Integer.MAX_VALUE as otherwise it will overflow and results will be unexpected
			return 9999;
		}
		
		if(value == 0) {
			
			// making flag as 1 to know that the change exists
			flag = 1;
			return 0;
		}
		
		if(index < 0) {
			
			// DO NOT RETURN Integer.MAX_VALUE as otherwise it will overflow and results will be unexpected
			return 9999;
		}
		
		if(arr[index] <= value) {
			
			return Integer.min(1+minCoins(arr, value-arr[index], index), 
					Integer.min(1+minCoins(arr, value-arr[index], index-1), 
							minCoins(arr, value, index-1)));
		}
		else {
			
			// NOTE: If the value at particular index is greater, just return 
			// the reursive call of the next index 
			// NOTE: DO NOT RETURN A VALUE
			// else it will stop the recursion from going to the next index
			return minCoins(arr, value, index-1);
		}
	}

	public static void main(String[] args) {
		
		int coins[] = {1, 2, 5, 10}; 
		int V = 48;
		
		int T[][] = new int[1000][1000];
		
		for(int i=0; i<1000; i++) {
			
			for(int j=0; j<1000; j++) {
				
				T[i][j] = -1;
			}
		}
		
		int result = minCoinsMemoized(coins, V, coins.length-1, T);
		
		if(flag == 0) {
			
			System.out.println("-1");
		}
		else {
			
			System.out.println(result);
		}
		
		
	}
}
