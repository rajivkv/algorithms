//Quicksort O(nlogn) algorithm - worst case O(n^2)
//a is the source array to be sorted
//recursive algorithm around pivot
public quicksort(int m, int n){

	if(m<=n){
		//nothing to do for one element
		return;
	}
	int pivot = a [m];

	//2-way partition around pivot
	//done in pre-order
	int pivotptr = m;
	for(int i = m+1 ;i <= n;i++){
		if(a[i]<=pivot){
			pivotptr++;
			int t = a[pivotptr];
			a[pivotptr] = a[i];
			a[i] = t;
		}
	}
	quicksort(m,pivot-1);
	quicksort(pivot+1,n);
}