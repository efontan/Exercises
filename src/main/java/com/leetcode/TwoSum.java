package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if (numbers.containsKey(remainder)) {
                return new int[]{numbers.get(remainder), i};
            }
            numbers.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] output = twoSum(new int[]{2, 7, 11, 15}, 9);

        System.out.print("[");
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i]);
            System.out.print((i != output.length - 1) ? "," : "");
        }
        System.out.print("]");
    }
}
