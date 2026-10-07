import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int leftRem = 0;
        int rightRem = 0;

        // Count minimum unmatched '(' and ')' to remove
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftRem++;
            } else if (c == ')') {
                if (leftRem > 0) {
                    leftRem--;
                } else {
                    rightRem++;
                }
            }
        }

        Set<String> result = new HashSet<>();
        backtrack(s, 0, 0, 0, leftRem, rightRem, new StringBuilder(), result);
        return new ArrayList<>(result);
    }

    private void backtrack(String s, int index, int openCount, int closeCount, 
                           int leftRem, int rightRem, StringBuilder current, Set<String> result) {
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0 && openCount == closeCount) {
                result.add(current.toString());
            }
            return;
        }

        char currentChar = s.charAt(index);
        int len = current.length();

        // Option 1: Discard current character (if it is a parenthesis and can be removed)
        if (currentChar == '(' && leftRem > 0) {
            backtrack(s, index + 1, openCount, closeCount, leftRem - 1, rightRem, current, result);
        } else if (currentChar == ')' && rightRem > 0) {
            backtrack(s, index + 1, openCount, closeCount, leftRem, rightRem - 1, current, result);
        }

        // Option 2: Keep current character
        current.append(currentChar);
        if (currentChar != '(' && currentChar != ')') {
            backtrack(s, index + 1, openCount, closeCount, leftRem, rightRem, current, result);
        } else if (currentChar == '(') {
            backtrack(s, index + 1, openCount + 1, closeCount, leftRem, rightRem, current, result);
        } else if (currentChar == ')' && openCount > closeCount) { // Maintain valid prefix balance
            backtrack(s, index + 1, openCount, closeCount + 1, leftRem, rightRem, current, result);
        }
        
        // Backtrack
        current.setLength(len);
    }
}