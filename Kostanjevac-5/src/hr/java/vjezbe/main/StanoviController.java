package hr.java.vjezbe.main;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;



import hr.java.vjezbe.entitet.Stan;
import hr.java.vjezbe.entitet.Stanje;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;


public class StanoviController {
	
	public static final List<Stan> listaArtikala = new ArrayList<>();

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
	    private TextField kvadraturaTextField;

	    @FXML
	    private TextField cijenaTextField;

	    @FXML
	    private Button pretraziStanove;

	    @FXML
	    private TableView<Stan> tablicaStanova;

	    @FXML
	    private TableColumn<Stan, String> naslovStanaTableColumn;

	    @FXML
	    private TableColumn<Stan, String> OpisStanaTableColumn;

	    @FXML
	    private TableColumn<Stan, Integer> kvadraturaStanaTableColumn;

	    @FXML
	    private TableColumn<Stan, BigDecimal> cijenaStanaTableColumn;

	    @FXML
	    private TableColumn<Stan, Stanje> stanjeStanaTableColumn;

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
    	
    	
		
    	naslovStanaTableColumn.setCellValueFactory(new PropertyValueFactory<Stan, String>("naslov"));
		
    	OpisStanaTableColumn.setCellValueFactory(new PropertyValueFactory<Stan, String>("opis"));
		
    	kvadraturaStanaTableColumn.setCellValueFactory(new PropertyValueFactory<Stan, Integer>("kvadratura"));
		
    	cijenaStanaTableColumn.setCellValueFactory(new PropertyValueFactory<Stan, BigDecimal>("cijena"));
		
    	stanjeStanaTableColumn.setCellValueFactory(new PropertyValueFactory<Stan, Stanje>("stanje"));
		
		List<Stan> filtriranaLista = ProdajaController.dohvatiArtikle().stream().filter(p -> p instanceof Stan).map(sc -> (Stan)sc).collect(Collectors.toList());
		listaArtikala.addAll(filtriranaLista);
		tablicaStanova.setItems(FXCollections.observableArrayList(filtriranaLista));
		
    }
    
    @FXML
    private void stanoviPretrazivanje(ActionEvent event) {
    	
    	
    	
    	
    	List<Stan> filtriranaLista = new ArrayList<>();
    	filtriranaLista.addAll(listaArtikala);
    	
    	List<Stan> filtriranaListaPoNaslovu = new ArrayList<>();
    	
    	boolean naslovUnesen = false;
    	
    	if(naslovTextField.getText().isEmpty() == false) {
			
    		naslovUnesen = true;
			
				for(Stan s : filtriranaLista) {
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
    	
    	List<Stan> filtriranaListaPoOpisu = new ArrayList<>();
    	boolean opisUnesen = false;
    	
    		if(opisTextField.getText().isEmpty() == false) {
			
    			opisUnesen = true;
			
    			if (filtriranaListaPoNaslovu.isEmpty() == false || naslovUnesen) {
    				for(Stan s : filtriranaListaPoNaslovu) {
    					if(s.getOpis().toLowerCase().contains(opisTextField.getText().toLowerCase())) {
    						filtriranaListaPoOpisu.add(s);
    					}
    				}
    				
    			}else {
    				for(Stan s : filtriranaLista) {
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
    	
    	List<Stan> filtriranaListaPoKvadraturi = new ArrayList<>();
    	boolean kvadraturaUnesena = false;
    	
    	if(kvadraturaTextField.getText().isEmpty() == false) {
			
    		kvadraturaUnesena = true;
    		
    		if (filtriranaListaPoOpisu.isEmpty() == false || opisUnesen) {
    			for(Stan s : filtriranaListaPoOpisu) {
    				if(Integer.toString(s.getKvadratura()).equals(kvadraturaTextField.getText())) {
    					filtriranaListaPoKvadraturi.add(s);
    				}
    			}
    		}else if (filtriranaListaPoNaslovu.isEmpty() == false || naslovUnesen) {
    			for(Stan s : filtriranaListaPoNaslovu) {
    				if(Integer.toString(s.getKvadratura()).equals(kvadraturaTextField.getText())) {
    					filtriranaListaPoKvadraturi.add(s);
    				}
    			}
    		}else {
    			for(Stan s : filtriranaLista) {
    				if(Integer.toString(s.getKvadratura()).equals(kvadraturaTextField.getText())) {
    					filtriranaListaPoKvadraturi.add(s);
    				}
    			}
    		}
 }	
    	filtriranaLista.clear();
    	if(filtriranaListaPoKvadraturi.isEmpty() == false || kvadraturaUnesena) {
				filtriranaLista.addAll(filtriranaListaPoKvadraturi);
		}
		else if ((filtriranaListaPoOpisu.isEmpty() == false || opisUnesen)){
				filtriranaLista.addAll(filtriranaListaPoOpisu);
				
		} else if (filtriranaListaPoNaslovu.isEmpty() == false || naslovUnesen)	{
				filtriranaLista.addAll(filtriranaListaPoNaslovu);
		}else {
			filtriranaLista.addAll(listaArtikala);
		}
    	List<Stan> filtriranaListaPoCijeni = new ArrayList<>();
    	boolean cijenaUnesena = false;
    	
    	if(cijenaTextField.getText().isEmpty() == false) {
			
    		cijenaUnesena = true;
    		
    		if (filtriranaListaPoKvadraturi.isEmpty() == false || kvadraturaUnesena) {
    			for(Stan s : filtriranaListaPoKvadraturi) {
    				if(s.getCijena().toString().equals(cijenaTextField.getText())) {
    					filtriranaListaPoCijeni.add(s);
    				}
    			}
    		}else if (filtriranaListaPoOpisu.isEmpty() == false || opisUnesen) {
    			for(Stan s : filtriranaListaPoOpisu) {
    				if(s.getCijena().toString().equals(cijenaTextField.getText())) {
    					filtriranaListaPoCijeni.add(s);
    				}
    			}
    		}else if (filtriranaListaPoNaslovu.isEmpty() == false || naslovUnesen) {
    			for(Stan s : filtriranaListaPoNaslovu) {
    				if(s.getCijena().toString().equals(cijenaTextField.getText())) {
    					filtriranaListaPoCijeni.add(s);
    				}
    			}
    		}else {
    			for(Stan s : filtriranaLista) {
    				if(s.getCijena().toString().equals(cijenaTextField.getText())) {
    					filtriranaListaPoCijeni.add(s);
    				}
    			}
    		}
 }	
    	filtriranaLista.clear();
    	if(filtriranaListaPoCijeni.isEmpty() == false || cijenaUnesena) {
			filtriranaLista.addAll(filtriranaListaPoCijeni);
    	}else if(filtriranaListaPoKvadraturi.isEmpty() == false || kvadraturaUnesena) {
				filtriranaLista.addAll(filtriranaListaPoKvadraturi);
		}else if ((filtriranaListaPoOpisu.isEmpty() == false || opisUnesen)){
				filtriranaLista.addAll(filtriranaListaPoOpisu);
				
		} else if (filtriranaListaPoNaslovu.isEmpty() == false || naslovUnesen)	{
				filtriranaLista.addAll(filtriranaListaPoNaslovu);
		}else {
			filtriranaLista.addAll(listaArtikala);
		}
    	tablicaStanova.setItems(FXCollections.observableArrayList(filtriranaLista));		
	
			
		}

	
	}
    



