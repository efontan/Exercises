package com.leetcode;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 *
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 */
public class SetMatrixZeroes {
    
    
    public void setZeroes(int[][] matrix) {
        if (matrix == null) return;
        
        solutionTwo(matrix);
    }
    
    /**
     * Solution One linear size complexity: 
     * Time: m x n + m x n = O(mn)
     * Size: O(m + n)
     */
    private void solutionOne(int[][] matrix) {
        boolean[] zeroRows = new boolean[matrix.length];
        boolean[] zeroCols = new boolean[matrix[0].length];
        
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    zeroRows[row] = true;
                    zeroCols[col] = true;
                }
            }
        }
        
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (zeroRows[row] || zeroCols[col]) {
                    matrix[row][col] = 0;
                }
            }
        }
    }
    
    /**
     * Solution Two constant size complexity: 
     * Time: nm + (n * m-1) + (n-1 * m) + n + m
     * Size: O(1)
     */
    private void solutionTwo(int[][] matrix) {
        
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        
        // O(nm)
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    if (row == 0) { firstRowHasZero = true; }
                    if (col == 0) { firstColHasZero = true; }
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
        
        // O(n * m-1)
        // iterate over the first row, and if the cell is equals to zero
        // set all the values in the actual column to zero (skip first row)
        for (int col = 1; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
        
        // O(n-1 * m)
        // iterate over the first col, and if the cell is equals to zero
        // set all the values in the actual row to zero (skip first col)
        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0 && row != 0) {
                for (int col = 0; col < matrix[0].length; col++) {
                    matrix[row][col] = 0;
                }
            }
        }
        
        
        // O(n)
        if (firstColHasZero) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
        
        // O(m)
        if (firstRowHasZero) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }
    }
    
}
