package tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class HeapMerge {

	
	public Integer[] topK(final int[] heapArray,int k){

		//top-k
		List<Integer> topk = new ArrayList<Integer>();
		PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(heapArray.length,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return heapArray[o1]<heapArray[o2]?1:-1;
			}
		});
	
		int i = 1;
		topk.add(heapArray[1]);
		int n =1;
		while(n<k){
			if(2*i < heapArray.length){
				pqueue.add(2*i);

			}
			if((2*i + 1)< heapArray.length){
				pqueue.add(2*i + 1);

			}
			i = pqueue.poll();
			n++;
			topk.add(heapArray[i]);
		}
		
		return topk.toArray(new Integer[0]);
	}
	
	
	
//	
//	public int[] mergeSum(int[] array1, int[] array2){
//		
//	}

	public static void main(String[] args) {
		int test[] = {4,2,6,21,90,53,1};
		
		Heap heap = new Heap();
		
		HeapMerge merge = new HeapMerge();
		int heap1[] = heap.buildHeap(test);
		for(int i=0;i<heap1.length;i++){
			System.out.println(heap1[i]);
		}		
		System.out.println();
		Integer kk [] = merge.topK(heap.buildHeap(test),3);
		for(int i=0;i<kk.length;i++){
			System.out.println(kk[i]);
		}
		
		
		//build a tournament tree
		int test1[] = {4,2,6,21,90,53,1};

		int tournament[] = new int [test1.length+test1.length];
		
		int t = tournament.length-1;
		for(int j=test1.length-1; j>=0 ; j--){
			tournament[t--] = test1[j];
		}
		int heap2[] = heap.buildHeap(tournament);

	}

	int RMQ(int[] heap, int current, int l , int m, int q1, int q2){
		if(current > heap.length){
			return -1;
		}
		if(l==m){
			return heap[current];
		}
		if(q1<=l && q2>=m){
			return heap[current];
		}
		
		if(l>m)
			return -1;
		
		int mid = (l + m)/2;
		
		
		int ltMax = RMQ(heap,2*current,l,mid,q1,q2);
		int rtMax = RMQ(heap,2*current+1,mid+1,m,q1,q2);
	
		return Math.max(ltMax, rtMax);
	}
}
