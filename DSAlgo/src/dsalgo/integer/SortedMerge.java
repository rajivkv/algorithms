package dsalgo.integer;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SortedMerge {

	static class IndexPair{
		public IndexPair(int i, int j) {
			x=i;
			y=j;
			value = a[i]+b[j];
		}
		int x;
		int y;
		int value;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			IndexPair other = (IndexPair) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
	
	static PriorityQueue<IndexPair> pq = new PriorityQueue<SortedMerge.IndexPair>(10,new Comparator<IndexPair>() {
		@Override
		public int compare(IndexPair o1, IndexPair o2) {
			if(o1.value>o2.value){
				return 1;
			}else if(o1.value<o2.value){
				return -1;
			}
			return 0;
		}
	});
	
	static int a[] = {5,10,20,30,50};
	static int b[] = {7,15,24,34};

	public static void  MergeSum(){
		Set<IndexPair> lookup = new HashSet<SortedMerge.IndexPair>();
		pq.add(new IndexPair(0,0));
		lookup.add(new IndexPair(0,0));

		while(!pq.isEmpty()){
			IndexPair m = pq.poll();
			System.out.println(m.value);
			if(m.x+1 < a.length){
				IndexPair nn =new IndexPair(m.x+1,m.y);
				if(!lookup.contains(nn)){
					pq.add(nn);
					lookup.add(nn);
				}
					
			}
			if(m.y+1 < b.length){
				IndexPair nn =new IndexPair(m.x,m.y+1);
				if(!lookup.contains(nn)){
					pq.add(nn);
					lookup.add(nn);
				}
			}
		}
	}
	
	public static void main(String[] args) {
	MergeSum();	
	}

}
