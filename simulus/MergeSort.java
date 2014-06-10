//o(nlogn) always - can be disk based sort as well

int a[];
void mergeSort(int m , int n){

	if(m<=n){
		return;
	}
	int mid = (m+n)/2;

	mergeSort(m,mid);
	mergeSort(mid+1,n);
	merge(m,mid,n); //done in post-order
}

void merge(int start, int mid , int end){

	int a1 = start; int a2=mid;
	int b1 = mid+1; int b2=end;
	//unnecessary copy - space o(n)
	int c[end-start+1];
	for(int i = 0 ; i < c.length ; i++){
		if(b1>b2 || a[a1]<b[b1]){
			c[i] = a[a1];
		}else{
			c[i] = b[b1];
		}

	}
	for(int i = 0 ; i < c.length ; i++){
		a[start++] = c[i];
	}
}