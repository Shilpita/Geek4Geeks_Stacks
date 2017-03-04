package StackQuestionFunctions;

import java.util.*;

/****************************************************************************************
 * author : Shilpita Roy
 * date   : Feb4,2017
 * purpose: Find the longest paranthesis substring .
 * 			Geek4Geeks
 * *************************************************************************************/

public class LongestParanthesisSubstring {
	
	public static int getLongestSubstring(String str){
		int count =0;
		if(str == null || str.length()==0) return count;
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0 ; i< str.length();i++){
			if(isCloseParanthesis(str.charAt(i))){
				if(!stack.isEmpty() && isMatchParanthesis(stack.peek(), str.charAt(i)))	 { 
						count =count+2;
						//System.out.println(count);
						stack.pop();
				}	
			}else if(isOpenParanthesis(str.charAt(i))){
				stack.push(str.charAt(i));
			}
		}
		
		return count;
	}
	

	private static boolean isMatchParanthesis(char b, Character a) {
		if(a==']' && b =='[')
			return true;
		else if(a=='}' && b=='{')
			return true;
		else if (a==')' && b =='(')
			return true;
		return false;
	}

	private static boolean isCloseParanthesis(char c){
		if(c == ')' || c=='}' || c==']')
			return true;
		return false;
	}
	
	private static boolean isOpenParanthesis(char c){
		if(c == '(' || c=='{' || c=='[')
			return true;
		return false;
	}

	public static void main(String[] args) {
		String str = "){((())(}))(";
        System.out.println(getLongestSubstring(str));
	}

}
