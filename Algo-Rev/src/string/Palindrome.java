package string;

import string.SuffixArray.Suffix;

public class Palindrome {

	public int longestPalindrome(String str){
		int lcp = 0;
		for(int i=0; i<str.length();i++){
			//center
			lcp = Math.max(lcp, 1+ lcpst(str,i+1,i-1)*2);
			//ending
			lcp = Math.max(lcp, lcpst(str,i+1,i)*2);
		}
		return lcp;
	}

	
	public int longestPalindrome_dp(String str){
		//a[i][j] = palindrome if a[i]=a[j] and a[i-1,j-1] is palindrome
		
		boolean isPalindrome[][] = new boolean[str.length()][str.length()+1];
		int max = 1;
		
		//one length string
		for(int i=0 ;i < str.length();i++){
			isPalindrome[i][1] = true;
		}
		//two length string
		for(int i=0 ;i < str.length()-1;i++){
			isPalindrome[i][2] = str.charAt(i)==str.charAt(i+1) ? true : false;
			if(isPalindrome[i][2]){
				max = 2;
			}
		}
		
		//for greater than 2 length strings
		for(int j=3;j<=str.length();j++){
			for(int i = 0 ; i<str.length();i++){
				if((i+j-1)<str.length()){
					isPalindrome[i][j]=(str.charAt(i)==str.charAt(i+j-1)) && isPalindrome[i+1][j-2];
					if(isPalindrome[i][j]){
						max = Math.max(max, j);
					}
				}
			}
		}
		return max;
	}
	
	public int longestPalindrome_suffixArray(String str){
		
		String strR = str + "#" + new StringBuilder(str).reverse().toString();
		SuffixArray suffArray = new SuffixArray(strR);
		
		
		Suffix suff[] = suffArray.getSuffixes();

		boolean cat[] = new boolean[suff.length];
		
		for(int i = 0; i<suff.length;i++){
			if(suff[i].suffix.indexOf('#')!=-1){
				cat[i] = true;
			}
		}
		int max = 0;
		for(int i = 0; i<suff.length;i++){
			
			for(int j=i+1;j<suff.length;j++){
				if((cat[i]==true && cat[j]==false) || (cat[i]==false && cat[j]==true)){
					max=  Math.max(max,suffArray.lcp(i, j));
					break;
				}
				
			}
		}
		return max;
	}
	private int lcpst(String str, int i, int j) {
		int cnt =0;
		while(i<str.length() && j>=0){
			if(str.charAt(i)==str.charAt(j)){
				i++;
				j--;
				cnt++;
			}else{
				break;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		
		String str = "abba";
		System.out.println(new Palindrome().longestPalindrome(str));
		System.out.println(new Palindrome().longestPalindrome_dp(str));
		System.out.println(new Palindrome().longestPalindrome_suffixArray(str));

	}
}
