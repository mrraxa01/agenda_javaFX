package com.mrraxa01.agenda;
	
import java.io.IOException;
import java.time.LocalDate;

import com.mrraxa01.agenda.gui.PessoaController;
import com.mrraxa01.agenda.model.Pessoa;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane principal; //declara o elemento anchorpane que foi utilizado para criar o fxml

	//o observableList permite capturar as alterações
	//private ObservableList<Pessoa> dados = FXCollections.observableArrayList();
	private ObservableList<Pessoa> dados = FXCollections.observableArrayList();
	
	public Main() {
		dados.add(new Pessoa("Andrey","Masiero", LocalDate.of(1983, 10, 29)));
		dados.add(new Pessoa("Nelson","Mandela", LocalDate.of(1918, 7, 18)));
		dados.add(new Pessoa("Frida","Kahlo", LocalDate.of(1907, 7, 6)));
		dados.add(new Pessoa("Ada","Lovelace", LocalDate.of(1815, 10, 12)));
		dados.add(new Pessoa("Karen","Horney", LocalDate.of(1885, 9, 16)));
	}	
	
		
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		//Título do aplicativo
		this.primaryStage.setTitle("Agenda App");
		//chamada do método para iniciar o stage
		initMainStage();
		carregarTela();
	
		
	}
	
	private void carregarTela() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("gui/Principal.fxml"));
			AnchorPane pessoasView = (AnchorPane) loader.load();

			this.principal.setCenter(pessoasView);

			PessoaController controller = loader.getController();
			controller.setMain(this);

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
		



	private void initMainStage() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("gui/Container.fxml"));
			//carrega o load no principal declarado no inicio com casting do anchopaner
			this.principal = (BorderPane) loader.load();
			
			Scene cena = new Scene(this.principal);
			
			
			this.primaryStage.setScene(cena);
			this.primaryStage.show();
			//PessoaController controller = loader.getController();
			//controller.setMain(this);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}




	public ObservableList<Pessoa> getDados() {
		
		return this.dados;
	}
}
