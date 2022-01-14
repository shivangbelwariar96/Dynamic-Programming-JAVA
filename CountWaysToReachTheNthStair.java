package package1;

// https://www.geeksforgeeks.org/count-ways-reach-nth-stair/

public class CountWaysToReachTheNthStair {

	public static void main(String[] args) {
		
		int T[] = new int[1000];
		
		for(int i=0; i<1000; i++) {
			
			T[i] = -1;
		}
		
		int result = solutionMemoized(2, T);
		
		System.out.println("Total ways = " + result);
	}
	
	public static int solution(int n) {
		
		if(n <= 0) {
			
			return 0;
		}
		
		if(n == 1) {
			
			return 1;
		}
		
		if(n == 2) {
			
			return 2;
		}
		
		// Apply memoization here
		return solution(n-1) + solution(n-2);
	}
	
	public static int solutionMemoized(int n, int T[]) {
		
		if(n <= 0) {
			
			return 0;
		}
		
		if(n ==1) {
			
			return 1;
		}
		
		if(n == 2) {
			
			return 2;
		}
		
		if(T[n] != -1) {
			
			return T[n];
		}
		else {
			
			T[n-1] = solutionMemoized(n-1, T);
			T[n-2] = solutionMemoized(n-2, T);
			
			return T[n-1] + T[n-2];
		}
		
		
	}
}
