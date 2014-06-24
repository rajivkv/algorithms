package dynamicprog;

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
		if(capacity<0 || index<0){
			return 0;
		}
		int max = 0;
		max = Math.max(knapSack1(size, value,capacity-size[index],index-1) +value[index],knapSack1(size, value,capacity-size[index],index-1)); 

		return max;
	}
	
	//closest to sum
	public boolean subSequenceSum(int arr[] , int sum, int index){
		
		if(sum<0 || index<0){
			return false;
		}
		
		if(sum==0){
			return true;
		}
		if(index==0 && arr[index]==sum){
			return true;
		}
		return subSequenceSum(arr, sum-arr[index], index-1) || subSequenceSum(arr, sum, index-1);
		
	}
	
	public void subSequenceSum1(int arr[] , int sum){
		boolean sumArr[][] = new boolean[arr.length+1][sum+1];
		
		for(int i = 0 ; i<sumArr.length;i++){
			sumArr[i][0] = true;
		}

		for(int i = 1 ; i<sumArr.length;i++){
			
			for(int j=1;j<=sum;j++){
				if(j-arr[i-1] ==0){
					sumArr[i][j] = true;
				}else if (j-arr[i-1] >=0){
					sumArr[i][j] = sumArr[i-1][j] | sumArr[i-1][j-arr[i-1]];
				}else{
					sumArr[i][j] = sumArr[i-1][j];
				}
			}
			
		}
		for(int i=0;i<sum;i++){
			System.out.println(i+" "+ sumArr[arr.length][i]);
		}
		
		
	}
	
	int [][] matrix ={
				{1,-4,5},
				{-3,6,7},
				{-12,23,4}
			};
	public void matrixSum(){
		int maxSum=0;
		int rows = matrix.length;
		int columns = matrix[0].length;
		for(int startx=0;startx<rows;startx++)
			for(int starty=0;starty<columns;starty++){
				
				int rowwise[] = new int[columns];
				for(int endx=startx;endx<rows;endx++){
					for(int endy=starty; endy<columns;endy++){
						int sum =0;
						for(int k1=startx;k1<=endx;k1++){
							for(int k2=starty;k2<=endy;k2++){
								sum = sum+matrix[k1][k2];
							}
							maxSum=Math.max(maxSum, sum);
						}
					}
				}
		}
		
	}
	
	public static void main(String[] args) {
		
		Sum ss = new Sum();
		ss.subSequenceSum1(new int[]{2, 6, 7,10},9);
		
	}
	
}
