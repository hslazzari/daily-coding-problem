package day162;

import java.util.*;

   

public class Trie {
    private HashMap<Character, Trie> letters;
    private HashMap<Character, Integer> countLetters;

    public Trie() {
        this.letters = new HashMap<>();
        this.countLetters = new HashMap<>();
    }

    public HashMap<Character, Trie> getLetters() {
        return this.letters;
    }

    public HashMap<Character, Integer> getCount() {
        return this.countLetters;
    }


    public void addWord(String s) {
        addWord(s, 0);
    }

    private void addWord(String s, int start) {
        if(s.length() == start) {
            if(!countLetters.containsKey('#')) {
                letters.put('#', null);
                countLetters.put('#', 1);
            } else {
                countLetters.put('#', countLetters.get('#') + 1);
            }
        } else {
            Character c = s.charAt(start);
            if(!countLetters.containsKey(c)) {
                letters.put(c, new Trie());
                countLetters.put(c, 1);
            } else {
                countLetters.put(c, countLetters.get(c) + 1);
            }

            Trie t = letters.get(c);
            t.addWord(s, start+1);
        }
    } 
}
