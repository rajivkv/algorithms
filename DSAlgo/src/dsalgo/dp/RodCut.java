package dsalgo.dp;

public class RodCut {

	
	int []cost = {10,20,30,40,5};
	int knapCost[] = {10,20,40,5,90};
	int knapValue[] = {100,400,600,900,1000};

	
	public int maxCost(int rodLength){
		//get all the cost from 1 to rodLength to make the decision
		int tCost[] = new int[rodLength+1];
		tCost[0] = 0;
		
		for(int i=1;i<=rodLength;i++){
			for(int j = 1; j <=i;j++){
				tCost[i] = Math.max(tCost[i], cost[j]+tCost[i-j]);
			}
		}
		return tCost[rodLength];
	}
	
	
	
	
	//knapsack with repetition allowed
	public int maxKnapValue(int maxKnapCost){
		//get all the cost from 1 to rodLength to make the decision
		int tCost[] = new int[maxKnapCost+1];
		tCost[0] = 0;
		
		for(int i=1;i<=maxKnapCost;i++){
			for(int j = 0; j <knapCost.length;j++){
				if(i-knapCost[j] >= 0){
					tCost[i] = Math.max(tCost[i-1], knapValue[j]+tCost[i-knapCost[j]]);
				}
			}
		}
		return tCost[maxKnapCost];	
	}
	
	//knapsack with repetition not allowed
	public int maxKnapValue1(int maxKnapCost){
		int tCost[][] = new int[maxKnapCost+1][knapCost.length+1];
		tCost[0][0] = 0;
		for(int i=0;i<tCost[0].length;i++){
			tCost[0][i]=0;
		}
		for(int i=0;i<tCost.length;i++){
			tCost[i][0]=0;
		}
		for(int i=1;i<=maxKnapCost;i++){
			for(int j = 1; j <=knapCost.length;j++){
				if(i-knapCost[j-1] >= 0)
					tCost[i][j] = Math.max(knapValue[j-1]+tCost[i-knapCost[j-1]][j-1],tCost[i][j-1] );
				else
					tCost[i][j] = tCost[i][j-1];
			}
		}
		return tCost[maxKnapCost][knapCost.length];
	}
	
	public int partitions(int[] partition, int noPartitions){
		
		int maxPart[][] = new int[noPartitions+1][partition.length+1];
		//base case
		maxPart[1][1] = partition[0]; 
		for(int i=2;i<=maxPart[1].length;i++){
			maxPart[1][i] = maxPart[1][i-1] + partition[i];	
		}
		for(int i=2; i<=noPartitions; i++){
			for(int j=1; j <=partition.length; j++){
					for(int j1=1;j1<=j;j1++){
						if(j1>i){
							int cost = Math.max(maxPart[i-1][j1], maxPart[1][noPartitions] - maxPart[1][j1]);
							if(maxPart[i][j]==0)
								maxPart[i][j]  = cost;
							else
								maxPart[i][j] = Math.min(maxPart[i][j], cost);
						}
					}
			}
		}
		return maxPart[noPartitions][partition.length];
	}
	
	public int longestIncreasingSeq(int[] sequence){
		
		int[] length = new int[sequence.length];
		
		length[0] = 1;
		
		for(int i=2;i<sequence.length;i++){
			for(int j=i-1;j>=0;j--){
				length[i] = 1;
				if(sequence[j]<sequence[i]){
					length[i] = Math.max(length[i], length[j] + 1);
				}
			}
		}
		int max =0;
		for(int i=1;i<sequence.length;i++){
			max = Math.max(max, length[i]);
		}
		return max;
	
	}
}
