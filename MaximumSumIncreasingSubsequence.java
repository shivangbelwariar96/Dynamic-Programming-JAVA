package package1;

// https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/

public class MaximumSumIncreasingSubsequence {

	public static void main(String[] args) {
		
		int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
		
		int result = solution(arr);
		
		System.out.println("Maximum Sum Increasing Subsequence = " + result);
	}
	
	public static int solution(int arr[]) {
		
		int temp[] = new int[arr.length];
		
		for(int i =0; i<temp.length; i++) {
			
			temp[i] = arr[i];
		}
				
		for(int i=1; i<arr.length; i++) {
			
			for(int j=0; j<i; j++) {
				
				if(arr[j] < arr[i]) {
					
					// Do not make mistake here
					// you need to check the sum till jth index(temp[j]) + the ith element(arr[i])
					// and according to that you need to compare it with sum till ith (temp[i])
					// if the value is less, then update sum till ith (temp[i])
					if(temp[i] < arr[i] + temp[j]) {
						
						temp[i] = arr[i] + temp[j];
					}
				}
			}
		}
		
		int maximum = Integer.MIN_VALUE;
		
		for(int i=0; i<temp.length; i++) {
			
			if(temp[i] > maximum) {
				
				maximum = temp[i];
			}
		}
		
		return maximum;
	}
}
