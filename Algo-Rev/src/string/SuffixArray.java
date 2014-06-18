package string;

import java.util.Arrays;
import java.util.Comparator;

public class SuffixArray {

	public static class Suffix{
		public Suffix(int i, String substring) {
			position = i;
			suffix = substring;
		}
		public int position;
		public String suffix;
		@Override
		public String toString() {
			return suffix;
		}
	}
	
	Suffix[] suffixes = null;
	int [] lcpSuffixes = null;
	public SuffixArray(String str){
		
		suffixes = new Suffix[str.length()];
		
		for(int i=0; i < str.length();i++){
			suffixes[i] = new Suffix(i,str.substring(i));
		}
		Arrays.sort(suffixes, new Comparator<Suffix>() {

			@Override
			public int compare(Suffix o1, Suffix o2) {
				return o1.suffix.compareTo(o2.suffix);
			}
		});
		lcpSuffixes = lcp();
	}
	
	int[] lcp(){
		int lcp[] = new int[suffixes.length-1];
		for(int i=0;i<lcp.length;i++){
			lcp[i]=commonStr(i,i+1);
			
		}
		return lcp;
	}
	private int commonStr(int i, int j) {

		String s1 = suffixes[i].suffix;
		String s2 = suffixes[j].suffix;
		int si1 = 0;
		int si2 = 0;
		int cnt = 0;
		while(si1<s1.length() && si2<s2.length()){
			if(s1.charAt(si1++) == s2.charAt(si2++)){
				cnt++;
			}else{
				break;
			}
		}
		return cnt;
	}

	public int lcp(int i , int j){
		int min = Integer.MAX_VALUE;
		for(int cnt = i ; cnt<j; cnt++){
			min = Math.min(min, lcpSuffixes[cnt]);
		}
		return min;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Suffix[] getSuffixes() {
		return suffixes;
	}

	public int[] getLcpSuffixes() {
		return lcpSuffixes;
	}

}
