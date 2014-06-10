package dsalgo.integer;

public class BitMap {

	int [] bitmap;
	public BitMap(int size){
		bitmap = new int[size/32 + 1];
	}
	
	public void set(int i){
		int idx = i / 32;
		int offset = i % 32;
		
		bitmap[idx] = bitmap[idx] | (1<<offset);
	}
	
	public void unset(int i){
		int idx = i / 32;
		int offset = i % 32;		
		bitmap[idx] = bitmap[idx] & ~(1<<offset);
	}
	
	public int parity(int index){
		int n = bitmap[index];
		int x = 0;
		while(n!=0){
			x = x ^ n%2; 
			//x = x ^ (x&1);
			n = n >>> 1;
		}
		return x;
	}

	public int test(int i){
		int idx = i / 32;
		int offset = i % 32;
		return  bitmap[idx] & (1<<offset);
	}
}
