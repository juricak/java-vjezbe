package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class MainController implements Initializable{


	@FXML 
	public Label myLabel;
	
	@FXML
	public ComboBox<String> combobox;
	
	@FXML
	public ListView<String> listview;
	
	ObservableList<String> list = FXCollections.observableArrayList("Mark", "Tom", "Jack", "Darko");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//combobox.setItems(list);
		listview.setItems(list);
		listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
	
	public void comboChanged(ActionEvent event) {
		
		//myLabel.setText(combobox.getValue());
		
	}

}
