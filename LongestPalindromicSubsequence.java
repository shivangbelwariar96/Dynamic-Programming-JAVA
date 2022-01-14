package package1;

// https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/

public class LongestPalindromicSubsequence {
	
	public static void main(String[] args) {
		
		String str = "GEEKSFORGEEKS";
		
		int T[][] = new int[1000][1000];
		
		for(int i=0; i<1000; i++) {
			
			for(int j=0; j<1000; j++) {
				
				T[i][j] = -1;
			}
		}
		
		int result = longestPalindromeMemoized(str, 0, str.length()-1, T);
		
		System.out.println("Longest Palindrome = " + result);
	}
	
	public static int longestPalindromeMemoized(String str, int start, int end, int T[][]) {
		
		if(start > end) {
			
			return 0;
		}
		
		if(start == end) {
			
			return 1;
		}
		
		if(T[start][end] != -1) {
			
			return T[start][end];
		}
		
		T[start+1][end-1] = longestPalindromeMemoized(str, start+1, end-1, T);
		T[start+1][end] = longestPalindromeMemoized(str, start+1, end, T);
		T[start][end-1] = longestPalindromeMemoized(str, start, end-1, T);
		
		if(str.charAt(start) == str.charAt(end)) {
			
			return Math.max((2 + T[start+1][end-1]),
					Math.max(T[start+1][end], 
							T[start][end-1]));
		}
		
		
		// Do not forget that even though the start and end chars are different,
		// we still have to consider the possibility of leaving them both
		return Math.max((T[start+1][end-1]),
					Math.max(T[start+1][end], 
							T[start][end-1]));
		
		
	}
	
	public static int longestPalindrome(String str, int start, int end) {
		
		if(start > end) {
			
			return 0;
		}
		
		if(start == end) {
			
			return 1;
		}
		
		if(str.charAt(start) == str.charAt(end)) {
			
			return Math.max((2 + longestPalindrome(str, start+1, end-1)),
					Math.max(longestPalindrome(str, start+1, end), 
							longestPalindrome(str, start, end-1)));
		}
		
		
		// Do not forget that even though the start and end chars are different,
		// we still have to consider the possibility of leaving them both
		return Math.max((longestPalindrome(str, start+1, end-1)),
					Math.max(longestPalindrome(str, start+1, end), 
							longestPalindrome(str, start, end-1)));
		
		
	}

}
