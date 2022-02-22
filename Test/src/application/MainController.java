package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class MainController {
	
	@FXML
	private Label result;
	
	private long num1 = 0;
	private long num2 = 0;
	private String operator = "";
	private boolean start = true;
	private Model model = new Model();

	public void processNumbers(ActionEvent event) {
		if (start) {
			result.setText("");
			start = false;
		}
		String value = ((Button)event.getSource()).getText();
		result.setText(result.getText()+ value);
	}
	public void processOperator(ActionEvent event) {
		String value = ((Button)event.getSource()).getText();
		
		if (value.equals("=")) {
			if (value.isEmpty()) {
				return;
			}
		
			num2 = Long.parseLong(result.getText());
			float output = model.calculate(num1, num2, operator);
			result.setText(String.valueOf(output));
			operator = "";
			start = true;
		
		}else {
			operator = value;
			num1 = Long.parseLong(result.getText());
			result.setText("");
			if (operator.isEmpty())
				return;
			
			
			
		}
	}
}
