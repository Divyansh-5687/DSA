package com.nt.arrayString;

import java.util.Arrays;

public class AllBallsToEachBox{
    public static void main(String[] args) {
        Solutio sol = new Solutio();
        
        // Example 1
        String boxes1 = "110";
        int[] result1 = sol.minOperations(boxes1);
        System.out.println("Input: " + boxes1);
        System.out.println("Output: " + Arrays.toString(result1)); // [1, 1, 3]

        // Example 2
        String boxes2 = "001011";
        int[] result2 = sol.minOperations(boxes2);
        System.out.println("Input: " + boxes2);
        System.out.println("Output: " + Arrays.toString(result2)); // [11, 8, 5, 4, 3, 4]
    }
}

class Solutio {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        
        // Left to right pass
        int balls = 0, ops = 0;
        for (int i = 0; i < n; i++) {
            ans[i] += ops;
            if (boxes.charAt(i) == '1') balls++;
            ops += balls;
        }
        
        // Right to left pass
        balls = 0; ops = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] += ops;
            if (boxes.charAt(i) == '1') balls++;
            ops += balls;
        }
        
        return ans;
    }
}
