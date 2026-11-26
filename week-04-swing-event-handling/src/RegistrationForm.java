import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public final class RegistrationForm extends JFrame {
    private final JTextField id = new JTextField();
    private final JTextField name = new JTextField();
    private final JButton save = new JButton("Save");
    private final JLabel status = new JLabel("Complete both fields");
    public RegistrationForm() {
        super("Week 4 — Interactive registration"); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel fields = new JPanel(new GridLayout(3, 2, 8, 8));
        fields.add(new JLabel("Registration:")); fields.add(id); fields.add(new JLabel("Name:")); fields.add(name);
        fields.add(new JLabel("Programme:")); fields.add(new JComboBox<>(new String[]{"BSc Computer Science", "Diploma in IT"}));
        save.setEnabled(false); save.addActionListener(e -> status.setText("Saved " + id.getText().trim()));
        DocumentListener validation = new DocumentListener() { public void insertUpdate(DocumentEvent e){refresh();} public void removeUpdate(DocumentEvent e){refresh();} public void changedUpdate(DocumentEvent e){refresh();} };
        id.getDocument().addDocumentListener(validation); name.getDocument().addDocumentListener(validation);
        JPanel bottom = new JPanel(new BorderLayout()); bottom.add(save, BorderLayout.WEST); bottom.add(status, BorderLayout.CENTER);
        add(fields, BorderLayout.CENTER); add(bottom, BorderLayout.SOUTH); setSize(420, 180); setLocationByPlatform(true);
    }
    private void refresh() { save.setEnabled(!id.getText().trim().isEmpty() && !name.getText().trim().isEmpty()); }
    public static void main(String[] args) { SwingUtilities.invokeLater(() -> new RegistrationForm().setVisible(true)); }
}
