package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

// Uma aplicação JavaFx tem que extender de Application.
// Somos obrigados a implementar o método start.

/*
 * OBS: Existem ainda os métodos init e stop. O init é para coisas que 
 * queremos que aconteça antes da aplicação iniciar e o stop é para coisas
 * que queremos que aconteça depois da aplicação terminar. O único método
 * obrigatório é o start.
 */
public class Main extends Application {
	// O palco (stage) vem como argumento no método start.
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane(); // Cria um obj de painel.
			Scene scene = new Scene(root,400,400); // Cria um obj de cena.
			// Essa linha pega os estilos do CSS.
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene); // Dentro do palco temos a cena.
			primaryStage.show(); // Mostrar o palco na tela.
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Ponto de entrada da aplicação. 
	public static void main(String[] args) {
		// Método estático da classe Application que serve para 
		// iniciar uma aplicação JavaFx.
		launch(args); 
	}
}