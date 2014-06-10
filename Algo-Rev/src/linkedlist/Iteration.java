package linkedlist;

import common.Node;

public class Iteration {

	//1->2->3->4
	//2->4
	public boolean pathToSum(Node list1, Node list2, int sum){
		
		
		if(list1.data==list2.data){
			return pathToSum(list2.left,list1.left,sum-list1.data)  || 
					pathToSum(list2.left,list1.left,sum-list2.data) ||
					pathToSum(list1.left,list2,sum-list1.data) || 
					pathToSum(list1,list2.left,sum-list2.data);
		}else{
			return pathToSum(list1.left,list2,sum-list1.data) || 
					pathToSum(list1,list2.left,sum-list2.data);
		}
		
	}
	
	
}
