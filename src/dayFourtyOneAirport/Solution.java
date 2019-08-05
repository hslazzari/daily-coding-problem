package dayFourtyOneAirport;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    

    public static void main(String[] args) {
        String[] pathsArray = {"A", "B", "A", "C", "B", "C", "C", "A"};
        HashMap<String, ArrayList<String>> paths = new HashMap<String, ArrayList<String>>();
        HashSet<String> visited = new HashSet<String>();
        
        for(int i = 0; i < pathsArray.length; i+=2) {
            if(!paths.containsKey(pathsArray[i])) {
                ArrayList<String> newPath = new ArrayList<String>();
                newPath.add(pathsArray[i+1]);
                paths.put(pathsArray[i], newPath);
            } else {
                ArrayList<String> newPath = paths.get(pathsArray[i]);
                newPath.add(pathsArray[i+1]);
                newPath.sort(String::compareTo);
            }
        }
        
        System.out.println(paths("A", paths, visited));
    }
    
    public static String paths(String source, HashMap<String, ArrayList<String>> c_paths, HashSet visited) {
        if(visited.size() == 4) {
            return source;
        }
        if(!c_paths.containsKey(source)) {
        	return null;
        }
        for(String toVisit : c_paths.get(source)) {
            String voo = source + "->" + toVisit;
            if(!visited.contains(voo)) {
                visited.add(voo);
                String partialPath = paths(toVisit, c_paths, visited);
                if(partialPath != null) {
                    return source + "," + partialPath;
                } else {
                    visited.remove(voo);
                }
            }
        }
        return null;
    }
}
