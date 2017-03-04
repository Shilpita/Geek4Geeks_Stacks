package StackQuestionFunctions;

import java.util.*;

/**************************************************************************
 * author : Shilpita Roy
 * date   : Feb8,2017
 * purpose: The Stock span problem a financial problem where we have a series 
 * 			of n daily price quotes for a stock and we need to calculate 
 * 			span of stock’s price for all n days. 
 * 			Geek4Geeks
 * *****************************************************************************/
public class StackSpanProblem {
	public static int[] countSpan(int[] arr){
		int[] result = new int[arr.length] ;
		if (arr.length == 0) return result;
		Stack<Integer> stack = new Stack<Integer>(); // STACK STORES THE INDICES OF THE ARRAY
		stack.push(0);
		result[0] = 1;
		for(int i = 1; i< arr.length ; i++){
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i])
				stack.pop();
			result[i] = stack.isEmpty()? (i+1) : (i- stack.peek()); // IF EMPTY STACK THEM ENTIRE LENGTH OR ONLY THE ONES LESS THAN CURRENT PRICE
	
			stack.push(i);
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] stock = {100,80,60,75,80,50};
		int[] result = countSpan(stock);
		for(int i = 0 ; i<result.length ; i++)
			System.out.println(result[i]);
	}

}
