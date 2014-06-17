package dynamicProgramming;

public class Sum {

	
	public int maxContiguousSum(int arr[]){
		int maxSum[] = new int[arr.length];
		
		//maxSum(i)=maxSum(i-1) + arr[i] ; if > 0 or 
		// 		   = 0
		
		//maxSum = max(maxSum(i))
		
		maxSum[0] = Math.max(arr[0], 0);
		
		for(int i=1; i<arr.length; i++){
			maxSum[i] = Math.max(maxSum[i-1]+arr[i], 0);
		}
		
		int max = 0;
		for(int i=0;i<maxSum.length;i++){
			max = Math.max(max, arr[i]);
		}
		
		return max;
	}
	
	//take all positive integers
	public int maxSubSequenceSum(int arr[]){
		int maxSum[] = new int[arr.length];

		//maxSum(i)=max[j=0toi-1](maxSum(j) + arr[i]) ; if > 0 or 
		// 		   = 0
		maxSum[0] = Math.max(arr[0], 0);

		for(int i=1; i<arr.length; i++){
			maxSum[i] = 0;
			for(int j=0;j<i-1;j++){
				maxSum[i] = Math.max(maxSum[j]+arr[i],maxSum[i] );
			}
		}
		int max = 0;
		for(int i=0;i<maxSum.length;i++){
			max = Math.max(max, arr[i]);
		}
		
		return max;
	}
	
	
	//knapsack problem
	//limited capacity , maximize the value
	//repitition allowed
	public int knapSack(int size[], int value[], int capacity){
		
		if(capacity<0){
			return 0;
		}
		int max = 0;
		for(int i =0; i<size.length;i++){
			max = Math.max(knapSack(size, value,capacity-size[i]) +value[i],max); 
		}

		return max;
	}
	
	
	//no repitition
	public int knapSack1(int size[], int value[], int capacity, int index){
		if(capacity<0){
			return 0;
		}
		int max = 0;
		max = Math.max(knapSack1(size, value,capacity-size[index],index-1) +value[index],knapSack1(size, value,capacity-size[index],index-1)); 

		return max;
	}
}
