package day164;

public class Solution {
	
	public static int findDuplicate(int[] numbers) {
        int start = 0;
        while(numbers[start] != -1) {
            int old_start = start;
            start = numbers[start];
            numbers[old_start] = -1;
        }

        return start;
    }
    
	public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] {1, 2, 3, 4, 4, 5, 6, 7, 8}));
	}
}
