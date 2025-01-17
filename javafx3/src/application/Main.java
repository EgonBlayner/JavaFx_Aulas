package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Uma aplica��o JavaFx tem que extender de Application.
// Somos obrigados a implementar o m�todo start.

/*
 * OBS: Existem ainda os m�todos init e stop. O init � para coisas que 
 * queremos que aconte�a antes da aplica��o iniciar e o stop � para coisas
 * que queremos que aconte�a depois da aplica��o terminar. O �nico m�todo
 * obrigat�rio � o start.
 */
public class Main extends Application {
	// O palco (stage) vem como argumento no m�todo start.
	@Override
	public void start(Stage stage) {
		try {
			// Carrega a tela num objeto do tipo Parent que � superclasse do 
			// AnchorPane do fxml (por isso da certo, pois � um upcasting).
			Parent parent = FXMLLoader.load(getClass().getResource("/gui/View.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene); // O palco vai ter a cena.
			stage.show(); // Mostra o palco na tela.
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Ponto de entrada da aplica��o.
	public static void main(String[] args) {
		// M�todo est�tico da classe Application que serve para
		// iniciar uma aplica��o JavaFx.
		launch(args);
	}
}