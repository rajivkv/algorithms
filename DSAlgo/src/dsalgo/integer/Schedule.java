package dsalgo.integer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Schedule {

	int s[] = {8,9,15,22};
	int f[]= {12,19,18,23};
	
	
	List<Integer> st = new ArrayList<Integer>();
	List<Integer> end = new ArrayList<Integer>();
	
	void schedule(){
		List<Integer> index = new ArrayList<Integer>();
		
		for(int i=0 ; i<f.length;i++){
			index.add(i);
		}
		while(!index.isEmpty()){
			//get minimum
			int min = 0;
			for(int i=1 ; i < index.size();i++){
				if(f[index.get(i)]<f[min]){
					min =i; 
				}
			}
			
			int sel = index.remove(min);
			end.add(f[sel]);
			st.add(s[sel]);
			
			Iterator<Integer> it =index.iterator(); 
			while(it.hasNext()){
				if(s[it.next()]<=f[sel]){
					it.remove();
				}
			}
		}
	}
	public static void main(String[] args) {
		Schedule ss = new Schedule();
		ss.schedule();
		System.out.println(ss.st);
		System.out.println(ss.end);
	}
}
