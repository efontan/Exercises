package main.com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *  return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * Solution complexity: (DFS recursive) 
 * Time: O(n) n = amount of nodes
 * Size: O(m) m= depth of the tree
 */
public class BinaryTreeLevelOrderTraversal {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        
        if (root == null) {
            return output;
        }
        
        traverse(output, root, 0);
        
        return output;
    }
    
    // Use the index of the array as the level of the tree
    private void traverse(List<List<Integer>> output, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        
        if (output.size() == level) {
            output.add(new ArrayList<>());
        }
        
        output.get(level).add(node.val);
        
        traverse(output, node.left, level + 1);
        traverse(output, node.right, level + 1);
    }
    
    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
    }
}

