package dayEightyOneAllLetters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        HashMap<Character, ArrayList<Character>> dict = new HashMap<Character, ArrayList<Character>>();
        
        dict.put('2', new ArrayList<Character>(Arrays.asList('a', 'b', 'c')));
        dict.put('3', new ArrayList<Character>(Arrays.asList('d', 'e', 'f')));
        
        String number = "23";
        
        ArrayList<String> result = new ArrayList<String>();
        
        allNumbers(number, dict, "", result);
        for(String s : result) {
        	System.out.println(s);
        }
    }
    

    public static void allNumbers(String number, HashMap<Character, ArrayList<Character>> dict, String prefix, ArrayList<String> result) {
    	if(number.equals("")) {
    		result.add(prefix);
    		return;
    	}
    	
    	for(char letter : dict.get(number.charAt(0))) {
    		allNumbers(number.substring(1), dict, prefix + letter, result);
    	}
    }
    
    //{"2": ["a", "b", "c"], 3: ["d", "e", "f"], } 

}    