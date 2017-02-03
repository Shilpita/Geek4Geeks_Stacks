package StackQuestionFunctions;
/****************************************************************************************************
 * author : Shilpita Roy
 * date   : Jan28,2017
 * purpose: Reverse a given string using stack. Time Complexity O(N) space Complexity O(N)
 * 			Geek4Geeks
 * *************************************************************************************************/

import java.util.*;

public class ReverseStringUsingStack {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter String to reverse:");
		String str = scan.nextLine();
		
		str = reverseString(str);
		System.out.println("Reversed String: "+ str);
	}

	private static String reverseString(String str) {
		if(str.isEmpty())
			return str;
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0 ; i< str.length();i++)
			stack.push(str.charAt(i));
		
		str = "";
		while(!stack.isEmpty())
			str = str+stack.pop();
		
		return str;
	}

}
