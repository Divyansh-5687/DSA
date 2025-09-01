package com.nt.arrayString;

import java.util.*;



class Self {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int prodl = 1;
        int prodr = 1;

        // Step 1: store right products
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = prodr;
            prodr = prodr * nums[i];
        }

        // Step 2: multiply with left products
        for (int i = 0; i < n; i++) {
            ans[i] = ans[i] * prodl;
            prodl = prodl * nums[i];
        }
        return ans;
    }

  
}


public class ProductExceptSelf {
	  // Main method to test
    public static void main(String[] args) {
        Self sol = new Self();
        int[] nums = {1, 2, 3, 4};
        int[] result = sol.productExceptSelf(nums);

        // Print result
        System.out.println(Arrays.toString(result));
    }
}
