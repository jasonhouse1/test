import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Random;

public class hw14_2 extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        GridPane gridPane = new GridPane();
        Random random = new Random();

        // Path to your image files
        FileInputStream xInputStream = new FileInputStream("C:\\Users\\kevin\\OneDrive\\桌面\\image\\x.gif");
        FileInputStream oInputStream = new FileInputStream("C:\\Users\\kevin\\OneDrive\\桌面\\image\\o.gif");
        
        Image xImagePath = new Image(xInputStream);
        Image oImagePath = new Image(oInputStream);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int cellValue = random.nextInt(3); // 0 = empty, 1 = X, 2 = O
                switch (cellValue) {
                    case 1:
                        ImageView xImage = new ImageView(xImagePath);
                        xImage.setFitWidth(50);
                        xImage.setFitHeight(50);
                        gridPane.add(xImage, col, row);
                        break;
                    case 2:
                        ImageView oImage = new ImageView(oImagePath);
                        oImage.setFitWidth(50);
                        oImage.setFitHeight(50);
                        gridPane.add(oImage, col, row);
                        break;
                    default:
                        // Empty cell
                        gridPane.add(new ImageView(), col, row);
                        break;
                }
            }
        }

        Scene scene = new Scene(gridPane, 200, 200);
        primaryStage.setTitle("Tic-Tac-Toe Board");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}