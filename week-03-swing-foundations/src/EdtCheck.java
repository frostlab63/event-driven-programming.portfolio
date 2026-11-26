import javax.swing.*;

public final class EdtCheck {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> System.out.println("GUI creation thread: " + Thread.currentThread().getName()));
    }
}
