package com.hackerrank;

import java.util.Scanner;

/**
 * Problem: https://www.hackerrank.com/challenges/mini-max-sum/problem
 *
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four
 * of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated
 * long integers.
 *
 * Solution: The minimun total is the result of the addition of all the elements excluding que largest. And the maximun
 * total is the result of addition of all the elements excluding the smallest. So, we need to rack the minimun and
 * maximun value, and substract them from the total to get each result.
 *
 * Time: O(n)
 * Space: O(1)
 */
public class MiniMaxSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i].trim());
            arr[i] = arrItem;
        }

        miniMaxSum(arr);
    }

    static void miniMaxSum(int[] arr) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        long total = 0;

        for (int elem : arr) {
            if (elem > max) {
                max = elem;
            }

            if (elem < min) {
                min = elem;
            }

            total += elem;
        }

        // Print min and max
        System.out.print((total - max) + " " + (total - min));
    }

}
