package hr.java.javafx;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PocetnaController implements Initializable {
	
	@FXML
	private TextField jmbagTextField;
	
	@FXML
	private TextField imeTextField;
	
	@FXML
	private TextField prezimeTextField;
	
	@FXML
	private ComboBox<String> predmetiComboBox;
	
	@FXML
	private ComboBox<Integer> ocjeneComboBox;
	
	public void provjeriProlaznostNaIspitu() {
		String jmbag = jmbagTextField.getText();
		String ime = imeTextField.getText();
		String prezime = prezimeTextField.getText();
		
		if(ocjeneComboBox.getValue() > Ocjena.NEDOVOLJAN.getBroj()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Informacija o ispitu");
			alert.setHeaderText("Prolazna ocjena");
			alert.setContentText("Èestitke što ste prošli ispit!\n"
					+ jmbag + " " + ime + " " + prezime);

			alert.showAndWait();
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Informacija o ispitu");
			alert.setHeaderText("Neprolazna ocjena");
			alert.setContentText("Više sreæe i znanja sljedeæi put!\n"
					+ jmbag + " " + ime + " " + prezime);

			alert.showAndWait();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ObservableList<String> listaPredmeta
			= FXCollections.observableArrayList("Programiranje u programskom jeziku Java",
				"Web aplikacije u Javi");

		predmetiComboBox.setItems(listaPredmeta);
		
		List<Integer> listaOcjena = new ArrayList<>();
		
		for(int i = 1; i <= 5; i++) {
			listaOcjena.add(i);
		}
		
		ObservableList<Integer> observableListaOcjena = FXCollections.observableList(listaOcjena);
		
		ocjeneComboBox.setItems(observableListaOcjena);
	}
	
}
