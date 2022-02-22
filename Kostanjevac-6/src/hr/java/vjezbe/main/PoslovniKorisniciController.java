package hr.java.vjezbe.main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import hr.java.vjezbe.entitet.PoslovniKorisnik;
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


public class PoslovniKorisniciController {
	
	public static final List<PoslovniKorisnik> listaPoslovnihKorisnika = new ArrayList<>();

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
	    private TextField nazivTextField;

	    @FXML
	    private TextField webTextField;

	    @FXML
	    private TextField telefonTextField;

	    @FXML
	    private Button pretraziKorisnike;

	    @FXML
	    private TableView<PoslovniKorisnik> tablicaPoslovniKorisnici;

	    @FXML
	    private TableColumn<PoslovniKorisnik, String> nazivTableColumn;

	    @FXML
	    private TableColumn<PoslovniKorisnik, String> webTableColumn;

	    @FXML
	    private TableColumn<PoslovniKorisnik, String> telefonTableColumn;

	    @FXML
	    private TableColumn<PoslovniKorisnik, String> emailTableColumn;

	    @FXML
	    private TextField emailTextField;



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
    	
    	
		
    	nazivTableColumn.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("naziv"));
		
    	webTableColumn.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("web"));
		
    	telefonTableColumn.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("telefon"));
		
    	emailTableColumn.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("email"));
		
		List<PoslovniKorisnik> unosLista = ProdajaController.dohvatiKontakte().stream().filter(p -> p instanceof PoslovniKorisnik).map(sc -> (PoslovniKorisnik)sc).collect(Collectors.toList());
		listaPoslovnihKorisnika.addAll(unosLista);
		tablicaPoslovniKorisnici.setItems(FXCollections.observableArrayList(unosLista));
		
    }
    
    @FXML
    private void stanoviPretrazivanje(ActionEvent event) {
    	
    	
    	
    	
    	List<PoslovniKorisnik> filtriranaLista = new ArrayList<>();
    	filtriranaLista.addAll(listaPoslovnihKorisnika);
    	
    	List<PoslovniKorisnik> filtriranaListaPoImenu = new ArrayList<>();
    	
    	boolean imeUneseno = false;
    	
    	if(nazivTextField.getText().isEmpty() == false) {
			
    		imeUneseno = true;
			
				for(PoslovniKorisnik s : filtriranaLista) {
					if(s.getNaziv().toLowerCase().contains(nazivTextField.getText().toLowerCase())) {
						filtriranaListaPoImenu.add(s);
					}
				}
			}
    	filtriranaLista.clear();
    	if(filtriranaListaPoImenu.isEmpty() == false || imeUneseno) {
				filtriranaLista.addAll(filtriranaListaPoImenu);
		}
		else {
				filtriranaLista.addAll(listaPoslovnihKorisnika);
		}
    	
    	List<PoslovniKorisnik> filtriranaListaPoPrezimenu = new ArrayList<>();
    	boolean prezimeUneseno = false;
    	
    		if(webTextField.getText().isEmpty() == false) {
			
    			prezimeUneseno = true;
			
    			if (filtriranaListaPoImenu.isEmpty() == false || imeUneseno) {
    				for(PoslovniKorisnik s : filtriranaListaPoImenu) {
    					if(s.getWeb().toLowerCase().contains(webTextField.getText().toLowerCase())) {
    						filtriranaListaPoPrezimenu.add(s);
    					}
    				}
    				
    			}else {
    				for(PoslovniKorisnik s : filtriranaLista) {
    					if(s.getWeb().toLowerCase().contains(webTextField.getText().toLowerCase())) {
    						filtriranaListaPoPrezimenu.add(s);
    					}
    				}
    			}
    		}
    	filtriranaLista.clear();
    	if(filtriranaListaPoPrezimenu.isEmpty() == false || prezimeUneseno) {
				filtriranaLista.addAll(filtriranaListaPoPrezimenu);
		}
		else if(filtriranaListaPoImenu.isEmpty() == false){
				filtriranaLista.addAll(filtriranaListaPoImenu);
		}else {
			filtriranaLista.addAll(listaPoslovnihKorisnika);
		}
    	
    	
    	List<PoslovniKorisnik> filtriranaListaPoTelefonu = new ArrayList<>();
    	boolean telefonUnesen = false;
    	
    	if(telefonTextField.getText().isEmpty() == false) {
			
    		telefonUnesen = true;
    		
    		 if (filtriranaListaPoPrezimenu.isEmpty() == false || prezimeUneseno) {
    			for(PoslovniKorisnik s : filtriranaListaPoPrezimenu) {
    				if(s.getTelefon().toLowerCase().contains(telefonTextField.getText().toLowerCase())) {
    					filtriranaListaPoTelefonu.add(s);
    				}
    			}
    		}else if (filtriranaListaPoImenu.isEmpty() == false || imeUneseno) {
    			for(PoslovniKorisnik s : filtriranaListaPoImenu) {
    				if(s.getTelefon().toLowerCase().contains(telefonTextField.getText().toLowerCase())) {
    					filtriranaListaPoTelefonu.add(s);
    				}
    			}
    		}else {
    			for(PoslovniKorisnik s : filtriranaLista) {
    				if(s.getTelefon().contains(telefonTextField.getText())) {
    					filtriranaListaPoTelefonu.add(s);
    				}
    			}
    		}
    	}	
    	filtriranaLista.clear();
    	if(filtriranaListaPoTelefonu.isEmpty() == false || telefonUnesen) {
			filtriranaLista.addAll(filtriranaListaPoTelefonu);
		}else if ((filtriranaListaPoPrezimenu.isEmpty() == false || prezimeUneseno)){
				filtriranaLista.addAll(filtriranaListaPoPrezimenu);
				
		} else if (filtriranaListaPoImenu.isEmpty() == false || imeUneseno)	{
				filtriranaLista.addAll(filtriranaListaPoImenu);
		}else {
			filtriranaLista.addAll(listaPoslovnihKorisnika);
		}
    	
    	
    	
    	List<PoslovniKorisnik> filtriranaListaPoEmailu = new ArrayList<>();
    	boolean emailUnesen = false;
    	
    	if(emailTextField.getText().isEmpty() == false) {
    		
    		emailUnesen = true;
    	if (filtriranaListaPoTelefonu.isEmpty() == false || telefonUnesen) {
    		for(PoslovniKorisnik s : filtriranaListaPoTelefonu) {
       			if(s.getEmail().toLowerCase().contains(emailTextField.getText().toLowerCase())) {
       				filtriranaListaPoEmailu.add(s);
       			}
       		}
    	}else if (filtriranaListaPoPrezimenu.isEmpty() == false || prezimeUneseno) {
   			for(PoslovniKorisnik s : filtriranaListaPoPrezimenu) {
   				if(s.getEmail().toLowerCase().contains(emailTextField.getText().toLowerCase())) {
   					filtriranaListaPoEmailu.add(s);
   				}
   			}
   		}else if (filtriranaListaPoImenu.isEmpty() == false || imeUneseno) {
   			for(PoslovniKorisnik s : filtriranaListaPoImenu) {
   				if(s.getEmail().toLowerCase().contains(emailTextField.getText().toLowerCase())) {
   					filtriranaListaPoEmailu.add(s);
   				}
   			}
   		}else {
   			for(PoslovniKorisnik s : filtriranaLista) {
   				if(s.getEmail().toLowerCase().contains(emailTextField.getText().toLowerCase())) {
   					filtriranaListaPoEmailu.add(s);
   				}
   			}
    	}
    	}
    	
    	filtriranaLista.clear();
    	if(filtriranaListaPoEmailu.isEmpty() == false || emailUnesen) {
			filtriranaLista.addAll(filtriranaListaPoEmailu);
    	}else if(filtriranaListaPoTelefonu.isEmpty() == false || telefonUnesen) {
			filtriranaLista.addAll(filtriranaListaPoTelefonu);
		}else if ((filtriranaListaPoPrezimenu.isEmpty() == false || prezimeUneseno)){
				filtriranaLista.addAll(filtriranaListaPoPrezimenu);		
		} else if (filtriranaListaPoImenu.isEmpty() == false || imeUneseno)	{
				filtriranaLista.addAll(filtriranaListaPoImenu);
		}else {
			filtriranaLista.addAll(listaPoslovnihKorisnika);
		}
    	tablicaPoslovniKorisnici.setItems(FXCollections.observableArrayList(filtriranaLista));		
	
			
		}

	
	}
    



