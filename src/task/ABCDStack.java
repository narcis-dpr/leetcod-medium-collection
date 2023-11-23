package task;

import java.util.ArrayDeque;
import java.util.Deque;

public class ABCDStack {
    public static void main(String[] args) {
        System.out.println(solution("ACBDACBD"));
    }

    public static String solution(String S) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : S.toCharArray()) {
            if (!stack.isEmpty()) {
                char top = stack.peek();
                if ((ch == 'B' && top == 'A') ||
                        (ch == 'A' && top == 'B') ||
                        (ch == 'D' && top == 'C') || (ch == 'C' && top == 'D')) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(ch);
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

}
