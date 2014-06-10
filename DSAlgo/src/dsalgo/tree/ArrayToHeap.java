package dsalgo.tree;

public class ArrayToHeap<T extends Comparable<T>> {

	// Max Heap
	public T array[];

	public ArrayToHeap(T[] array){
		this.array = array;
		buildHeap();
	}

	// build heap in O(n) time :-
	public void buildHeap() {
		for (int i = array.length / 2; i >= 1; i--) {
			shiftDown(i);
		}
	}

	public void shiftDown(int i) {
		int t = i;
		while (2 * t < array.length) {
			int max = 2 * t;
			max = (2 * t + 1) < array.length && array[2 * t + 1] .compareTo(array[2 * t]) > 0 ? 2 * t + 1
					: 2 * t;

			if (array[t].compareTo(array[max]) > 0) {
				break;
			} else {
				T temp = array[max];
				array[max] = array[t];
				array[t] = temp;
				t = max;
			}
		}
	}

	
	public static ArrayToHeap<Integer> getIntHeap(){
		Integer intArray[] = new Integer[101];
		for (int i = 0; i <= 100; i++) {
			intArray[i] = i;
		}
		ArrayToHeap<Integer> intHeap = new ArrayToHeap<Integer>(intArray);
		return intHeap;
	}
}
