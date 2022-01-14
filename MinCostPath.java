package package1;

// https://www.geeksforgeeks.org/min-cost-path-dp-6/

public class MinCostPath {

	public static void main(String[] args) {
		
		int cost[][]= { {1, 8, 8, 1, 5},
                {4, 1, 1, 8, 1},
                {4, 2, 8, 8, 1},
                {1, 5, 8, 8, 1} };
		
		int T[][] = new int[1000][1000];
		
		for(int i=0; i<1000; i++) {
			
			for(int j=0; j<1000; j++) {
				
				T[i][j] = -1;
			}
		}
		
		int result = solutionMemoized(cost, 3, 4, 0, 0, T);
		
		System.out.println("Min Cost = " + result);
	}
	
	
	
	public static int solution(int arr[][], int xEnd, int yEnd, int xStart, int yStart) {
		
		if(xStart > xEnd || yStart > yEnd) {
			
			//returning max int value as out logic will always reject this as
			// our logic is finding the minimum value
			return 9999;
		}
		
		if(xStart == xEnd && yStart == yEnd) {
			
			return arr[xStart][yStart];
		}
		
		return arr[xStart][yStart] + 
				Math.min(solution(arr, xEnd, yEnd, xStart+1, yStart), 
						Math.min(solution(arr, xEnd, yEnd, xStart, yStart+1)
								, solution(arr, xEnd, yEnd, xStart+1, yStart+1)));
		
		
	}
	
	
public static int solutionMemoized(int arr[][], int xEnd, int yEnd, int xStart, int yStart, int T[][]) {
		
		if(xStart > xEnd || yStart > yEnd) {
			
			//returning max int value as out logic will always reject this as
			// our logic is finding the minimum value
			return 9999;
		}
		
		if(xStart == xEnd && yStart == yEnd) {
			
			return arr[xStart][yStart];
		}
		
		if(T[xStart][yStart] != -1) {
			
			return T[xStart][yStart];
		}
		
		return T[xStart][yStart] = arr[xStart][yStart] + 
				Math.min(solutionMemoized(arr, xEnd, yEnd, xStart+1, yStart, T), 
						Math.min(solutionMemoized(arr, xEnd, yEnd, xStart, yStart+1, T)
								, solutionMemoized(arr, xEnd, yEnd, xStart+1, yStart+1, T)));
		
		
	}
}
