
public class StringSort {

	private String s[];
	
	public void sort(int lo, int hi, int pos){
		if(lo>=hi)
			return;
		
		int lookup[] = new int[128];
		for(int i =lo; i<=hi;i++){
			lookup[charat(s[i],pos)]++;
		}
		//start index
		int index = 0;
		for(int i=0 ; i < lookup.length;i++){
			int cnt = lookup[i];
			lookup[i]=index;
			index= index+cnt;
		}
		String strTemp[] = new String[hi-lo+1];
		for(int i =0; i<strTemp.length;i++){
			strTemp[lookup[charat(s[lo+i],pos)]++]=s[lo+i];
		}
		//lookup has endindex-1
		for(int i =0; i<strTemp.length;i++){
			s[lo+i]=strTemp[i];
		}
		index=lo;
		for(int i=0 ; i < lookup.length;i++){
			sort(index,lo+lookup[i]-1,pos+1);
			index=index+lookup[i];
		}
	}

	private int charat(String string, int pos) {
		if(string.length()==pos)
			return 0;
		return string.charAt(pos);
	}
	
	public static void main(String[] args) {
		
		StringSort tt = new StringSort();
		tt.s=new String[]{"z","zabc","adv","ad","ggd","a"};

		tt.sort(0, tt.s.length-1, 0);
		
		for(int i=0;i<tt.s.length;i++)
			System.out.println(tt.s[i]);
	}
}
