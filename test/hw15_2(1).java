import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class hw15_2 extends Application {
    private static final double MOVE_DISTANCE = 5;

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPrefSize(300, 150);

        Circle circle = new Circle(150, 75, 10, Color.WHITE);
        circle.setStroke(Color.BLACK);

        Button leftButton = new Button("Left");
        Button rightButton = new Button("Right");
        Button upButton = new Button("Up");
        Button downButton = new Button("Down");

        leftButton.setOnAction(e -> {
            if (circle.getCenterX() - circle.getRadius() - MOVE_DISTANCE > 0) {
                circle.setCenterX(circle.getCenterX() - MOVE_DISTANCE);
            }
        });

        rightButton.setOnAction(e -> {
            if (circle.getCenterX() + circle.getRadius() + MOVE_DISTANCE < pane.getWidth()) {
                circle.setCenterX(circle.getCenterX() + MOVE_DISTANCE);
            }
        });

        upButton.setOnAction(e -> {
            if (circle.getCenterY() - circle.getRadius() - MOVE_DISTANCE > 0) {
                circle.setCenterY(circle.getCenterY() - MOVE_DISTANCE);
            }
        });

        downButton.setOnAction(e -> {
            if (circle.getCenterY() + circle.getRadius() + MOVE_DISTANCE < pane.getHeight()) {
                circle.setCenterY(circle.getCenterY() + MOVE_DISTANCE);
            }
        });

        HBox buttonContainer = new HBox(10, leftButton, rightButton, upButton, downButton);
        buttonContainer.setStyle("-fx-alignment: center;");

        VBox root = new VBox(10, pane, buttonContainer);
        root.setStyle("-fx-alignment: center;");

        pane.getChildren().add(circle);

        Scene scene = new Scene(root, 400, 250);
        primaryStage.setTitle("Move the Ball");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
