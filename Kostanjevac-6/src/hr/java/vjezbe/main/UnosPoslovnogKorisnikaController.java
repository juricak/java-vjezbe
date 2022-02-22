package hr.java.vjezbe.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import hr.java.vjezbe.entitet.PoslovniKorisnik;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class UnosPoslovnogKorisnikaController {

	
		@FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextField nazivTextField;

	    @FXML
	    private TextField webTextField;

	    @FXML
	    private TextField telefonTextField;

	    @FXML
	    private Button unesiKorisnike;

	    @FXML
	    private TextField emailTextField;

	    @FXML
	    private MenuItem uslugePretraga;

	    @FXML
	    private MenuItem automobiliPretraga;

	    @FXML
	    private MenuItem stanoviPretraga;

	    @FXML
	    private MenuItem privatniKorisniciPretraga;

	    @FXML
	    private MenuItem poslovniKorisniciPretraga;

	    @FXML
	    private MenuItem privatniKorisniciUnos;
	    
	    @FXML
	    private MenuItem poslovniKorisniciUnos;
	    
	    @FXML
	    private MenuItem uslugeUnos;
	    
	    @FXML
	    private MenuItem automobiliUnos;
	    
	    @FXML
	    private MenuItem stanoviUnos;
	
	 @FXML
	    public void prikaziPretraguAutomobila(ActionEvent event) {
	    	 try {
	    		 BorderPane center = FXMLLoader.load(getClass().getResource("Automobili.fxml"));
	    		 Main.setCenterPane(center);
	    	 } catch (IOException e) {
	    		 e.printStackTrace();
	    	 }
	    	}
	   
	    @FXML
	    public void prikaziPretraguStanova(ActionEvent event) {
	    	 try {
	    		 BorderPane center = FXMLLoader.load(getClass().getResource("Stanovi.fxml"));
	    		 Main.setCenterPane(center);
	    	 } catch (IOException e) {
	    		 e.printStackTrace();
	    	 }
	    	}
	    
	    @FXML
	    public void prikaziPretraguUsluga(ActionEvent event) {
	    	 try {
	    		 BorderPane center = FXMLLoader.load(getClass().getResource("Usluge.fxml"));
	    		 Main.setCenterPane(center);
	    	 } catch (IOException e) {
	    		 e.printStackTrace();
	    	 }
	    	}
	    @FXML
	    public void prikaziPretraguPoslovnihKorisnika(ActionEvent event) {
	    	 try {
	    		 BorderPane center = FXMLLoader.load(getClass().getResource("PoslovniKorisnici.fxml"));
	    		 Main.setCenterPane(center);
	    	 } catch (IOException e) {
	    		 e.printStackTrace();
	    	 }
	    	}
	    @FXML
	    public void prikaziPretraguPrivatnihKorisnika(ActionEvent event) {
	    	 try {
	    		 BorderPane center = FXMLLoader.load(getClass().getResource("PrivatniKorisnici.fxml"));
	    		 Main.setCenterPane(center);
	    	 } catch (IOException e) {
	    		 e.printStackTrace();
	    	 }
	    	}
	
	    @FXML
	    public void prikaziUnosPrivatnihKorisnika(ActionEvent event) {
	    	 try {
	    		 BorderPane center = FXMLLoader.load(getClass().getResource("UnosPrivatnihKorisnika.fxml"));
	    		 Main.setCenterPane(center);
	    	 } catch (IOException e) {
	    		 e.printStackTrace();
	    	 }
	    	}
	    @FXML
	    public void prikaziUnosPoslovnihKorisnika(ActionEvent event) {
	    	 try {
	    		 BorderPane center = FXMLLoader.load(getClass().getResource("UnosPoslovnihKorisnika.fxml"));
	    		 Main.setCenterPane(center);
	    	 } catch (IOException e) {
	    		 e.printStackTrace();
	    	 }
	    	}
	    public void prikaziUnosUsluge(ActionEvent event) {
	   	 try {
	   		 BorderPane center = FXMLLoader.load(getClass().getResource("UnosUsluge.fxml"));
	   		 Main.setCenterPane(center);
	   	 } catch (IOException e) {
	   		 e.printStackTrace();
	   	 }
	   	}
	    public void prikaziUnosStanova(ActionEvent event) {
	      	 try {
	      		 BorderPane center = FXMLLoader.load(getClass().getResource("UnosStanova.fxml"));
	      		 Main.setCenterPane(center);
	      	 } catch (IOException e) {
	      		 e.printStackTrace();
	      	 }
	      	}
	    public void prikaziUnosAutomobila(ActionEvent event) {
	      	 try {
	      		 BorderPane center = FXMLLoader.load(getClass().getResource("UnosAutomobila.fxml"));
	      		 Main.setCenterPane(center);
	      	 } catch (IOException e) {
	      		 e.printStackTrace();
	      	 }
	      	}
	    @FXML
	    void initialize() {
	    	
	    	
	    	
	    }
	    
	@FXML    
	public void spremiPoslovnogKorisnika() {
		boolean imaGresaka = false;
		StringBuilder greske = new StringBuilder();
		
		String naziv = nazivTextField.getText();
		
		if(naziv.isBlank()) {
			imaGresaka = true;
			greske.append("Naziv firme nije upisan!\n");
		}
		
		String web = webTextField.getText();
		
		if(web.isBlank()) {
			imaGresaka = true;
			greske.append("Web firme nije upisan!\n");
		}
		
		String telefon = telefonTextField.getText();
		
		if(telefon.isBlank()) {
			imaGresaka = true;
			greske.append("Telefon firme nije upisan!\n");
		}
		
		String email = emailTextField.getText();
		
		if(email.isBlank()) {
			imaGresaka = true;
			greske.append("E-mail firme nije upisan!\\n");
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
			alert.setContentText("Podaci o novoj firmi su uspješno spremljeni!");
			alert.showAndWait();
			PoslovniKorisnik noviPrivatniKorisnik = new PoslovniKorisnik(email,telefon,naziv,web);
			ProdajaController.listaKorisnika.add(noviPrivatniKorisnik);
		}

	}

}
