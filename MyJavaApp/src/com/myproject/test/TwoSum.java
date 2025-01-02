package com.myproject.test;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // Map to store numbers and their indices
        Map<Integer, Integer> numIndices = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement
            
            int complement = target - nums[i];
            System.out.println(complement);
            // Check if the complement exists in the map
            if (numIndices.containsKey(complement)) {
                // Return the indices of the two numbers
            	 System.out.println("Hello" + numIndices.get(complement) + i);
                return new int[] { numIndices.get(complement), i };
            }
            
            // Store the current number and its index in the map
            numIndices.put(nums[i], i);
        }
        
        // If no solution is found, throw an exception
        throw new IllegalArgumentException("No two sum solution exists for the given input.");
    }

    public static void main(String[] args) {
        int[] nums = {9, 7, 8, 2, 4, 3, 5, 3, 7, 3, 11, 15};
        int target = 9;

        try {
            int[] result = twoSum(nums, target);
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
