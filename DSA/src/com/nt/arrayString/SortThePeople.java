package com.nt.arrayString;

import java.util.*;

class Solute{
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        
        // Create an array of indices [0, 1, 2, ... , n-1]
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        // Sort indices based on heights (descending)
        Arrays.sort(indices, (a, b) -> heights[b] - heights[a]);
        
        // Build result using sorted indices
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = names[indices[i]];
        }
        
        return result;
    }
}

public class SortThePeople{
    public static void main(String[] args) {
        Solute sol = new Solute();

        String[] names1 = {"Mary","John","Emma"};
        int[] heights1 = {180,165,170};
        System.out.println(Arrays.toString(sol.sortPeople(names1, heights1)));
        // Output: ["Mary", "Emma", "John"]

        String[] names2 = {"Alice","Bob","Bob"};
        int[] heights2 = {155,185,150};
        System.out.println(Arrays.toString(sol.sortPeople(names2, heights2)));
        // Output: ["Bob", "Alice", "Bob"]
    }
}