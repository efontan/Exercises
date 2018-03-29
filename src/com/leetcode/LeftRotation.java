package com.leetcode;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
A left rotation operation on an array of size n shifts each of the array's elements 1 unit to the left. For example, if 2 left rotations are performed on array [1, 2, 3, 4, 5], then the array would become [3, 4, 5, 1, 2].

Given an array of n integers and a number, d, perform d left rotations on the array. Then print the updated array as a single line of space-separated integers.

Input Format

The first line contains two space-separated integers denoting the respective values of n (the number of integers) and n (the number of left rotations you must perform). 
The second line contains n space-separated integers describing the respective elements of the array's initial state.

Constraints
1 <= n <= 10^5
1 <= d <= n

Output Format

Print a single line of n space-separated integers denoting the final state of the array after performing d left rotations.

Sample Input

5 4
1 2 3 4 5
Sample Output

5 1 2 3 4

*/

0
1

public class LeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int i=0; i < n; i++){
            a[i] = in.nextInt();    
        }
        
        int[] output = rotate(a, n, d);

        for (int i=0;i<n;i++)
            System.out.print(output[i]+" ");
    } 

    /*
	Here we have that d < n, so we can add d to index i and then sustract n
	 to get the index of the rotated array. 
    */
    public static int[] rotate(int[] array, int size, int distance) {
    	int[] rotated = new int [size];
        if (size==1) { 
            rotated = array;
        } else {
            for (int i=0; i < size; i++) {
                int rotatedIndex = (i - distance + size) % size;
                rotated[rotatedIndex] = array[i];
            }
        }
        return rotated;
    } 
}
