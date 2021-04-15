package com.mrraxa01.agenda.gui;

import com.mrraxa01.agenda.Main;
import com.mrraxa01.agenda.model.Pessoa;
import com.mrraxa01.agenda.util.DateUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PessoaController {

	@FXML
	private TableView<Pessoa> tabela;
	@FXML
	private TableColumn<Pessoa, String> colunaNome;
	@FXML
	private TableColumn<Pessoa, String> colunaSobrenome;
	
	@FXML
	private Label rotuloNome;
	@FXML
	private Label rotuloSobrenome;
	@FXML
	private Label rotuloDataNascimento;
	
	private Main main;
	
	public PessoaController() {}
	
	@FXML
	private void initialize() {
		colunaNome.setCellValueFactory(celula -> celula.getValue().nomeProperty());
		colunaSobrenome.setCellValueFactory(celula -> celula.getValue().sobrenomeProperty());
		
		mostraDetalhe(null);
		
		tabela.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> mostraDetalhe(newValue));
	}
	
	public void setMain(Main main) {
		this.main = main;
		this.tabela.setItems(main.getDados());
	}

	private void mostraDetalhe(Pessoa pessoa) {
		if(pessoa != null) {
			rotuloNome.setText(pessoa.getNome());
			rotuloSobrenome.setText(pessoa.getSobrenome());
			rotuloDataNascimento.setText(DateUtil.format(pessoa.getDataNascimento()));
		} else {
			rotuloNome.setText("");
			rotuloSobrenome.setText("");
			rotuloDataNascimento.setText("");
		}
		
	}
	
	@FXML
	private void handleNovaPessoa() {
		Pessoa temp = new Pessoa();
		boolean okClicked = main.mostrarContatoDialog(temp);
		if(okClicked) {
			main.getDados().add(temp);
		}
	
	}
	
	@FXML
	private void handleExcluiPessoa() {
		int selecionado = tabela.getSelectionModel().getSelectedIndex();
		if(selecionado >= 0) {
			tabela.getItems().remove(selecionado);
		}else {
			emiteAlerta("Erro ao excluir", "Nenhum item selecionado!", "Por favor, selecione um item para excluir!");
		}
	}


	
	@FXML
	private void handleEditarPessoa() {
		Pessoa selecionada = tabela.getSelectionModel().getSelectedItem();
		if(selecionada != null) {
			boolean onClicked = main.mostrarContatoDialog(selecionada);
			if(onClicked) this.mostraDetalhe(selecionada);
					
		}else {
			
			emiteAlerta("Erro ao editar", "Nenhum item selecionado!", "Por favor, selecione um item para editar!");
		}
		
	}
	
	private void emiteAlerta(String title, String header, String content) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
}


