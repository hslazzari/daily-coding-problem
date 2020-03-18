package day18;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	
	
	public static int[] maxValues(int[] numbers, int window) {
		int res[] = new int[numbers.length - window + 1];
		int res_element = 0;
		Deque<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 0; i < window; i++) {
			while(!queue.isEmpty() && numbers[i] >= numbers[queue.getLast()]) {
				queue.removeLast();
			}
			queue.addLast(i);
		}
		
		for(int i = window; i < numbers.length; i++) {
			res[res_element++] = numbers[queue.getFirst()];
			while(!queue.isEmpty() && numbers[i] >= numbers[queue.getLast()]) {
				queue.removeLast();
			}
			
			while(!queue.isEmpty() && queue.getFirst() <= i - window) {
				queue.removeFirst();
			}
	        queue.addLast(i);
		}
		res[res_element++] = numbers[queue.getFirst()];		
		return res;
	}
	
	public static void main(String[] args) {
		int[] numbers = {10, 5, 2, 7, 8, 7};
		for(int i : maxValues(numbers, 3)) {
			System.out.println(i);			
		}
	}
}
