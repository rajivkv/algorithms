package tree;

public class CountBST {

	
	public int countBST(int arr[], int m , int n){
		if(m==n || m>n)
			return 1;
		
		int total = 0;
		for(int i =m; i <=n;i++){
			int ltBST = countBST(arr, m, i-1);
			int rtBST = countBST(arr,i+1,n);
			total = total + ltBST*rtBST;
		}
		return total;
	}
	
	static int a[] = {1,2,4,};
	
	public static void main(String[] args) {
		System.out.println(new CountBST().countBST(a, 0, a.length-1));
	}
}
