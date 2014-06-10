public static class Node {
	List<Node> child = new ArrayList<Node>();
	int value;
}

public Node insert(Node parent, int value){
	Node newNode = new Node(value);
	parent.child.add(newNode);
}

Set<Node> visited = new HashSet<Node>();
//print route from parent to child
public void dfs(Node parent){
	if(parent==null || visited.contains(parent))
		return;

	for(Node child : parent.child){
		visited.add(child);
		dfs(child);
	}
}

//BFS - shortest path from parent

public void bfs(Node parent){

	Queue<Node> bfsQueue = new LinkedList<Node>();
	while(!bfsQueue.empty()){
		parent = bfsQueue.pop();
		for(Node child : parent.child){
			if(!visited.contains(child)){
				visited.add(child);
				bfsQueue.add(child);
			}
		}
	}
}

public static class Node {
	List<Edge> edges = new ArrayList<Edge>();
	int value;
}
public static class Edge {
	int cost;
	Node other;
}

public void DikAlgorithm(Node src, Node dest){
	Map<Node,Integer> discovered = new HashMap<Node,Integer>();
	discovered.add(src,0);

	while(!discovered.keyset().contains(dest)){
		int mincost = Integer.Max;
		Node minNode = null;
		for(Node n : discovered.keyset){
			for(Edge e : n.edges){
				if(discovered.keyset.contains(e.other)){
					continue;
				}
				int cost = discovered.get(n) + e.cost;
				if(cost<mincost)
					minNode = e.other;
			}
		}
		discovered.add(minNode);
	}
	System.out.println("MinCost ": discovered.get(dest));

}