package main.com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: https://leetcode.com/problems/linked-list-components/description/
 * <p>
 * Solution complexity:
 * Time: O(n)
 * Space: O(1)
 */
public class LinkedListComponents {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public int numComponents(ListNode head, int[] G) {
        if(head == null) return 0;

        Set<Integer> subset = new HashSet<>();
        for (int value : G) {
            subset.add(value);
        }

        int frequency = 0;

        while (head != null) {
            boolean consecutive = false;

            while (head != null && subset.contains(head.val)) {
                consecutive = true;
                head = head.next;
            }

            if (consecutive) {
                frequency++;
            }

            if (head != null) {
                head = head.next;
            }
        }

        return frequency;
    }
}
