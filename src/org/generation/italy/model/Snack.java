package org.generation.italy.model;

public class Snack extends Prodotto{
private int peso;

public int getPeso() {
	return peso;
}

public Snack(String nome, double costo, int quantita, int peso) {
	super();
	this.setNome(nome);
	this.setCosto(costo);
	this.setQuantita(quantita);
	this.peso = peso;
}

public void setPeso(int peso) {
	this.peso = peso;
}
@Override
public String toString() {
	boolean disponibile=false;
	if (getQuantita()>0) {
		disponibile=true;
	}
	return "Snack " + getNome() + ", Costo: " + getCosto()
	+", Peso: "+getPeso()+ ", Prodotto " +(disponibile?"Disponibile":"Non Disponibile");
}

}
