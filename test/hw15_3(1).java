
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class hw15_3 extends Application{
    @Override
    public void start(Stage primaryStage){
        VBox root = new VBox(10);
        HBox numberBox = new HBox(10);
        
        Label label_1 = new Label("Number 1: ");
        TextField num1 = new TextField();
        num1.setPrefWidth(50);
        Label label_2 = new Label("Number 2: ");
        TextField num2 = new TextField();
        num2.setPrefWidth(50);
        Label label_3 = new Label("Result: ");
        TextField result = new TextField();
        result.setPrefWidth(50);
        result.setEditable(false);
        
        numberBox.getChildren().addAll(label_1, num1, label_2, num2, label_3, result);
        numberBox.setStyle("-fx-alignment: center;");
        
        HBox operandBox = new HBox(10);
        Button Add = new Button("Add");
        Button Subtract = new Button("Subtract");
        Button Multiply = new Button("Multiply");
        Button Divide = new Button("Divide");
        
        Add.setOnAction((t) -> {
            double n1 = Double.parseDouble(num1.getText());
            double n2 = Double.parseDouble(num2.getText());
            result.setText(String.valueOf(n1 + n2));
        });
        Subtract.setOnAction((t) -> {
            double n1 = Double.parseDouble(num1.getText());
            double n2 = Double.parseDouble(num2.getText());
            result.setText(String.valueOf(n1 - n2));
        });
        Multiply.setOnAction((t) -> {
            double n1 = Double.parseDouble(num1.getText());
            double n2 = Double.parseDouble(num2.getText());
            result.setText(String.valueOf(n1 * n2));
        });
        Divide.setOnAction((t) -> {
            double n1 = Double.parseDouble(num1.getText());
            double n2 = Double.parseDouble(num2.getText());
            result.setText(String.valueOf(n1 / n2));
        });
                        
        
        
        operandBox.getChildren().addAll(Add, Subtract, Multiply, Divide);
        operandBox.setStyle("-fx-alignment: center;");
        
        root.getChildren().addAll(numberBox, operandBox);
        
        Scene scene = new Scene(root, 400, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
