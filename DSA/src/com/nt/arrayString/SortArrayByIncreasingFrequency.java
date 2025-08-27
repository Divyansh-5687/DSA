package com.nt.arrayString;

import java.util.*;
class Sort {
    public int[] frequencySort(int[] nums) {
        

        Map<Integer, Integer> freq = new HashMap();

        for(int x : nums){
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }


        Integer[] numsObj = new Integer[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            numsObj[i] = nums[i];
        }

        Arrays.sort(numsObj, (a, b) -> {
            if(freq.get(a).equals(freq.get(b))){
                return Integer.compare(b,a);
            }
            return Integer.compare(freq.get(a), freq.get(b));
        });

        for(int i = 0; i < nums.length ; i++){
            nums[i] = numsObj[i];
        }

        return nums;
    }
}
public class SortArrayByIncreasingFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Sort sol = new Sort();

	        System.out.println(Arrays.toString(sol.frequencySort(new int[]{1,1,2,2,2,3})));
	        // Output: [3,1,1,2,2,2]

	        System.out.println(Arrays.toString(sol.frequencySort(new int[]{2,3,1,3,2})));
	        // Output: [1,3,3,2,2]

	        System.out.println(Arrays.toString(sol.frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1})));
	        // Output: [5,-1,4,4,-6,-6,1,1,1]
	}

}
