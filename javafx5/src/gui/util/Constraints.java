package gui.util;

import javafx.scene.control.TextField;

public class Constraints {
	// 1-> Esses métodos adicionam um Listener nos nossos controles que
	// irá controlar o comportamento do nosso controle.
	
	// 2-> O Listener é uma função que será executada quando o controle fizer
	// alguma interação com o usuário.
	
	// 3-> No caso da caixa de texto (TextField) é só chamarmos apartir dela
	// o textProperty e depois o addListener, nesse addListener iremos 
	// passar como argumento uma função quer você quer que execute quando
	// essa caixa de texto sofrer alguma alteração. Vamos passar essa função
	// na forma de expressão lambda, essa expressão lambda vai receber 3 
	// argumentos.
	
	// 4-> O obs é uma referência para o controle, oldValue é o valor 
	// que o controle tinha antes de mexermos nele e o novo valor do 
	// controle depois que a gente mexeu.
	public static void setTextFieldInteger(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			
			// 1-> Quando a gente mexer no controle e gerarmos um novo valor para ele
			// vamos verificar se esse novo valor não é nule e se ele atende a uma 
			// expressão regular. Aqui estamos testando se o novo valor é um número inteiro,
			// a expressão regular de um número inteiro é \\d* .
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