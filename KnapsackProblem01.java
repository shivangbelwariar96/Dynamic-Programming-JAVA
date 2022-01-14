package package1;

// https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

public class KnapsackProblem01 {
	
    
    public static void main(String[] args) {
    	
    	int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        
        int n = wt.length-1;
        
        int T[][] = new int[1000][1000];
        
        for(int i=0; i<1000; i++) {
        	
        	for(int j = 0; j<1000; j++) {
        		
        		T[i][j] = -1;
        	}
        }
        
    	int result = knapsackMemoized(val, wt, W, n, T);
    	
    	System.out.println("Maximum Value = " + result);
    	
    }
    
    // starting to analyze from lest element to first element. Hence n = last index
    public static int knapsackMemoized(int val[], int wt[], int W, int n, int T[][]) {
    	
    	// If all the elements are processed then value is 0
    	if(n < 0) {
    		
    		return 0;
    	}
    	
    	// If the Weight left is less that OR EQUAL to Zero then the value will also be 0
    	if(W <= 0) {
    		
    		return 0;
    	}
    	
    	if(T[W][n] != -1) {
    		
    		return T[W][n];
    	}
    	
    	if(wt[n] > W) {
    		
    		return T[W][n] = knapsackMemoized(val, wt, W, n-1, T);
    	}
    	else {
    		
    		return T[W][n] = Math.max(val[n] + knapsackMemoized(val, wt, W-wt[n], n-1, T)
    		, knapsackMemoized(val, wt, W, n-1, T));
    	}
    	
    }

}
