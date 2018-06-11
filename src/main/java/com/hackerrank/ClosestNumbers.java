package com.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Given a list of unsorted integers, A={a1,a2,...,aN}, can you find the pair of elements that have the smallest absolute 
 * difference between them? If there are multiple pairs, find them all.
 *
 * Input Format 
 * The first line of input contains a single integer, N, representing the length of array A. In the second line, there are N 
 * space-separated integers, a1,a2,...,aN, representing the elements of array A.
 *
 * Output Format 
 * Output the pairs of elements with the smallest difference. If there are multiple pairs, output all of them in ascending 
 * order, all on the same line (consecutively) with just a single space between each pair of numbers. If there's a number 
 * which lies in two pair, print it two times (see the sample case #3 for explanation).
 *
 * Constraints
 * 2 <= N <= 200000
 * -10 ^ 7 <= ai <= 10 ^ 7
 * ai != aj, where 1 <= i < j <= N
 *
 * Sample Input #1
 *
 * 10
 * -20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854
 */

public class ClosestNumbers {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        
        List<Integer> input = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            input.add(scanner.nextInt());
        }
        
        List<String> output = closestNumbers(input);
        
        System.out.print(output.stream().collect(Collectors.joining(" ")));
        scanner.close();
    }
    
    private static List<String> closestNumbers(List<Integer> input) {
        List<String> output = new ArrayList<>();
        Collections.sort(input);
    
        int distance;
        int minimunDistance = Integer.MAX_VALUE;
    
        for (int i = 0; i < input.size() - 1; i++) {
            distance =  Math.abs(Math.abs(input.get(i)) - Math.abs(input.get(i + 1)));
        
            if (distance < minimunDistance) {
                minimunDistance = distance;
                output = new ArrayList<>();
                output.add(format(input.get(i), input.get(i + 1)));
            } else if (distance == minimunDistance) {
                output.add(format(input.get(i), input.get(i + 1)));
            }
        }
    
        return output;
    }
    
    private static String format(int x, int y) {
        return x + " " + y;
    }
    
}


