
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class hw14_5 extends Application{
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        
        String text = "WELCOME TO JAVA";
        
        double radius = 100;
        double centerX = 200;
        double centerY = 200;
        
        double angleStep = 360.0 / text.length();
        
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            double angle = - (i * angleStep);

            // 計算字元的位置（圓周上的點）
            double x = centerX + radius * Math.cos(Math.toRadians(angle));
            double y = centerY - radius * Math.sin(Math.toRadians(angle)); // 注意 Y 軸方向反轉

            // 創建 Text 節點
            Text t = new Text(String.valueOf(character));
            t.setFont(Font.font("Times New Roman", FontWeight.BOLD, 40));
            t.setScaleX(-1);
            t.setScaleY(-1);
            t.setX(x);
            t.setY(y);

            // 使字元面向圓心
            t.setRotate(-(angle + 90)); // 旋轉文字

            pane.getChildren().add(t);
        }

        
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle(text);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public static void main(String[] args){
        launch(args);
    }
}

