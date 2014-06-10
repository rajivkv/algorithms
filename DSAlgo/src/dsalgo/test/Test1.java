package dsalgo.test;

import java.util.Arrays;
import java.util.Set;

public class Test1 {
	
	public void palindromeUsingTable(String input){
		
	}
	
	public String palindromeUsingON(String input){
		String lcs = "";
		for(int i=1;i<input.length();i++){
			String lcp1 = lcp(input, i , i);
			String lcp2 = lcp(input,i,i-1);
			
			if(lcp1.length()>lcs.length()){
				lcs=lcp1;
			}
			if(lcp2.length()>lcs.length()){
				lcs=lcp2;
			}
		}
		return lcs;
	}
	
	String lcp(String input, int front, int back){
		String lcs ="";

		while(back>=0 && front<input.length() && input.charAt(front)==input.charAt(back)){
			front++;
			back--;
		}
		lcs=input.substring(back+1, front);
		return lcs;
	}
	public int cnt=0;
	public String wordMarker(String input, Set<String> dictionay){
		cnt++;
		if(dictionay.contains(input)){
			return input;
		}
		for(int i =0 ; i < input.length();i++){
			if(dictionay.contains(input.substring(0, i))){
				String sub1 = wordMarker(input.substring(i),dictionay);
				if(sub1!=null){
					return input.substring(0, i) + " " + sub1;
				}
			}
		}
		return null;
	}

	int lcs =0;
	public int leastCommonSubstring(String str1, String str2, int m , int n){
		if(m<0 || n<0){
			return 0;
		}
		int lcs2 = 0 ;
		for(int i=m;i>=0;i--){
			for(int j=n;j>=0;j--){
				if(str1.charAt(m)==str2.charAt(n)){
					lcs2 = 1+leastCommonSubstring(str1, str2, m-1, n-1);
					lcs= Math.max(lcs, lcs2);
				}				
			}
		}
		return lcs2;
	}
	
	public String[] generateConcats(String[] str){
		return null;
	}
	
	public int[] partitions(int[] partition, int k){
		if(k==1){
			return new int[]{sum(partition)};
		}
		if(partition.length ==k){
			return Arrays.copyOf(partition,partition.length);
		}
		int retPar[] = null, retSum = Integer.MAX_VALUE;
		for(int i = partition.length- 1 ;i>=k;i--){
			int currPar[] = partitions(Arrays.copyOfRange(partition, 0, i),k-1);
			int currSum = sum(Arrays.copyOfRange(partition, i, partition.length));
			int maxSum = max(currPar,currSum);
			if(maxSum < retSum){
				retSum = maxSum;
				retPar = Arrays.copyOf(currPar, currPar.length+1);
				retPar[retPar.length-1] = currSum;
			}
		}
		return retPar;
	}

	private int max(int[] currPar, int currSum) {
		int max = currSum;
		for(int i=0; i<currPar.length;i++){
			max = Math.max(max, currPar[i]);
		}
		return max;
	}

	private int sum(int[] partition) {
		int sum = 0;
		for(int i=0; i<partition.length; i++){
			sum = sum + partition[i];
		}
		return sum;
	}
}
