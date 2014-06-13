package common;

public class SegmentTree {

	
	public Node constructRMQ(int[] array, int lo , int hi){
		
	
		if(lo==hi){
			Node nn = new Node(array[lo]);
			return nn;
		}
	
		int mid = (lo+hi)/2;
		
		
		Node left = constructRMQ(array, lo, mid);
		Node right = constructRMQ(array, mid+1, hi);
		
		Node nn = new Node(left.data<right.data?left.data:right.data);
		nn.left = left;
		nn.right = right;
		
		return nn;
	}
	
	
	
	public int getMin(Node root, int lo , int hi,int start, int end){
		
		
		if(start<=lo && hi>=end){
			return root.data;
		}
		if(hi < start || lo > end){
			return Integer.MAX_VALUE;
		}
		
		if(lo==hi)
			return root.data;
		int mid = (lo+hi)/2;
		
		int left = getMin(root.left, lo, mid,start,end);
		int right = getMin(root.right, mid+1, hi,start,end);
	
		return left<right?left:right; 
	}
}
