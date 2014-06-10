package dsalgo.bstree.set;

/*
 BST :- Node + size
	contain(Node)
	rank[Node], Node[rank]
	Nodes[rank1-rank2]
	lo < Nodes < hi
	floor(Node), Ceiling(Node)
 
 */
public interface OrderedSet<T> {

	public void put(T key);
	
	public int rank(T key);
	
	public boolean contains(T key);
	
	public T select(int rank);
	
	public T[] keys();
	
	public T[] keys(int lo,int hi);

	public T[] keys(T lo, T hi);
	
	//(key-1)find the predecessor
	public T floor(T key);
	
	//(key+1)find the successor
	public T ceiling(T key);
}
