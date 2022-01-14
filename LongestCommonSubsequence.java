package package1;

// https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/

/* A Naive recursive implementation of LCS problem in java*/
public class LongestCommonSubsequence
{
 
/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
int lcs( char[] X, char[] Y, int m, int n )
{
    if (m == 0 || n == 0)
    return 0;
    if (X[m-1] == Y[n-1])
    return 1 + lcs(X, Y, m-1, n-1);
    else
    return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
}

int lcsMemoized(char[] X, char[] Y, int m, int n, int T[][])
{
    if (m == 0 || n == 0)
    return 0;
    
    if(T[m][n] != -1) {
    	return T[m][n];
    }
    
    if (X[m-1] == Y[n-1]) {
    	
    	return T[m][n] = 1 + lcs(X, Y, m-1, n-1);
    }
    else {
    	
    	return T[m][n] = max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
    }
    
}
 
/* Utility function to get max of 2 integers */
int max(int a, int b)
{
    return (a > b)? a : b;
}
 
public static void main(String[] args)
{
    LongestCommonSubsequence lcs = new LongestCommonSubsequence();
    String s1 = "AGGTAB";
    String s2 = "GXTXAYB";
 
    char[] X=s1.toCharArray();
    char[] Y=s2.toCharArray();
    int m = X.length;
    int n = Y.length;
    
    int T[][] = new int[1000][1000];
    
    for(int i=0; i<1000; i++) {
    	
    	for(int j=0; j<1000; j++) {
    		
    		T[i][j] = -1;
    	}
    }
 
    System.out.println("Length of LCS is" + " " +
                                lcs.lcsMemoized( X, Y, m, n, T ) );
}
 
}
