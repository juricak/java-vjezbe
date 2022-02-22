package hr.java.vjezbe.main;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import hr.java.vjezbe.entitet.Automobil;
import hr.java.vjezbe.entitet.Stanje;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class UnosAutomobilaController {

		ObservableList<Stanje> stanjeArtiklaList = FXCollections.observableArrayList(Stanje.values()[0],Stanje.values()[1],Stanje.values()[2],Stanje.values()[3]);
	
		@FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextField naslovTextField;

	    @FXML
	    private TextField opisTextField;

	    @FXML
	    private TextField cijenaTextField;
	    
	    @FXML
	    private TextField snagaTextField;

	    @FXML
	    private ChoiceBox<Stanje> izborStanja;

	    @FXML
	    private Button unesiArtikle;

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
	    	
	    	izborStanja.setValue(Stanje.values()[0]);
	    	izborStanja.setItems(stanjeArtiklaList);
	    	
	    }
	    
	@FXML    
	public void spremiAutomobil() {
		boolean imaGresaka = false;
		StringBuilder greske = new StringBuilder();
		
		String naslov = naslovTextField.getText();
		
		if(naslov.isBlank()) {
			imaGresaka = true;
			greske.append("Naslov automobila nije upisan!\n");
		}
		
		String opis = opisTextField.getText();
		
		if(opis.isBlank()) {
			imaGresaka = true;
			greske.append("Opis automobila nije upisan!\n");
		}
		BigDecimal cijena = new BigDecimal(0);
		
		
		if(cijenaTextField.getText().isBlank()) {
			imaGresaka = true;
			greske.append("Cijena automobila nije upisana!\n");
		}else {
			
			cijena =  new BigDecimal(cijenaTextField.getText());
			
		}
		
		BigDecimal snagaKs = new BigDecimal(0);
		
		
		if(cijenaTextField.getText().isBlank()) {
			imaGresaka = true;
			greske.append("Snaga automobila nije upisana!\n");
		}else {
			
			snagaKs =  new BigDecimal(cijenaTextField.getText());
			
		}
		
		Stanje stanje = izborStanja.getValue();
		
		
		if(imaGresaka) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška kod unosa");
			alert.setContentText(greske.toString());
			alert.showAndWait();
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Uspješno spremanje!");
			alert.setContentText("Podaci o novom automobilu su uspješno spremljeni!");
			alert.showAndWait();
			Automobil noviAutomobil = new Automobil(naslov,opis,stanje,cijena, snagaKs);
			ProdajaController.listaArtikala.add(noviAutomobil);
		}

	}

}
