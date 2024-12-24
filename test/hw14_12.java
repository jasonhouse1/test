
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class hw14_12 extends Application{
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        
        double projectPercent = 20;
        double quizPercent = 10;
        double midtermPercent = 30;
        double finalPercent = 40;
        
        double barWidth = 100;
        double maxHeight = 300;
        double baseY = 350;
        
        Rectangle projectBar = new Rectangle(50, baseY - projectPercent * maxHeight / 100, barWidth, projectPercent * maxHeight / 100);
        projectBar.setFill(Color.RED);
        Text projectText = new Text(55, 280, "Project -- 20%");
        projectText.setFont(Font.font(14));

        Rectangle quizBar = new Rectangle(180, baseY - quizPercent * maxHeight / 100, barWidth, quizPercent * maxHeight / 100);
        quizBar.setFill(Color.BLUE);
        Text quizText = new Text(190, 310, "Quiz -- 10%");
        quizText.setFont(Font.font(14));

        Rectangle midtermBar = new Rectangle(310, baseY - midtermPercent * maxHeight / 100, barWidth, midtermPercent * maxHeight / 100);
        midtermBar.setFill(Color.GREEN);
        Text midtermText = new Text(310, 250, "Midterm -- 30%");
        midtermText.setFont(Font.font(14));

        Rectangle finalBar = new Rectangle(440, baseY - finalPercent * maxHeight / 100, barWidth, finalPercent * maxHeight / 100);
        finalBar.setFill(Color.ORANGE);
        Text finalText = new Text(450, 220, "Final -- 40%");
        finalText.setFont(Font.font(14));
        
        pane.getChildren().addAll(projectBar, quizBar, midtermBar, finalBar, projectText, quizText, midtermText, finalText);
        
        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("Bar Chart Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
