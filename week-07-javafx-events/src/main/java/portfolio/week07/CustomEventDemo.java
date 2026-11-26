package portfolio.week07;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public final class CustomEventDemo extends Application {
    @Override
    public void start(Stage stage) {
        Label output = new Label("No order yet");
        Button place = new Button("Place order");
        place.addEventHandler(CustomEvent.ORDER_PLACED,
                event -> output.setText("Received order event: " + event.orderId()));
        place.setOnAction(event -> Event.fireEvent(place, new CustomEvent("ORD-1001")));
        VBox root = new VBox(12, place, output);
        root.setPadding(new javafx.geometry.Insets(18));
        stage.setScene(new Scene(root, 360, 150));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
