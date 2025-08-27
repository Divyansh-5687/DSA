package com.nt.arrayString;

import java.util.*;

class Custom {
    public String customSortString(String order, String s) {
        // Step 1: Count frequency of characters in s
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        StringBuilder result = new StringBuilder();

        // Step 2: Add characters in the order specified by 'order'
        for (char c : order.toCharArray()) {
            if (freq.containsKey(c)) {
                int count = freq.get(c);
                for (int i = 0; i < count; i++) {
                    result.append(c);
                }
                freq.remove(c); // remove processed char
            }
        }

        // Step 3: Add remaining characters (not in 'order')
        for (char c : freq.keySet()) {
            int count = freq.get(c);
            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}

public class CustomSortString  {
    public static void main(String[] args) {
        Custom sol = new Custom();

        // Example 1
        String order1 = "cba";
        String s1 = "abcd";
        System.out.println(sol.customSortString(order1, s1));  
        // Output could be: "cbad"

        // Example 2
        String order2 = "bcafg";
        String s2 = "abcd";
        System.out.println(sol.customSortString(order2, s2));  
        // Output could be: "bcad"
    }
}





