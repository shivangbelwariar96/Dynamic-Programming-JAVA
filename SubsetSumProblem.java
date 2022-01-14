package package1;

// https://www.geeksforgeeks.org/subset-sum-problem-dp-25/

public class SubsetSumProblem {
	
	static int flag = 0;
	
	public static void main(String[] args) {
		
		int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int n = set.length-1;
        
        int T[][] = new int[1000][1000];
        
        for(int i=0; i<1000; i++) {
        	
        	for(int j=0; j<1000; j++) {
        		
        		T[i][j] = -1;
        	}
        }
        
        boolean result = subsetSumMemoized(set, n, sum, T);
        
        System.out.println("Result = " + result);
	}
	
	
	// Notice how we have created memoized solution even though the function
	// returns boolean. Instead of storing the return value for function call
	// we are checking if its true or now and accordingly storing 0 & 1 to our 2D array
	// also see how we are checking if our 2D array contains 1 or 0 and so returning
	// true and false respectively
	// ONLY RECURSIVE SOLUTION (WITHOUT MEMOIZATION) is given here: 
	// https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
	public static boolean subsetSumMemoized(int arr[], int n, int sum, int T[][]) {
		
		if(n < 0 || sum < 0) {
			
			return false;
		}
		
		if(sum == 0) {
			
			return true;
		}
		
		if(T[sum][n] == 1) {
			
			return true;
		}
		
		if(T[sum][n] == 0) {
			
			return false;
		}
		
		// SEE HOW HERE WE ARE NOT JUST RETURNING SOME value but we are returning the 
		// recursive call to the next element without considering the current element
		// this will make sure that the resursion does not halt in case a bigger number comes
		if(arr[n] > sum) {
			
			boolean temp;
			
			if(subsetSumMemoized(arr, n-1, sum, T) == false) {
				
				temp = false;
				T[sum][n] = 0;
			}
			else {
				
				temp = true;
				T[sum][n] = 1;
			}
			
			return temp;
		}
		else {
			
			boolean temp;
			
			// CAN TO IMPROVEMENT HERE. INSTEAD OF CALLING BOTH THE RECUSRIVE CALLS,
			// WE CAN CALL ONE AND THEN PUT THE VALUE AND THEN CALL ANOTHER.
			if((subsetSumMemoized(arr, n-1, sum, T) 
					|| subsetSumMemoized(arr, n-1, sum-arr[n], T)) == false) {
				
				temp = false;
				T[sum][n] = 0;
			}
			else {
				
				temp = true;
				T[sum][n] = 1;
			}
			
			return temp;
		}
		
	}

}
