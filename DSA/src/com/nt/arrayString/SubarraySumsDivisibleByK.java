package com.nt.arrayString;

import java.util.*;

class Subarray {
    public int subarraysDivByK(int[] nums, int k) {
        int map[]=new int[k];
        map[0]=1;
        int sum=0;
        int res=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int mod=sum%k;
            if(mod<0){
                mod=mod%k+k;
            }
            res+=map[mod];
            map[mod]++;
        }
        return res;
    }
    
}

public class SubarraySumsDivisibleByK {
	  // main function to test
    public static void main(String[] args) {
        Subarray obj = new Subarray();

        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;

        int result = obj.subarraysDivByK(nums, k);
        System.out.println("Number of subarrays divisible by " + k + " = " + result);
    }
}
