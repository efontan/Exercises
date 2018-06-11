package com.leetcode;

/**
 * 3Sum Closest
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 */
public class ThreeSumClosest {
    
    public static int threeSumClosest(int[] nums, int target) {
        
        if (nums.length < 3) {
            throw new IllegalArgumentException("Size must be at least 3");
        } else if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        
        int minSum = Integer.MAX_VALUE;
        int minDistance = Integer.MAX_VALUE;
        int sum;
        
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    
                    if (sum == target) {
                        minSum = target;
                    } else if (distance(sum, target) < minDistance) {
                        minSum = sum;
                        minDistance = distance(sum, target); 
                    }
    
                }
            }
        }
        
        return minSum;
    }
    
    private static int distance(int number, int target) {
        return Math.abs(number - target);
    }
    
    public static void main(String[] args) {
        int[] input = {1,1,1,0};
        int answer = threeSumClosest(input, -100);
        System.out.println(answer);
    }
}
