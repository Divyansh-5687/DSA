package com.nt.arrayString;

import java.util.*;

public class AnagramsInString {
    public static void main(String[] args) {
        Anagram sol = new  Anagram ();

        // Example 1
        String s1 = "cbaebabacd";
        String p1 = "abc";
        System.out.println(sol.findAnagrams(s1, p1)); // Expected [0, 6]

        // Example 2
        String s2 = "abab";
        String p2 = "ab";
        System.out.println(sol.findAnagrams(s2, p2)); // Expected [0, 1, 2]

        // Custom test
        String s3 = "aaacb";
        String p3 = "abc";
        System.out.println(sol.findAnagrams(s3, p3)); // Expected [2]
    }
}

class  Anagram  {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // count chars in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int window = p.length();

        for (int i = 0; i < s.length(); i++) {
            // add current char to window count
            sCount[s.charAt(i) - 'a']++;

            // remove char that slides out of window
            if (i >= window) {
                sCount[s.charAt(i - window) - 'a']--;
            }

            // compare frequency arrays
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - window + 1);
            }
        }

        return result;
    }
}
