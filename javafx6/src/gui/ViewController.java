package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entities.Person;

// Tem que implementar Initializable para poder usar os Constraints.
public class ViewController implements Initializable {

	// Vamos criar um atributo que vai ser uma associação com
	// o ComboBox da tela.
	
	// O ComboBox é um tipo genérico que espera um atributo,
	// nós vamos colocar um Person nele.
	@FXML
	private ComboBox<Person> comboBoxPerson;
	
	@FXML
	private Button btAll;

	// Vamos carregar a lista de pessoas dentro da caixa com
	// um atributo do tipo ObservableList, que é um tipo especial
	// de lista que fica associado ao componente visual, já implementa
	// um comportamento de interação entre o Combobox e a nossa coleção.
	private ObservableList<Person> obsList;
	
	@FXML
	public void onComboBoxPersonAction () {
		// Pega o item que foi selecionado no ComboBox.
		Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
		System.out.println(person);
	}
	
	// Ação do botão (imprimir todos os elementos).
	@FXML
	public void onBtAllAction() {
		for (Person person : comboBoxPerson.getItems()) {
			System.out.println(person);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "Maria", "maria@gmail.com"));
		list.add(new Person(2, "Alex", "alex@gmail.com"));
		list.add(new Person(3, "Bob", "bob@gmail.com"));

		// observableArrayList espera uma lista comum como argumento.
		obsList = FXCollections.observableArrayList(list);
		// Carrega os elementos no ComboBox.
		comboBoxPerson.setItems(obsList);
		
		// O código abaixo é para personalizar o toString.
		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
			@Override
			protected void updateItem(Person item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};
		
		comboBoxPerson.setCellFactory(factory);
		comboBoxPerson.setButtonCell(factory.call(null));
	}
}