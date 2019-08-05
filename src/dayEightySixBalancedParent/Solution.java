package dayEightySixBalancedParent;

public class Solution {

    public static void main(String[] args) {
        String word1 = "()())()";
        String word2 = ")(";       
        System.out.println(par(word1));
        System.out.println(par(word2));
    }

    public static int par(String word) {

        int open = 0;
        int close = 0;

        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == '(') {
                open++;
            } else {
                if(open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }

        return open + close;
    }
    
}