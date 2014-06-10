package dsalgo.enumeration;

import java.util.ArrayList;
import java.util.List;

public class BackTrack_Grid extends BackTrack<IntPair> {

  int maxX=0, maxY=0;
  int destX=0, destY=0;
  boolean found=false;
  @Override
  public IntPair[] canditates(List<IntPair> output) {

    IntPair lastPt = output.get(output.size()-1);
    List<IntPair> ret = new ArrayList<IntPair>();    

    if((lastPt.x+1)<=maxX){
      ret.add(new IntPair(lastPt.x+1,lastPt.y));
    }
    if((lastPt.y+1)<=maxY){
      ret.add(new IntPair(lastPt.x,lastPt.y+1));
    }

    if((lastPt.x+1)<=maxX && (lastPt.y+1)<=maxY){
      ret.add(new IntPair(lastPt.x+1,lastPt.y+1));
    }
    
    
    return ret.toArray(new IntPair[0]);
  }

  @Override
  public boolean isResult(List<IntPair> output) {
    IntPair lastPt = output.get(output.size()-1);
    found=found | (lastPt.x==destX && lastPt.y==destY);
    return found;
  }

  List<IntPair> output = null;
  @Override
  public void generateOutput(List<IntPair> output) {
    if(this.output==null){
      this.output=output;
      System.out.println(output);
    }
  }

  public static void main(String[] args) {
    BackTrack_Grid  par1 =  new BackTrack_Grid();

    par1.maxX=4;
    par1.maxY=4;
    par1.destX=3;
    par1.destY=3;
    List<IntPair> ip = new ArrayList<IntPair>();    
    ip.add(new IntPair(0, 0));
    par1.generatePermutations(ip);
  }
}
