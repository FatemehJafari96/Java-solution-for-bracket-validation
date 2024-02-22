package src;

import java.util.Stack;

class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : s.toCharArray()) {
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char openBracket = stack.pop();
                if ((bracket == ')' && openBracket != '(') ||
                        (bracket == '}' && openBracket != '{') ||
                        (bracket == ']' && openBracket != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    public static void main(String[] args) {
        // Example usage
        String example1 = "()";
        String example2 = "()[]{}";
        String example3 = "(]";

        System.out.println("Example 1: " + isValid(example1));
        System.out.println("Example 2: " + isValid(example2));
        System.out.println("Example 3: " + isValid(example3));
    }
}
