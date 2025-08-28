package com.nt.arrayString;

import java.util.*;

class KfrequentElement{
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: MinHeap to store top k frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove least frequent
            }
        }

        // Step 3: Build the result
        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll().getKey();
        }

        return result;
    }
}
public class TopKfrequentElement {
    public static void main(String[] args) {
    	KfrequentElement sol = new KfrequentElement();

        // Example input
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] result = sol.topKFrequent(nums, k);

        // Print result
        System.out.print("Top " + k + " frequent elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
