package com.leetcode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 *  Solution Complexity:
 *  Time: O(n)
 *  Space: O(1)
 */
public class ConvertSortedArrayToBinarySearchTree {
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) { return null; }
        return sortBTS(nums, 0, nums.length - 1);
    }
    
    private TreeNode sortBTS(int[] nums, int min, int max) {
        if (min > max) { return null; }
        int med = (min + max) / 2;
        
        TreeNode root = new TreeNode(nums[med]);
        root.left = sortBTS(nums, min, med - 1);
        root.right = sortBTS(nums, med + 1, max);
        
        return root;
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
    }
    
}
