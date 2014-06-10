package dsalgo.tree;

public class Heap {

  public int[] buildHeap(int[] input) {
    int heap[] = new int[input.length + 1];

    for (int i = 1; i < heap.length; i++)
      heap[i] = input[i - 1];

    for (int i = heap.length / 2 -1; i >= 1; i--) {
      int max = 2 * i;
      
      if ((2 * i + 1) < heap.length) {
        max = heap[2 * i + 1] > heap[2 * i] ? (2 * i + 1) : 2 * i;
      }
      if (heap[i] < heap[max]) {
        int t = heap[i];
        heap[i] = heap[max];
        heap[max] = t;
      }

    }
    return heap;
  }

  public int[] buildTournamentTree(int[] input) {
    int[] tournament = new int[input.length + input.length];
    int i = tournament.length - 1;
    for (int j = input.length - 1; j >= 0; j--) {
      tournament[i] = j;
      i--;
    }
    for (int j = i; j >= 1; j--) {

      int min = 2 * j;
      if ((2 * j + 1) < tournament.length) {
        min = input[tournament[2 * j + 1]] < input[tournament[2 * j]] ? (2 * j + 1)
            : 2 * j;
      }
      tournament[j] = tournament[min];
    }
    return tournament;
  }

  public int getTournMin(int[] tournament, int[] input) {

    int minRet = tournament[1] < input.length ? input[tournament[1]] : -1;

    input[tournament[1]] = Integer.MAX_VALUE;

    int tindex = input.length + tournament[1];
    int parent = tindex / 2;
    while (true) {
      int min = 2 * parent;
      if ((2 * parent + 1) < tournament.length) {
        min = input[tournament[2 * parent + 1]] < input[tournament[2 * parent]] ? (2 * parent + 1)
            : (2 * parent);
      }

      tournament[parent] = tournament[min];
      if (parent == 1) {
        break;
      }
      parent = parent / 2;
    }
    return minRet;
  }

}
