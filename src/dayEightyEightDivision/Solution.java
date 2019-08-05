package dayEightyEightDivision;


public class Solution {
    public static void main(String[] args) {
    	System.out.println(division(20, 4));
    }

    public static int division(int a, int b) {
        int temp = 0;
        int quotient = 0;
        
        for (int i = 30; i >= 0; --i) { 
        if (temp + (b << i) <= a) { 
        	temp += b << i; 
            quotient = quotient | 1 << i; 
        } 
      } 
      
      return quotient; 
    }
}


