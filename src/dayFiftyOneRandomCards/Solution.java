package dayFiftyOneRandomCards;

import java.util.Random;

public class Solution {
	public static void main(String[] args) {
		int[] deck = {1,2,3,4};
		shuffle(deck);
		for(int card : deck) {
			System.out.format("%d, ", card);
		}
		System.out.println("");
	}
	
	public static void shuffle(int[] deck) {
		Random r = new Random();
		for(int i = deck.length - 1; i > 0; i--) {
			int randPosition = r.nextInt(i+1);
			int aux = deck[i];
			deck[i] = deck[randPosition];
			deck[randPosition] = aux;
		}
	}
}
