package sort;

import java.util.ArrayList;
import java.util.List;


/**
 * Binary Search :- Find elements, Find spot to insert, Rotated array
 * Find Pivot :- Rotated Array, Peak curve
 *
 */

public class BinarySearch {

	int a[] = {10,40};
	
	void findNumber(int k ){
		
		int l = 0;
		int n = a.length - 1;
		while(l<n){
			//mid falls either towards l or n
			//the corresponding has to be incremented or decremented
			int m = (l+1)+(n-l)/2;
			
			/*finds first big one or else finds last occuring k
			m=(l) +(m-1)/2;
			//is true
			if(a[m]<k){
				l =m+1;
			}else{
				n=m;
			}
			*/
			/*finds first small one or else finds first occuring k
			m=(l) +(m-1)/2 + 1;
			//is true
			if(a[m]<=k){
				l =m;
			}else{
				n=m-1;
			}
			*/
			//Do we retain the last small one or move towards the first big one
			//Do we retain the first repeating or last repeating
			//depends if l moves towards n or n moves towards l when predicate
			//is true
			if(a[m]<k){
				//last small one
				l=m;
				//first big one
				//l=m+1
			}else if(a[m]>k){
				//last small one
				n=m-1;
				//first big one
				//n=m
			}else if(a[m]==k){
				// find last one
				l=m;
				//find first one
				//n=m
			}
		}
		System.out.println(a[l]==k);
	}

	
	int a1[] = {30,40,50,500,501,20,22,25};
	//find first element which is lesser than a[0]
	//find 50
	
	//find pivot for the rotated array
	int findPivot (int l , int n){
		

		if(a1[l] <= a1[n]){
			return a1[l]; 
		}
		int m = (l)+(n-l)/2;
		
		System.out.println("*"+m);
		if(a1[m]>a1[l]){
			//could not m be the pivot point ????
			//no because pivot is the smallest
			return findPivot(m+1,n);
		}else{
			return findPivot(l+1,m);
		}
				
	}
	
	
	int findPivot1 (int l , int n){
		//always make a1[l] > a1[n] so that array is not sorted
		//reject the sorted array
		//does not handle the condition when a1[l] ... a1[n] is not rotated, 
		//handle it b4 invoking the function

		if(n-l==1){
			//two element array
			return a1[n]; 
		}

		int m = (l)+(n-l)/2;
		
		if(a1[m]>a1[l]){
			return findPivot(m,n);
		}else{
			return findPivot1(l,m);
		}
				
	}
	int a2[] = {10,20,30,40,50,60,45,25,25,12};
//a[i] > a[i-1]
	//Peak Curve
	int findPeak(int l , int n){
		
		if(n-l == 1){
			return -1; 
		}
		int m = (l)+(n-l)/2;
		
		
		if(a2[m-1] < a2[m] && a2[m] > a2[m+1]){
			return m;
		}else if (a2[m-1] < a2[m] && a2[m]<a2[m+1]){
			return findPeak(m, n);
		}else{
			return findPeak(l, m);
		}
		
	}
	
	
	public static int search(int a[], int l, int u, int x) {
		while (l <= u) {
			int m = (l + u) / 2;
			if (x == a[m]) {
				return m;
			} else if (a[l] <= a[m]) {
				//a[l...m]is sorted 
				//check if x is within them or outside
				if (x > a[m]) {
					// x is above range
					l = m + 1;
				} else if (x >= a[l]) {
					//x is b/w a[l] and a[m]
					u = m - 1;
				} else {
					//x is less than a[l]
					l = m + 1;
				}
			}else if (a[m] <= a[u]){
				//a[m....u] is sorted
				//check if x is within them or outside
				if (x < a[m]){
					u = m - 1;
				}else if (x <= a[u]){
				//x is b/w m and u
					l = m + 1;
				}else{
					u = m - 1;
				}
			}
		}
		return -1;
	}
	public static int findMissing(List<Integer> a, int l, int n){
		
		if(l==n){
			System.out.println(a);
			System.out.println(l);
			System.out.println(n);
			return l;
		}
		int m = (l+n)/2;
	
	
		List<Integer> rr = new ArrayList<Integer>();
		List<Integer> rr1 = new ArrayList<Integer>();
		for(int i=0; i<a.size();i++){
			//can be separated based on bits @MSB-i as well
			if(a.get(i) > m){
				rr1.add(a.get(i));
			}else{
				rr.add(a.get(i));
			}
		}
		int n1 = m - l + 1;
		int n2 = n - m;
		if(rr1.size()!=n2){
			return findMissing(rr1, m+1, n);	
		}else{
			return findMissing(rr,l,m);
		
		}
	}
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		
		bs.findNumber(40);
		
		System.out.println(bs.findPivot1(0, bs.a1.length-1));
		System.out.println(bs.findPeak(0, bs.a2.length-1));
	}
}