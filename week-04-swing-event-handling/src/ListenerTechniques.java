import javax.swing.*;
import java.awt.*;

public final class ListenerTechniques extends JFrame implements java.awt.event.ActionListener {
    private final JLabel result = new JLabel("Choose a listener style");
    public ListenerTechniques() {
        super("Week 4 — Listener techniques");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton named = new JButton("Named class");
        JButton lambda = new JButton("Lambda");
        JButton reference = new JButton("Method reference");
        named.addActionListener(this);
        lambda.addActionListener(e -> result.setText("Lambda handled: " + e.getActionCommand()));
        reference.addActionListener(this::handleReference);
        JPanel row = new JPanel(); row.add(named); row.add(lambda); row.add(reference);
        add(row, BorderLayout.CENTER); add(result, BorderLayout.SOUTH); setSize(460, 160);
    }
    @Override public void actionPerformed(java.awt.event.ActionEvent e) { result.setText("Named class handled: " + e.getActionCommand()); }
    private void handleReference(java.awt.event.ActionEvent e) { result.setText("Method reference handled: " + e.getActionCommand()); }
    public static void main(String[] args) { SwingUtilities.invokeLater(() -> new ListenerTechniques().setVisible(true)); }
}
