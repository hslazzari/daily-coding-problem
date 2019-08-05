package dayTwentyFivePatternMatching;

/*
    Given an array of numbers, find the length of the longest increasing 
    subsequence in the array. The subsequence does not necessarily have 
    to be contiguous.
*/

public class Solution {
    /*  
        c.*
        c
        a
        s
        a  
    */
    public static void main(String[] args) {
    	String word = "casa";
        String pattern = "c*";
        System.out.println(patternMatching(word, pattern));
    }

    public static boolean patternMatching(String word, String pattern) {
        boolean[][] dp = new boolean[word.length()+1][pattern.length()+1];

        dp[word.length()][pattern.length()] = true;

        for(int i = word.length(); i >= 0; i--) {
            for(int j = pattern.length()-1; j >= 0; j--) {
                boolean firstMatch = (i < word.length() && 
                                        (   pattern.charAt(j) == word.charAt(i)
                                         || pattern.charAt(j) == '.'));
                if(j + 1 < pattern.length() && pattern.charAt(j+1) == '*') {
                    dp[i][j] = dp[i][j+2] || (firstMatch && dp[i+1][j]);
                } else {
                    dp[i][j] = firstMatch && dp[i+1][j+1];
                }
            }
        }

        return dp[0][0];

    }


}
