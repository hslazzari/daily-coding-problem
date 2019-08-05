package dayElevenQueryString;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	public static HashMap<Character, Dictionary> dictionary = new HashMap<Character, Solution.Dictionary>();
	
	public static class Dictionary {
		char letter;
		HashMap<Character, Dictionary> next;
		boolean word;
	}
	
	public static void addWord(String s) {
		char[] letters = s.toCharArray();
		int i = 0;
		HashMap<Character, Dictionary> aux = dictionary;
		while(i < letters.length) {
			if(!aux.containsKey(letters[i])) {
				Dictionary d = new Dictionary();
				d.letter = letters[i];
				d.next = new HashMap<Character, Solution.Dictionary>();
				if(i == letters.length - 1) {
					d.word = true;
				}
				aux.put(letters[i], d);
				aux = d.next;
			} else {
				Dictionary d = aux.get(letters[i]);
				if(i == letters.length - 1) {
					d.word = true;
				}
				aux = d.next;
			}
			i++;
		}
	}
	
	public static ArrayList<String> prefix(String s) {
		char[] letters = s.toCharArray();
		int i = 0;
		HashMap<Character, Dictionary> aux = dictionary;
		ArrayList<String> words = new ArrayList<String>();
		while(i < letters.length) {
			if(aux == null) {
				return null;
			}
			if(!aux.containsKey(letters[i])) {
				return null;
			}
			
			if(i == letters.length - 1 && aux.get(letters[i]).word) {
				words.add(s);
			}
			
			aux = aux.get(letters[i]).next;
			
			i++;
		}
		
		
		
		
		for(Dictionary d : aux.values()) {
			recursiveWord(s, d, words);
		}
		
		return words;
	}
	
	private static void recursiveWord(String prefix, Dictionary dic, ArrayList<String> words) {
		if(dic == null) {
			return;
		}
		
		if(dic.word) {
			words.add(prefix + dic.letter);
		}
		
		for(Dictionary d : dic.next.values()) {
			recursiveWord(prefix + dic.letter, d, words);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		addWord("casas");
		addWord("casa");
		addWord("casabela");
		addWord("cas");
		
		ArrayList<String> words = prefix("cas");
		for(String s : words) {
			System.out.println(s);
		}
	}
}
