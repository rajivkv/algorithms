package dsalgo.bstree.set;

public interface IndexPQ <T>{

	public void put(int index, T key);
	
	public T get(int index);
	
	public int getMaxIndex();
	
	public T removeMax();
}
