package package1;

// https://www.geeksforgeeks.org/binomial-coefficient-dp-9/

public class BinomialCoefficient {

	public static void main(String[] args) {
		
		int T[][] = new int[1000][1000];
		
		for(int i=0; i<1000; i++) {
			
			for(int j=0; j<1000; j++) {
				
				T[i][j] = -1;
			}
		}
		
		int result = solutionMemoized(5, 2, T);
		
		System.out.println("Binomial Coefficient = " + result);
	}
	
	public static int solutionMemoized(int n, int k, int T[][]) {
		
		if(n == k || k == 0) {
			
			return 1;
		}
		
		if(T[n][k] != -1) {
			
			return T[n][k];
		}
		
		int temp1 = solutionMemoized(n-1, k-1, T);
		int temp2 = solutionMemoized(n-1, k, T);
		
		return temp1 + temp2;
	}
	
	public static int solution(int n, int k) {
		
		if(n == k || k == 0) {
			
			return 1;
		}
		
		return solution(n-1, k-1)
				+ solution(n-1, k);
	}
	
	/*
	 * Rule for calculating binomial coefficient:
	 * 
	 * C(n, k) = C(n-1, k-1) + C(n-1, k)
   	 * C(n, 0) = C(n, n) = 1
	 *
	 * A binomial coefficient C(n, k) can be defined as 
	 * the coefficient of x^k in the expansion of (1 + x)^n.
	 * 
	 * A binomial coefficient C(n, k) also gives the number of ways, 
	 * disregarding order, that k objects can be chosen from among n objects 
	 * more formally, the number of k-element subsets (or k-combinations) of a n-element set.
	 */
}
