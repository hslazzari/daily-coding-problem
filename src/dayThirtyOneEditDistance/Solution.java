package dayThirtyOneEditDistance;

public class Solution {
	static int helper[][];
	
	public static void main(String[] args) {
		String word1 = "sundaysundaysundaysundaysundaysundaysundaysundaysunday";
		String word2 = "saturdays";
		helper = new int[word1.length()+1][word2.length()+1];
		for(int i = 0; i < word1.length()+1; i++) {
			for(int j = 0; j < word2.length()+1; j++) {
				helper[i][j] = -1;
			}
		}
		long start = System.currentTimeMillis();
		System.out.println(editDistance(word1, word2, word1.length(), word2.length()));
		System.out.println("Time: " + (System.currentTimeMillis()-start));
		helper = new int[word1.length()+1][word2.length()+1];
		for(int i = 0; i < word1.length()+1; i++) {
			for(int j = 0; j < word2.length()+1; j++) {
				helper[i][j] = -1;
			}
		}
		start = System.currentTimeMillis();
		System.out.println(editDistanceDP(word1, word2, word1.length(), word2.length()));
		System.out.println("Time: " + (System.currentTimeMillis()-start));
		helper = new int[word1.length()+1][word2.length()+1];
		for(int i = 0; i < word1.length()+1; i++) {
			for(int j = 0; j < word2.length()+1; j++) {
				helper[i][j] = 0;
			}
		}
		start = System.currentTimeMillis();
		System.out.println(editDistanceReverse(word1, word2, word1.length(), word2.length()));
		System.out.println("Time: " + (System.currentTimeMillis()-start));
	}
	
	public static int editDistance(String word1, String word2, int n, int m) {
		if(n == 0) {
			return m;
		}
		
		if(m == 0) {
			return n;
		}
		

		
		if(word1.charAt(n-1) == word2.charAt(m-1)) { 
			helper[n][m] = editDistance(word1, word2, n-1, m-1);
			return helper[n][m];
		}
		helper[n][m] = 1 + min(editDistance(word1, word2, n-1, m-1),editDistance(word1, word2, n, m-1), editDistance(word1, word2, n-1, m)); 

		return helper[n][m];
	}
	
	public static int editDistanceDP(String word1, String word2, int n, int m) {
		if(n == 0) {
			return m;
		}
		
		if(m == 0) {
			return n;
		}
		
		if(helper[n][m] != -1) {
			return helper[n][m]; 
		}
		
		if(word1.charAt(n-1) == word2.charAt(m-1)) { 
			helper[n][m] = editDistance(word1, word2, n-1, m-1);
			return helper[n][m];
		}
		helper[n][m] = 1 + min(editDistance(word1, word2, n-1, m-1),editDistance(word1, word2, n, m-1), editDistance(word1, word2, n-1, m)); 

		return helper[n][m];
	}
	
	public static int editDistanceReverse(String word1, String word2, int n, int m) {
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= m; j++) {
				if(i == 0) {
					helper[i][j] = j;
				}
				else if(j == 0) {
					helper[i][j] = i;
				}
				else if(word1.charAt(i-1) == word2.charAt(j-1)) { 					
					helper[i][j] = helper[i-1][j-1];
				} else {
					helper[i][j] = 1 + min(helper[i-1][j-1], helper[i][j-1], helper[i-1][j]);
				}
			}
		}
		
		return helper[n][m];
	}
	
	public static int min(int ... numbers) {
		int min = numbers[0];
		for(int n : numbers) {
			min = Math.min(min, n);
		}
		return min;
	}
}
