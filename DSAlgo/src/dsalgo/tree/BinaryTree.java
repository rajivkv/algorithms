package dsalgo.tree;

import java.util.Iterator;
import java.util.LinkedList;

public class BinaryTree {

	public static class Node {
		public Node(int i) {
			data = i;
		}
		public Node left;
		public Node right;
		public int data;
	}
	
	
	public Node listToTree(Iterator<Node> listit, int st, int end){
		System.out.println(st + " " + end );
		if(st>end){
			return null;
		}
		
		int mid = st + (end-st)/2;		
		Node left = listToTree(listit,st,mid-1);
		Node current =  listit.next();
		
		System.out.println("* "+ current.data);
		current.left = left;
		current.right = listToTree(listit,mid+1,end);

		return current;
	}
	
	//inorder traversal
	public Node treeToList(Node root){
		if(root==null){
			return null;
		}
		Node left = treeToList(root.left);
		//list.add(root);
		
		Node current = root;
		Node right = treeToList(root.right);

		
		if(left!=null){
			Node ltRight = left;
			while(ltRight.right!=null){
				ltRight= left.right;
			}
			current.left = ltRight;
			ltRight.right = current;
		}

		if(right!=null){
			current.right = right;
			right.left = current;
		}
		
		return left!=null ? left:current;
	}
	
}
