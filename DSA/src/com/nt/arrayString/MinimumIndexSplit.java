package com.nt.arrayString;

import java.util.*;

class Solution {
    public int minimumIndex(int[] nums) {
        int n = nums.length;

        // Step 1: Find dominant element using Boyer-Moore
        int candidate = -1, count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate ? 1 : -1);
        }
        int dom = candidate;

        // Step 2: Count total frequency of dominant
        int total = 0;
        for (int num : nums) {
            if (num == dom) total++;
        }

        // Step 3: Check prefix & suffix dominance
        int prefix = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == dom) prefix++;

            int leftSize = i + 1;
            int rightSize = n - leftSize;

            if (prefix * 2 > leftSize && (total - prefix) * 2 > rightSize) {
                return i;  // minimum index found
            }
        }

        return -1;
    }
}

public class MinimumIndexSplit {
    public static void main(String[] args) {
        Solution sol = new Solution();  // ✅ create object

        int[] nums1 = {1, 2, 2, 2};
        int[] nums2 = {2, 1, 3, 1, 1, 1, 7, 1, 2, 1};
        int[] nums3 = {3, 3, 3, 3, 7, 2, 2};

        System.out.println("Output 1: " + sol.minimumIndex(nums1)); // Expected 2
        System.out.println("Output 2: " + sol.minimumIndex(nums2)); // Expected 4
        System.out.println("Output 3: " + sol.minimumIndex(nums3)); // Expected -1
    }
}
