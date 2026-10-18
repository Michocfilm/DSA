package pack;

import java.util.StringTokenizer;

public class MyShunting_680449 {
    private static int order(String c) {
        return switch (c) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }
    public static String infixToPostfix(String infixString) {
        MyQueueL_680449<String> queue = new MyQueueL_680449<>();
        MyStack_680449<String> stack = new MyStack_680449<>();

        StringTokenizer st = new StringTokenizer(infixString);
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (MyRPN_680449.isNumeric(t)) {
                queue.enqueue(t);
            } else if (t.equals("(")) {
                stack.push(t);
            } else if (t.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    queue.enqueue(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && !stack.peek().equals("(")
                        && order(stack.peek()) >= order(t)) {
                    queue.enqueue(stack.pop());
                }
                stack.push(t);
            }
        }

        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (String token : queue) {
            sb.append(token).append(" ");
        }
        return sb.toString().trim();
    }    
}