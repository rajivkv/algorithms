package dsalgo.enumeration;

public class IntPair {
  public IntPair(int i, int y2) {
    x=i; y = y2;
  }
  int x;
  int y;
  
  @Override
  public String toString() {
    return "(" + x + "," +y+")";
  }
}
