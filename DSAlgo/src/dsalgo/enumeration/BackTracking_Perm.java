package dsalgo.enumeration;
import java.util.ArrayList;
import java.util.List;


public class BackTracking_Perm extends BackTrack<Integer> {

	int a[] = {1,2,3,4,5,6,9};
	int r = a.length;
	static int count=0;


	/* (non-Javadoc)
	 * @see BackTrack#canditates(java.util.List)
	 */
	@Override
	public Integer[] canditates(List<Integer> output) {
		List<Integer> arr = new ArrayList<Integer>();
		for(int i=0;i<a.length;i++){
			if(!output.contains(a[i]))
					arr.add(a[i]);
		}
		return arr.toArray(new Integer[0]);
	}
	
	/* (non-Javadoc)
	 * @see BackTrack#isResult(java.util.List)
	 */
	@Override
	public boolean isResult(List<Integer> output) {
		return output.size()==r;
	}
	
	public void generateOutput(List<Integer> output) {
		System.out.println(output);
		count++;
	}
	
	public static void main(String[] args) {
		new BackTracking_Perm().generatePermutations(new ArrayList<Integer>());
		System.out.println(count);
		
	}
}
