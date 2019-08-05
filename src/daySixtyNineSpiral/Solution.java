package daySixtyNineSpiral;

public class Solution {

	public static void main(String[] args) {

		int[][] values = {{ 1, 2, 3, 4, 5},
		                 { 6, 7, 8, 9,10},
		                 {11,12,13,14,15},
		                 {16,17,18,19,20}};
		
		int[][] values2 = {{1,2}, {3,4}};
		
		
		 printSpiral(values2);

	}
	
	public static void printSpiral(int[][] values) {
		for(int line = 0; line < values.length / 2; line++) {
		    for(int col = line; col < values[0].length - line; col++) {
		        System.out.println(values[line][col]);
		    }
		
		    System.out.println("A");
		    for(int lin = line + 1; lin < values.length - line; lin++) {
		        System.out.println(values[lin][values[0].length - line - 1]);
		    }
		    System.out.println("B");
		
		    for(int col = values.length - line - 1; col >= line; col--) {
		    	System.out.println(values[values.length - line - 1][col]);
		    }
		    
		    System.out.println("C");
		
		    for(int lin = values.length - line - 2; lin > line; lin--) {
		        System.out.println(values[lin][line]);
		    }
		 }
	}

}
