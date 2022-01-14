package package1;

//https://www.geeksforgeeks.org/partition-problem-dp-18/

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
