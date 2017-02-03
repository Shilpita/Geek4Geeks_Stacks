package StackQuestionFunctions;

import java.util.*;

/****************************************************************************************
 * author : Shilpita Roy
 * date   : Feb 2,2017
 * purpose: Evaluate a given prefix expression using a stack
 * 			Geek4Geeks
 * *************************************************************************************/


public class EvaluatePrefix {
	
	public static int evaluateExpression(String str){
		if(str == null || str.length() == 0) return 0;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i =str.length()-1 ; i>= 0; i--){
			if(str.charAt(i) != ' '  && str.charAt(i) !=','){
			  if(isOperator(str.charAt(i))){
				  int a = stack.pop();
				  int b = stack.pop();
				  int res = computeOperation(str.charAt(i),a,b);
				  System.out.println(res);
				  stack.push(res);
			  }else if (isOperand(str.charAt(i))){
				  String operand = "";
				  while(i >=0 && isOperand(str.charAt(i))){
					  operand = str.charAt(i)+operand;
					  i--;
				  }
				  System.out.println(operand);
				  stack.push(Integer.parseInt(operand));
			  }
			}
		}
		return stack.pop();	
	}

	
	private static boolean isOperand(char x) {
		if(x >= '0' && x <= '9')
			return true;
		return false;
	}

	private static boolean isOperator(char c) {
		if(c == '*' || c == '+' || c=='-'||c=='/')
			return true;
		return false;
	}
	
	private static int computeOperation(char c, int a, int b) {
		if(c == '+')
			return a+b;
		else if(c =='-')
			return a-b;
		else if(c == '*')
			return a*b;
		else if(c == '/')
			return a/b;
		else return 0;
	}

	public static void main(String[] args) {
		String str = "+ + * 4 5 * 4 8 / 10 2";
		System.out.println("String entered : "+ str);
		System.out.println("Evaluated Result : "+ evaluateExpression(str));
	}

}
