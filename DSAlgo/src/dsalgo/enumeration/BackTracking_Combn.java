package dsalgo.enumeration;
import java.util.ArrayList;
import java.util.List;

//T(n) = sum(a=o,n-1)T(a)+ 1 = O(2^n) , T(1) = 1

public class BackTracking_Combn extends BackTrack<Integer> {

	int a[] = {1,2,3,4,5,6,9};
//	int r = 3;
	int r = 3;
	static int count=0;

	@Override
	public boolean isResult(List<Integer> output) {
		return output.size()==r;
	}
	
	//combinations nCr
	public Integer[] canditates(List<Integer> output) {
		List<Integer> arr = new ArrayList<Integer>();
		//int j =0;//repeating
		int j = -1;
		
		//finding the position of last index
		if(output.size() > 0){
			int cand = output.get(output.size()-1);
			for(int i = 0;i <a.length;i++){
				if(a[i]==cand){
					j=i;
					break;
				}
			}
		}
		for(int i=j+1;i<a.length;i++){
			arr.add(a[i]);
		}
		return arr.toArray(new Integer[0]);
	}
	
	public void generateOutput(List<Integer> output) {
		System.out.println(output);
		count++;
	}
	
	public static void main(String[] args) {
		new BackTracking_Combn().generatePermutations(new ArrayList<Integer>());
		System.out.println(count);
		
	}
}
