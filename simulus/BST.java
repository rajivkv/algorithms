//LCA in binary search tree

static class Node {
	int value;
	Node right;
	Node left;
}

//sorted array -> BST
//Not sorted - > Balanced binary tree
aptr=0;
Node arrayToTree(int m , int n){
	if(m<n){
		return null;
	}
	Node n = new Node();
	int mid = (m + n)/2
	n.left = arrayToTree(m,mid-1);	
	//aptr is incremented exactly n times why ?
	n.value = a[aptr++];
	n.right = arrayToTree(mid+1,n);
	return n ;
}

Node LCA(Node node, int m , int n){
	if(n==null)
		return null;
	if(m<node.value &&  n< node.value){
		return LCA(node.left,m,n);
	}else if( m > node.value && n>node.value){
		return LCA(node.right,m,n);
	}else {
		return node;
	}
}

//inorder successor

public void inorderSuccessor(Node node){

	//if there are right nodes
	//smallest in the right
	smallest(node.left)!=null 

	//no right node
	//node.parent.left==node
	return node.parent;

	//find first node where node.parent.left = node
}

public void inorderpredecessor(Node node){
	largest(node.left);
	//
}

public Node floor(Node m, int n){

	if(m==null)
		return null;

	if(m.value<n){
		Node m = floor(m.right,n);
		if(m==null)
			return m;
	}else{
		return floor(node.left,n);
	}

}

public void ceiling(int n){
	if(m==null)
		return null;

	if(m.value>n){
		Node m = ceiling(m.left,n);
		if(m==null)
			return m;
	}else{
		return ceiling(node.right,n);
	}
}

public void prettyPrintBTree(Node root, int n){

	if(root==null)
		return null;



}

//Restore tree from file

//you need in-order and pre-order/post-order

-inorder is for traversal
-pre-order /post-order is for insert
public void reconstructBT(int m , int n){

	if(m<n)
		return null;
	int pos = find(inorder, preorder[ptr++]);

	Node n = new Node();
	n.value = inorder[pos];
	node.left=reconstruct(m,pos-1);
	node.right=reconstruct(pos+1,n);
}
int preOrderPtr = 0;
//postorder start from length-1 to 0
public void reconstructBST(int[] preorder, int min , int max){
	Node n = new Node(preorder[preOrderPtr]);
	preOrderPtr++;
	if(preorder[preOrderPtr] > min && preorder[preOrderPtr] <= n.value){
		n.left=reconstructBST(preorder,min,n.value);
	}
	if(preorder[preOrderPtr] > n.value && preorder[preOrderPtr] < max){
		n.right=reconstructBST(preorder,n.value,max);
	}
	return n;
}