package dsalgo.bstree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import dsalgo.tree.BinaryTree.Node;

public class BinarySearchTree {

	Map<Node, Integer> maxMap = new HashMap<Node, Integer>();
	Map<Node, Integer> minMap = new HashMap<Node, Integer>();
	Map<Node, Integer> sizeMap = new HashMap<Node, Integer>();

	Node largest = null;

	public Node largestBSTinBT(Node root) {
		if (root == null) {
			return null;
		}

		largestBSTinBT(root.left);
		largestBSTinBT(root.right);

		int size = 1;
		int min = root.data;
		int max = root.data;
		boolean isBst = true;

		if (root.left != null) {
			isBst = maxMap.get(root.left) <= root.data ? true : false;
			if (isBst) {
				min = minMap.get(root.left);
				size += sizeMap.get(root.left);
			}
		}
		if (root.right != null) {
			isBst = minMap.get(root.right) >= root.data ? true : false;
			if (isBst) {
				max = maxMap.get(root.right);
				size += sizeMap.get(root.right);
			}
		}
		if (isBst) {
			minMap.put(root, min);
			maxMap.put(root, max);
			sizeMap.put(root, size);
		} else {
			sizeMap.put(root, 1);
			minMap.put(root, root.data);
			maxMap.put(root, root.data);
		}

		if (largest == null)
			largest = root;
		else
			largest = sizeMap.get(root) > sizeMap.get(largest) ? root : largest;

		return root;
	}

	// structure modifications to tree are allowed
	public Node largestBSTinBT1(Node root) {

		if (root == null) {
			return null;
		}

		Node ltLargest = largestBSTinBT1(root.left);
		Node rtLargest = largestBSTinBT1(root.right);

		Node nn = new Node(root.data);

		int size = 1;
		int min = root.data;
		int max = root.data;
		boolean isBst = true;

		if (ltLargest != null) {
			isBst = maxMap.get(ltLargest) <= root.data ? true : false;
			if (isBst) {
				min = minMap.get(ltLargest);
				size += sizeMap.get(ltLargest);
				nn.left = ltLargest;
			}
		}
		if (rtLargest != null) {
			isBst = minMap.get(rtLargest) >= root.data ? true : false;
			if (isBst) {
				max = maxMap.get(rtLargest);
				size += sizeMap.get(rtLargest);
				nn.right = rtLargest;
			}
		}
		minMap.put(nn, min);
		maxMap.put(nn, max);
		sizeMap.put(nn, size);

		Node largest = nn;
		if (ltLargest != null) {
			largest = sizeMap.get(ltLargest) > sizeMap.get(largest) ? ltLargest
					: largest;
		}
		if (rtLargest != null) {
			largest = sizeMap.get(rtLargest) > sizeMap.get(largest) ? rtLargest
					: largest;
		}
		return largest;
	}

	public void iterativeInorder(Node root) {
		// print pairs,// previous, me

		lastVisited = null;
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);

		Node prev = null;

		while (!stack.isEmpty()) {

			Node curr = stack.peek();

			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null) {
					stack.push(curr.left);
				} else if (curr.right != null) {
					visit(curr);
					stack.push(curr.right);
				} else {
					visit(curr);
					stack.pop();
				}
			} else if (curr.left == prev) {
				visit(curr);
				if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
				}
			} else if (curr.right == prev) {
				stack.pop();
			}

			prev = curr;
		}
	}

	Node lastVisited = null;

	private void visit(Node curr) {
		System.out.println(curr.data + " "
				+ (lastVisited != null ? lastVisited.data : null));
		lastVisited = curr;
	}
}
