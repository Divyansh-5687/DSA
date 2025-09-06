package com.nt.arrayString;

import java.util.*;

class Palindrom{
    public int maxProduct(String s) {
        int n = s.length();
        int totalMasks = 1 << n;
        
        // Store palindrome lengths for each mask
        int[] palLen = new int[totalMasks];
        
        for (int mask = 1; mask < totalMasks; mask++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sb.append(s.charAt(i));
                }
            }
            if (isPalindrome(sb)) {
                palLen[mask] = sb.length();
            }
        }
        
        int ans = 0;
        for (int mask1 = 1; mask1 < totalMasks; mask1++) {
            if (palLen[mask1] == 0) continue;
            for (int mask2 = mask1 + 1; mask2 < totalMasks; mask2++) {
                if (palLen[mask2] == 0) continue;
                if ((mask1 & mask2) == 0) { // disjoint
                    ans = Math.max(ans, palLen[mask1] * palLen[mask2]);
                }
            }
        }
        
        return ans;
    }
    
    private boolean isPalindrome(StringBuilder sb) {
        int l = 0, r = sb.length() - 1;
        while (l < r) {
            if (sb.charAt(l++) != sb.charAt(r--)) return false;
        }
        return true;
    }
}


public class PalindromicSubsequences {
	public static void main(String[] args) {
        Palindrom sol = new Palindrom();

        String s1 = "leetcodecom";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + sol.maxProduct(s1)); // Expected 9

        String s2 = "bb";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + sol.maxProduct(s2)); // Expected 1

        String s3 = "accbcaxxcxx";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + sol.maxProduct(s3)); // Expected 25
    }
}
