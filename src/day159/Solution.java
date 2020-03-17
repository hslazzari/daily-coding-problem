package day159;

import java.util.*;

public class Solution {
	
    /*
        Complexity: O(n)
        Memory Space: O(n)

        If there are only character from a-z lowercase could use 
        an array with the alphabet size.
    */
    
    public static Character recurringCharacter(String word) {
        HashSet<Character> charSaw = new HashSet<>();
        for(char c : word.toCharArray()) {
            if(charSaw.contains(c)) {
                return c;
            } else {
                charSaw.add(c);
            }
        }
        return null;
    }
    
	public static void main(String[] args) {
        String input = "abca";
        Character output = recurringCharacter(input);
        System.out.println(output);
	}
}
