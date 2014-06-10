package dsalgo.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MinMaxPairs {

	public static class Pair{
		int first;
		int second;	
	}
	
	int maxDiff(int[] array){
		
		int min = array[0];
		int maxDiff = Integer.MIN_VALUE;
		for(int i=1;i<array.length;i++){
			maxDiff = Math.max(maxDiff, array[i]-maxDiff);
			min = Math.min(min, array[i]);
		}
		return maxDiff;
	}
	
	//using lmin and rmax array we can acheive the min & max
	//first max in the right side of array
	List<Pair> firstmaxRtPair(int[] array){
		
		List<Pair> pairs = new ArrayList<Pair>();
		LinkedList<Integer> dqueue = new LinkedList<Integer>();
		
		for(int i = 0; i < array.length;i++){
			
			while(!dqueue.isEmpty()){
				if(array[i] < dqueue.get(dqueue.size()-1)){
					Pair nn = new Pair();
					nn.first =  dqueue.removeLast();
					nn.second = array[i];
					pairs.add(nn);
				}else{
					break;
				}
			}
		}
		//dqueue is sorted in increasing order
		while(!dqueue.isEmpty()){
			Pair nn = new Pair();
			nn.first =  dqueue.removeLast();
			nn.second = -1;
			pairs.add(nn);
		}
		
		return pairs;
	}
	List<Pair> lastmaxRtPair(final int[] array){
		List<Pair> pairs = new ArrayList<Pair>();

		Integer index[] = new Integer[array.length];
		for(int i=0;i<array.length;i++){
			index[i] = i ;
			
		}
		Collections.sort(Arrays.asList(index), new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return array[o1]< array[o2] ? -1 : 1;
			}
		});
		
		Integer index1[] = new Integer[array.length];
		index1[index.length-1] = index[index.length-1];
		for(int i = index.length-2 ; i>=0; i --){
			if(index1[i+1]>index[i]){
				index1[i] = index1[i+1];
			}else{
				index1[i] = index[i];
			}
		}
		for(int i =0; i < index.length;i++){
			Pair nn = new Pair();
			nn.first = array[index[i]];
			nn.second = array[index1[i]];
			pairs.add(nn);
		}
		return pairs;
	}
	//sort stack using another stack
	
	public Stack<Integer> sort(Stack<Integer> input){
		Stack<Integer> nn = new Stack<Integer>();
		while(!input.isEmpty()){
			int top = input.pop();

			while(!nn.isEmpty() && nn.peek()>top){
				input.push(nn.pop());
			}
			input.push(top);
			
		}
		
		return nn;
		
	}
	
	//maximize distance such that a[i]<a[j]
	
	public int maxDt(int[] input){
		
		int lmin[] = new int[input.length];
		int rmax[] = new int[input.length];
		lmin[0] = input[0];
		rmax[input.length-1] = input[input.length-1];
		for(int i =1 ;i < input.length;i++){
			if(input[i]<lmin[i-1]){
				lmin[i]=input[i];
			}else{
				lmin[i] = lmin[i-1];
			}
		}
		for(int i =input.length-2 ;i>=0;i--){
			if(input[i] > rmax[i+1]){
				rmax[i]=input[i];
			}else{
				rmax[i] = rmax[i+1];
			}			
		}
		int l=0, r = 0;
		int maxDiff = 0;
		while(r<input.length){
			
			maxDiff = Math.max(maxDiff,r-l);
			if(lmin[l]<rmax[r]){
				r++;
			}else{
				l++;
			}
		}
		
		return maxDiff;
	}
}
