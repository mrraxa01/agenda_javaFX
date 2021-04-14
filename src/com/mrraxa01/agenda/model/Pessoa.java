package com.mrraxa01.agenda.model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pessoa {
	
	private StringProperty nome;
	private StringProperty sobrenome;
	private ObjectProperty<LocalDate> dataNascimento;
	
	public Pessoa() {}

	public Pessoa(String nome, String sobrenome, LocalDate dataNascimento) {
		this.nome = new SimpleStringProperty(nome);
		this.sobrenome = new SimpleStringProperty(sobrenome);
		this.dataNascimento = new SimpleObjectProperty<LocalDate>(dataNascimento);
	}
	
	public String getNome() {
		return this.nome.get();
	}
	public void setNome(String nome) {
		this.nome.set(nome);
	}

	public StringProperty nomeProperty() {
		return this.nome;
	}
	
	public String getSobrenome() {
		return this.sobrenome.get();
	}
	
	public void SetSobrenome(String sobrenome) {
		this.sobrenome.set(sobrenome);
	}
	
	public StringProperty sobrenomeProperty() {
		return this.sobrenome;
	}
	
	
	public LocalDate getDataNascimento() {
		return this.dataNascimento.get();
	} 
	
	public void setDataNascimento(LocalDate datanascimento) {
		this.dataNascimento.setValue(datanascimento);
	}
	
	public ObjectProperty<LocalDate> dataNascimentoProperty(){
		return this.dataNascimento;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}