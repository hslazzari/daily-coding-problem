package dayTwentyNineEncodeString;

public class Solution {
	public static void main(String[] args) {
		String entry = "AAAABBBCCDAA";
		
		System.out.println(encodeString(entry));
	}
	
	public static String encodeString(String entry) {
		
		if(entry.length() == 0) {
			return entry;
		}
		
		StringBuilder bfString = new StringBuilder();
		char prevChar = entry.charAt(0);
		int count = 1;
		
		for(int index = 1; index < entry.length(); index++) {
			if(prevChar != entry.charAt(index)) {
				bfString.append(count);
				bfString.append(prevChar);
				count = 1;
				prevChar = entry.charAt(index);
			} else {
				count++;
			}
		}
		
		bfString.append(count);
		bfString.append(prevChar);
		
		return bfString.toString();
	}
}
