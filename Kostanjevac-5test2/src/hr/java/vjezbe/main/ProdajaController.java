package hr.java.vjezbe.main;





import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import hr.java.vjezbe.entitet.Artikl;
import hr.java.vjezbe.entitet.Automobil;
import hr.java.vjezbe.entitet.Stan;
import hr.java.vjezbe.entitet.Stanje;
import hr.java.vjezbe.entitet.Usluga;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;



public class ProdajaController {
	
	
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private MenuItem automobiliPretraga;
    
    @FXML
    private MenuItem stanoviPretraga;
    
    @FXML
    private MenuItem uslugePretraga;
    
    @FXML
    private BorderPane centar1;
    
    @FXML
    private BorderPane centar2;
    
    @FXML
    private BorderPane centar3;
    
   
    
     @FXML
    private void pretragaAutomobili(ActionEvent event) {
    	
     }
	
    @FXML
    public void prikaziPretraguAutomobila(ActionEvent event) {
    	 try {
    		 BorderPane center1 = FXMLLoader.load(getClass().getResource("Automobili.fxml"));
    		 Main.setCenterPane(center1);
    	 } catch (IOException e) {
    		 e.printStackTrace();
    	 }
    	}
   
    @FXML
    public void prikaziPretraguStanova(ActionEvent event) {
    	 try {
    		 BorderPane center2 = FXMLLoader.load(getClass().getResource("Stanovi.fxml"));
    		 Main.setCenterPane(center2);
    	 } catch (IOException e) {
    		 e.printStackTrace();
    	 }
    	}
    
    @FXML
    public void prikaziPretraguUsluga(ActionEvent event) {
    	 try {
    		 BorderPane center3 = FXMLLoader.load(getClass().getResource("Usluge.fxml"));
    		 Main.setCenterPane(center3);
    	 } catch (IOException e) {
    		 e.printStackTrace();
    	 }
    	}

    @FXML
    void initialize() {
    	
    	dohvatiArtikle();
    	
    }

     

	public static List<Artikl> dohvatiArtikle() {
    	List<Artikl> listaArtikala = new ArrayList<>();
    	BigDecimal cijenaS = new BigDecimal(100000.00);
		Integer kvadratura = 150;
		Stan as = new Stan("Samobor", "Novi", Stanje.values()[0], cijenaS, kvadratura);
		listaArtikala.add(as);
		
		cijenaS = new BigDecimal(500000.00);
		kvadratura = 100;
		Stan bs = new Stan("Zaprešic", "Radnicki", Stanje.values()[2], cijenaS, kvadratura);
		listaArtikala.add(bs);
		
    	BigDecimal cijenaU = new BigDecimal(200.00);
		Usluga au = new Usluga("Košenje", "Flaksericom", Stanje.values()[0], cijenaU);
		listaArtikala.add(au);
		
		cijenaU = new BigDecimal(150.00);
		Usluga bu = new Usluga("Instrukcije", "Matematika", Stanje.values()[0], cijenaU);
		listaArtikala.add(bu);
		
		BigDecimal cijenaA = new BigDecimal(50000.00);
		BigDecimal snaga = new BigDecimal(260);
		Automobil aa = new Automobil("BMW", "Diesel", Stanje.values()[1], cijenaA, snaga);
		listaArtikala.add(aa);
		
		cijenaA = new BigDecimal(30000.00);
		snaga = new BigDecimal(240);
		Automobil ba = new Automobil("Mercedes", "Benzinac", Stanje.values()[2], cijenaA, snaga);
		listaArtikala.add(ba);
		
		cijenaA = new BigDecimal(20000.00);
		snaga = new BigDecimal(120);
		Automobil ca = new Automobil("Toyota", "Benzinac", Stanje.values()[3], cijenaA, snaga);
		listaArtikala.add(ca);
		
		return listaArtikala;
	}
	
   

    
}
