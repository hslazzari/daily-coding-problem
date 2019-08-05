package daySixtyEigthBishop;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		int[][] bishops = {{0,0},
				           {1,2},
				           {2,3},
				           {2,2},
				           {4,0}};
		System.out.println(bishopAttack(bishops));
	}

	private static void incrementHash(HashMap<Integer,Integer> hash, int key) {
		if(hash.containsKey(key)) {
			hash.put(key, hash.get(key) + 1);
		} else {
			hash.put(key, 1);
		}	
	}
	public static int bishopAttack(int[][] bishops) {
		HashMap<Integer,Integer> leftDiagonal = new HashMap<Integer, Integer>();
	HashMap<Integer,Integer> rightDiagonal = new HashMap<Integer, Integer>();

	for(int[] bishopPair : bishops) {
		int ldiag = bishopPair[0] - bishopPair[1];
		incrementHash(leftDiagonal, ldiag);
		int rdiag = bishopPair[1] - bishopPair[0];
		incrementHash(rightDiagonal, rdiag);
	}
	return countResult(leftDiagonal) + countResult(rightDiagonal);

	}

	private static int factorial(int n) { 
		int result = 1;
		for(int n1 = 1; n1 < n; n1++) {
			result*=n1;
		}
		return result;
	}

	 public static int countResult(HashMap<Integer,Integer> hash) {
		int result = 0;
	for(int key : hash.keySet()) {
		int value = hash.get(key);
		if(value >= 2) {
			result+=factorial(value);
		} 
	}
	return result;
	}




}
