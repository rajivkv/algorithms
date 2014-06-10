package tree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import common.Node;
import common.TreeUtil;

public class Expressions {

	public String infixToPostFix(String infix){
		String postfix = null;
		
		
		return postfix;
	}
	
	//convert infix to postfix
	// - using recursion
	// - using stack
	
	public String infixToPostfix(String infix){
		return infix;
	}

	public int evaluate(String postfix){
		return 0;
	}
	
	public Node expTreefromPre(String str){
		return null;
	}
	
	
	public Node expTreeFromPost(String str){
		return null;
	}
	int infixPtr= 0;
	//2+3+5
	public Node expTreefromInfix(Iterator<String> operators, Iterator<String> operands){
		Node prev = null;
		while (operators.hasNext()){
			String op = operators.next();
			if(op.endsWith(")")){
				break;
			}
			if(op.endsWith("(")){
				Node n1 = new Node(op);
				n1.left= prev==null ? new Node(operands.next()) : prev;
				n1.right =expTreefromInfix(operators, operands);
				prev=n1;
			}else{
				Node n1 = new Node(op);
				n1.left = prev==null ? new Node(operands.next()) : prev;
				n1.right = new Node(operands.next());
				prev=n1;
			}
		}
		return prev;
	}
	//3+(4*5-7)
	public static void main(String[] args) {
		
		Expressions expr = new Expressions();
		Node root = expr.expTreefromInfix(Arrays.asList("+(","*(","-",")",")").iterator(),Arrays.asList("3","4","5","7").iterator());
		
		TreeView util = new TreeView();
		util.prettyPrint(root);
	}
}
