package com.leetcode;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Solution complexity: 
Time: O(n)
Size: O(n)
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    
    public boolean isValid(String s) {
        Stack<Character> openBrackets = new Stack<>();
        
        Map<Character,Character> validBracketsMap = new HashMap<>();
        validBracketsMap.put('(', ')');
        validBracketsMap.put('{', '}');
        validBracketsMap.put('[', ']');
                
        for (int i=0; i<s.length(); i++) {
            Character currentChar = s.charAt(i);
            
            if (validBracketsMap.keySet().contains(currentChar)) {
                openBrackets.push(currentChar);
            } else if (validBracketsMap.values().contains(currentChar)) {
                if (openBrackets.isEmpty() || !validBracketsMap.get(openBrackets.pop()).equals(currentChar)) {
                    return false;
                }
            }            
        }        
        return openBrackets.isEmpty();
    }
}
