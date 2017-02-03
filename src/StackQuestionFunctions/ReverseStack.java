package StackQuestionFunctions;

import java.util.*;

/****************************************************************************************
 * author : Shilpita Roy
 * date   : Jan28,2017
 * purpose: Reverse a given stack without use of other Data structure (Recursion)
 * 			Geek4Geeks
 * *************************************************************************************/

public class ReverseStack {
	private static Stack<Integer> stack;
	static int count1 =0;
	static int count2 =10;
	
	public ReverseStack(){
		stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
	}
	
	public static void printStack(){
			System.out.println(stack.toString());
	}
	
	public static void insertAtBottom(Stack<Integer> stack,int x){
		if(stack.isEmpty()){
			stack.push(x);
			return;
		}else{
			int temp = stack.pop();
			insertAtBottom(stack,x);
			stack.push(temp);
		//	System.out.println("InsertAtBottom:"+ (count1+1));
		//	printStack();
		}
	}
	
	public static void reverse(Stack<Integer> stack){
		if(stack.isEmpty()){
			return;
		}else{
			int temp = stack.pop();
			reverse(stack);
			insertAtBottom(stack,temp);
		//	System.out.println("reverse:"+ (count2+1));
		//	printStack();
		}		
	}
	
	public static void main(String[] args) {	
		ReverseStack rs = new ReverseStack();
		rs.printStack();
		rs.reverse(stack);
		rs.printStack();
	}

}
