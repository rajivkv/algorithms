package dsalgo.integer.others;

public class BinarySearch2Arrays1 {

	int a[] = {2,4,6};
	int b[] = {3,7};
	
	//logm + logn algorithm
	int findMedian(int a1,int a2, int b1,int b2, int k){
//		System.out.println(a1+ " " + " " +a2 +" " + k);
//		System.out.println(b1+ " " + " " +b2);
		if(a1>a2){
			return b[b1+k];
		}
		if(b1>b2){
			return a[a1+k];
		}
		
		int amid = a1 + (a2-a1)/2;
		int bmid = b1 + (b2-b1)/2;
		int t = (a2-a1)+1 +(b2-b1) + 1;

		if(a[amid]<b[bmid]){
			//two possibilities here
			//a1..amid does not contain kth element (OR)
			//bmid....b2 doer not contain kth element
			//k is in upper half
			if(k< (t/2)){
				return findMedian(a1, a2, b1, bmid-1, k);
			}else{
				return findMedian(amid+1, a2, b1, b2, k-(amid-a1+1));
			}
			
		}else{
			//two possibilities here
			//amid....a2 does not contain kth element (OR)
			//b1....bmid doer not contain kth element
			if(k< t/2){
				return findMedian(a1, amid-1, b1, b2, k);
			}else{
				return findMedian(a1, a2, bmid+1, b2, k-(bmid-b1+1));
			}
		}
		
	}
	public static void main(String[] args) {
		BinarySearch2Arrays1 ba1 = new BinarySearch2Arrays1();
		for(int i=0;i<ba1.a.length+ba1.b.length;i++)
			System.out.println(ba1.findMedian(0, ba1.a.length-1, 0, ba1.b.length-1,i));
	}
}
