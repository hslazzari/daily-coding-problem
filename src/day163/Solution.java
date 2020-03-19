package day163;

import java.util.*;

public class Solution {
	
	public static int solver(String[] expression) {
        Deque<Integer> stack = new LinkedList<>();
        int a, b;
        for(String e : expression) {
            switch(e) {
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a+b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a-b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a*b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a/b);
                    break;
                default:
                    stack.push(Integer.valueOf(e));
            }
        }

        return stack.pop();
    }

	public static void main(String[] args) {
        System.out.println(solver(new String[] {"6", "4", "+"}));
	}
}
