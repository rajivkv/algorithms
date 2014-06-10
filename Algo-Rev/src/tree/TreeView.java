package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import common.Node;
import common.TreeUtil;

public class TreeView {
	public void prettyPrint(Node root){
		List<List<Node>> levels= new ArrayList<List<Node>>();
		
		List<Node> level0 = new ArrayList<Node>();
		level0.add(root);
		levels.add(level0);
		
		List<Node> prevLevel = level0;
		boolean traverse = true;
		
		while(traverse){
			List<Node> nextLevel = new ArrayList<Node>();
			Iterator<Node> prevIt = prevLevel.iterator();
			traverse = false;
			while(prevIt.hasNext()){
				Node node = (Node)prevIt.next();
				if(node!=null){
					traverse=true;
					nextLevel.add(node.left);
					nextLevel.add(node.right);
				}else{
					nextLevel.add(null);
					nextLevel.add(null);
				}
			}
			if(traverse)
				levels.add(nextLevel);
			prevLevel = nextLevel;
		}
		
		int gridSize = levels.get(levels.size()-2).size();
		int grid[][] =new int[levels.size()][2*gridSize];
//		int offset = 0;
		int increment = 2;
		for(int i =levels.size()-2 ; i>=0; i--){
			Iterator<Node> levelit = levels.get(i).iterator();
//			int j = (int) (Math.pow(2, offset)-1);
			//width of tree in prev level
			int j = increment/2 - 1;
			
			System.out.println(levels.get(i).size());
			while(levelit.hasNext()){
				Node node = (Node)levelit.next();
				grid[i][j] = node!=null ? node.data : 0;
				j = j + increment;
			}
			increment = increment *2;
			//offset = offset + 1;

		}
		
		for(int i=0; i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				if(grid[i][j]==0)
					System.out.print(" ");
				else
					System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
	
	
	//traverse through first node in a level
	public void leftView(Node root){
		if(root==null){
			return;
		}
		System.out.println(root.data);
		if(root.left!=null){
			leftView(root.left);
		}else{
			leftView(root.right);
		}
	}
	
	
	public void rightView(Node root){
		if(root==null){
			return;
		}
		if(root.right!=null){
			rightView(root.right);
		}else{
			rightView(root.left);
		}
		System.out.println(root.data);
	}
	
	
	public void leaf(Node root){
		if(root==null){
			return;
		}
		if(root.right==null && root.left==null){
			System.out.println(root.data);
			return;
		}else{
			leaf(root.left);
			leaf(root.right);
		}
			
	}
	
	
	public void outer(Node root){
		leftView(root);
		leaf(root);
		rightView(root);
	}
	
	
	public static void main(String[] args) {
		LinkedList<Node> list = new LinkedList<Node>();

		list.add(new Node(4));
		list.add(new Node(5));
		list.add(new Node(10));
		list.add(new Node(7));
		list.add(new Node(8));

		TreeUtil bt = new TreeUtil();
		TreeView tv = new TreeView();
		Node root = bt.listToTree(list.iterator(), 0, list.size()-1);

		tv.prettyPrint(root);
		
		tv.leftView(root);
		System.out.println();
		tv.leaf(root);
		System.out.println();
		tv.rightView(root);
	}
}
