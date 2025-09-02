package com.nt.arrayString;

import java.util.*;

class OddSum {
    public int numOfSubarrays(int[] arr) {
        int mod=1000000007;
        int even=1;
        int odd=0;
        int prefix=0;
        int res=0;
        for(int num:arr){
            prefix+=num;
            if(prefix % 2 == 0){
                res+=odd;
                even++;
            }
            else{
                res+=even;
                odd++;
            }
            res=res%mod;
        }
        return res;
    }
}

public class SubarraysWithOddSum {
	 public static void main(String[] args) {
	        OddSum obj = new OddSum();

	        int[] arr1 = {1, 3, 5};
	        int[] arr2 = {2, 4, 6};
	        int[] arr3 = {1, 2, 3, 4};

	        System.out.println("Number of odd-sum subarrays (arr1): " + obj.numOfSubarrays(arr1)); // Expected 4
	        System.out.println("Number of odd-sum subarrays (arr2): " + obj.numOfSubarrays(arr2)); // Expected 0
	        System.out.println("Number of odd-sum subarrays (arr3): " + obj.numOfSubarrays(arr3)); // Expected 6
	    }
}
