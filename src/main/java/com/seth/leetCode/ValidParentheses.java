package com.seth.leetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        Set<Character> frontParentheses = new HashSet<>();
        frontParentheses.add('(');
        frontParentheses.add('[');
        frontParentheses.add('{');
        Set<Character> backParentheses = new HashSet<>();
        backParentheses.add(')');
        backParentheses.add(']');
        backParentheses.add('}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(!frontParentheses.contains(s.charAt(i)) && !backParentheses.contains(s.charAt(i))) return false;
            else if(frontParentheses.contains(s.charAt(i))) stack.push(s.charAt(i));
            else if(stack.empty()) return false;
            else if (s.charAt(i) == ']' && stack.peek() != '[') return false;
            else if (s.charAt(i) == ')' && stack.peek() != '(') return false;
            else if (s.charAt(i) == '}' && stack.peek() != '{') return false;
            else stack.pop();
        }
        return stack.empty();
    }
}
