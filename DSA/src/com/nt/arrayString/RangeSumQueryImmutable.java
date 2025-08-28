package com.nt.arrayString;

import java.util.*;

public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);

        // Example test cases
        System.out.println("sumRange(0, 2): " + obj.sumRange(0, 2)); // Expected 1
        System.out.println("sumRange(2, 5): " + obj.sumRange(2, 5)); // Expected -1
        System.out.println("sumRange(0, 5): " + obj.sumRange(0, 5)); // Expected -3
    }
}

class NumArray {
    int[] prefix;

    public NumArray(int[] nums) {
        int n = nums.length;
        prefix = new int[n];

        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefix[right];
        }
        return prefix[right] - prefix[left - 1];
    }
}
