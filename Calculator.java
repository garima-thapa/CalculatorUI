public class Calculator {
    public static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+' -> {
                return num1 + num2;
            }
            case '-' -> { 
                return num1 - num2;
            }
            case '*' -> {
                return num1 * num2;
            }
            case '/' -> {
                if (num2 == 0) {
                    return Double.NaN; // "Not a Number" if divide by zero
                }
                return num1 / num2;
            } 
            default -> {
                return Double.NaN; // invalid operator
            }
        }
    }
}
