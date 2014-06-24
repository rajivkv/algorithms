package dsalgo.enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackingInterleaving extends BackTrack<Character> {

  String s1 = "abcde";
  String s2 = "fghijk";
  static int iw=0;

  //(m+n)!/(m!*n!)
  @Override
  public Character[] canditates(List<Character> output) {
    int index1=-1;
    int index2=-1;
    List<Character> charList = new ArrayList<Character>();

    for(Character c:output){
      if(s1.indexOf(c)!=-1){
        index1=s1.indexOf(c);
      }else{
        index2=s2.indexOf(c);
      }
    }
    if(index1+1 < s1.length()){
      charList.add(s1.charAt(index1+1));
    }
    if(index2+1 < s2.length()){
      charList.add(s2.charAt(index2+1));
    }
    return charList.toArray(new Character[]{});
  }

  @Override
  public boolean isResult(List<Character> output) {
    return output.size()==(s1.length()+s2.length());
  }

  @Override
  public void generateOutput(List<Character> output) {
    iw++;
    System.out.println(output);
  }

  
  public static void main(String[] args) {
      new BackTrackingInterleaving().generatePermutations(Arrays.asList(new Character[]{}));
      System.out.println(iw);
  }
}
