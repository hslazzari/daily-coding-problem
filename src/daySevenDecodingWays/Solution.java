package daySevenDecodingWays;

public class Solution {
	
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1};
		
		System.out.println(decodingWaysRecursive(numbers, 0));
		System.out.println(decodingWays(numbers));
		
	}
	
	public static int decodingWays(int[] numbers) {
		
		int[] countWords = new int[numbers.length + 1];
		countWords[0] = 1;
		countWords[1] = 1;
		
		for(int i = 2; i <= numbers.length; i++) {
			if(numbers[i-1] > 0) {
				countWords[i] = countWords[i-1];
			}
			
			int numberTwo = numbers[i - 2] * 10 + numbers[i-1];
			
			if(numberTwo > 9 && numberTwo <= 26) {
				countWords[i]+=countWords[i-2];
			}
		}
		
		return countWords[numbers.length];
	}
	
	public static int decodingWaysRecursive(int[] numbers, int startPoint) {
		if(startPoint >= numbers.length - 1) {
			return 1;
		}
		
		int count = 0;
		
		if(numbers[startPoint] > 0) {
			count = decodingWaysRecursive(numbers, startPoint+1);
		}
		
		if(startPoint < numbers.length - 1) {
			if(numbers[startPoint] * 10 + numbers[startPoint+1] <= 26 && numbers[startPoint] * 10 + numbers[startPoint+1] > 9) {
				count+= decodingWaysRecursive(numbers, startPoint+2);
			}
		}
		
		
		return count;
	}
}
