package hr.java.vjezbe.main;
	


import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;



public class Main extends Application {
	
	private static Stage window;
	private static BorderPane root;
	
	@Override
	public void start(Stage primaryStage) {
		
		Main.window = primaryStage;
		Main.window.setTitle("Prodaja app");
		
		showMainView();
			
			
			
		
			
		
		
	}
	
	public static void setCenterPane(BorderPane root) {
		Scene scene = new Scene(root, 600, 500);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		window.setScene(scene);
		window.show();
	}


	private void showMainView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Prodaja.fxml"));		
			root = loader.load();
			setCenterPane(root);
			
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	}
	
	



	public static void main(String[] args) {
		launch(args);
	}
	
	


	


	

	


	

	
	
	
	
	
	
}
