package package1;

//https://www.geeksforgeeks.org/partition-problem-dp-18/


FIRST APPROACH (BETTER THAN SECOND BELOW):
NOTE that for Questions involving BOOLEAN in Memoization DP, Use 2 T[][], first should be a boolean T[][] to store results of subproblems (of sub-recursions)  
	& USE another T (T2[][]) for marking if the recursion is already traversed or not. If already traversed (T2[][] value is not -1), return T[][] else, mark T2[][]
	and assign T[][] by making boolean result recursive calls.

	public static boolean partitonProblem(int arr[], int halfValue, int end, boolean T[][], int T2[][]) {
		
		if(end < 0) {
			
			return false;
		}
		
		if(halfValue == 0) {
			
			return true;
		}
		
		if(halfValue < 0) {
			
			return false;
		}
		
		if(T2[halfValue][end] != -1) {
			
			return T[halfValue][end];
		}
		
		T2[halfValue][end] = 1;
		
		return T[halfValue][end] = partitonProblem(arr, halfValue-arr[end], end-1, T, T2)
				|| partitonProblem(arr, halfValue, end-1, T, T2);
	}
	
	
	public static void main(String[] args) {
		
		
		int arr[] = {  3, 1, 5, 9, 12 };
        int n = arr.length;
        
        int sum = 0;
        
        for(int i=0; i<n; i++) {
        	
        	sum += arr[i];
        }
        
        if(sum%2 !=0) {
        	
        	System.out.println("Partiton sum not possible");
        }
        else {
        	
        	boolean T[][] = new boolean[1000][1000];
        	int T2[][] = new int[1000][1000];
        	
        	for(int i=0; i<1000; i++) {
        		
        		for(int j=0; j<1000; j++) {
        			
        			T2[i][j] = -1;
        		}
        	}
        	
        	int halfSum = sum/2;
        	
        	if(partitonProblem(arr, halfSum, n-1, T, T2) == true) {
        		System.out.println("Partiton sum is possible");
        	}
        	else {
        		System.out.println("Partiton sum not possible");
        	}
        }
		
	}





SECOND METHOD:

public class PartitionProblem {
	
	public static void main(String[] args) {
		
		int arr[] = {3, 1, 5, 9, 12};
		
		int total = 0;
		
		for(int i=0; i<arr.length; i++) {
			total += arr[i];
		}
		
		boolean result;
		
		int T[][] = new int[1000][1000];
		
		for(int i=0; i<1000; i++) {
			
			for(int j=0; j<1000; j++) {
				
				T[i][j] = -1;
			}
		}
		
		if(total%2 != 0) {
			
			result = false;
		}
		else {
			
			result = solutionMemoized(arr, (total/2), arr.length-1, T);
		}
		
		System.out.println("Partition exists ?: " + result);
	}
	
	public static boolean solutionMemoized(int arr[], int total, int n, int T[][]) {
		
		if(n < 0) {
			
			return false;
		}
		
		if(total < 0) {
			
			return false;
		}
		
		if(total == 0) {
			
			return true;
		}
		
		if(T[total][n] == 1) {
			
			return true;
		}
		
		if(T[total][n] == 0) {
			
			return false;
		}
		
		boolean temp1 = solutionMemoized(arr, total, n-1, T);
		boolean temp2 = solutionMemoized(arr, total-arr[n], n-1, T);
		
		if(total >=0 && n-1 >=0) {
			
			if(temp1) {
				T[total][n-1] = 1;
			}
			else {
				T[total][n-1] = 0;
			}
		}
		
		
		if(total-arr[n] >= 0 && n-1 >= 0) {
			
			if(temp2) {
				T[total-arr[n]][n-1] = 1;
			}
			else {
				T[total-arr[n]][n-1] = 0;
			}
		}
		
		
		return (temp1 || temp2);
	}
	
	public static boolean solution(int arr[], int total, int n) {
		
		if(n < 0) {
			
			return false;
		}
		
		if(total < 0) {
			
			return false;
		}
		
		if(total == 0) {
			
			return true;
		}
		
		return (solution(arr, total, n-1)
				|| solution(arr, total-arr[n], n-1));
	}

}
