package org.generation.italy.model;

public class Prodotto {
private String nome;
private double costo;
private int quantita;

public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public double getCosto() {
	return costo;
}
public void setCosto(double costo) {
	this.costo = costo;
}
public int getQuantita() {
	return quantita;
}
public void setQuantita(int quantita) {
	this.quantita = quantita;
}
public void registraVendita() {
	this.quantita--;
}
}
