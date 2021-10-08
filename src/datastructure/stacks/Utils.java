package datastructure.stacks;

import java.util.Stack;

public class Utils {

    public static String reverse(String str) {
        if (str == null) throw new IllegalArgumentException();
        StringBuilder reversed = new StringBuilder();

        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        while (!stack.empty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    public static boolean isBalanced(String input) {
        if (input == null) throw new IllegalArgumentException();

        java.util.Stack<Character> stack = new Stack<>();

        for (char current : input.toCharArray()) {
            if (isLeftBrackets(current)) {
                stack.push(current);
                continue;
            }

            if (stack.isEmpty())
                return false;

            char top;
            switch (current) {
                case ')':
                    top = stack.pop();
                    if (top == '{' || top == '[')
                        return false;
                    break;
                case '}':
                    top = stack.pop();
                    if (top == '(' || top == '[')
                        return false;
                    break;
                case ']':
                    top = stack.pop();
                    if (top == '(' || top == '{')
                        return false;
                    break;
            }
        }

        return stack.isEmpty();
    }

    private static boolean isLeftBrackets(char input) {
        return input == '(' || input == '[' || input == '{' || input == '<';
    }

    private static boolean isRightBrackets(char input) {
        return input == ')' || input == ']' || input == '}' || input == '>';
    }

    private static boolean isBracketMatch(char left, char right) {
        return (right == ')' && left != '(' );
    }
}
