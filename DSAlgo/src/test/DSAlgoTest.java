package test;

import java.util.Arrays;
import java.util.LinkedList;

import org.testng.annotations.Test;

import dsalgo.bstree.BinarySearchTree;
import dsalgo.integer.BitMap;
import dsalgo.integer.SlidingWindow;
import dsalgo.string.SuffixArray;
import dsalgo.tree.BinaryTree;
import dsalgo.tree.BinaryTree.Node;
import dsalgo.tree.Heap;

public class DSAlgoTest {
	@Test
	public void testBitMap() {

		BitMap bm =  new BitMap(256);
		System.out.println(bm.test(201));
		System.out.println(bm.test(20));
		for(int i = 0 ; i < 256 ; i++){
			if(i%2==0)
				bm.set(i);
		}
		System.out.println(bm.test(201));
		System.out.println(bm.test(20));
		System.out.println(bm.parity(1));
		bm.set(33);
		System.out.println(bm.parity(1));  
	}
	
	@Test
	public void testTree(){
		BinaryTree bt = new BinaryTree();
		LinkedList<Node> list = new LinkedList<Node>();

		list.add(new Node(4));
		list.add(new Node(5));
		list.add(new Node(10));
		list.add(new Node(7));
		list.add(new Node(8));

		Node root = bt.listToTree(list.iterator(), 0, list.size()-1);
		BinarySearchTree bst = new BinarySearchTree();

		System.out.println(root.data);
		System.out.println(root.left.data);
		System.out.println(root.right.data);
	
		System.out.println(root.left.left);
		System.out.println(root.left.right.data);
		
		System.out.println(root.right.left);
		System.out.println(root.right.right.data);

		
		root = bst.largestBSTinBT(root);
		System.out.println("***BST***");
		System.out.println(root.data);
		System.out.println(root.left);
		System.out.println(root.right.data);
		
		Node curr = bt.treeToList(root);

		while(curr!=null){
			System.out.println(curr.data);
			curr = curr.right;
		}
	}

	@Test
	public void testBSTree(){
		BinaryTree bt = new BinaryTree();
		LinkedList<Node> list = new LinkedList<Node>();

		list.add(new Node(4));
		list.add(new Node(5));
		list.add(new Node(10));
		list.add(new Node(7));
		list.add(new Node(8));
		
		Node root = bt.listToTree(list.iterator(), 0, list.size()-1);
		BinarySearchTree bst = new BinarySearchTree();

		System.out.println(root.data);
		System.out.println(root.left.data);
		System.out.println(root.right.data);
	
		System.out.println(root.left.left);
		System.out.println(root.left.right.data);
		
		System.out.println(root.right.left);
		System.out.println(root.right.right.data);
		System.out.println("***BST***");

		bst.iterativeInorder(root);

		root = bst.largestBSTinBT1(root);
		System.out.println("***BST***");

		bst.iterativeInorder(root);


	}
	@Test
	public void testSuffixArray(){
		SuffixArray suffixArray = new SuffixArray();
		String str[] = suffixArray.suffixArray("palindromemem");
		System.out.println(Arrays.asList(str));
		System.out.println(Arrays.asList(suffixArray.indexArr));

		System.out.println(suffixArray.search(str, "eme"));
	}
	
	@Test
	public void slidingWindow(){
		SlidingWindow sld = new SlidingWindow();
		int a[] = {3,2,4,1,6,7,8,9,10,-1,3};
		int b[] = sld.slidingWindow(a, 3);
		for(int i=0;i<b.length;i++){
			System.out.println(b[i]);
		}
	}
	
	@Test
	public void testHeap(){
		Heap heap = new Heap();
		
		int[] input = {10,32,45,2,3,50};
		
		int[] heap1 = heap.buildHeap(input);
		int[] tournament = heap.buildTournamentTree(input);
		
		for(int i=0;i<heap1.length;i++)
			System.out.print(heap1[i] + " ");
		System.out.println();
		for(int i=0;i<tournament.length;i++)
			System.out.print(tournament[i] + " ");
		System.out.println(heap.getTournMin(tournament, input));
		System.out.println(heap.getTournMin(tournament, input));

		System.out.println(heap.getTournMin(tournament, input));
		for(int i=0;i<tournament.length;i++)
			System.out.print(tournament[i] + " ");
	}
}
