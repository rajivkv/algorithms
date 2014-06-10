package dsalgo.enumeration;

import java.util.ArrayList;
import java.util.List;

public class BackTracking_Paranthesis extends BackTrack<Character> {

  @Override
  public Character[] canditates(List<Character> output) {
    int l =0, r =0 ;
    for(int i=0;i<output.size();i++){
      if(output.get(i)=='('){
        l++;
      }else{
        r++;
      }
    }
    List<Character> ret = new ArrayList<Character>();
    if(l<cnt/2)
      ret.add('(');
    
    if(l>r)
      ret.add(')');
    
    return ret.toArray(new Character[]{});
    
    //return (l>r && l<=cnt/2)? new Character[]{'(',')'} : new Character[]{'('};
   // return new Character[]{'(',')'};
  }

  int cnt;
  int total;
  @Override
  public boolean isResult(List<Character> output) {
    return output.size()==cnt;
  }

  @Override
  public void generateOutput(List<Character> output) {
    total++;

    System.out.println(output);    
  }

  @Override
  public void generatePermutations(List<Character> output) {
    super.generatePermutations(output);
  }
  public static void main(String[] args) {
    BackTracking_Paranthesis par1 =  new BackTracking_Paranthesis();
    par1.cnt = 10;
    par1.generatePermutations(new ArrayList<Character>());
    
    System.out.println(par1.total);
}
}
