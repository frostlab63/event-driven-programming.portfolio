package procedural;

import java.util.Scanner;

/** A deliberately linear calculator for comparison with the Swing version. */
public final class ProceduralCalculator {
    private ProceduralCalculator() { }

    public static double calculate(double left, String operator, double right) {
        return switch (operator) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            case "/" -> {
                if (right == 0) throw new IllegalArgumentException("Cannot divide by zero");
                yield left / right;
            }
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("First number: ");
            double left = scanner.nextDouble();
            System.out.print("Operator (+, -, *, /): ");
            String operator = scanner.next();
            System.out.print("Second number: ");
            double right = scanner.nextDouble();
            System.out.println("Result: " + calculate(left, operator, right));
        }
    }
}
