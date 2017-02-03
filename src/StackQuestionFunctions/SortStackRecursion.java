package StackQuestionFunctions;
/************************************************************************************************************************************
 * author : Shilpita Roy
 * date   : Jan28,2017
 * purpose: Sort a given stack without use of other Data structure (Recursion)
 * 			TIME COMPLEXITY : O(N*N). BETTER METHOD USEING TEMP STACK WITH O(N) TIME COMPLEXITY O(N) SPACE COMPLEXITY
 * 			Geek4Geeks
 * *********************************************************************************************************************************/

import java.util.Stack;

public class SortStackRecursion {
	private static Stack<Integer> stack;
	public SortStackRecursion(){
		stack = new Stack<Integer>();
		stack.push(11);
		stack.push(2);
		stack.push(13);
		stack.push(4);
	}
	
	public static void printStack(){
		System.out.println(stack.toString());
	}
	
	public static void sort(Stack<Integer> stack){
		if(stack.isEmpty())
			return;
		else{
			int temp = stack.pop();
			sort(stack);
			sortedInsertion(stack,temp);
		}
	}
	
	private static void sortedInsertion(Stack<Integer> stack2, int x) {
		if(stack.isEmpty() || stack.peek() >= x){
			stack.push(x);
		}else{
			int temp = stack.pop();
			sortedInsertion(stack,x);
			stack.push(temp);
		}
		
	}

	public static void main(String[] args) {
		SortStackRecursion ss = new SortStackRecursion();
		ss.printStack();
		ss.sort(stack);
		ss.printStack();
	}

}
