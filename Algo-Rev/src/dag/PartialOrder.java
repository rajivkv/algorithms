package dag;

public class PartialOrder {

	
	//works for negative numbers also
	int consecutiveSum(int array[],int i1, int j1){
		int sum[]= new int[array.length];
		sum[0]=array[0];
		for(int i=1;i<array.length;i++){
			sum[i] = sum[i-1] + array[i];
		}
		
		return i1==0? sum[j1] : sum[j1]-sum[i1-1];
	}
	
	public static void main(String[] args) {
		
		int array[] = {10,-5,3,8,7,-12};
		PartialOrder po = new PartialOrder();
		
		for(int i=0;i<array.length;i++){
			for(int j=i;j<array.length;j++){
				System.out.print(po.consecutiveSum(array, i, j) + " ");
			}
			System.out.println();
		}
	}
}
