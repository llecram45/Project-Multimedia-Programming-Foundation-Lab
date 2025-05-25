package main;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Login extends Application{
	
	Scene scene;
	BorderPane bp;
	Image img;
	ImageView backgroundView, profileView;
	
	HBox passwordBox;
	VBox loginBox;
	Label welcomeLbl, errorLbl;
	PasswordField password;
	Button loginBtn;
	
	final String STATIC_PASSWORD = "test123";

	
	public void init() {
		
		img = new Image(getClass().getResourceAsStream("/main/image/nature.jpg"));
		backgroundView = new ImageView();
		backgroundView.setFitHeight(500);
		backgroundView.setFitWidth(750);
		backgroundView.setPreserveRatio(false);
		
		bp = new BorderPane();
		scene = new Scene(bp, 750, 500);
	}
	

    public void imgBackground() {
    	backgroundView.setImage(img);
        bp.getChildren().add(backgroundView);
    }
    
    public void login() {
     
        Image profileImg = new Image(getClass().getResourceAsStream("/main/image/default_profile_pic.png"));
        profileView = new ImageView(profileImg);
        profileView.setFitHeight(100);
        profileView.setFitWidth(100);

        welcomeLbl = new Label("Welcome RU24-2!");
        welcomeLbl.setTextFill(Color.WHITE);
        welcomeLbl.setFont(new Font("Arial", 20));

        password = new PasswordField();
        password.setPromptText("Enter password");
        password.setPrefWidth(200);
        password.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-border-color: white;" +
            "-fx-text-fill: white;" +
            "-fx-border-radius: 10;" +
            "-fx-background-radius: 10;" +
            "-fx-padding: 8 12;" +
            "-fx-font-size: 14;"
        );

        loginBtn = new Button("Login");
        loginBtn.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-border-color: white;" +
            "-fx-text-fill: white;" +
            "-fx-border-radius: 10;" +
            "-fx-background-radius: 10;" +
            "-fx-padding: 8 16;" +
            "-fx-font-size: 14;"
        );
        
        loginBtn.setOnAction(e -> {
            if (password.getText().equals(STATIC_PASSWORD)) {
                Stage stage = (Stage) loginBtn.getScene().getWindow();
                new Home().start(stage);
            } else {
                errorLbl.setText("Wrong Password!");
            }
        });

        
        errorLbl = new Label("");
        errorLbl.setTextFill(Color.RED);
        errorLbl.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        HBox passwordBox = new HBox(10);
        passwordBox.setAlignment(Pos.CENTER);
        passwordBox.getChildren().addAll(password, loginBtn);

     
        loginBox = new VBox(15);
        loginBox.setAlignment(Pos.CENTER);
        loginBox.getChildren().addAll(profileView, welcomeLbl, passwordBox, errorLbl);

      
        StackPane centerPane = new StackPane(loginBox);
        centerPane.setAlignment(Pos.CENTER);
        bp.setCenter(centerPane);
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		init();
		imgBackground();
		login();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
