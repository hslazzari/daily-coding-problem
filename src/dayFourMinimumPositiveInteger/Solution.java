package dayFourMinimumPositiveInteger;

import java.util.Random;

public class Solution {
	
	public static void main(String[] args) {
		int[] numbers = createArray(5, 10, 5);
		printArray(numbers);
		numbers = onlyInt(numbers);
		printArray(numbers);
		System.out.format("Missing integer: %d", findMissingInteger(numbers));
	}

	public static int[] createArray(int size, int upper, int substract) {
		Random r = new Random();
		int[] returnArray = new int[size];
		
		for(int i = 0; i < size; i++) {
			returnArray[i] = r.nextInt(upper) - substract;
		}
		
		return returnArray;
	}
	
	public static int[] onlyInt(int[] numbers) {
		int positiveNumbers = 0;
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] > 0) {
				positiveNumbers++;
			}
		}
		
		int[] positiveArray = new int[positiveNumbers];
		int positiveIndex = 0;
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] > 0) {
				positiveArray[positiveIndex++]=numbers[i];
			}
		}
		
		return positiveArray;
		
	}
	
	public static void printArray(int[] numbers) {
		for(int i = 0; i < numbers.length; i++) {
			System.out.format("%d ", numbers[i]);
		}
		System.out.println("");		
	}
	
	public static int findMissingInteger(int[] numbers) {
		for(int i = 0; i < numbers.length; i++) {
			int x = Math.abs(numbers[i]);
			if(x < numbers.length && numbers[x-1] > 0) {
				numbers[x-1] = -1 * numbers[x-1];
			}
		}
		
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] > 0) {
				return i + 1;
			}
		}	
		
		return numbers.length + 1;
	}
}
