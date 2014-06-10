package dsalgo.integer;

public class DivideAndConquer {
	static int pow(int x,int y){
		if(y==1)
			return x;
		int k = 1;
		if(y%2==0){
			k = pow(x,y/2);
			return k*k;
		}else{
			k = pow(x,y/2);
			return k*k*x;
		}
	}
	//x=k*y + x%y
	static int gcd(int x, int y){
		if(y==1)
			return 1;
		if(y==0)
			return x;
		return gcd(y,x%y);
	}
	
	static int sqrt(int n){
		
		int l=1;
		int m=n;
		
		while(l<m){
			int mid = l +(m-l)/2;
			if(mid*mid < n){
				l=mid+1;
			}else{
				m=mid;
			}
		}
		return l;
	}
	static void rule(int l, int r, int h){ 
	    for (int t = 1, j = 1; t <= h; j += j, t++) 
	      for (int i = 0; l+j+i <= r; i += j+j)
	    	  System.out.println((l+j+i)+"  "+ t);
	}
	public static void main(String[] args) {
		System.out.println(pow(3,4));
		System.out.println(sqrt(82));
		System.out.println(sqrt(81));
		System.out.println(gcd(16,15));
		//level-order traversal starting with lowest possible nodes
		rule(0,2,9);
	}
}
