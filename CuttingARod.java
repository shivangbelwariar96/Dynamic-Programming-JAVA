// Java program to find maximum
// profit from rod of size n 

import java.util.*;

class GfG {

    static int cutRodRecur(int i, int[] price, int[] memo) {
        
        // Base case
        if (i == 0) return 0;
        
        // If value is memoized
        if (memo[i - 1] != -1) return memo[i - 1];
        
        int ans = 0;

        // Find maximum value for each cut.
        // Take value of rod of length j, and 
        // recursively find value of rod of 
        // length (i-j).
        for (int j = 1; j <= i; j++) {
            ans = Math.max(ans, price[j - 1] + cutRodRecur(i - j, price, memo));
        }

        return memo[i - 1] = ans;
    }

    static int cutRod(int[] price) {
        int n = price.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return cutRodRecur(n, price, memo);
    }

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price));
    }
}





____________________________________









package package1;

// https://www.geeksforgeeks.org/cutting-a-rod-dp-13/

public class CuttingARod {
	
	public static void main(String[] args) {

		int price[] = new int[] {3, 5, 8, 9, 10, 17, 17, 20};
		
		//int price[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
		
		int T[][] = new int[1000][1000];
		
		for(int i=0; i<1000; i++) {
			
			for(int j=0; j<1000; j++) {
				
				T[i][j] = -1;
			}
		}
		
		int result = maxValueRodCuttingMemoized(price, price.length, price.length-1, T);
		
		System.out.println("Max Value = " + result);
	}
	
	public static int maxValueRodCuttingMemoized(int price[], int lengthOfRod, int n, int T[][]) {
		
		if(lengthOfRod <= 0) {
			
			return 0;
		}
		
		if(n < 0) {
			
			return 0;
		}
		
		if(T[lengthOfRod][n] != -1) {
			
			return T[lengthOfRod][n];
		}
		
		//If we make cut at the given length then the new length of the rod will be lengthOfRod-(n+1)
		// AND
		// The new last index of the remaining rod will be lengthOfRod-(n+2)
		//NOTE here that the remaining rod will be a new smaller rod whose starting index is from 0
		// And ending is its new length - 1
		
		
		// SEE THAT ALL THE BELOW if-else CHECKS ARE NECESSARY 
		// THIS IS TO MAKE SURE THAT THERE IS NEVER INDEX-OUT-OF-BOUND ERROR
		// IT IS ALSO NECESSARY TO STORE THE RESULTS IN TEMP1 & TEMP2
		// AS IN THE BELOW RETURN STATEMENT WE DO NOT USE ARRAY DIRECTLY
		// WHICH CAN LEAD TO OUT OF BOUND ERROR
		// WE CAN INITIALIZE THE TEMP1 & TEMP2 WITH 0
		int temp1=0, temp2=0;
		
		if((lengthOfRod-(n+1) >=0) && (lengthOfRod-(n+2)>=0)) {
			T[lengthOfRod-(n+1)][lengthOfRod-(n+2)] 
					= maxValueRodCuttingMemoized(
							price, lengthOfRod-(n+1), lengthOfRod-(n+2), T);
			
			temp1 = T[lengthOfRod-(n+1)][lengthOfRod-(n+2)];
		}
		
		if(lengthOfRod>=0 && n-1>=0) {
			T[lengthOfRod][n-1] 
					= maxValueRodCuttingMemoized(price, lengthOfRod, n-1, T);
			
			temp2 = T[lengthOfRod][n-1];
		}
		
		
		return 
			Math.max(
					(price[n] + temp1),
					temp2);
	}

	public static int maxValueRodCutting(int price[], int lengthOfRod, int n) {
		
		if(lengthOfRod <= 0) {
			
			return 0;
		}
		
		if(n < 0) {
			
			return 0;
		}
		
		//If we make cut at the given length then the new length of the rod will be lengthOfRod-(n+1)
		// AND
		// The new last index of the remaining rod will be lengthOfRod-(n+2)
		//NOTE here that the remaining rod will be a new smaller rod whose starting index is from 0
		// And ending is its new length - 1
		return 
			Math.max(
					(price[n] + maxValueRodCutting(price, lengthOfRod-(n+1), lengthOfRod-(n+2))),
					maxValueRodCutting(price, lengthOfRod, n-1));
	}
}















NOTE ----------------------------
	
ANOTHER RECURSIVE & MEMOIZED SOLUTION (SIMPLER):


public static int rodCutting(int valueOfLength[], int start, int length) {
		
		if(start >= length) {
			
			return 0;
		}
		
		if(start == length-1) {
			
			return valueOfLength[length-1];
		}
		
		// Starting from the beginning. There can be only 2 possibilities: a) A cut is made.  b) A cut is not made
		// We are considering both the cases here to find the MAXIMUM from them.
		return Math.max(rodCutting(valueOfLength, start+1, length), 
				valueOfLength[start] + rodCutting(valueOfLength, 0, length-start-1));
	}



public static int rodCuttingMemoized(int valueOfLength[], int start, int length, int T[][]) {
		
		if(start >= length) {
			
			return 0;
		}
		
		if(start == length-1) {
			
			return valueOfLength[length-1];
		}
		
		if(T[start][length] != -1) {
			
			return T[start][length];
		}
		
		return T[start][length] = 
				Math.max(rodCuttingMemoized(valueOfLength, start+1, length, T), 
				valueOfLength[start] + rodCuttingMemoized(valueOfLength, 0, length-start-1, T));
	}
