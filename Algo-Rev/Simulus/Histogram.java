//min queue
//min stack


Queue<Integer> queue = new LinkedList<Integer>();
Queue<Integer> minqueue = new LinkedList<Integer>();

public void insert(int n){
	queue.insert(n);
	int n1 = minqueue.peek();
	if(n>n1){
		minqueue.insert(n);
	}else{
		while(n<n1){
			n1 = minqueue.pop();
		}
		minqueue.insert(n);
	}
}
public int pop(){
	int n1 = queue.pop();
	int min = minqueue.peek();
	if(min==n1)
		minqueue.pop();
	return n1;
}

public int min(){
	return minqueue.peek();
}




Stack<Integer> stack = new Stack<Integer>();
Stack<Integer> minstack = new Stack<Integer>();

public void insert(int n){
	stack.insert(n);
	int n1 = stack.peek();
	if(n<n1){
		stack.insert(n);
	}
}
public int pop(){
	int n1 = stack.pop();
	int min = minstack.peek();
	if(min==n1)
		minstack.pop();
	return n1;
}

public int min(){
	return minstack.peek();
}
