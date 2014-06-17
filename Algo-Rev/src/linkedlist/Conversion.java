package linkedlist;

import common.Node;

public class Conversion {

	
	public  Node treeLeavesToList(Node root){
		if(root==null)
			return null;
		
		if(root.left==null && root.right==null){
			return root;
		}
		
		Node ltLeaf = treeLeavesToList(root);
		Node rtLeaf = treeLeavesToList(root);
		
		if(ltLeaf!=null){
			while(ltLeaf.left!=null){
				ltLeaf = ltLeaf.left;
			}
			ltLeaf.left = rtLeaf;
			return ltLeaf;
		}else{
			return rtLeaf;
		}
	}
}
