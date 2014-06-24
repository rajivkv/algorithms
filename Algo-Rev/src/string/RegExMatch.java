package string;

public class RegExMatch {

	public boolean isInterLeaved(String s1, String s2, String s3){
		
		int i =0;
		int j=0;
		int k=0;
		while(k<s3.length()){
			if(i<s1.length() && s3.charAt(k)==s1.charAt(i)){
				i++;
			}else if(j<s2.length() && s3.charAt(k)==s2.charAt(j)){
				j++;
			}else{
				return false;
			}
			k++;
		}
		return true;
	}
	public boolean isInterLeaved_NotUnique(String s1, String s2, String s3){
		
		int i =0;
		int j=0;
		int k=0;
		while(k<s3.length()){
			boolean isduplicate = false;
			boolean isMatch = false;
			if(i<s1.length() && s3.charAt(k)==s1.charAt(i)){
				isduplicate=true;
				i++;
				isMatch=true;
			}
			if(j<s2.length() && s3.charAt(k)==s2.charAt(j)){
				j++;
				if(isduplicate){
					return isInterLeaved_NotUnique(s1.substring(i-1),s2.substring(j),s3.substring(k+1))
					 || isInterLeaved_NotUnique(s1.substring(i),s2.substring(j-1),s3.substring(k+1));
				}
				isMatch=true;
			}
			k++;
			if(!isMatch)
				return false;
		}
		return true;
	}
	public int closestSubArraySum(int array[], int sum){
		//negative numbers http://stackoverflow.com/questions/5534063/zero-sum-subarray
		int stIndex=0;
		int currSum=0;
		for(int i =0;i<array.length;i++){
			currSum = currSum+array[i];
			if(currSum>sum){
				while(currSum>sum && stIndex<=i){
					currSum = currSum-array[stIndex++];
				}
			}
			if(currSum==sum){
				break;
			}
		}
		
		return stIndex;
	}
	
	
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
		
		
		{
			
			String s11="abcd";
			String s21="aefgh";
			String s31="aaefghbcd";
			
			RegExMatch match = new RegExMatch();
			System.out.println(match.isInterLeaved(s11, s21, s31));
			System.out.println(match.isInterLeaved_NotUnique(s11, s21, s31));

			System.out.println(match.closestSubArraySum(new int[]{3,12,45,1,56,223,12},46));
		}
	}
	
}
