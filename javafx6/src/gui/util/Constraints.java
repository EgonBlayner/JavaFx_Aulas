package gui.util;

import javafx.scene.control.TextField;

public class Constraints {
	// O Lissener vai controlar o comportamento dos nossos controles.
	
	// O Lissener � uma fun��o que ser� executada quando o controle
	// sofrer alguma modifica��o ou intera��o com o usu�rio.
	public static void setTextFieldInteger(TextField txt) {
		// No addLissener vamos passar como argumento uma fun��o que queremos
		// que execute quando a caixa de texto sofrer alguma intera��o com
		// o usu�rio.
		
		// Estamos passando essa fun��o na forma de express�o lambda, que
		// vai receber 3 argumentos.
		
		// obs: � uma refer�ncia para o controle.
		// oldValeu: � o valor que o controle tinha antes de mexermos nele.
		// newValeu: � o novo valor do controle depois de mexermos nele.
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			// Depois de mexermos no controle vamos verificar se o valor 
			// n�o � nulo e tamb�m se ele atende a um express�o regular.
			
			// \\d* � uma express�o regular para qualquer quantidade apenas
			// de digitos num�ricos.
			if (newValue != null && !newValue.matches("\\d*")) {
				// Se n�o for digitos num�ricos vamos setar para o valor antigo.
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