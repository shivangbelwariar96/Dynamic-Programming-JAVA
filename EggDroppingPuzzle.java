package package1;

// https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/

public class EggDroppingPuzzle {

	public static void main(String[] args) {
		
		int T[][] = new int[1000][1000];
		
		for(int i=0; i<1000; i++) {
			
			for(int j=0; j<1000; j++) {
				
				T[i][j] = -1;
			}
		}
		
		int minTrialInWorstCase = eggDropSolutionMemoized(36, 2, T);
		
		System.out.println("Minimum number of trials in worst case = " + minTrialInWorstCase);
	}
	
	public static int eggDropSolutionMemoized(int floor, int egg, int T[][]) {
		
		if(egg == 1) {
			
			return floor;
		}

		
		if(floor == 1 || floor == 0) {
			
			return floor;
		}
		
		if(T[floor][egg] != -1) {
			
			return T[floor][egg];
		}
		
		int minimum = Integer.MAX_VALUE;
		
		for(int k=1; k<=floor; k++) {
			
			//We are finding the minimum of the worst case
			// that's why min of max()
			
			T[k-1][egg-1] = eggDropSolutionMemoized(k-1, egg-1, T);
					
			T[floor-k][egg] = eggDropSolutionMemoized(floor-k, egg, T);
					
			int temp = 
					1 + Math.max(T[k-1][egg-1], T[floor-k][egg]);
			
			if(temp < minimum) {
				
				minimum = temp;
			}
		}
		
		return minimum;
	}
	
	// Minimum number of trials in worst case
	public static int eggDropSolution(int floor, int egg) {
		
		if(egg == 1) {
			
			return floor;
		}

		
		if(floor == 1 || floor == 0) {
			
			return floor;
		}
		
		int minimum = Integer.MAX_VALUE;
		
		for(int k=1; k<=floor; k++) {
			
			//We are finding the minimum of the worst case
			// that's why min of max()
			int temp = 
					1 + Math.max(
							eggDropSolution(k-1, egg-1), eggDropSolution(floor-k, egg));
			
			if(temp < minimum) {
				
				minimum = temp;
			}
		}
		
		return minimum;
	}
}
