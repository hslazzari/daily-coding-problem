package daySeventyFiveLongestIncreasingSubsequence;

/*
    Given an array of numbers, find the length of the longest increasing 
    subsequence in the array. The subsequence does not necessarily have 
    to be contiguous.
*/

public class Solution {
   
    public static void main(String[] args) {
        int[] numbers = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};

        System.out.println(longestIncreasing(numbers));
    }

    public static int longestIncreasing(int[] numbers) {
    	if(numbers.length == 0) {
    		return 0;
    	}
    	
        int[] longest = new int[numbers.length];
        
        int max = 1;        
        longest[0] = 1;
        
        for(int i = 1; i < numbers.length; i++) {
        	longest[i] = 1;
        	
            for(int j = 0; j < i; j++) {
                if(numbers[i] > numbers[j] && longest[i] < longest[j] + 1) {
                    longest[i] = longest[j] + 1;
                }
            }
            
            max = Math.max(longest[i], max);
        }

        return max;
    }


}
