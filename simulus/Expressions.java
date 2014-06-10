
//3+4*3 = 34+3*
//3+(4*3) 343*+
public void eval(String expression){
	String posExpr = toPostfix(expression);
	evalpostfix(posExpr);

}
int pos = 0;
public String toPostfix(String expression){

	List<String> operators = new ArrayList<String>();
	List<String> operands = new ArrayList<String>();

	while(pos < expression.length()){

		char ch = expression.charAt(pos++);

		switch(ch){
			case '(':
				String posExpr = toPostfix(expression,pos);
				operands.add(posExpr);
				break;
			case ')':
				return toexpr(operators,operands);
				break;
			case '*':
			case '+':
			case '-':
			case '/':
				operators.add(ch);
				break;
			default :
				operands.add(ch);
		}
			return toexpr(operators,operands);
	}
}


public String toexpr(List<operators operators, List operands){
	//operands.size = 2 * operator.size
	StringBuffer sbr = new StringBuffer();
	int i = 0;
	for(String operator : operators){
		sbr.append(operands.get(i)).append(get(i+1)).append(operator);
	}
}

public int evalpostfix(String expression){
	Stack operands = new Stack();

	for(int i=expression.length-1; i > 0;i++){

		char ch = expression.charAt(i);

		switch(ch){
			case '*':
			case '+':
			case '-':
			case '/':
				int op1 = operands.pop();
				int op2 = operands.pop();
				int op3= evaluate(op1,op2,ch);
				operands.push(op3);
			default :
				operands.push(ch);
		}
	}
	return operands.pop();
}
