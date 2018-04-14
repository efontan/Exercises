package com.leetcode;

/**
 * Problem: https://leetcode.com/problems/binary-tree-pruning/description/
 *
 * Description: We are given the head node root of a binary tree, where additionally every node's value is either a
 * 0 or a 1. Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 * (Recall that the subtree of a node X is X, plus every node that is a descendant of X.)
 *
 * Solution:
 * Iterate the tree and asign to each child the pruned subtree. If the node hasn't childs and the value is zero,
 * removes the node from the tree returning a null reference.
 *
 * Solution complexity:
 * Time: O(n) n = nodes - 1
 * Size: O(n)
 */

class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}