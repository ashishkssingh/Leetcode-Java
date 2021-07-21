package Algorithms.ValidParenthesis;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/

import java.util.HashMap;
import java.util.Stack;

class ValidParenthesis {
    public boolean isValid1(String s) {

        int length = s.length();
        if (length == 0)
            return true;
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> end_dict = new HashMap<Character, Character>() {
            {
                put('(', ')');
                put('{', '}');
                put('[', ']');
            }
        };
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (end_dict.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char previous = stack.pop();
                if (end_dict.get(previous) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean leetCodeFastest(String s) {
        int i = -1;
        int j = 0;
        char[] a = s.toCharArray();

        while (j < s.length()) {
            if (i == -1 || !match(a, i, j)) {
                a[++i] = a[j++];
            } else {
                i--;
                j++;
            }
        }

        return i == -1;
    }

    boolean match(char[] a, int i, int j) {
        if ((a[i] == '(' && a[j] == ')') || (a[i] == '{' && a[j] == '}') || (a[i] == '[' && a[j] == ']')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidParenthesis valid = new ValidParenthesis();
        System.out.println(valid.isValid1("{[]}"));
        System.out.println(valid.leetCodeFastest("()[]{}"));
    }
}