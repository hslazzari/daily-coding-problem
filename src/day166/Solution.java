package day166;


public class Solution {
	
	public static void main(String[] args) {
        Integer[][] items = new Integer[][] {
            {1, 2},
            {},
            {},
            {3},
            {},
            {4,5,6},
            {}
        };

        TwoDIterator<Integer> t = new TwoDIterator<Integer>(items);

        for(int n : t) {
            System.out.println(n);
        }

	}
}
