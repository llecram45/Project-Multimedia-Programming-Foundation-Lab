package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Home extends Application {
    Scene scene;
    BorderPane bp;
    Image img;
    ImageView backgroundView;

    public void init() {
        // Load image
        img = new Image(getClass().getResourceAsStream("/main/image/homepage.jpg"));
        backgroundView = new ImageView();
        backgroundView.setFitHeight(500);
        backgroundView.setFitWidth(750);
        backgroundView.setPreserveRatio(false);
        backgroundView.setImage(img); 

        bp = new BorderPane();
        bp.getChildren().add(backgroundView); 
        scene = new Scene(bp, 750, 500);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        init();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
