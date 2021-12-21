package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import gui.util.Alerts;

public class ViewController {
	
	// Tipo Button 
	@FXML
	private Button btMyButton;
	
	// Um controle pode ter vários eventos, abaixo criamos um evento.
	// Se usarmos null o cabeçalho sai.
	// O tipo do alert é uma enumeração.
	@FXML
	public void onMyButtonClick() {
		Alerts.showAlert("Alert title", "Alert header", "Hello", AlertType.INFORMATION);
	}
}