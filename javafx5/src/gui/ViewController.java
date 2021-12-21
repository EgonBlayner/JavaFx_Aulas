package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// Tem que implementar Initializable para poder usar os Constraints.
public class ViewController implements Initializable{
	
	@FXML
	private TextField txtNumber1;
	
	@FXML
	private TextField txtNumber2;
	
	@FXML
	private Label labelResult;
	
	// Tipo Button 
	@FXML
	private Button btSum;
	
	// Um controle pode ter vários eventos, abaixo criamos um evento.
	// Se usarmos null o cabeçalho sai.
	// O tipo do alert é uma enumeração.
	@FXML
	public void onBtSumAction() {
		try {
			Locale.setDefault(Locale.US);
			
			// Pegamos o conteúdo do txtNumber com o getText, porém como vem
			// em string nós convertemos para Double.
			double number1 = Double.parseDouble(txtNumber1.getText());
			double number2 = Double.parseDouble(txtNumber2.getText());
			double sum = number1 + number2;
			labelResult.setText(String.format("%.2f", sum));
		}
		// Tratamento para se digitarmos letras no lugar de números.
		catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}
	}

	// URL é o caminho da nossa tela e rb é alguns recursos que podemos usar.
	// Na maioria das vezes não vamos usar URL nem rb.
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// Só aceita números.
		Constraints.setTextFieldDouble(txtNumber1);
		Constraints.setTextFieldDouble(txtNumber2);
		// Máximo de casas decimais.
		Constraints.setTextFieldMaxLength(txtNumber1, 12);
		Constraints.setTextFieldMaxLength(txtNumber2, 12);
	}
}