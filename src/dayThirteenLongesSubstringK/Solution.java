package dayThirteenLongesSubstringK;

import java.util.HashMap;

public class Solution {
	public static class HashMapInteger<K> extends HashMap<K,Integer> {  
		public Integer increment(K key) {
        	Integer value = 1;
          if(super.containsKey(key)) {
        	  value = super.get(key)+1;
        	  super.put(key,value);
          }              
          else
              super.put(key,new Integer(1));
          
          return value;
        }
		
		public Integer decrement(K key) {
        	Integer value = 1;
          if(super.containsKey(key)) {
        	  value = super.get(key)-1;
        	  super.put(key,value);
          }              
          else
              super.put(key,new Integer(0));
          
          return value;
        }

       
      }
	public static void main(String[] args) {
		System.out.println(longestSubstring("abcba", 2));
	}
	
	public static String longestSubstring(String word, Integer k) {
		HashMapInteger<Character> frequency = new HashMapInteger<Character>();
		
		char[] letters = word.toCharArray();
		int start = 0;
		int end = 0;
		int currentK = 0;
		int l = 0;
		for(int i = 0; i < letters.length; i++) {
			if(frequency.increment(letters[i]) == 1) {
				currentK++;
			}
			
			while(currentK > k) {
			    if(frequency.decrement(letters[l]) == 0) {
			    	currentK--;
			    }
			    
			    l++;
			}
			
			if(i - l >= end - start) {
				end = i;
				start = l;
			}
		}
		String s = "";
		for(int i = start; i <= end; i++) {
			s+=letters[i];
		}
		
		return s;
	}
}
