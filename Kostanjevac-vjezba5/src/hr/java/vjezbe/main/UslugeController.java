package hr.java.vjezbe.main;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;



import hr.java.vjezbe.entitet.Stanje;
import hr.java.vjezbe.entitet.Usluga;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;


public class UslugeController {
	
	public static final List<Usluga> listaArtikala = new ArrayList<>();

	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;
	    
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
	    private TextField naslovTextField;

	    @FXML
	    private TextField opisTextField;

	    @FXML
	    private TextField cijenaTextField;
	    
	    @FXML
	    private ComboBox<Stanje> stanjeComboBox;

	    @FXML
	    private Button pretraziStanove;

	    @FXML
	    private Button pretraziUsluge;

	    @FXML
	    private TableView<Usluga> tablicaUsluga;

	    @FXML
	    private TableColumn<Usluga, String> naslovUslugeTableColumn;

	    @FXML
	    private TableColumn<Usluga, String> OpisUslugeTableColumn;

	    @FXML
	    private TableColumn<Usluga, BigDecimal> cijenaUslugeTableColumn;

	    @FXML
	    private TableColumn<Usluga, Stanje> stanjeUslugeTableColumn;


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
	    public void prikaziPretraguPrivatnihKorisnika(ActionEvent event) {
	    	 try {
	    		 BorderPane center1k = FXMLLoader.load(getClass().getResource("PrivatniKorisnici.fxml"));
	    		 Main.setCenterPane(center1k);
	    	 } catch (IOException e) {
	    		 e.printStackTrace();
	    	 }
	    	}
	    @FXML
	    public void prikaziPretraguPoslovnihKorisnika(ActionEvent event) {
	    	 try {
	    		 BorderPane center3 = FXMLLoader.load(getClass().getResource("PoslovniKorisnici.fxml"));
	    		 Main.setCenterPane(center3);
	    	 } catch (IOException e) {
	    		 e.printStackTrace();
	    	 }
	    	}
    @FXML
    void initialize() {
    	
    	
		
    	naslovUslugeTableColumn.setCellValueFactory(new PropertyValueFactory<Usluga, String>("naslov"));
		
    	OpisUslugeTableColumn.setCellValueFactory(new PropertyValueFactory<Usluga, String>("opis"));
		
    	cijenaUslugeTableColumn.setCellValueFactory(new PropertyValueFactory<Usluga, BigDecimal>("cijena"));
		
    	stanjeUslugeTableColumn.setCellValueFactory(new PropertyValueFactory<Usluga, Stanje>("stanje"));
		
		List<Usluga> filtriranaLista = ProdajaController.dohvatiArtikle().stream().filter(p -> p instanceof Usluga).map(sc -> (Usluga)sc).collect(Collectors.toList());
		listaArtikala.addAll(filtriranaLista);
		tablicaUsluga.setItems(FXCollections.observableArrayList(filtriranaLista));
		
    }
    
    @FXML
    private void stanoviPretrazivanje(ActionEvent event) {
    	
    	
    	
    	
    	List<Usluga> filtriranaLista = new ArrayList<>();
    	filtriranaLista.addAll(listaArtikala);
    	
    	List<Usluga> filtriranaListaPoNaslovu = new ArrayList<>();
    	
    	boolean naslovUnesen = false;
    	
    	if(naslovTextField.getText().isEmpty() == false) {
			
    		naslovUnesen = true;
			
				for(Usluga s : filtriranaLista) {
					if(s.getNaslov().toLowerCase().contains(naslovTextField.getText().toLowerCase())) {
						filtriranaListaPoNaslovu.add(s);
					}
				}
			}
    	filtriranaLista.clear();
    	if(filtriranaListaPoNaslovu.isEmpty() == false || naslovUnesen) {
				filtriranaLista.addAll(filtriranaListaPoNaslovu);
		}
		else {
				filtriranaLista.addAll(listaArtikala);
		}
    	
    	List<Usluga> filtriranaListaPoOpisu = new ArrayList<>();
    	boolean opisUnesen = false;
    	
    		if(opisTextField.getText().isEmpty() == false) {
			
    			opisUnesen = true;
			
    			if (filtriranaListaPoNaslovu.isEmpty() == false || naslovUnesen) {
    				for(Usluga s : filtriranaListaPoNaslovu) {
    					if(s.getOpis().toLowerCase().contains(opisTextField.getText().toLowerCase())) {
    						filtriranaListaPoOpisu.add(s);
    					}
    				}
    				
    			}else {
    				for(Usluga s : filtriranaLista) {
    					if(s.getOpis().toLowerCase().contains(opisTextField.getText().toLowerCase())) {
    						filtriranaListaPoOpisu.add(s);
    					}
    				}
    			}
    		}
    	filtriranaLista.clear();
    	if(filtriranaListaPoOpisu.isEmpty() == false || opisUnesen) {
				filtriranaLista.addAll(filtriranaListaPoOpisu);
		}
		else if(filtriranaListaPoNaslovu.isEmpty() == false){
				filtriranaLista.addAll(filtriranaListaPoNaslovu);
		}else {
			filtriranaLista.addAll(listaArtikala);
		}
    	
    	
    	List<Usluga> filtriranaListaPoCijeni = new ArrayList<>();
    	boolean cijenaUnesena = false;
    	
    	if(cijenaTextField.getText().isEmpty() == false) {
			
    		cijenaUnesena = true;
    		
    		 if (filtriranaListaPoOpisu.isEmpty() == false || opisUnesen) {
    			for(Usluga s : filtriranaListaPoOpisu) {
    				if(s.getCijena().toString().equals(cijenaTextField.getText())) {
    					filtriranaListaPoCijeni.add(s);
    				}
    			}
    		}else if (filtriranaListaPoNaslovu.isEmpty() == false || naslovUnesen) {
    			for(Usluga s : filtriranaListaPoNaslovu) {
    				if(s.getCijena().toString().equals(cijenaTextField.getText())) {
    					filtriranaListaPoCijeni.add(s);
    				}
    			}
    		}else {
    			for(Usluga s : filtriranaLista) {
    				if(s.getCijena().toString().equals(cijenaTextField.getText())) {
    					filtriranaListaPoCijeni.add(s);
    				}
    			}
    		}
 }	
    	filtriranaLista.clear();
    	if(filtriranaListaPoCijeni.isEmpty() == false || cijenaUnesena) {
			filtriranaLista.addAll(filtriranaListaPoCijeni);
		}else if ((filtriranaListaPoOpisu.isEmpty() == false || opisUnesen)){
				filtriranaLista.addAll(filtriranaListaPoOpisu);
				
		} else if (filtriranaListaPoNaslovu.isEmpty() == false || naslovUnesen)	{
				filtriranaLista.addAll(filtriranaListaPoNaslovu);
		}else {
			filtriranaLista.addAll(listaArtikala);
		}
    	
    	  	
    	
    	tablicaUsluga.setItems(FXCollections.observableArrayList(filtriranaLista));		
	
			
		}

	
	}
    



