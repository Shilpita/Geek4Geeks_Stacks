package StackQuestionFunctions;

import java.util.*;
/****************************************************************************************
 * author : Shilpita Roy
 * date   : Feb4,2017
 * purpose: Find the Next greater element in the array.
 * 			Geek4Geeks
 * *************************************************************************************/

public class NextGreater {
	public static void getNextGreater(int[] arr){
		if(arr.length == 0) System.out.println(-1);;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(arr[0]);
		for(int i = 1; i< arr.length; i++){
			int current = arr[i];
			while(!stack.isEmpty() && current > stack.peek()){
					System.out.println(stack.peek() +"--->"+ current);
					stack.pop();	
			}
			stack.push(current);
		}
		
		while(!stack.isEmpty()){
			System.out.println(stack.peek() +"--->"+ -1);
			stack.pop();
		}
	}

	public static void main(String[] args) {
		int[] arr = {3,4,1,10,9,2};
		getNextGreater(arr);
	}

}
