package dsalgo.test;

import java.util.Arrays;
import java.util.HashSet;

import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void palindrome() {
	  Test1 tt = new Test1();
	  System.out.println(tt.palindromeUsingON("vfabbakk"));
  }
  
  @Test
  public void dictionary(){
	  Test1 tt = new Test1();
	  System.out.println(tt.wordMarker("testmachine1", new HashSet<String>(Arrays.asList("asda","machine","test","Aasda","1"))));
	  System.out.println(tt.cnt);
  }
  
  @Test
  public void testPartition(){
	  Test1 tt = new Test1();
	  int part[] = {20,20,20,30,50,20};
	  int res[] = tt.partitions(part, 3);
	  System.out.println(res.length);
	  
	  for(int i=0; i<res.length;i++)
		  System.out.println(res[i]);
  }
}
