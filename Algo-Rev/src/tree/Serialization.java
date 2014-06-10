package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import common.Node;

public class Serialization {

	
	//storing null elements
	
	Node preorder(Iterator<Integer> preorder){
		if(preorder.hasNext()){
			Integer curr = preorder.next();
			if(curr==null)
				return null;
			
			Node nn = new Node(curr);
			nn.left = preorder(preorder);
			nn.right = preorder(preorder);
			return nn;
		}
		return null;
	}
	
	public Node buildTree(List<Integer> inorder, List<Integer> levelorder){
		
		if(levelorder.isEmpty()){
			return null;
		}
		
		Node nn = new Node(levelorder.get(0));
		
		int index = inorder.indexOf(levelorder.get(0));
		
		List<Integer> ltList = new ArrayList<Integer>();
		List<Integer> rtList = new ArrayList<Integer>();
		
		for(int i=0;i<levelorder.size();i++){
			if(inorder.indexOf(levelorder.get(i)) < index){
				ltList.add(levelorder.get(i));
			}else{
				rtList.add(levelorder.get(i));
			}
		}
		nn.left=buildTree(inorder,ltList);
		nn.right = buildTree(inorder, rtList);
		return nn;
	}

	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(null);
		list.add(null);
		list.add(null);
		list.add(null);		
		Serialization ss =new Serialization();
		Node root = ss.preorder(list.iterator());
		
		TreeView tv = new TreeView();
		tv.prettyPrint(root);
	}
} 
