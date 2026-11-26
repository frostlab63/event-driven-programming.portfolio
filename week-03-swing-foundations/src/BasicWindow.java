import javax.swing.*;

public final class BasicWindow extends JFrame {
    public BasicWindow() { super("Week 3 — Basic JFrame"); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setSize(320, 180); add(new JLabel("Created on the EDT", SwingConstants.CENTER)); }
    public static void main(String[] args) { SwingUtilities.invokeLater(() -> new BasicWindow().setVisible(true)); }
}
