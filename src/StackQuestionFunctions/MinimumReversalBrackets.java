package StackQuestionFunctions;
/**************************************************************************
 * author : Shilpita Roy
 * date   : Feb8,2017
 * purpose: Count the number of reversal needed to balance the parenthesis.
 * 			Geek4Geeks
 * *****************************************************************************/
import java.util.*;

public class MinimumReversalBrackets {
	public static int countReversal(String str){
		if(str==null || str.length() == 0)
			return -1;
		int count =0;
		if(str.length()%2 != 0)
			return -1;
		else{
			Stack<Character> stack = new Stack<Character>();
			for(int i = 0 ; i< str.length() ; i++){
				if(str.charAt(i) == '}' && !stack.isEmpty()){
					if(stack.peek() == '{'){
						stack.pop();
					}else{
						stack.push(str.charAt(i));
					}
				}else{
					stack.push(str.charAt(i));
				}
			}
			int reducedLength = stack.size();
			int n = 0;
			while(!stack.empty() && stack.peek() == '{'){
				stack.pop();
				n++;
			}
			count = (reducedLength/2)+(n%2);
		}
		
		return count;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter String :");
		String str = scan.nextLine();
		System.out.println(countReversal(str));
	}

}
