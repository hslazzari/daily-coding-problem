package dayNineLargesSumNonAdjacent;

public class Solution {

	public static void main(String[] args) {
		int numbers[] = new int[]{6, 7, 1, 3, 8, 2, 4};
		System.out.println(sumNumbers(numbers));
	}
	
	public static int sumNumbers(int[] numbers) {
		int excluding = 0;
		int including = numbers[0];
		
		for(int i = 1; i < numbers.length; i++) {
			int newExcluding = Math.max(including, excluding);
			including = excluding + numbers[i];
			excluding = newExcluding;
		}	
		
		return Math.max(including, excluding);
	}

}
