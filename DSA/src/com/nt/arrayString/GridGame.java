package com.nt.arrayString;

import java.util.*;

class Grid {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        long topSum = 0;
        for (int i = 0; i < n; i++) topSum += grid[0][i];

        long bottomSum = 0;
        long ans = Long.MAX_VALUE; // <-- fix

        for (int p = 0; p < n; p++) {
            topSum -= grid[0][p];
            ans = Math.min(ans, Math.max(topSum, bottomSum));
            bottomSum += grid[1][p];
        }
        return ans;
    }
}


public class GridGame {
	
	    public static void main(String[] args) {
	        Grid sol = new Grid();

	        // Example 1
	        int[][] grid1 = {
	            {2, 5, 4},
	            {1, 5, 1}
	        };
	        System.out.println(sol.gridGame(grid1)); // Expected 4

	        // Example 2
	        int[][] grid2 = {
	            {20, 3, 20, 17, 2, 12, 15, 17, 4, 15},
	            {20, 10, 13, 14, 15, 5, 2, 3, 14, 3}
	        };
	        System.out.println(sol.gridGame(grid2)); // Expected 63

	        // Large custom example
	        int[][] grid3 = {
	            {97743,90258,99629,95476,91139,95417,90316,96771,90828,93868},
	            {10000,20000,30000,40000,50000,60000,70000,80000,90000,100000}
	        };
	        System.out.println(sol.gridGame(grid3)); // Just to test
	    }
}
