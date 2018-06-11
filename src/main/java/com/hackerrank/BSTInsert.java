package com.hackerrank;

/**
 * Binary Search Tree Insertion
 * 
 * Problem: https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
 * 
 * You are given a pointer to the root of a binary search tree and a value to be inserted into the tree. 
 * Insert this value into its appropriate position in the binary search tree and return the root of the 
 * updated binary tree.
 */
public class BSTInsert {

    class Node {
        int data;
        Node left;
        Node right;
    }

    public Node insert(Node root, int value) {
        if (root == null) {
            root = new Node();
            root.data = value;
        } else if (root.data < value) {
            root.right = insert(root.right, value);
        } else {
            root.left = insert(root.left, value);
        }

        return root;
    }



}

