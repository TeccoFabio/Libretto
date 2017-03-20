package it.polito.tdp.libretto;
	
import it.polito.tdp.libretto.model.Model;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Libretto.fxml"));
			BoarderPane root = (BoarderPane)loader.load(); // Carica la vista
			
			LibrettoController controller = (LibrettoController)loader.getController();
			Model model = new Model();
			
			controller.setModel(model); 		//Devo farmelo dire da  FXMLLoader
			Scene scene = new Scene(root);
			//Creo il modello
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
