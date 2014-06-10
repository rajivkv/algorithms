package dsalgo.integer;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindow {

	//use minQueue
	//init minQueue with w elements
	//min, pop(1), push(1)
	
	public int[] slidingWindow(int[] input, int width){
		//O(N) amoritized cost
		int[] minArray = new int[input.length-width];
		LinkedList<Integer> queue = new LinkedList<Integer>();

		queue.add(input[0]);
		for(int i =0 ; i < width; i++){
			for(int j=queue.size()-1;j>=0;j--){
				if(input[i]<queue.get(j)){
					queue.removeLast();
				}else{
					break;
				}
			}
			queue.add(input[i]);
		}
		for(int i=width;i<input.length;i++){
			minArray[i-width]=queue.get(0);
			if(queue.get(0)==input[i-width]){
				queue.removeFirst();
			}
			for(int j=queue.size()-1;j>=0;j--){
				if(input[i]<queue.get(j)){
					queue.removeLast();
				}else{
					break;
				}
			}
			queue.add(input[i]);
		}
		return minArray;
	}

}
