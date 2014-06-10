package dsalgo.tree.ntree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nary {

	public static class Node implements Comparable<Node>{
		
		Node child;
		Node sibling;
		Integer value;
		
		public Node[] getChildren(){
			List<Node> children = new ArrayList<Node>();
			Node current = this.child;
			while(current!=null){
				children.add(current);
				current=current.sibling;
			}
			return children.toArray(new Node[0]);
		}

		@Override
		public int compareTo(Node o) {
			return value.compareTo(o.value);
		}
	}
	
	
	public void sortChildren(Node parent){
		if(parent==null)
			return;
		Node sortedChild[] = parent.getChildren(); 
		Arrays.sort(sortedChild);
		for(int i=0; i < sortedChild.length;i++){
			sortedChild[i].sibling = (i+1) <sortedChild.length ? sortedChild[i+1]:null; 
			sortChildren(sortedChild[i]);
		}
		parent.child = sortedChild.length > 0 ?  sortedChild[0] : null;
	}
	
	public void preorder(Node current,int level){
		
		if(current==null){
			return;
		}
		for(int i=0;i<level;i++)
			System.out.print(" ");
		System.out.println(current.value);
		preorder(current.child,level+1);
		preorder(current.sibling,level);
	}
	public void levelorder(Node current,int level){
		
		if(current==null){
			return;
		}
		for(int i=0;i<level;i++)
			System.out.print(" ");
		System.out.println(current.value);
		levelorder(current.sibling,level);
		levelorder(current.child,level+1);
	}

	public int max(Node current){
		
		if(current==null){
			return Integer.MIN_VALUE;
		}
		
		int sibMax = max(current.sibling);
		int childMax = max(current.child);
		
		return Math.max(current.value, Math.max(sibMax,childMax));
	}
	public int sum(Node current){
		
		if(current==null){
			return 0;
		}
		
		int sibSum = sum(current.sibling);
		int childSum = sum(current.child);
		
		return current.value+ sibSum + childSum;
	}
	public void insertChild(Node parent,int value){
		parent.child = new Node();
		parent.child.value = value;
		Node current = parent.child;
		for(int i=1;i < 10;i++){
			current.sibling = new Node();
			current.sibling.value = (value-i);
			current = current.sibling;
		}
	}

	public static class Link{
		Link n;
		int val;
	}
	
	Link getListBeginWithMe(Node parent){
		
		if(parent==null)
			return null;
		
		Link ll = new Link();
		ll.val = parent.value;
		Link sibling = getListBeginWithMe(parent.sibling);
		Link children = getListBeginWithMe(parent.child);
		ll.n = sibling;
		
		Link prev = ll;
		Link traverse = ll.n;
		while(traverse!=null){
			prev=traverse;
			traverse=traverse.n;
		}
		prev.n = children;
		return ll;
	}
	
	
	Node root = null;
	public static void main(String[] args) {
		Nary ary = new Nary();
		ary.root = new Node();
		ary.root.value = 0;
		ary.insertChild(ary.root,100);
		ary.insertChild(ary.root.child.sibling,110);
		ary.insertChild(ary.root.child.sibling.child.sibling,120);
		ary.sortChildren(ary.root);
		ary.preorder(ary.root,0);
		ary.levelorder(ary.root,0);
		System.out.println(ary.max(ary.root));
		System.out.println(ary.sum(ary.root));
		
		Link op = ary.getListBeginWithMe(ary.root);
		while(op!=null){
			System.out.print(op.val +" ");
			op=op.n;
		}
		
	}

}
