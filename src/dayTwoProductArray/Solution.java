package dayTwoProductArray;

import java.util.Random;

/*
 * Given an array of integers, return a new array such that each element
 * at index i of the new array is the product of all the numbers in the
 * original array except the one at i 
 */

public class Solution {
	
	public static void main(String[] args) {
		int[] testArray = createArray(4, 3);
		printArray(testArray);
		int[] result = productOfNumberV2(testArray);
		printArray(result);
		//result = productOfNumber(testArray);
		//printArray(result);
	}
	
	public static int[] createArray(int n, int limit) {
		int[] returnArray = new int[n];
		Random r = new Random();
		
		for(int i = 0; i < n; i++) {
			returnArray[i] = r.nextInt(limit);
		}		
		
		return returnArray;
	}
	
	public static void printArray(int[] numbers) {

		for(int i = 0; i < numbers.length; i++) {
			System.out.format("%d ", numbers[i]);
		}
		
		System.out.println("");
	}
	
	public static int[] productOfNumber(int[] numbers) {
		long total = 1;
		int[] result = new int[numbers.length];
		
		for(int i = 0; i < numbers.length; i++) {
			total*=numbers[i];
		}
		
		for(int i = 0; i < numbers.length; i++) {
			result[i] = (int) total / numbers[i];
		}
		
		return result;
	}
	
	public static int[] productOfNumberV2(int[] numbers) {
		long total = 1;
		int[] result = new int[numbers.length];
		int[] left = new int[numbers.length];
		int[] rigth = new int[numbers.length];
		
		for(int i = 0; i < numbers.length; i++) {
			if(i == 0) {
				left[i] = 1;
			} else {
				left[i] = left[i-1] * numbers[i-1];
			}
		}
		
		for(int i = numbers.length - 1; i >= 0; i--) {
			if(i == numbers.length - 1) {
				rigth[i] = 1;
			} else {
				rigth[i] = rigth[i+1] * numbers[i+1];
			}
		}
		
		for(int i = 0; i < numbers.length; i++) {
			result[i] = left[i] * rigth[i];
		}
		return result;
	}
}
