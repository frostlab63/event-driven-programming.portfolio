package portfolio.capstone;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public final class MainController {
    @FXML private StackPane content;
    @FXML private Label heartbeat;
    private StudentController studentController;

    @FXML
    private void initialize() {
        showStudents();
    }

    @FXML
    private void showStudents() {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("student-view.fxml"));
            content.getChildren().clear();
            content.getChildren().add(loader.load());
            studentController = loader.getController();
        } catch (Exception exception) {
            heartbeat.setText("View load failed: " + exception.getMessage());
        }
    }

    public void markRefresh() {
        heartbeat.setText("Auto-refresh completed");
        if (studentController != null) {
            studentController.reload();
        }
    }
}