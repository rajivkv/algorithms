package dsalgo.enumeration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BackTracking_Enum extends BackTrack<Integer> {


	Integer a1[][] = {
			{1,2,3,4},
			{5,6,7}
	};
	static int count=0;


	//binary numbers
	public void generateOutput(List<Integer> output) {
		System.out.println(output);
		count++;
	}

	//Enumeration m*n
	public Integer[] canditates(List<Integer> output){
		return a1[output.size()];
	}
	public boolean isResult(List<Integer> output) {
		return output.size()==a1.length;
	}
	
	public static void main(String[] args) {
		new BackTracking_Enum().generatePermutations(new ArrayList<Integer>());
		System.out.println(count);
		
	}
}
