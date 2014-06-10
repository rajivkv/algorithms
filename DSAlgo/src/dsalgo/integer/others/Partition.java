package dsalgo.integer.others;

//Two and Three way partition . used for string / integer Qsort
public class Partition {
	//2-way partition
	int a[]= {1,1,1,1,0,0,1,0,0,0};
	
	//can be used for Qsort
	int twowayPartition(int a[] , int pivot){
		int l = -1;
		int i = 0;
		while(i<a.length){
			if(a[i]<=pivot){
				int t = a[++l];
				a[l]=a[i];
				a[i++] =t;
			}else{
				i++;
			}
		}
		for(int i1 = 0 ; i1 <=l;i1++){
			System.out.print(a[i1] +" ");
		}
		System.out.print("*");
		for(int i1 = l+1 ; i1 <a.length;i1++){
			System.out.print(a[i1] +" ");
		}
		return l;
	}
	
	//3-way partition
	int a1[]= {1,1,1,1,0,0,1,0,0,0,2,2,2,0,1,2};

	//can be used for 3-way Q-sort for string sorting
	public void threewayPartition(int k){
		
		int l = -1;
		int i = 0;
		int n = a1.length;
		
		while(i<n){
			if(a1[i]<k){
				int t = a1[++l];
				//the element 't' swapped is a[i] = k, no need to check again, 
				//proceed to i+1
				a1[l] =  a1[i];
				a1[i++] = t;
			}else if(a1[i]>k){
				int t = a1[--n];
				a1[n] =  a1[i];
				//do not increment i here , compare again
				a1[i]= t;
			}else{
				i++;
			}
		}
		
		for(int i1 = 0 ; i1 <=l;i1++){
			System.out.print(a1[i1] +" ");
		}
		System.out.print("*");
		for(int i1 = l+1 ; i1 <n;i1++){
			System.out.print(a1[i1] +" ");
		}
		System.out.print("*");
		for(int i1 = n ; i1 <a1.length;i1++){
			System.out.print(a1[i1] +" ");
		}
	}
	
	
	public static void main(String[] args) {
		
		Partition part = new Partition();
		System.out.println(part.twowayPartition(part.a,0));
		
		int b[]={2,1,4,2,5};
		System.out.println(part.twowayPartition(b,b[0]));
		System.out.println();
		part.threewayPartition(1);
	}
}
