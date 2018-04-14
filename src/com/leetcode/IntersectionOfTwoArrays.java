package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 *
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 * Solution complexity:
 * Time: O(n+m) (size of each array)
 * Size: O(n)
 * (*) set.contains(Elem) is O(1) time because reads from a HashMap keyset
 */

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numbers = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            numbers.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (numbers.contains(nums2[i])) {
                ans.add(nums2[i]);
                numbers.remove(nums2[i]);
            }
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }

}