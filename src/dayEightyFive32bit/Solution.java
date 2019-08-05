package dayEightyFive32bit;

public class Solution {
	public static void main(String[] args) {
		int x = 5;
    	int y = 10;
    	int b = 0;
    	
    	System.out.println( (((b << 31) >> 31) & x) | (~((b << 31) >> 31) & y));
	}
}
