package package1;

// https://www.geeksforgeeks.org/edit-distance-dp-5/

public class EditDistance {

	public static void main(String[] args) {
		
		int[][] T = new int[1000][1000];
		
		int i,j;
		
		for(i=0; i<1000; i++) {
			
			for(j=0; j<1000; j++) {
				
				T[i][j] = -1;
			}
		}
		
		String str1 = "food";
		String str2 = "money";
		
		int result = editDistSol(str1, str2, str1.length(), str2.length(), T);
		
		System.out.println("Edit Distance = " + result);
	}
	
	public static int editDistSol(String str1, String str2, int len1, int len2, int T[][]) {
		
		if(len1 == 0) {
			
			return len2;
		}
		
		if(len2 == 0) {
			
			return len1;
		}
		
		if(T[len1][len2] != -1) {
			
			return T[len1][len2];
		}
		
		if(str1.charAt(len1-1) == str2.charAt(len2-1)) {
			
			return T[len1][len2] = editDistSol(str1, str2, len1-1, len2-1, T);
		}
		
		return T[len1][len2] = 
				1 + (Math.min(editDistSol(str1, str2, len1-1, len2, T),
				Math.min(editDistSol(str1, str2, len1, len2-1, T), 
						editDistSol(str1, str2, len1-1, len2-1, T))));
		
	}
}
