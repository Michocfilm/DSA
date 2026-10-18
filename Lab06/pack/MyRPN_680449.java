package pack;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class MyRPN_680449 {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    public static boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;
        return pattern.matcher(strNum).matches();
    }
    public static double computeRPN(String rpn) {
        MyStack_680449<Double> stack = new MyStack_680449<>();
        StringTokenizer st = new StringTokenizer(rpn);
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (isNumeric(t)) {
                stack.push(Double.parseDouble(t));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                double result = switch (t) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default -> throw new RuntimeException("Unknown operator: " + t);
                };
                stack.push(result);
            }
        } //while
        return stack.pop();
    }    
}