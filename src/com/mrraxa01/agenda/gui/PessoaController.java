package com.mrraxa01.agenda.gui;

import com.mrraxa01.agenda.Main;
import com.mrraxa01.agenda.model.Pessoa;
import com.mrraxa01.agenda.util.DateUtil;

import javafx.fxml.FXML;
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
}


