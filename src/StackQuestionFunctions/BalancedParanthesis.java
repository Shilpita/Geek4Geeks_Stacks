package StackQuestionFunctions;
/**************************************************************************
 * author : Shilpita Roy
 * date   : Jan28,2017
 * purpose: Validate if given string has balanced parenthesis using stack.
 * 			Geek4Geeks
 * *****************************************************************************/
import java.util.*;

public class BalancedParanthesis {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		
		System.out.println("Paranthesis in String "+s+" are balanced :"+ isBalanced(s));
	}

	private static boolean isBalanced(String s) {
		if(s==null||s.length()==0)
			return true;
		Stack<Character> stk = new Stack<Character>();
		for(int i=0; i < s.length();i++){
			if(s.charAt(i) =='['||s.charAt(i)=='{'|| s.charAt(i)=='(')
				stk.push(s.charAt(i));
			else if(s.charAt(i) ==']'||s.charAt(i)=='}'|| s.charAt(i)==')'){
				if(stk.isEmpty())
					return false;
				else if(!matchedParanthesis(s.charAt(i),stk.pop()))
					return false;
				}
			}
		if(!stk.isEmpty())
			return false;
		else
			return true;
	}


	private static boolean matchedParanthesis(char a, Character b) {
		if(a==']' && b =='[')
			return true;
		else if(a=='}' && b=='{')
			return true;
		else if (a==')' && b =='(')
			return true;
		return false;
	}


}
