package dsalgo.enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking_Rabbit extends BackTrack<Integer> {

  List<Integer> dt = Arrays.asList(2,4,5,9);
  int hops[] = {1,3,5};
  
  @Override
  public Integer[] canditates(List<Integer> output) {
    int index = output.size();
    List<Integer> canditates = new ArrayList<Integer>();
    int stone = index==-0 ? 0 : output.get(index-1);
    for(int i = 0 ; i<hops.length;i++){
      if(dt.contains(stone+hops[i])){
        canditates.add(stone+hops[i]);
      }
    }
    for(int i = 0 ; i<hops.length;i++){
      if((stone-hops[i]) >0 && !output.contains(stone-hops[i]) && dt.contains(stone-hops[i])){
        canditates.add(stone-hops[i]);
      }
    }
    return canditates.toArray(new Integer[0]);
  }

  @Override
  public boolean isResult(List<Integer> output) {
    int index = output.size();
    int stone = index==-0 ? 0 : output.get(index-1);
    return stone==dt.get(dt.size()-1);
  }

  int min = Integer.MAX_VALUE;
  @Override
  public void generateOutput(List<Integer> output) {
    if(output.size()<min){
      min = output.size();
    }
  }
  
  public static void main(String[] args) {
    Backtracking_Rabbit br = new Backtracking_Rabbit();
    br.generatePermutations(new ArrayList<Integer>());
    System.out.println(br.min); 
  }
}
