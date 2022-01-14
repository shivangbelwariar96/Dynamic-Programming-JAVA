package package1;

// https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/

public class FibonacciNumbers {
	
	
	public static int findNthFibonacciMemoized(int N, int T[]) {
		
		if(N == 0) {
			
			return 0;
		}
		
		if(N == 1) {
			
			return 1;
		}
		
		if(T[N] != -1) {
			
			return T[N];
		}
		else {
			
			T[N-1] = findNthFibonacciMemoized(N-1, T);
			T[N-2] = findNthFibonacciMemoized(N-2, T);
			
			return T[N-1] + T[N-2];
		}
		
	}
	
	public static int findNthFibonacci(int N) {
		
		if(N == 0) {
			
			return 0;
		}
		
		if(N == 1) {
			
			return 1;
		}
		
		
		return findNthFibonacci(N-1) + findNthFibonacci(N-2);
	}
	
	public static void main(String[] args) {
		
		int T[] = new int[1000];
		
		for(int i=0; i<1000; i++) {
			
			T[i] = -1;
		}
		
		int result = findNthFibonacciMemoized(9, T);
		
		System.out.println("Result = " + result);
	}

}
