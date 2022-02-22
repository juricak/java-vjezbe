package hr.tvz.java.javafx;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class NoviStudentController {
	
	@FXML
	private TextField imeTextField;
	
	@FXML
	private TextField prezimeTextField;
	
	@FXML
	private TextField jmbagTextField;
	
	@FXML
	private Button button;
	
	public void spremiStudenta() {
		boolean imaGresaka = false;
		StringBuilder greske = new StringBuilder();
		
		String imeStudenta = imeTextField.getText();
		
		if(imeStudenta.isBlank()) {
			imaGresaka = true;
			greske.append("Ime studenta nije upisano!\n");
		}
		
		String prezimeStudenta = prezimeTextField.getText();
		
		if(prezimeStudenta.isBlank()) {
			imaGresaka = true;
			greske.append("Prezime studenta nije upisano!\n");
		}
		
		String jmbagStudenta = jmbagTextField.getText();
		
		if(jmbagStudenta.isBlank()) {
			imaGresaka = true;
			greske.append("JMBAG studenta nije upisan!\n");
		}
		
		if(imaGresaka) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška kod unosa");
			alert.setContentText(greske.toString());
			alert.showAndWait();
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Uspješno spremanje!");
			alert.setContentText("Podaci o novom studentu su uspješno spremljeni!");
			alert.showAndWait();
			Student noviStudent = new Student(imeStudenta,prezimeStudenta, jmbagStudenta);
			PocetniController.listaStudenata.add(noviStudent);
		}

	}
	
	public void prikaziEkranZaUnosNovogStudenta() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("noviStudent.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.mainStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void prikaziEkranPretraguStudenata() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("pocetni.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.mainStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
