package day162;

import java.util.*;
import day162.Trie;

public class Solution {
	
    public static List<String> shortestPrefix(List<String> words) {
        Trie t = new Trie();
        List<String> result = new ArrayList<>();

        for(String s : words) {
            t.addWord(s);
        }

        searchPrefix("", result, t);
        
        return result;
    }

    private static void searchPrefix(String prefix, List<String> result, Trie trie) {
        for(Character c : trie.getLetters().keySet()) {
            if(c == '#') {
                result.add(prefix + " - Not found (full word)");
            } else {
                if(trie.getCount().get(c) == 1) {
                    result.add(prefix + c);
                } else {
                    searchPrefix(prefix + c, result, trie.getLetters().get(c));
                }
            }
        }
    }
    
	public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("cat");
        words.add("zoo");
        words.add("dog");
        words.add("forest");
        for(String s : shortestPrefix(words)) {
           System.out.println(s);
        }
    }
    
     
}
