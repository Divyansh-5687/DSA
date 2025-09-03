package com.nt.arrayString;

import java.util.*;

public class InterchangeableRectangle {
    static class Solution {
        public long interchangeableRectangles(int[][] rectangles) {
            double[] ratio = new double[rectangles.length];
            long count = 1, pairs = 0;

            for (int i = 0; i < rectangles.length; i++) {
                ratio[i] = (double) rectangles[i][0] / rectangles[i][1];
            }

            Arrays.sort(ratio);

            for (int i = 1; i < rectangles.length; i++) {
                if (ratio[i] == ratio[i - 1]) {
                    count++;
                } else {
                    pairs += (count * (count - 1)) / 2;
                    count = 1;
                }
            }

            pairs += (count * (count - 1)) / 2;
            return pairs;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] rectangles1 = {{4, 8}, {3, 6}, {10, 20}, {15, 30}};
        System.out.println("Output: " + sol.interchangeableRectangles(rectangles1)); 
        // Expected: 6

        int[][] rectangles2 = {{4, 5}, {7, 8}};
        System.out.println("Output: " + sol.interchangeableRectangles(rectangles2)); 
        // Expected: 0

        int[][] rectangles3 = {{1, 2}, {2, 4}, {3, 6}, {4, 8}, {5, 10}};
        System.out.println("Output: " + sol.interchangeableRectangles(rectangles3)); 
        // Expected: 10
    }
}
