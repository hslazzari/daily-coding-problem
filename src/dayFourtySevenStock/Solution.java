package dayFourtySevenStock;

public class Solution {

	public static void main(String[] args) {
		int[] stocks = {9, 11, 8, 5, 7, 10};
		System.out.println(maxDiff(stocks));

	}
	
	public static int maxDiff(int[] stocks) {
		int min = stocks[0];
		int maxDiff = stocks[1] - stocks[0];
		
		for(int i = 1; i < stocks.length; i++) {
			if(stocks[i] - min > maxDiff) {
				maxDiff = stocks[i] - min;
			}
			
			if(stocks[i] < min) {
				min = stocks[i];
			}
		}
		
		return maxDiff;
	}

}
