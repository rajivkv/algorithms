package dsalgo.integer.others;

public class Sum {

	static int a[] = {-10,0,10,20,50,70,80};
	
	static int l , m;
	public static int findTwoNo(int exclude,int sum){
		l = 0;
		m = a.length-1;
		while(l<m){
			if(l==exclude){
				l++;
				continue;
			}
			if(m==exclude){
				m--;
				continue;
			}
			int t = a[l] + a[m];
			if(t<sum){
				l++;
			}else if(t>sum){
				m--;
			}else{
				System.out.println( l + " " + m);
				return 1;
			}
		}
		l = m = -1;
		return -1;
	}
	
	public static void findThreeNo(int sum){
		for(int i=0; i <a.length;i++){
			if(findTwoNo(i, sum-a[i]) !=-1){
				System.out.println("Found "+ i +" "+l + " "+m);
				break;
			}
		}
	}
	public static void main(String[] args) {
		findThreeNo(0);
	}
	
}
