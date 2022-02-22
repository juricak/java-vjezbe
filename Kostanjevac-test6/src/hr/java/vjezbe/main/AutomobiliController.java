package hr.java.vjezbe.main;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import hr.java.vjezbe.entitet.Artikl;
import hr.java.vjezbe.entitet.Automobil;
import hr.java.vjezbe.entitet.Stanje;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;


public class AutomobiliController {
	
	public static final List<Automobil> listaArtikala = new ArrayList<>();

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
    private Button pretraziAutomobile;
    
    @FXML
    private TextField naslovTextField;

    @FXML
    private TextField opisTextField;

    @FXML
    private TextField snagaTextField;

    @FXML
    private TextField cijenaTextField;

    
    @FXML
    private TableView<Artikl> tablicaAutomobila;

    @FXML
    private TableColumn<Automobil, String> naslovAutomobilaTableColumn;

    @FXML
    private TableColumn<Automobil, String> opisAutomobilaTableColumn;

    @FXML
    private TableColumn<Automobil, BigDecimal> snagaAutomobilaTableColumn;

    @FXML
    private TableColumn<Automobil, BigDecimal> cijenaAutomobilaTableColumn;
    
    @FXML
    private TableColumn<Automobil, Stanje> stanjeAutomobilaTableColumn;

    
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
    public void prikaziPretraguPrivatnihKorisnika(ActionEvent event) {
    	 try {
    		 BorderPane center = FXMLLoader.load(getClass().getResource("PrivatniKorisnici.fxml"));
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
    	
    	
		
		naslovAutomobilaTableColumn.setCellValueFactory(new PropertyValueFactory<Automobil, String>("naslov"));
		
		opisAutomobilaTableColumn.setCellValueFactory(new PropertyValueFactory<Automobil, String>("opis"));
		
		snagaAutomobilaTableColumn.setCellValueFactory(new PropertyValueFactory<Automobil, BigDecimal>("snagaKs"));
		
		cijenaAutomobilaTableColumn.setCellValueFactory(new PropertyValueFactory<Automobil, BigDecimal>("cijena"));
		
		stanjeAutomobilaTableColumn.setCellValueFactory(new PropertyValueFactory<Automobil, Stanje>("stanje"));
		
		List<Automobil> filtriranaLista = ProdajaController.dohvatiArtikle().stream().filter(p -> p instanceof Automobil).map(sc -> (Automobil)sc).collect(Collectors.toList());
		listaArtikala.addAll(filtriranaLista);
		tablicaAutomobila.setItems(FXCollections.observableArrayList(filtriranaLista));
		
		
        
		
		tablicaAutomobila.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
            	
            	if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    if(mouseEvent.getClickCount() == 2){
                    	try {
                     		 BorderPane center = FXMLLoader.load(getClass().getResource("UnosAutomobila.fxml"));
                     		 Main.setCenterPane(center);
                     	 } catch (IOException e) {
                     		 e.printStackTrace();
                     	 }
                    }
                }    
            }                  
        });
    }
    
    @FXML
    private void automobiliPretrazivanje(ActionEvent event) {
    	
    	
    	
    	
    	List<Automobil> filtriranaLista = new ArrayList<>();
    	filtriranaLista.addAll(listaArtikala);
    	
    	List<Automobil> filtriranaListaPoNaslovu = new ArrayList<>();
    	
    	boolean naslovUnesen = false;
    	
    	if(naslovTextField.getText().isEmpty() == false) {
			
    		naslovUnesen = true;
			
				for(Automobil s : filtriranaLista) {
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
    	
    	List<Automobil> filtriranaListaPoOpisu = new ArrayList<>();
    	boolean opisUnesen = false;
    	
    		if(opisTextField.getText().isEmpty() == false) {
			
    			opisUnesen = true;
			
    			if (filtriranaListaPoNaslovu.isEmpty() == false || naslovUnesen) {
    				for(Automobil s : filtriranaListaPoNaslovu) {
    					if(s.getOpis().toLowerCase().contains(opisTextField.getText().toLowerCase())) {
    						filtriranaListaPoOpisu.add(s);
    					}
    				}
    				
    			}else {
    				for(Automobil s : filtriranaLista) {
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
    	
    	List<Automobil> filtriranaListaPoSnazi = new ArrayList<>();
    	boolean snagaUnesena = false;
    	
    	if(snagaTextField.getText().isEmpty() == false) {
			
    		snagaUnesena = true;
    		
    		if (filtriranaListaPoOpisu.isEmpty() == false || opisUnesen) {
    			for(Automobil s : filtriranaListaPoOpisu) {
    				if(s.getSnagaKs().toString().equals(snagaTextField.getText())) {
    					filtriranaListaPoSnazi.add(s);
    				}
    			}
    		}else if (filtriranaListaPoNaslovu.isEmpty() == false || naslovUnesen) {
    			for(Automobil s : filtriranaListaPoNaslovu) {
    				if(s.getSnagaKs().toString().equals(snagaTextField.getText())) {
    					filtriranaListaPoSnazi.add(s);
    				}
    			}
    		}else {
    			for(Automobil s : filtriranaLista) {
    				if(s.getSnagaKs().toString().equals(snagaTextField.getText())) {
    					filtriranaListaPoSnazi.add(s);
    				}
    			}
    		}
 }	
    	filtriranaLista.clear();
    	if(filtriranaListaPoSnazi.isEmpty() == false || snagaUnesena) {
				filtriranaLista.addAll(filtriranaListaPoSnazi);
		}
		else if ((filtriranaListaPoOpisu.isEmpty() == false || opisUnesen)){
				filtriranaLista.addAll(filtriranaListaPoOpisu);
				
		} else if (filtriranaListaPoNaslovu.isEmpty() == false || naslovUnesen)	{
				filtriranaLista.addAll(filtriranaListaPoNaslovu);
		}else {
			filtriranaLista.addAll(listaArtikala);
		}
    	List<Automobil> filtriranaListaPoCijeni = new ArrayList<>();
    	boolean cijenaUnesena = false;
    	
    	if(cijenaTextField.getText().isEmpty() == false) {
			
    		cijenaUnesena = true;
    		
    		if (filtriranaListaPoSnazi.isEmpty() == false || snagaUnesena) {
    			for(Automobil s : filtriranaListaPoSnazi) {
    				if(s.getCijena().toString().equals(cijenaTextField.getText())) {
    					filtriranaListaPoCijeni.add(s);
    				}
    			}
    		}else if (filtriranaListaPoOpisu.isEmpty() == false || opisUnesen) {
    			for(Automobil s : filtriranaListaPoOpisu) {
    				if(s.getCijena().toString().equals(cijenaTextField.getText())) {
    					filtriranaListaPoCijeni.add(s);
    				}
    			}
    		}else if (filtriranaListaPoNaslovu.isEmpty() == false || naslovUnesen) {
    			for(Automobil s : filtriranaListaPoNaslovu) {
    				if(s.getCijena().toString().equals(cijenaTextField.getText())) {
    					filtriranaListaPoCijeni.add(s);
    				}
    			}
    		}else {
    			for(Automobil s : filtriranaLista) {
    				if(s.getCijena().toString().equals(cijenaTextField.getText())) {
    					filtriranaListaPoCijeni.add(s);
    				}
    			}
    		}
 }	
    	filtriranaLista.clear();
    	if(filtriranaListaPoCijeni.isEmpty() == false || cijenaUnesena) {
			filtriranaLista.addAll(filtriranaListaPoCijeni);
    	}else if(filtriranaListaPoSnazi.isEmpty() == false || snagaUnesena) {
				filtriranaLista.addAll(filtriranaListaPoSnazi);
		}else if ((filtriranaListaPoOpisu.isEmpty() == false || opisUnesen)){
				filtriranaLista.addAll(filtriranaListaPoOpisu);
				
		} else if (filtriranaListaPoNaslovu.isEmpty() == false || naslovUnesen)	{
				filtriranaLista.addAll(filtriranaListaPoNaslovu);
		}else {
			filtriranaLista.addAll(listaArtikala);
		}
    	tablicaAutomobila.setItems(FXCollections.observableArrayList(filtriranaLista));		
	
			
		}

	
	}
    



