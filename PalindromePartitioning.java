package package1;

// https://www.geeksforgeeks.org/palindrome-partitioning-dp-17/

public class PalindromePartitioning {

	public static void main(String[] args) {
		
		String str = "ababbbabbababa";
		
		int T[][] = new int[1000][1000];
		
		for(int i=0; i<1000; i++) {
			
			for(int j=0; j<1000; j++) {
				
				T[i][j] = -1;
			}
		}
		
		int result = solutionMemoized(str, 0, str.length()-1, T);
		
		System.out.println("Minimum no. of cuts to make every cut palindrome = " + result);
		
	}
	
	// SEE THAT WE NEED TO PASS start & end here in parameter 
	// as if we want to calculate the palindrome of that particular string
	// which is from start to end
	public static int isPalindrome(String str, int start, int end) {
		
		while(start<end) {
			
			if(str.charAt(start) != str.charAt(end)) {
				
				return 0;
			}
			
			start++;
			end--;
		}
		
		return 1;
	}
	
public static int solutionMemoized(String str, int start, int end, int T[][]) {
		
		if(start >= end) {
			
			return 0;
		}
		
		if(isPalindrome(str, start, end) == 1) {
			
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int k = start; k<end; k++) {
			
			int temp1 = solutionMemoized(str, start, k, T);
			int temp2 = solutionMemoized(str, k+1, end, T);
			
			int temp = 1 + temp1 + temp2;
			
			min = Math.min(min, temp);
		}
		
		return min;
	}
	
	public static int solution(String str, int start, int end) {
		
		if(start >= end) {
			
			return 0;
		}
		
		if(isPalindrome(str, start, end) == 1) {
			
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int k = start; k<end; k++) {
			
			int temp = 1 
					+ solution(str, start, k)
					+ solution(str, k+1, end);
			
			min = Math.min(min, temp);
		}
		
		return min;
	}
}
