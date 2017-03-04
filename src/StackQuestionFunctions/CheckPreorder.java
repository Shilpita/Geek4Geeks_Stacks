package StackQuestionFunctions;
/**************************************************************************
 * author : Shilpita Roy
 * date   : Feb8,2017
 * purpose: Check if given array is preorder traversal of BST.
 * 			Geek4Geeks
 * *****************************************************************************/

import java.util.*;

public class CheckPreorder {
	
	public static boolean isPreorder(int[] arr){
		Stack<Integer> stack = new Stack<Integer>();
		int root = Integer.MIN_VALUE;
		if(arr.length == 0) return true;
		for(int i = 0 ; i< arr.length ; i++){
			if(root > arr[i]) return false; // root is smaller than right hand child return false
			else{
				while(!stack.isEmpty() && stack.peek() < arr[i]){
					root = stack.pop();
				}
				stack.push(arr[i]);
			}		
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arr = {40, 30, 35, 120, 80, 100};
		System.out.println(isPreorder(arr));
	}

}
