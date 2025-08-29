package com.nt.arrayString;

import java.util.*;

class Wall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> edgeCount = new HashMap<>();
        
        for (List<Integer> row : wall) {
            int prefixSum = 0;
            // Exclude the last brick to avoid right boundary
            for (int i = 0; i < row.size() - 1; i++) {
                prefixSum += row.get(i);
                edgeCount.put(prefixSum, edgeCount.getOrDefault(prefixSum, 0) + 1);
            }
        }

        int maxEdges = 0;
        for (int count : edgeCount.values()) {
            maxEdges = Math.max(maxEdges, count);
        }

        return wall.size() - maxEdges;
    }
}

public class BrickWall {
    public static void main(String[] args) {
        Wall solution = new Wall();

        List<List<Integer>> wall1 = Arrays.asList(
            Arrays.asList(1, 2, 2, 1),
            Arrays.asList(3, 1, 2),
            Arrays.asList(1, 3, 2),
            Arrays.asList(2, 4),
            Arrays.asList(3, 1, 2),
            Arrays.asList(1, 3, 1, 1)
        );

        List<List<Integer>> wall2 = Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(1),
            Arrays.asList(1)
        );

        System.out.println("Output 1: " + solution.leastBricks(wall1)); // Expected: 2
        System.out.println("Output 2: " + solution.leastBricks(wall2)); // Expected: 3
    }
}
