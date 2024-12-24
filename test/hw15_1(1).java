import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class hw15_1 extends Application {
    private static final String IMAGE_PATH = "file:\\C:\\Users\\kevin\\OneDrive\\桌面\\image\\card\\";
    private static final int CARD_COUNT = 52;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        HBox cardBox = new HBox();
        Button refreshButton = new Button("Refresh");

        ImageView[] cardViews = new ImageView[4];
        for (int i = 0; i < 4; i++) {
            cardViews[i] = new ImageView();
            cardViews[i].setFitWidth(100);
            cardViews[i].setFitHeight(150); 
            cardBox.getChildren().add(cardViews[i]);
        }

        refreshButton.setOnAction(event -> {
            Random random = new Random();
            for (ImageView cardView : cardViews) {
                int cardNumber = random.nextInt(CARD_COUNT) + 1;
                cardView.setImage(new Image(IMAGE_PATH + cardNumber + ".png"));
            }
        });

        refreshButton.fire();
        root.getChildren().addAll(cardBox, refreshButton);

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Card Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}