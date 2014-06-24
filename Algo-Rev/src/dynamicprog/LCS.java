package dynamicprog;

public class LCS {

	
	public void LCS(String s1,String s2){
		int lcs[][] = new int[s1.length()+1][s2.length()+1];
		for(int i=1;i<=s1.length();i++){
			for(int j=1;j<=s2.length();j++){
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					lcs[i][j] = lcs[i-1][j-1]+1;
				}else{
					lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
				}
			}
		}
		if(s2.length()==lcs[s1.length()][s2.length()]){
			//we found a match
			int endIndex=-1;
			int beginIndex=-1;
			
			int i=s1.length(),j=s2.length();
			int count=0;
			while(count!=s2.length()){
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					count++;
					if(count==1){
						endIndex=i;
					}
					i--;j--;
				}else{
					if(lcs[i][j-1] > lcs[i-1][j]){
						j--;
					}else{
						i--;
					}
				}
			}
			beginIndex = i+1;
			System.out.println(s1.substring(beginIndex-1,endIndex));
		}
	}
	public static void main(String[] args) {
		
		String s1 = "rajivkumar";
		String s2 = "jvma";

		new LCS().LCS(s1, s2);
	}
}
