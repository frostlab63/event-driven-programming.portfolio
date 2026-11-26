import javax.swing.*;
import java.awt.*;

public final class StudentPortal extends JFrame {
    public StudentPortal() {
        super("Week 3 — Student Portal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(12, 12));
        add(new JLabel("Student Portal", SwingConstants.CENTER), BorderLayout.NORTH);
        JPanel form = new JPanel(new GridLayout(4, 2, 8, 8));
        form.add(new JLabel("Registration:")); form.add(new JTextField("S101"));
        form.add(new JLabel("Name:")); form.add(new JTextField("Amina Otieno"));
        form.add(new JLabel("Programme:")); form.add(new JComboBox<>(new String[]{"BSc Computer Science", "Diploma in IT"}));
        form.add(new JLabel("Status:")); form.add(new JLabel("Active"));
        add(form, BorderLayout.CENTER);
        add(new JLabel("Week 3: layout and EDT practice"), BorderLayout.SOUTH);
        setSize(420, 240); setLocationByPlatform(true);
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(() -> new StudentPortal().setVisible(true)); }
}
