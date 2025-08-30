package com.nt.arrayString;

import java.util.*;

class Divisible {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int num : nums) total += num;
        
        int remainder = (int)(total % p);
        if (remainder == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // prefix sum before starting
        long prefix = 0;
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            int target = (int)((prefix - remainder + p) % p);

            if (map.containsKey(target)) {
                res = Math.min(res, i - map.get(target));
            }

            map.put((int)prefix, i);
        }

        return res == nums.length ? -1 : res;
    }
}
public class SumDivisibleByP {
    public static void main(String[] args) {
    	Divisible sol = new Divisible();

        int[] nums1 = {3, 1, 4, 2};
        int p1 = 6;
        System.out.println(sol.minSubarray(nums1, p1)); // Output: 1

        int[] nums2 = {6, 3, 5, 2};
        int p2 = 9;
        System.out.println(sol.minSubarray(nums2, p2)); // Output: 2

        int[] nums3 = {1, 2, 3};
        int p3 = 3;
        System.out.println(sol.minSubarray(nums3, p3)); // Output: 0
    }
}
