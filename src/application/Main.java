package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Parent root=FXMLLoader.load(getClass().getResource("view/electeurRegistration.fxml"));
			Parent root=FXMLLoader.load(getClass().getResource("view/home.fxml"));

			Scene scene = new Scene(root);
			//primaryStage.setTitle("Registration electeur");
			primaryStage.setTitle("test swipe");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
