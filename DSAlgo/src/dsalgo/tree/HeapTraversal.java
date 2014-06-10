package dsalgo.tree;

import java.util.ArrayList;
import java.util.List;

//Cheap plane tickets :- Generating sorted sum from two sorted arrays
//O(k) algorithm - to find x is smaller that kth largest element - heap of n is given

public class HeapTraversal {

	
	ArrayToHeap<Integer> h = ArrayToHeap.getIntHeap();
	
	
	List<Integer> output = new ArrayList<Integer>();
	
	//kth smallest/largest element should be at maximum distance k from root
	public void traverse(int i, int depth){
		if(depth==0 || i >=h.array.length){
			return ;
		}
		output.add(h.array[i]);
		traverse(2*i,depth-1);
		traverse(2*i + 1,depth-1);
	}
	
	//find k elements greater than x if one exists
	List<Integer> output1 = new ArrayList<Integer>();
	//traverse up-to height k and try to find k elements greater than x
	//O(k) algorithm :- maintain the global count of number of nodes visited
	public void traverse1(int i, int depth, int x, int k){
		if(depth==0 || i >=h.array.length || output1.size()==k){
			return;
		}
		if(h.array[i] > x){
			output1.add(h.array[i]);
			traverse1(2*i,depth-1,x,k);
			traverse1(2*i + 1,depth-1,x,k);
		}
	}
	
	//traverse entire tree to find greater elements
	//O(k) algorithm :- maintain the count of number of nodes visited
	public int traverse2(int i, int depth, int x, int rem){
		if(rem<=0 || i >=h.array.length){
			return 0;
		}
		if(h.array[i] > x){
			int lt = traverse2(2*i,depth-1,x,rem-1);
			int rt = traverse2(2*i + 1,depth-1,x,rem-lt-1);
			return (lt+rt+1);
		}else{
			return 0;
		}

	}
	
	public static void main(String[] args) {
		HeapTraversal ss = new HeapTraversal();
//		ss.traverse(1, 5);
//		Collections.sort(ss.output,Collections.reverseOrder());
//		System.out.println(ss.output);
		ss.traverse1(1, 5, 20,5);
		System.out.println(ss.output1);
		System.out.println(ss.traverse2(1, 5, 99, 5));
		
	}
	
}
