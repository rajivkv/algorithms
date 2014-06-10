package dsalgo.enumeration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class BackTracking_Tele extends BackTrack<Character> {

	String a[]={"tf","e","s","t"};
	static int count=0;

	public void generatePermutations(StringBuffer output) {
		if(isResult(output)){
			generateOutput(output);
		}else{
			String cands = canditates(output);

			for(char cand:cands.toCharArray()){
				StringBuffer buff = new StringBuffer(output.toString());
				buff.append(cand);
				generatePermutations(buff);
			}
		}
	}
	
	//binary numbers
	public void generateOutput(StringBuffer output) {
			System.out.println(output);
			count++;
	}

	//Enumeration m*n
	public String canditates(StringBuffer output){
		StringBuffer ret = new StringBuffer();
		for(char s : a[output.length()].toCharArray()){
				ret.append(s);
		}
		return ret.toString();	
		
	}
	public boolean isResult(StringBuffer output) {

		return output.toString().length()==a.length;
	}
	
	public static void main(String[] args) {
		new BackTracking_Tele().generatePermutations(new StringBuffer());
		System.out.println(count);
		
	}

	@Override
	public Character[] canditates(List<Character> output) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isResult(List<Character> output) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void generateOutput(List<Character> output) {
		// TODO Auto-generated method stub
		
	}


}
