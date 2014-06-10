int a[]
int b[]
int findKElt(int a1, int a2, int b1, int b2, int k){
	if(a1>a2){
		return b[b1+k-1];
	}
	if(b1>b2){
		return a[a1+k-1];
	}
	int amid=(a2-a1)/2;
	int bmid=(b2-b1)/2;
	int t = (a2-a1+1) + (b2-b1+1);

	//choose amid, bmid such that amid < k  < bmid, so that both halves can be eliminated
	if(a[mid]<b[mid]){
		//min position of amid -> (amid-a1)
		//max position of amid -> (amid-a1)+(bmid-b1)
		//min position of bmid-> (mid1-a1 + mid2-b1)
		//max position of bmid -> (a2-a1 + mid2-b1)
		//a1..amid..a2..b1..bmid..b2
		//elmimiate bmid..b2 iff k < 
		if(k<t/2){
			findKElt(a1,a2,b1,bmid-1,k);
		}else{
			findKElt(amid+1,a2,b1,b2,(k-amid-a1-1))
		}
	}else if(a[mid]>b[mid]){

		if(k<t/2){
			findKElt(a1,amid-1,b1,b2,k);
		}else{
			findKElt(a1,a2,bmid+1,b2,k-bmid-b1-1);
		}
	}
}