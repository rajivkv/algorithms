package dsalgo.tree;

import java.util.Stack;
public class Expressions {

	//evaluate postfix
	//prefix to post fix -> tree

	
	//stack based solution
	//construct a binary tree using post-order traversal
	int computePost(String expression){
		Stack<Integer> operands = new Stack<Integer>();
		for(char c : expression.toCharArray()){
			switch(c){
				case '+':
					{
					int p2 = operands.pop();
					int p1 = operands.pop();
					operands.push(p1+p2);
				
					break;
					}
				case '-':
					{
					int p2 = operands.pop();
					int p1 = operands.pop();
					operands.push(p1-p2);
					}
					break;
				case '*':
					{
					int p2 = operands.pop();
					int p1 = operands.pop();
					operands.push(p1*p2);
					}
					break;
				case '/':
					{
					int p2 = operands.pop();
					int p1 = operands.pop();
					operands.push(p1/p2);
					}
					break;
				default:
					if(c>='0' && c<='9'){
						operands.push(c-'0');
					}
			}
		}
		return operands.pop();
	}

	//for prefix - push the operators into stack, whenever two numbers are found, pop the stack to evalutate it
	
	//construct a tree from post-fix and reduce the tree
	static class Node{
		Node left;
		Node right;
		char c;
		
		Node(char c){
			this.c=c;
		}
	}
	//construct a binary tree using post-order traversal for postfix and preorder tree traversal for prefix
	Node createPostTree(String expression){
		Stack<Node> operands = new Stack<Node>();
		for(char c : expression.toCharArray()){
			switch(c){
				case '+':
				case '-':
				case '*':
				case '/':					
					{
						Node p2 = operands.pop();
						Node p1 = operands.pop();
						Node p = new Node(c);
						p.left = p1;
						p.left = p2;
						operands.push(p);
				
					break;
					}
				default:
					if(c>='0' && c<='9'){
						operands.push(new Node(c));
					}
			}
		}
		return operands.pop();
	}

	static int pre=0;
	//construct a binary tree using post-order traversal for postfix and preorder tree traversal for prefix
	Node createPreeTree(String expression){
			char c = expression.charAt(pre++);
			switch(c){
				case '+':
				case '-':
				case '*':
				case '/':					
					{
						Node p = new Node(c);
						p.left = createPreeTree(expression);
						p.right = createPreeTree(expression);
						return p;
					}
				default:
					if(c>='0' && c<='9'){
						Node p = new Node(c);
						return p;
					}
			}
			return null;
	}

	
	String infixToPostFix(){
		
		String infix="(2*9)+3+(4+(7*3))";
		StringBuffer str = new StringBuffer();
		Stack<Character> operand = new Stack<Character>();
		Stack<Node> vals = new Stack<Node>();
		for(char c:infix.toCharArray()){
			
			if((c-'0')>=0 && (c-'0')<=9){
				str.append(c);
				vals.push(new Node(c));
			}else if(c==')'){
				while(operand.peek()!='('){
					char ch=operand.pop();
					str.append(ch);
					Node rt = vals.pop();
					Node lt = vals.pop();
					Node curr = new Node(ch);
					curr.left = lt; curr.right = rt;
					vals.push(curr);
				}
				operand.pop();
			}else if(c=='('){
				operand.push(c);			
			}else{
				while(!operand.isEmpty() && operand.peek()!='('){
					char ch=operand.pop();
					str.append(ch);
					Node rt = vals.pop();
					Node lt = vals.pop();
					Node curr = new Node(ch);
					curr.left = lt; curr.right = rt;
					vals.push(curr);					
				}
				operand.push(c);
			}
		}
		while(!operand.isEmpty()){
			char ch=operand.pop();
			str.append(ch);
			Node rt = vals.pop();
			Node lt = vals.pop();
			Node curr = new Node(ch);
			curr.left = lt; curr.right = rt;
			vals.push(curr);	
		}
		traverse(vals.pop());
		System.out.println();
		return str.toString();
	}
	void traverse(Node t){
		if(t==null)
			return;
		traverse(t.left);
		System.out.print(t.c + " ");
		traverse(t.right);
	}
	
	public static void main(String[] args) {
		Expressions ee = new Expressions();
		System.out.println(ee.infixToPostFix());
		ee.traverse(ee.createPreeTree("+*234"));
	}
}
