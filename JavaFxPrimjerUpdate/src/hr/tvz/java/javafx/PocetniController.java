package hr.tvz.java.javafx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class PocetniController {
	
	public static final List<Student> listaStudenata = new ArrayList<>();

	@FXML
	private TextField imeTextField;
	
	@FXML
	private TextField prezimeTextField;
	
	@FXML
	private TextField jmbagTextField;
	
	@FXML
	private TableView<Student> tablicaStudenata;
	
	@FXML
	private TableColumn<Student, String> imeStudentaTableColumn;
	
	@FXML
	private TableColumn<Student, String> prezimeStudentaTableColumn;
	
	@FXML
	private TableColumn<Student, String> jmbagStudentaTableColumn;
	
	@FXML
	public void initialize() {
		Student student = new Student("Pero", "Periæ", "2039482039");
		
		imeStudentaTableColumn
		.setCellValueFactory(new PropertyValueFactory<Student, String>("ime"));
		
		prezimeStudentaTableColumn
		.setCellValueFactory(new PropertyValueFactory<Student, String>("prezime"));
		
		jmbagStudentaTableColumn
		.setCellValueFactory(new PropertyValueFactory<Student, String>("jmbag"));
		
		
		listaStudenata.add(student);
		
		
	}
	
	public void pretraziStudente() {
		
		List<Student> filtriranaLista = new ArrayList<>();
		filtriranaLista.addAll(listaStudenata);
		
		List<Student> filtriranaListaPoImenu = new ArrayList<>();
		
		boolean imeUneseno = false;
		
		if(imeTextField.getText().isEmpty() == false) {
			
			imeUneseno = true;
			
			for(Student s : filtriranaLista) {
				if(s.getIme().equals(imeTextField.getText())) {
					filtriranaListaPoImenu.add(s);
				}
			}
		}
		
		filtriranaLista.clear();
		if(filtriranaListaPoImenu.isEmpty() == false || imeUneseno) {
			filtriranaLista.addAll(filtriranaListaPoImenu);
		}
		else {
			filtriranaLista.addAll(listaStudenata);
		}
		
		List<Student> filtriranaListaPoPrezimenu = new ArrayList<>();
		boolean prezimeUneseno = false;
		
		if(prezimeTextField.getText().isEmpty() == false) {
			prezimeUneseno = true;
			
			for(Student s : filtriranaLista) {
				if(s.getPrezime().equals(prezimeTextField.getText())) {
					filtriranaListaPoPrezimenu.add(s);
				}
			}
		}
		
		filtriranaLista.clear();
		if(filtriranaListaPoPrezimenu.isEmpty() == false || prezimeUneseno) {
			filtriranaLista.addAll(filtriranaListaPoPrezimenu);
		}
		else {
			filtriranaLista.addAll(filtriranaListaPoImenu);
		}
		
		tablicaStudenata.setItems(FXCollections.observableArrayList(filtriranaLista));
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

