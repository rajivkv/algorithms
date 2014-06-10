package dsalgo.enumeration;
import java.util.ArrayList;
import java.util.List;

public abstract class BackTrack<T> {

	public void generatePermutations(List<T> output) {
		if(isResult(output)){
			generateOutput(output);
		}else{
			T cands[] = canditates(output);
			for(T cand:cands){
			    //newOp serves as link to ancestor
				List<T> newOp = new ArrayList<T>(output);
				newOp.add(cand);
				generatePermutations(newOp);
			}
		}
	}

	public abstract T[] canditates(List<T> output);

	public abstract boolean isResult(List<T> output);

	public abstract void generateOutput(List<T> output);

}