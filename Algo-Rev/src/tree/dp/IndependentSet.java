package tree.dp;

import common.Node;


//set contains node without interconnecting edges with them
public class IndependentSet {

	
	public int longestIndependentSet(Node root){
		if(root==null){
			return 0;
		}
		
		int sizeExRoot =  longestIndependentSet(root.left) + longestIndependentSet(root.right);
		int sizeIncRoot = 1;
		if(root.left!=null)
			sizeIncRoot = sizeIncRoot + longestIndependentSet(root.left.left) + longestIndependentSet(root.left.right);
		if(root.right!=null)
			sizeIncRoot = sizeIncRoot + longestIndependentSet(root.right.left) + longestIndependentSet(root.right.right);

		return Math.max(sizeExRoot, sizeIncRoot);
	}

}
