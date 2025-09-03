package com.nt.arrayString;

public class MinimumNumberOfSwapsOfStrings {
	 static class Solution {
	        public int minSwaps(String s) {
	            int balance = 0, minBalance = 0;

	            for (char c : s.toCharArray()) {
	                if (c == '[') balance++;
	                else balance--;
	                minBalance = Math.min(minBalance, balance);
	            }

	            // Swaps needed = ceil(-minBalance / 2)
	            return (-minBalance + 1) / 2;
	        }
	    }

	    public static void main(String[] args) {
	        Solution sol = new Solution();

	        String s1 = "][][";
	        System.out.println("Input: " + s1 + " -> Output: " + sol.minSwaps(s1)); // Expected 1

	        String s2 = "]]][[[";
	        System.out.println("Input: " + s2 + " -> Output: " + sol.minSwaps(s2)); // Expected 2

	        String s3 = "[]";
	        System.out.println("Input: " + s3 + " -> Output: " + sol.minSwaps(s3)); // Expected 0

	        // You can add more custom tests
	        String s4 = "[][][]";
	        System.out.println("Input: " + s4 + " -> Output: " + sol.minSwaps(s4)); // Expected 0
	   }
}	    
