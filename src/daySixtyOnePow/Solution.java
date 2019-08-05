package daySixtyOnePow;

/* pow(x, y) function, where x and y are integers and returns x^y. */

public class Solution {
        
    public static void main(String[] args) {
    	System.out.println(naivePow(2, 5));
    	System.out.println(recursivePow(4, 2));
    }

    public static int naivePow(int x, int y) {
        int result = 1;
        for(int i = 1; i <= y; i++) {
            result*=x;
        }

        return result;
    } 
    
    public static int recursivePow(int x, int y) {
        if(y == 1) {
            return x;
        }

        if(y == 0) {
            return 1;
        }

        boolean hasOneMore = (y % 2 == 1);
        int half = recursivePow(x, y/2);


        half*=half;

        if(hasOneMore) {
            half*=x;
        }

        return half;

    }
    
    
}