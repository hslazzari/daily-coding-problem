package day161;

public class Solution {
	
	public static int invertNumber(int number) {
		return (~number);
    }
    
    public static void printBinary(int number, int bits) {
        
        for(int i = bits - 1; i >= 0; i--) {
            
            if((number & (1 << i)) != 0) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
            if(i % 4 == 0) {
                System.out.print(" ");
            }
        }
        System.out.println("");
    }
	
	public static void main(String[] args) {
        printBinary(16, 32);
        int result = invertNumber(16);
		printBinary(result, 32);
	}
}
