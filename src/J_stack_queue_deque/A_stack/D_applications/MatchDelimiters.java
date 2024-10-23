package J_stack_queue_deque.A_stack.D_applications;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * A classic stack application.
 */
public class MatchDelimiters {
    public static void main(String[] args) {
        String[] valid = {
                "()(()){([()])}",
                "( ) ( ( ) ) {( [ ( )  ] ) } ",
                "(3) (3 + (4 - 5) ) {( [ ( )  ] ) } ",
                "((()(()){([()])}))",
                "[(5+x)-(y+z)]"
        };

        String[] invalid = {
                ")(()){([()])}",
                "({[])}",
                "([]"
        };

        for (String s : valid) {
            if (!isMatched(s)) {
                System.out.println("Error evaluating valid: " + s);
            }
        }

        for (String s : invalid) {
            if (isMatched(s)) {
                System.out.println("Error evaluating invalid: " + s);
            }
        }
    }

    /**
     * Determines if the delimiters in the given expression are properly matched.
     */
    public static boolean isMatched(String expression) {
        List<Character> openingDelimiters = List.of('(', '{', '[');
        List<Character> closingDelimiters = List.of(')', '}', ']');
        Deque<Character> stack = new ArrayDeque<>(); // or: new LinkedList<>();

        for (char c : expression.toCharArray()) {
            if (openingDelimiters.contains(c)) { // c is a left delimiter
                stack.push(c);
            } else if (closingDelimiters.contains(c)) { // c is a right delimiter
                if (stack.isEmpty()) {
                    return false; // nothing to match with
                }

                if (closingDelimiters.indexOf(c) != openingDelimiters.indexOf(stack.pop())) {
                    return false; // mismatched delimiter
                }
            }
        }

        return stack.isEmpty(); // were all opening delimiters matched?
    }
}
