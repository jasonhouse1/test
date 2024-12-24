
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class hw14_18 extends Application{
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        
        Line xAxis = new Line(0, 200, 400, 200);
        Line yAxis = new Line(200, 0, 200, 400);
        Line xArrow1 = new Line(400, 200, 390, 195);
        Line xArrow2 = new Line(400, 200, 390, 205);
        Line yArrow1 = new Line(200, 0, 195, 10);
        Line yArrow2 = new Line(200, 0, 205, 10);
        Text x_label = new Text(390, 180, "X");
        Text y_label = new Text(220, 10, "Y");
        Polyline polyline = new Polyline();
        ObservableList<Double> list = polyline.getPoints();
        double scaleFactor = 0.0125;
        for(int x=-100; x<=100; x++){
            list.add(x + 200.0);
            list.add(200 - scaleFactor * x * x);
        }
        pane.getChildren().addAll(xAxis, yAxis, xArrow1, xArrow2, yArrow1, yArrow2, x_label, y_label, polyline);
        Scene scene = new Scene(pane, 400,400);
        primaryStage.setTitle("f(x) = x^2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
