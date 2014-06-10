//to print all paths which sum up to that value. 
//Note that it can be any path in the tree - it does not have to start at the root.
//average of lg n amount of work on each step), or we can be super mathematical:

/*There are 2^r nodes at level r.
1*2^1 + 2*2^2 + 3*2^3 + 4*2^4 + ... d * 2^d
= sum(r * 2^r, r from 0 to depth)
= 2 (d-1) * 2^d + 2
n = 2^d ==> d = lg n
NOTE: 2^lg(x) = x
O(2 (lg n - 1) * 2^(lg n) + 2) = O(2 (lg n - 1) * n ) = O(n lg n)
Following similar logic, our space complexity is O(n lg n).*/
public boolean sumofPath(Node node, List<Node> path, int sum){

	if(node==null){
		return false;
	}

	path.add(node);

	int rem = sum;
	//O(n)
	for(int i = path.size()-1; i >=0;i--){
		rem = rem - path.get(i).value;
	}
	if(rem==0){
		//result
		printPath(path);
		return true;
	}
	//nlogn algorithm
	//Does the node end at me ? nlogn algorithm
	boolean found = sumofPath(node.left, path, sum) || sumofPath(node.right, path, sum);
	path.remove(node);

	//is this algorithm o(n) or o(n^2) ??
	//Recursion tree and binary tree will be different
	//4^logn leaf nodes for n leaf binary tree
	//canditates
	//if(!found)
	//	found = sumofPath(node.left, path, sum);
	//if(!found)
	//	found = sumofPath(node.right, path, sum);
	return found;
}

public void LCA(Node m , Node n){

//o(n) solution
List<Node> pathm = pathtoNode(m);
List<Node> pathn = pathtoNode(n);

while(pathm[i].value == pathn[i].value){
	i++;
}
LCA = pathm[i-1];

//m has parent
//path - o(logn) solution
}
public boolean path(List<Node> path, Node current, Node n){
	if(n==null){
		return null;
	}
	if(current.value==n.value){
		path.add(current);
		return true;
	}
	path.add(current);
	boolean found = path(path,current.left,n);
	found = path(path,current.right,n);
	if(found)
		return true;
	else {
		path.remove(current);
		return false;
	}
}

public Collection<Node> path(Node n){

	Collection<Node> stack = new Stack<Node>();
	while(n.parent!=null){
		stack.add(n);
		n = n.parent;
	}
}