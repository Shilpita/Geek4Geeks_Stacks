package StackQuestionFunctions;
/****************************************************************************************
 * author : Shilpita Roy
 * date   : Feb 2,2017
 * purpose: Convert Infix to Postfix expression
 * 			Geek4Geeks
 * *************************************************************************************/

import java.util.*;

public class InfixToPrefix {
	public static HashMap<Character, Integer> precedenceMap ;
	public InfixToPrefix(){
		precedenceMap= new HashMap<Character, Integer>();
		precedenceMap.put('/', 1);
		precedenceMap.put('*' ,2);
		precedenceMap.put('+', 3);
		precedenceMap.put('-', 4);
	}
	
	public static String createPostFix(String str){
		if(str == null || str.length() == 0)
			return str;
		Stack<Character> stack = new Stack<Character>();
		String postfix ="";
		for(int i = 0; i< str.length();i++){
			if(str.charAt(i) != ' ' || str.charAt(i)!= ','){
				if(isOperand(str.charAt(i))){
					while(i < str.length() && isOperand(str.charAt(i))){
						postfix = postfix +str.charAt(i);
						i++;
					}
					
					postfix = postfix +' ';
				}else if(isOperator(str.charAt(i))){
					if(stack.isEmpty())
						stack.push(str.charAt(i));
					else{
						
						while(!stack.isEmpty() && isPrecedent(str.charAt(i), stack.peek()))
							postfix = postfix + stack.pop() + ' ';
						
						stack.push(str.charAt(i));
					}
				}		
			}
		}
		
		while(!stack.isEmpty())
			postfix = postfix + stack.pop() + ' ';
		
		return postfix;
	}
	
	private static boolean isPrecedent(char op1 , char op2){
		if(precedenceMap.get(op1) >= precedenceMap.get(op2))
			 return true ;
		return false;
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

	public static void main(String[] args) {
		InfixToPrefix ip = new InfixToPrefix();
		String str = "2 * 13 + 24 / 2 + 5";
        System.out.println("Enter Infix expression : "+ str);
        System.out.println("Postfix expression : "+ createPostFix(str));
		
	}

}
