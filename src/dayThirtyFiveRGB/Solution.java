package dayThirtyFiveRGB;

public class Solution {

	public static void main(String[] args) {
		char[] letters = {'G', 'B', 'R', 'R', 'B', 'R', 'G'};
		for(char l : letters) {
			System.out.format("%c ", l);
		}
		System.out.println("");
		reorder_letters(letters);
		
	}
	
	public static void reorder_letters(char[] letters) {
		int r_array = 0;
		int b_array = letters.length-1;
		if(letters.length > 1) {
			while(letters[r_array] == 'R') r_array++;
			while(letters[b_array] == 'B') b_array--;
			
			for(int i = r_array; i <= b_array; i++) {
				System.out.println("analisando letra: " + letters[i] + " " + i);
				
				
				if(letters[i] == 'R' && letters[i] != letters[r_array]) {
					letters[i] = letters[r_array];
					letters[r_array] = 'R';
					r_array++;
					i = i - 1;
				} else {
					if(letters[i] == 'B' && letters[i] != letters[b_array]) {
						letters[i] = letters[b_array];
						letters[b_array] = 'B';
						b_array--;
						i = i - 1;
					}
				}
				
				for(char l : letters) {
					System.out.format("%c ", l);
				}
				System.out.println("");
			}
		}
		
		
			
	}

}
