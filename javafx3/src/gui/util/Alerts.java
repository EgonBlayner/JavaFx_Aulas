package gui.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerts {
	// Função estática para gerar um alert.
	public static void showAlert(String title, String header, String content, AlertType type) {
		Alert alert = new Alert(type); // Cria um obj alert.
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
	}
}
