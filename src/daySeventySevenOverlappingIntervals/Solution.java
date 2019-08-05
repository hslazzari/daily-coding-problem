


package daySeventySevenOverlappingIntervals;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static class Interval implements Comparable<Interval> {
        int start;
        int end;
        
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Interval e2) {
            if(this.start == e2.start) {
                if(this.end == e2.end) {
                    return 0;
                }
                
                if(this.end > e2.end) {
                    return 1;
                } else {
                    return -1;
                }
            }
            
            if(this.start > e2.start) {
                return 1;
            } else {
                return -1;
            }
        }
        
        @Override
        public String toString() {
            return "(" + String.valueOf(this.start) + ", " + String.valueOf(this.end) + ")";
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Interval> listOfIntervals = new ArrayList<Solution.Interval>();
        listOfIntervals.add(new Interval(1, 3));
        listOfIntervals.add(new Interval(5, 11));
        listOfIntervals.add(new Interval(4, 10));
        listOfIntervals.add(new Interval(20, 25));
        
        for(Interval i : listOfIntervals) {
        	System.out.print(i + ", ");
        }
        
        System.out.println("");

        ArrayList<Interval> result = mergeArrays(listOfIntervals);

        for(Interval i : result) {
        	System.out.print(i + ", ");
        }
    }

    public static ArrayList<Interval> mergeArrays(ArrayList<Interval> listOfIntervals) {
        Interval newInterval = new Interval(listOfIntervals.get(0).start, listOfIntervals.get(0).end);
        ArrayList<Interval> result = new ArrayList<Interval>();
        listOfIntervals.sort(null);
        boolean first = true;
        for(Interval i : listOfIntervals) {
        	if(!first) {
	            if(i.start >= newInterval.start && i.start <= newInterval.end) {
	                newInterval.start = Math.min(i.start, newInterval.start);
	                newInterval.end = Math.max(i.end, newInterval.end);
	            } else {
	                result.add(newInterval);
	                newInterval = new Interval(i.start, i.end);
	            }
        	} else {
        		first = false;
        	}
        }
        result.add(newInterval);
        return result;
    }
}
