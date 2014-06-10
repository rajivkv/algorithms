package dsalgo.enumeration;
import java.util.ArrayList;
import java.util.List;


public class BackTracking_Subset extends BackTrack<Integer> {

	int a[] = {1,2,3,4,5,6,9};
	int r = a.length;
	static int count=0;


	/* (non-Javadoc)
	 * @see BackTrack#isResult(java.util.List)
	 */
	@Override
	public boolean isResult(List<Integer> output) {
		return output.size()==r;
	}

	
	//subset combinations, binary number
	public Integer[] canditates(List<Integer> cand) {
		return new Integer[]{0,1};
	}
	
	public void generateOutput(List<Integer> output) {
		for(int i=0; i < output.size();i++){
			if(output.get(i)==1)
				System.out.print(a[i]);
		}
		count++;
		System.out.println();
	}

	
	public static void main(String[] args) {
		new BackTracking_Subset().generatePermutations(new ArrayList<Integer>());
		System.out.println(count);
		
	}
}
