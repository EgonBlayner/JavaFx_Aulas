package gui.util;

import javafx.scene.control.TextField;

public class Constraints {
	// O Lissener vai controlar o comportamento dos nossos controles.
	
	// O Lissener é uma função que será executada quando o controle
	// sofrer alguma modificação ou interação com o usuário.
	public static void setTextFieldInteger(TextField txt) {
		// No addLissener vamos passar como argumento uma função que queremos
		// que execute quando a caixa de texto sofrer alguma interação com
		// o usuário.
		
		// Estamos passando essa função na forma de expressão lambda, que
		// vai receber 3 argumentos.
		
		// obs: é uma referência para o controle.
		// oldValeu: é o valor que o controle tinha antes de mexermos nele.
		// newValeu: é o novo valor do controle depois de mexermos nele.
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			// Depois de mexermos no controle vamos verificar se o valor 
			// não é nulo e também se ele atende a um expressão regular.
			
			// \\d* é uma expressão regular para qualquer quantidade apenas
			// de digitos numéricos.
			if (newValue != null && !newValue.matches("\\d*")) {
				// Se não for digitos numéricos vamos setar para o valor antigo.
				txt.setText(oldValue);
			}
		});
	}

	public static void setTextFieldMaxLength(TextField txt, int max) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() > max) {
				txt.setText(oldValue);
			}
		});
	}

	public static void setTextFieldDouble(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) {
				txt.setText(oldValue);
			}
		});
	}
}