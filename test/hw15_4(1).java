
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class hw15_4 extends Application{
    @Override
    public void start(Stage primaryStage){
        HBox root = new HBox(10);
        Label label = new Label("請按開始:");
        TextField input = new TextField();
        input.setEditable(false);
        
        Button button = new Button("開始");
        
        Random random = new Random();
        int value = random.nextInt(20);
        System.out.println("target value: " + value);
        
        button.setOnAction((event) -> {
           String input_value = input.getText();
           input.setEditable(true);
           button.setText("猜!");
           if(Integer.parseInt(input_value) > value){
               label.setText("Too Big");
               label.setTextFill(Color.RED);
           } else if (Integer.parseInt(input_value) < value){
               label.setText("Too Small");
               label.setTextFill(Color.GREEN);
           } else {
               label.setText("Correct! 請按開始");
               label.setTextFill(Color.BLACK);
               button.setText("開始");
               input.setEditable(false);
           }
            
        });
        
        root.getChildren().addAll(label, input, button);
        Scene scene = new Scene(root, 350, 30);
        primaryStage.setTitle("411630907 洪振凱");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
