package string;

public class RegExMatch {

	//sort
	//length of longest substring without repetition
	//suffix array
	//lcp of suffix array
	//interleaved string
	//palindrome usig suffix array
	//palindrome using dp
	
	//partition problem -> subsets
	public int lengthLongestWithoutRep(String str){
		
		int[] length = new int[str.length()];
		
		int bfound[]=new int[256];
		
		for(int i=0;i<bfound.length;i++){
			bfound[i]=-1;
		}
		length[0] =1;
		for(int i=1;i<str.length();i++){
			if(bfound[str.charAt(i)]!=-1 && (i-length[i-1])<=bfound[str.charAt(i)]){
				length[i] = i-bfound[str.charAt(i)];
			}else{
				length[i]=length[i-1]+1;
			}
			bfound[str.charAt(i)] = i;
		}
		int max = 0;
		for(int i=0;i<length.length;i++){
			max = Math.max(length[i], max);
		}
		return max;
	}
	
	
	//interleaving of strings
	public static boolean matches(String s1, String s2){
		
		int state = 0;
		char prev=' ';
		int i=0, j=0;
		
		while(i <s1.length()){
			if(state==0 && (i+1)<s1.length() && s1.charAt(i+1)=='*'){
				state = 1;
			}else if(state==0){
				if(j>=s2.length()){
					return false;
				}
				if(s1.charAt(i)==s2.charAt(j)){
					i++; j++;
				}else{
					return false;
				}
			}else if(state==1){
				
				//j can be 0 or more characters of prev
				if(j>=s2.length()&& i==s1.length()-2){
					return true;
				}
				if(s1.charAt(i)==s2.charAt(j)){
					j++;
				}else{
					i+=2;
					state=0;
				}
			}
		}

		while(j<s2.length()){
			if(state==1 && prev==s2.charAt(j)){
				j++;
			}else{
				return false;
			}
		}
		return true;
	}
			
	public static void main(String[] args) {
		String s1 = "abc*";
		String s2 = "abccccccccccccccc";
		System.out.println(matches(s1,s2));
	}
	
}
