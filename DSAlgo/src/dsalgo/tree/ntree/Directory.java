package dsalgo.tree.ntree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Directory {

	class Node {
		
		String value ; 
		Map<String, Node> childs = new HashMap<String, Directory.Node>();
	}
	Node root = new Node();
	{
		root.value = "ROOT";
	}
	
	
	public String[] format(String[] paths){
		for(String path : paths){
			String names[] = path.split("/");
			dfs(root,names,1);
		}
		List<String> op = new ArrayList<String>(); 
		dfsPrint(root,op,"");
		return op.toArray(new String[0]);
	}
	public static void main(String[] args) {
		String s[] =  {"/usr/lib/libc", "/usr/bin/find", "/home/schveiguy/bashrc",
 "/usr/bin/bash", "/usr/local/bin/ssh"};
	
		Directory cc = new Directory();
		String ops[] = cc.format(s);
		for(String op:ops){
			System.out.println(op);
		}
	}
	//can be substituted as iterative, similar to trie
	private void dfs(Node current, String [] names, int i){
		if(i==names.length){
			return;
		}
		Node newNode =current.childs.get(names[i]);
		if(newNode==null){
			newNode = new Node();
			newNode.value = names[i];
			current.childs.put(names[i],newNode);
		}
		
		dfs(newNode,names,i+1);
	}

	private void dfsPrint(Node current, List<String> output,String leadingChar){
		if(current==null){
			return;
		}
		StringBuffer sbf = new StringBuffer();
		sbf.append(leadingChar + "+-" + current.value);
		
		output.add(sbf.toString());
		int i =0;
		for(Node child : current.childs.values()){
			if(i==current.childs.size()-1)
				dfsPrint(child,output,leadingChar + " ");
			else
				dfsPrint(child,output,leadingChar+" ");
			i++;
		}
	}

}
