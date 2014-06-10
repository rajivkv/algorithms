package dsalgo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuffixArray {

	
	public String[] suffixArray(String str){
		List<String> suffixArr = new ArrayList<String>();
		for(int i = 0 ; i < str.length() ; i++){
			suffixArr.add(str.substring(i));
		}
		indexArr=new Integer[str.length()];
		
		for(int i =0;i < indexArr.length;i++){
			indexArr[i]=i;
		}
		return sort(suffixArr.toArray(new String[]{}));
	}

	public String[] sort(String[] array) {
		sort(array,0,array.length-1,0);
		return array;
	}
	public String search(String[] array, String query){
		
		int m=0, n = array.length - 1;
		//first element which is greater
		while(m<n){
			int mid = m + (n-m)/2;
			int cmp = compare(array[mid],query);

			if(cmp<0){
				m = mid+1;
			}else if(cmp>=0){
				n = mid;
			}
			
		}
		return array[m];
		
	}
	
	
	private int compare(String string, String query) {

		int cnt = Math.min(string.length(), query.length());
		
		for(int i=0; i <cnt;i++){
			
			if(string.charAt(i)<query.charAt(i)){
				return -1;
			}
			
			if(string.charAt(i)>query.charAt(i)){
				return 1;
			}
		}
		return string.length() - query.length();
	}

	public int[] LCS(String[] suffixArray){
		int lcs[] = new int[suffixArray.length-1];
		
		for(int i=0; i<suffixArray.length-1;i++){
			lcs[i] = lcs(suffixArray[i],suffixArray[i+1]);
		}
		return lcs;
	}
	private int lcs(String string, String string2) {
		int i = 0;
		if(string.charAt(i)==string2.charAt(i)){
			i++;
		}
		return i;
	}

	public Integer[] indexArr ;
	public Integer[] sort(String[] array, int start, int end, int index){
		
		if(end<=start)
			return indexArr;

		//use count sort
		int[] cnt = new int[256];
		
		for(int i=start; i<=end;i++){
			cnt[charat(array[i],index)]++;
		}
		
		//convert cnt to index
		int runcnt = 0;
		for(int i=0;i<cnt.length;i++){
			int no = cnt[i];
			cnt[i] = runcnt;
			runcnt = runcnt + no;
		}
		String temp[] = new String[end-start+1];
		List<Integer> indexArrCp = new ArrayList<Integer>(Arrays.asList(indexArr));
		for(int i=start;i<=end;i++){
			temp[cnt[charat(array[i],index)]] = array[i]; 
			indexArr[start + cnt[charat(array[i],index)]] = indexArrCp.get(i);
			cnt[charat(array[i],index)]++;
		}
		for(int i=0; i<temp.length;i++){
			array[start+i] = temp[i];
		}
		
		runcnt=start;
		for(int i = 0 ; i < cnt.length; i++){
			sort(array,runcnt,start+cnt[i]-1,index+1);
			runcnt=start+cnt[i];
		}
		return indexArr;
	}
	
	private int charat(String string, int pos) {
		if(pos>=string.length())
			return 0;
		return string.charAt(pos);
	}
	
	
	public String longestCommonSubString(String s1, String s2){
		return null;
	}
	
	public String longestPalindrome(String s1){
		return null;
	}
}
