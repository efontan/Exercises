package main.com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * 
 * Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 
 * Output: [3, 14.5, 11]
 * 
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * 
 * Note: The range of node's value is in the range of 32-bit signed integer.
 *
 * Solution complexity: 
 * Time: O(n)
 * Size: O(n)
 */
public class AverageTree {
    
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> output = new ArrayList<>();
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        
        while (!nodes.isEmpty()) {
            Queue<TreeNode> level = new ArrayDeque<>();
            double sum = 0;
            int count = 0;
            
            while (!nodes.isEmpty()) {
                TreeNode node = nodes.remove();
                sum += node.getVal();
                count++;
                
                if (node.getLeft() != null) {
                    level.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    level.add(node.getRight());
                }
            }
            
            nodes = level;
            output.add(Double.valueOf(sum) / Double.valueOf(count));
        }
        
        return output;
    }
    
    public class TreeNode {
        double val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
        
        public double getVal() {
            return val;
        }
        
        public void setVal(double val) {
            this.val = val;
        }
        
        public TreeNode getLeft() {
            return left;
        }
        
        public void setLeft(TreeNode left) {
            this.left = left;
        }
        
        public TreeNode getRight() {
            return right;
        }
        
        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
    
}

