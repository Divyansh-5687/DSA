package com.nt.arrayString;

import java.util.*;

class  Palindrome {
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending in 0 (but not 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        // For even length: x == reversed
        // For odd length: x == reversed / 10 (middle digit ignored)
        return x == reversed || x == reversed / 10;
    }
}

public class PalindromeNumber{
	 public static void main(String[] args) {
	        Palindrome solution = new  Palindrome();

	        int[] testCases = {121, -121, 10, 12321, 0, 1221};
	        for (int x : testCases) {
	            System.out.println("Input: " + x + " → " + solution.isPalindrome(x));
	        }
	    }
	
}