package gui;

import java.util.Locale;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController {
	
	@FXML
	private TextField txtNumber1;
	
	@FXML
	private TextField txtNumber2;
	
	@FXML
	private Label labelResult;
	
	// Tipo Button 
	@FXML
	private Button btSum;
	
	// Um controle pode ter v�rios eventos, abaixo criamos um evento.
	// Se usarmos null o cabe�alho sai.
	// O tipo do alert � uma enumera��o.
	@FXML
	public void onBtSumAction() {
		try {
			Locale.setDefault(Locale.US);
			
			// Pegamos o conte�do do txtNumber com o getText, por�m como vem
			// em string n�s convertemos para Double.
			double number1 = Double.parseDouble(txtNumber1.getText());
			double number2 = Double.parseDouble(txtNumber2.getText());
			double sum = number1 + number2;
			labelResult.setText(String.format("%.2f", sum));
		}
		// Tratamento para se digitarmos letras no lugar de n�meros.
		catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}
	}
}