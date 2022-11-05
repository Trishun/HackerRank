package eu.ztsh.training.hackerrank.datastructures.stack;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Java Stack task.
 * source: https://www.hackerrank.com/challenges/java-stack
 */
public class Solution {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            var stack = new Stack<Character>();
            var line = scanner.next();
            for (char input : line.toCharArray()) {
                if (stack.empty()) {
                    stack.push(input);
                    continue;
                }
                char head = stack.peek();
                if (closingChars.getOrDefault(input, '0').equals(head)) {
                    stack.pop();
                } else {
                    stack.push(input);
                }
            }
            System.out.println(stack.empty());
        }

    }

    private static final Map<Character, Character> closingChars = Map.of(
            ']', '[',
            '}', '{',
            ')', '('
    );

}
