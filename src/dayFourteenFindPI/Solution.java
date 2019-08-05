package dayFourteenFindPI;

import java.util.Random;

public class Solution {

	public static void main(String[] args) {
		System.out.println(findPi(1000000000L));
	}
	
	public static double findPi(long max_numbers) {
		Random r = new Random();
		long square = 0;
		long circle = 0;
		float x = 0;
		float y = 0;
		for(long i = 0; i < max_numbers; i++) {
			x = r.nextFloat();
			y = r.nextFloat();
			if(Math.pow(x, 2) + Math.pow(y, 2) <= 1) {
				circle++; 
			} 
			square++;
		}
		
		return 4 * ((double) circle / (double) square);
	}
}
