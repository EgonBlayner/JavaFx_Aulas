package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ViewController {
	
	// Tipo Button 
	@FXML
	private Button btMyButton;
	
	// Um controle pode ter v�rios eventos,
	// abaixo criamos um evento.
	@FXML
	public void onMyButtonClick() {
		System.out.println("Hello!");
	}
}