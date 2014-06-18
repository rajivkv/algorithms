package string;

public class RegExMatch {

	//sort
	//length of longest substring without repetition
	//suffix array
	//lcp of suffix array
	
	//palindrome usig suffix array
	//palindrome using dp
	
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
