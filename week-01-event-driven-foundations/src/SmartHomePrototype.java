import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

/** Week 1 design prototype: three sources, three handlers, one visible state log. */
public final class SmartHomePrototype extends JFrame {
    private final JLabel status = new JLabel("System ready");
    private final JTextArea log = new JTextArea(10, 32);
    private final JToggleButton lights = new JToggleButton("Lights: OFF");
    private final JToggleButton security = new JToggleButton("Security: OFF");

    public SmartHomePrototype() {
        super("Week 1 — Smart Home Controller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        log.setEditable(false);
        lights.addActionListener(e -> toggleLights());
        security.addActionListener(e -> toggleSecurity());
        JButton door = new JButton("Simulate door sensor");
        door.addActionListener(e -> doorOpened());
        JPanel controls = new JPanel(new GridLayout(1, 3, 6, 6));
        controls.add(lights);
        controls.add(security);
        controls.add(door);
        add(status, BorderLayout.NORTH);
        add(new JScrollPane(log), BorderLayout.CENTER);
        add(controls, BorderLayout.SOUTH);
        setSize(520, 360);
        setLocationByPlatform(true);
    }

    private void toggleLights() {
        lights.setText("Lights: " + (lights.isSelected() ? "ON" : "OFF"));
        record("Light state changed");
    }

    private void toggleSecurity() {
        security.setText("Security: " + (security.isSelected() ? "ARMED" : "OFF"));
        record("Security state changed");
    }

    private void doorOpened() {
        status.setText(security.isSelected() ? "ALARM ACTIVE" : "Door opened");
        record(security.isSelected() ? "Alarm raised by door event" : "Door sensor event");
    }

    private void record(String message) {
        log.append("[" + LocalTime.now().withNano(0) + "] " + message + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SmartHomePrototype().setVisible(true));
    }
}