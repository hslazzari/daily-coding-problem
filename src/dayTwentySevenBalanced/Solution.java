package dayTwentySevenBalanced;

import java.util.Stack;

public class Solution {
	
	public static void main(String[] args) {
		System.out.println(isBalanced("[][]"));
	}
	
	public static boolean openElement(Character c) {
		if(c == '[' || c == '{' || c == '(') {
			return true;
		}
		
		return false;
	}
	
	public static boolean reversed(Character open, Character close) {
		if(open == '(' && close == ')') 
			return true;
		if(open == '[' && close == ']') 
			return true;
		if(open == '{' && close == '}')  
			return true;
		
		return false;
	}
	
	public static boolean isBalanced(String query) {
		char[] queryArray = query.toCharArray();
		Stack<Character> stackBalanced = new Stack<Character>();
		for(Character c : queryArray) {
			if(openElement(c)) {
				stackBalanced.push(c);
			} else {
				if(stackBalanced.isEmpty()) {
					return false;
				}
				Character o = stackBalanced.pop();
				if(!reversed(o, c)) {
					return false;
				}
				
			}
		}	
		
		if(!stackBalanced.isEmpty()) {
			return false;
		}
		
		return true;
	}
}
