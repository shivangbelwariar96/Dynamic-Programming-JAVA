package package1;

// https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/

public class MatrixChainMultiplication {
	
	public static void main(String[] args) {
		
		int arr[] = { 1, 2, 3, 4 };
		
		int T[][] = new int[1000][1000];
		
		for(int i=0; i<1000; i++) {
			
			for(int j=0; j<1000; j++) {
				
				T[i][j] = -1;
			}
		}
		
		int result = MCMsolutionMemoized(arr, 1, arr.length-1, T);
		
		System.out.println("Minimum cost multiplying the matrix = " + result);
	}
	
public static int MCMsolutionMemoized(int arr[], int start, int end, int T[][]) {
		
		if(start == end) {
			
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		
		if(T[start][end] != -1) {
			
			return T[start][end];
		}
		
		for(int k=start; k<end; k++) {
			
			T[start][k] = MCMsolutionMemoized(arr, start, k, T);
			T[k+1][end] = MCMsolutionMemoized(arr, k+1, end, T);
			
			int temp = 
					T[start][k]
					+ arr[start-1]*arr[k]*arr[end]
					+ T[k+1][end];
			
			if(temp < min) {
				
				min = temp;
			}
		}
		
		return min;
	}
	
	// public static int min = Integer.MAX_VALUE;
	
	public static int MCMsolution(int arr[], int start, int end) {
		
		if(start == end) {
			
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int k=start; k<end; k++) {
			
			int temp = 
					MCMsolution(arr, start, k)
					+ arr[start-1]*arr[k]*arr[end]
					+ MCMsolution(arr, k+1, end);
			
			if(temp < min) {
				
				min = temp;
			}
		}
		
		return min;
	}

}
