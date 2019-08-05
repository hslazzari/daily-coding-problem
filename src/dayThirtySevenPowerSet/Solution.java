package dayThirtySevenPowerSet;
import java.lang.Math;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = {1,2,3};

        for(ArrayList<Integer> set : powerSet(numbers)) {
        	String s = set.stream().map(e -> e.toString()).collect(Collectors.joining(","));
        	System.out.println(s);
        }
    }

    public static ArrayList<ArrayList<Integer>> powerSet(int[] numbers) {
        long totalSets = (long) Math.pow(2, numbers.length);
        ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
        sets.add(new ArrayList<Integer>());
        for(int set = 1; set <= totalSets; set++) {
            ArrayList<Integer> newSet = new ArrayList<Integer>();

            for(int number_index = 0; number_index < numbers.length; number_index++) {
                if((set & (1 << number_index)) != 0) {
                    newSet.add(numbers[number_index]);
                }
            }

            sets.add(newSet);
        }

        return sets;
    }
}
