import javax.swing.*;
import java.awt.*;

/** A deliberately small calculator used to show the event path, not polish. */
public final class EventDrivenCalculator extends JFrame {
    private final JTextField display = new JTextField("0");
    private double firstOperand;
    private String operator;
    private boolean startNewNumber = true;

    public EventDrivenCalculator() {
        super("Week 1 — Event-driven calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);
        JPanel keys = new JPanel(new GridLayout(4, 4, 4, 4));
        for (String key : new String[]{"7","8","9","/","4","5","6","*","1","2","3","-","0","C","=","+"}) {
            JButton button = new JButton(key);
            button.addActionListener(event -> handle(event.getActionCommand()));
            keys.add(button);
        }
        add(keys, BorderLayout.CENTER);
        setSize(280, 320);
        setLocationByPlatform(true);
    }

    private void handle(String command) {
        if (command.matches("\\d")) {
            display.setText(startNewNumber ? command : display.getText() + command);
            startNewNumber = false;
            return;
        }
        if (command.equals("C")) { display.setText("0"); firstOperand = 0; operator = null; startNewNumber = true; return; }
        if (command.matches("[+\\-*/]")) { firstOperand = Double.parseDouble(display.getText()); operator = command; startNewNumber = true; return; }
        if (command.equals("=") && operator != null) {
            double second = Double.parseDouble(display.getText());
            if (operator.equals("/") && second == 0) display.setText("Error");
            else display.setText(Double.toString(calculate(second)));
            startNewNumber = true;
        }
    }

    private double calculate(double second) {
        return switch (operator) {
            case "+" -> firstOperand + second;
            case "-" -> firstOperand - second;
            case "*" -> firstOperand * second;
            case "/" -> firstOperand / second;
            default -> throw new IllegalStateException("Unknown operator: " + operator);
        };
    }

    public static void main(String[] args) { SwingUtilities.invokeLater(() -> new EventDrivenCalculator().setVisible(true)); }
}
