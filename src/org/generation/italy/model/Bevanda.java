package org.generation.italy.model;

public class Bevanda extends Prodotto{
private boolean zuccherata;

public boolean isZuccherata() {
	return zuccherata;
}

public Bevanda(String nome, double costo, int quantita, boolean zuccherata) {
	super();
	this.setNome(nome);
	this.setCosto(costo);
	this.setQuantita(quantita);
	this.zuccherata = zuccherata;
}

public void setZuccherata(boolean zuccherata) {
	this.zuccherata = zuccherata;
}

@Override
public String toString() {
	boolean disponibile=false;
	if (getQuantita()>0) {
		disponibile=true;
	}
	return "Bevanda " +(isZuccherata()?"zuccherata ":"non zuccherata ") + getNome() + ", Costo: " + getCosto()
			+ ", Prodotto " +(disponibile?"Disponibile":"Non Disponibile");
}
}
