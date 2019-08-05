package dayTwentyFive;

import java.util.Stack;

public class Solution {
	public static boolean matches(String pattern, String query) {
		int patIndex = 0;
		int startIndex = 0;
		boolean anyCharacter = false;
		boolean repeat = false;
		
		if(pattern.equals("")) {
			return true;
		}
		
		if(pattern.equals(".*")) {
			return true;
		}
		
		if(query.equals("")) {
			return false;
		}
		
		while(patIndex < pattern.length()) {
			
			if(pattern.charAt(patIndex) == '.') {
				anyCharacter = true;
			}
			if(patIndex+1 < pattern.length() && pattern.charAt(patIndex+1) == '*') {
				repeat = true;
			}
			
			patIndex++;
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		String query, pattern;
		
		query = "ab";
		pattern = ".*";
		
		System.out.format("Query %s - Pattern %s = %b", query, pattern, matches(pattern, query));
	}
}
