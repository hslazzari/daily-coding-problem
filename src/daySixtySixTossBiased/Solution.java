package daySixtySixTossBiased;

import java.util.Random;

public class Solution {

    public static void main(String[] args) {
        int head = 0;
        int tails = 0;
        
        for(int i = 0; i < 100; i++) {
        	if(biasedCoin() == 1) {
        		head++;
        	} else 
        		tails++;
        }
        
        System.out.println("Head: " + head);
        System.out.println("Tails: " + tails);
    }
    
    public static int biasedCoin() {
        Random r = new Random();
        int head = r.nextInt(20);
        if(head > 1) {
            return 1;
        }
        return 0;
    }

    public static int unbiasedCoin() {
        int first;
        int second;
        do {
            first = biasedCoin();
            second = biasedCoin();    
        } while(first == second);

        return first;
        
    }

}
