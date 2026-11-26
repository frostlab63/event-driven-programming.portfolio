import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public final class FileExplorer extends JFrame {
    public FileExplorer() {
        super("Week 5 — File Explorer"); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("projects");
        DefaultMutableTreeNode java = new DefaultMutableTreeNode("java"); java.add(new DefaultMutableTreeNode("EventDemo.java")); java.add(new DefaultMutableTreeNode("WeatherStation.java")); root.add(java);
        JTree tree = new JTree(root);
        JList<String> recent = new JList<>(new String[]{"README.md", "pom.xml", "schema.sql"});
        recent.setCellRenderer(new DefaultListCellRenderer(){ public Component getListCellRendererComponent(JList<?> l,Object v,int i,boolean s,boolean f){ JLabel x=(JLabel)super.getListCellRendererComponent(l,v,i,s,f); x.setText("• " + v); return x; }});
        JTable table = new JTable(new Object[][]{{"EventDemo.java","Java","2 KB"},{"README.md","Markdown","4 KB"}}, new String[]{"Name","Type","Size"});
        JTabbedPane tabs = new JTabbedPane(); tabs.addTab("Files", new JScrollPane(table)); tabs.addTab("Recent", new JScrollPane(recent));
        add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(tree), tabs)); setSize(640, 360); setLocationByPlatform(true);
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(() -> new FileExplorer().setVisible(true)); }
}
