package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import gui.util.Alerts;

public class ViewController {
	
	// Tipo Button 
	@FXML
	private Button btMyButton;
	
	// Um controle pode ter v�rios eventos, abaixo criamos um evento.
	// Se usarmos null o cabe�alho sai.
	// O tipo do alert � uma enumera��o.
	@FXML
	public void onMyButtonClick() {
		Alerts.showAlert("Alert title", "Alert header", "Hello", AlertType.INFORMATION);
	}
}