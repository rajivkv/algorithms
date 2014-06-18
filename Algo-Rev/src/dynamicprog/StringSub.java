package dynamicprog;

public class StringSub {
	public int editDistance(String s1,String s2){
		int dt =0;
		
		int editDt[][] = new int[s1.length()+1][s2.length()+1];
		
		for(int i=0; i<editDt[0].length;i++){
			editDt[0][i] = 0;
		}
		for(int i=0; i<editDt.length;i++){
			editDt[i][0] = 0;
		}
		
		for(int i =1;i<=s1.length();i++){
			for(int j=1 ; j <=s2.length();j++){
				int cost = 1;
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					cost = editDt[i-1][j-1];
				}else{
					//replace
					cost = 1 + editDt[i-1][j-1];
					//no replacements allowed for lcs
					//make this maximum
				}
				//delete a character
				cost = Math.max(cost, 1+editDt[i-1][j]);
				//insert a character
				cost = Math.max(cost, 1+editDt[i][j-1]);
				editDt[i][j] = cost;
			}
		}
		return dt;
	}
	
	
	public int longestCommonSubString(String s1, String s2){
	
		int lcs[][] = new int[s1.length()+1][s2.length()+1];
		//longest common suffix for all prefixes
		for(int i=0;i<=s1.length();i++){
			lcs[i][0]=0;
		}
		for(int i=0;i<=s2.length();i++){
			lcs[0][i]=0;
		}

		int max = 0;
		for(int i=1;i<=s1.length();i++){
			for(int j=1;j<s2.length();j++){
				if(s1.charAt(i)==s2.charAt(j)){
					lcs[i][j]=lcs[i-1][j-1]+1;
				}else{
					lcs[i][j]= 0;
				}
				max = Math.max(max, lcs[i][j]);
			}
		}
		return max;
	}
	
}
