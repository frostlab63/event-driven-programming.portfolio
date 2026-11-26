import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public final class ComponentModelDemo extends JFrame {
    public ComponentModelDemo() {
        super("Week 5 — Component models"); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultTableModel model = new DefaultTableModel(new Object[][]{{"S101","Amina",3.7},{"S102","Brian",3.1}}, new String[]{"Reg","Name","GPA"});
        JTable table = new JTable(model);
        JList<String> list = new JList<>(new String[]{"Online", "Offline", "Away"});
        JTree tree = new JTree();
        JTabbedPane tabs = new JTabbedPane(); tabs.addTab("Table", new JScrollPane(table)); tabs.addTab("List", new JScrollPane(list)); tabs.addTab("Tree", new JScrollPane(tree));
        add(tabs); setSize(560, 320);
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(() -> new ComponentModelDemo().setVisible(true)); }
}
