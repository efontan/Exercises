package com.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: https://leetcode.com/explore/interview/card/top-interview-questions-medium/112/design/812/
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your 
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be 
 * serialized to a string and this string can be deserialized to the original tree structure.
 *
 * For example, you may serialize the following tree
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * as "[1,2,3,null,null,4,5]"
 *
 */

public class SerializeAndDeserializeBinaryTree {
    
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        List<Integer> values = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node != null) {
                values.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
                
            } else {
                
                values.add(null);
            }
        }
        
        // build output string
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        Iterator<Integer> iter = values.iterator();
        while (iter.hasNext()) {
            sb.append(String.valueOf(iter.next()));
            if (iter.hasNext()) {
                sb.append(",");
            }
        }
        sb.append("]");
        
        return sb.toString();
    }
    
    //     Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
    
        // parse string
        data = data.replace("[","");
        data = data.replace("]","");
        String[] values = data.split(",");
        
        if (values.length == 0) {
            return null;
        }
    
        // [1,2,3,null,null,4,5,null,null,null,null]
        Queue<String> queue = new LinkedList<>();
        for (String value : values) {
            queue.offer(value);
        }
        
        return buildTree(queue);
    }
    
    private static TreeNode buildTree(Queue<String> queue) {
        String value = queue.poll();
    
        if (value.equals("null")) { 
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(value));
            root.left = buildTree(queue);
            root.right = buildTree(queue);
            return root;
        }
    }
    
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
    }
    
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        System.out.println(serialize(root));
    
        TreeNode deserialize = deserialize("[1,2,3,null,null,4,5,null,null,null,null]");
    
        deserialize(serialize(root));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
