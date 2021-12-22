package gui.util;

import javafx.scene.control.TextField;

public class Constraints {
	// 1-> Esses m�todos adicionam um Listener nos nossos controles que
	// ir� controlar o comportamento do nosso controle.
	
	// 2-> O Listener � uma fun��o que ser� executada quando o controle fizer
	// alguma intera��o com o usu�rio.
	
	// 3-> No caso da caixa de texto (TextField) � s� chamarmos apartir dela
	// o textProperty e depois o addListener, nesse addListener iremos 
	// passar como argumento uma fun��o quer voc� quer que execute quando
	// essa caixa de texto sofrer alguma altera��o. Vamos passar essa fun��o
	// na forma de express�o lambda, essa express�o lambda vai receber 3 
	// argumentos.
	
	// 4-> O obs � uma refer�ncia para o controle, oldValue � o valor 
	// que o controle tinha antes de mexermos nele e o novo valor do 
	// controle depois que a gente mexeu.
	public static void setTextFieldInteger(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			
			// 1-> Quando a gente mexer no controle e gerarmos um novo valor para ele
			// vamos verificar se esse novo valor n�o � nule e se ele atende a uma 
			// express�o regular. Aqui estamos testando se o novo valor � um n�mero inteiro,
			// a express�o regular de um n�mero inteiro � \\d* .
			if (newValue != null && !newValue.matches("\\d*")) {
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