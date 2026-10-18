import java.util.*;
public class Lab05a_680449 {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Lab05a_680449 sol = new Lab05a_680449();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input(s): ");
        String s = scanner.nextLine();
        String result = sol.removeDuplicates(s);
        System.out.println("Output: " + result);
        scanner.close();
    }
}
