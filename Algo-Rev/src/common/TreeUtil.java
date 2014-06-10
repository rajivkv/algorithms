package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import tree.TreeView;

public class TreeUtil {

	/**
	 * Linked List to Tree - using inorder size and values
	 * @param listit
	 * @param st
	 * @param end
	 * @return
	 */
	public Node listToTree(Iterator<Node> listit, int st, int end){
		if(st>end){
			return null;
		}
		
		int mid = st + (end-st)/2;		
		Node left = listToTree(listit,st,mid-1);
		Node current =  listit.next();
		
		current.left = left;
		current.right = listToTree(listit,mid+1,end);

		return current;
	}
	
	//Tree to Linked list
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
		while(right!=null && right.right!=null){
			right=right.right;
		}
		if(left!=null){
			left.right = right;
		}
		if(right!=null){
			right.left=left;
		}
		return left!=null ? left:current;
	}

	public Node[] findNodesAtDistanceK(Node root, Node find, int k){
		List<Node> ancesstors = new ArrayList<Node>();
		pathToRoot(root,find,ancesstors);
		ancesstors.add(find);
		List<Node> kdistList = new ArrayList<Node>();

		for(int i=0;i < ancesstors.size()-1;i++){
			int kdist = ancesstors.size() - 1-i;
			if(ancesstors.get(i).left==null || ancesstors.get(i).right==null){
				continue;
			}
			if(kdist>k){
				continue;
			}
			if(kdist==k){
				kdistList.add(ancesstors.get(i));
				continue;
			}
			boolean isLeft = ancesstors.get(i).left==ancesstors.get(i+1) ? false : true;
			if(isLeft){
				findChildAtDistanceK(ancesstors.get(i).left,k-kdist-1,kdistList);
			}else{
				findChildAtDistanceK(ancesstors.get(i).right,k-kdist-1,kdistList);
			}
		}
		findChildAtDistanceK(find,k,kdistList);

		return kdistList.toArray(new Node[]{});
	}
	
	public void findChildAtDistanceK(Node root, int k, List<Node> nodes){
		if(root==null){
			return;
		}
		if(k==0){
			nodes.add(root);
			return;
		}
		findChildAtDistanceK(root.left,k-1,nodes);
		findChildAtDistanceK(root.right,k-1,nodes);
	}
	
	public boolean pathToRoot(Node root, Node find , List<Node> ancesstor){
		if(root==null)
			return false;
		if(root==find)
			return true;

		ancesstor.add(root);
		boolean bfind = pathToRoot(root.left,find,ancesstor) || pathToRoot(root.right,find,ancesstor);
		if(!bfind)
			ancesstor.remove(root);
		return bfind;
	}
	Map<Node,Integer> cache = new HashMap<Node,Integer>();
	//longest path in tree
	int diameter(Node root){
	
		if(root==null)
			return 0;
	
		int ltHeight = height(root.left,cache);
		int rtHeight = height(root.right,cache);
		
		int ltDia = diameter(root.left);
		int rtDia = diameter(root.right);
		
		return Math.max(ltHeight+rtHeight+1, Math.max(ltDia,rtDia));
	}
	
	
	public int height(Node root, Map<Node,Integer> cache){
		if(root==null)
			return 0;
		
		if(cache.get(root)!=null){
			return cache.get(root);
		}
		
		int lt = height(root.left,cache);
		int rt = height(root.right,cache);
		
		if(cache.get(root)==null){
			cache.put(root, Math.max(lt, rt)+1);
		}
		return Math.max(lt, rt)+1;
	}
	public static void main(String[] args) {
		LinkedList<Node> list = new LinkedList<Node>();

		list.add(new Node(4));
		list.add(new Node(5));
		list.add(new Node(10));
		list.add(new Node(7));
		list.add(new Node(8));
		list.add(new Node(10));
		list.add(new Node(7));
		list.add(new Node(8));

		TreeUtil bt = new TreeUtil();
		TreeView tv = new TreeView();
		Node root = bt.listToTree(list.iterator(), 0, list.size()-1);

		tv.prettyPrint(root);
		
		Node nns[] = bt.findNodesAtDistanceK(root, root.right.right, 4);
		for(Node nn:nns){
			System.out.println(nn.data);
		}
	}
}
