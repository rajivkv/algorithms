package dsalgo.integer.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Two Sorted Arrays, Find the result from union
//merge sort
public class BinSearch2Arrays {

	//two sorted arrays of equal length
	//find median
	int a[] = {10,20,30,40,50};
	int b[] = {15,25,30,45,55};
	void findMedian(int a1,int a2,int b1,int b2){
//		System.out.println("[" + a1 + "]"   +"[" + a2 + "]" + "[" + b1 + "]"   +"[" + b2 + "]" +"="+(a2-a1+1+b2-b1+1));
		if((a2-a1+1) +(b2-b1+1) <= 4){
			if(a[a2]<=b[b1]){
				System.out.println(a[a2] +" " + b[b1]);
			}else if(b[b2]<=a[a1]){
				System.out.println(b[b2] +" " + a[a1]);
			}else if(b[b1]>a[a1]){
				System.out.println(b[b1] +" " + a[a2]);
			}else{
				System.out.println(a[a1] +" " + b[b2]);
			}
			return;
		}
		int amid = (a1+a2)/2;
		int bmid = (b1+b2)/2;
		
		if(a[amid]<b[bmid]){
			findMedian(amid, a2, b1, bmid);
		}else{
			findMedian(a1, amid, bmid, b2);
		}
	}
	
	
	//two sorted arrays of unequal length
	//find kth element
	int b1[] = {10,20,30,40,50};
	int a1[] = {15,25,35,45,55,65,75,85,95,105};

	void findKelement(int a11,int a21,int b11,int b21,int k){
		System.out.println("[" + a11 + "]"   +"[" + a21 + "]" + "[" + b11 + "]"   +"[" + b21 + "]" +"="+(a21-a11+1+b21-b11+1));
		
		int m = (a21-a11) + 1;
		int n = (b21-b11) + 1;

		int iq = (int)((double)m / (m+n) * (k-1));
		int j = (k-1) - iq -1;
		
		int amid =  a11+iq;
		int bmid =  b11 +j;
		System.out.println("*"+iq + "[" + m +"  " + n + "]" + k);
		if(bmid<b11 || bmid>=b21){
			// Merge two sorted array
			List<Integer> op = new ArrayList<Integer>();
			for(int i=a11; i <=a21;i++){
				op.add(a1[i]);
			}
			for(int i=b11; i <=b21;i++){
				op.add(b1[i]);
			}			
			Integer ff[] = op.toArray(new Integer[0]);
			Arrays.sort(ff);
			System.out.println(a11 + "[" + b11 +"  " + b21 + "]" + k);
			System.out.println(ff[k]);
			return;
		}
		//take K & K+1 element and find which is the kth element.
		//instead take K & K-1 element so that you can add 1
		//add a buffer of -inf to handle edge cases
		if(getVal(a1,amid)< getVal(b1,bmid)){
			findKelement(amid+1, a21, b11, bmid,k-iq-1);
		}else{
			findKelement(a11, amid, bmid+1, b21,k-j-1);
		}
	}
	
	public int getVal(int aq[], int index){
		if(index < 0) {
			return Integer.MIN_VALUE;
		}
		if(index >= aq.length){
			return 		Integer.MAX_VALUE;
		}else{
			return aq[index];
		}
		
	}
	public static void main(String[] args) {
		BinSearch2Arrays n1 = new BinSearch2Arrays();
		n1.findMedian(0, n1.a.length-1, 0, n1.b.length-1);
		for(int i = 0 ; i <n1.a1.length+n1.b1.length;i++){
			System.out.println(i);
			n1.findKelement(0, n1.a1.length-1, 0, n1.b1.length-1,i);
		}
	}
}
