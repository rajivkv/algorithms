package dsalgo.integer;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IndexedBitmap {
	public static void main(String[] args) {
		//System.out.println(sUniqueChars("rajiv ".toCharArray()));
		int i = 1;
		//i = ~(i << 10);
		// int j;
		//char i1 = 10;
		i = i << 31;
		i=1;
		System.out.println(i>>1);
		
	}

	public static boolean sUniqueChars(char[] str) {
		// 1 true
		// -l false

		int bitmap[] = new int[256];

		// initialize with random numbers from 1, 512
		int n = 512;
		int m = 255;
		Random randf = new Random();
		for (int i = 0; i < n; i++) {
			int rand = randf.nextInt();
			if (rand < 0) {
				rand = -rand;
			}
			if ((rand % (n - i)) < m) {
				bitmap[m] = i;
				m--;
			}
		}

		for (int i = 0; i < bitmap.length; i++) {
			System.out.print(bitmap[i] + " ");
		}
		List<Integer> items = new ArrayList<Integer>();

		// int bitmap1[] = new int[256];

		for (int i = 0; i < str.length; i++) {
			int index = str[i];
			if (bitmap[index] >= items.size()
					|| items.get(bitmap[index]) != index) {
				items.add(index);
				bitmap[index] = items.size() - 1;
			} else {
				return false;
			}

		}
		return true;
	}
}
