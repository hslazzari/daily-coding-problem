package day165;

public class Solution {
	
	public static int[] smallerElementsNaive(int[] numbers) {
        int[] result = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            int smaller = 0;
            for(int j = i + 1; j < numbers.length; j++) {
                if(numbers[j] < numbers[i]) {
                    smaller++;
                }
            }
            result[i] = smaller;
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for(int e : arr) {
            System.out.print(e + ", ");
        }
        System.out.println("");
    }
    
	public static void main(String[] args) {
        printArray(smallerElementsNaive(new int[] {3, 4, 9, 6, 1}));
	}
}
