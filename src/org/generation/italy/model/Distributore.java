package org.generation.italy.model;

/*
 * creare una classe Distributore con i seguenti attributi privati: credito (double), elencoProdotti (array di 3 oggetti della classe Bevanda e 3 oggetti della classe Snack)
creare il costruttore della classe Distributore (senza parametri) che imposta a 0 il credito e inizializza l'array dei prodotti con 6 prodotti a  scelta (per ogni prodotto indicare in maniera fissa il nome, il costo, la quantità 
e zuccherata/grammi a seconda della tipologia).
Es: elencoProdotti[0]=new Bevanda("Aranciata", 1.70, 20, true);
       elencoProdotti[1]=new Snack("Patatine", 1.10, 10, 100);
creare un metodo inserisciMoneta(double moneta) che incrementa il credito del valore della moneta. Le monete accettate sono: 0.10, 0.20, 0.50, 1, 2 (verificare all'interno del metodo la validità della moneta).
creare un metodo erogaProdotto(int nrProdotto). 
Se il credito è sufficiente, il metodo mostra un messaggio del tipo: 
se il prodotto è una bevanda: "Bevanda <nome bevanda> erogata correttamente - tipologia: <zuccherata/non zuccherata>" (il nome della bevanda e la tipologia devono essere quelli della bevanda selezionata)
se il prodotto è uno snack: "Snack <nome snack> erogato correttamente - grammi: <quantità grammi>" (il nome dello snack e i grammi devono essere quelli dello snack selezionato)
aggiorna il credito del distributore e la quantità del prodotto.
Se la quantità è 0 il prodotto non può essere erogato
Il nrProdotto indica la posizione nell'array;
Se il credito non è sufficiente mostra il messaggio: "Credito insufficiente"
Creare un metodo visualizzaProdotti() che mostra a video l'elenco dei prodotti (per ognuno mostrarne la tipologia)
Creare un metodo erogaResto() che mostra il messaggio "Resto erogato: <importo resto>" e azzera il credito
 */
public class Distributore {
	private double credito;
	Prodotto[] elencoProdotti = new Prodotto[6];

	public Distributore() {
		super();
		this.credito = 0;
		this.elencoProdotti[0] = new Bevanda("Aranciata", 1.70, 20, true);
		this.elencoProdotti[1] = new Bevanda("Limonata", 1.0, 20, true);
		this.elencoProdotti[2] = new Bevanda("Acqua", 0.50, 20, false);
		this.elencoProdotti[3] = new Snack("Patatine", 1.10, 10, 70);
		this.elencoProdotti[4] = new Snack("Croccantelle", 0.50, 10, 50);
		this.elencoProdotti[5] = new Snack("Bruschettini", 0.80, 10, 80);

	}

	public String inserisciMoneta(double creditoIns) {
		if (creditoIns == 0.10 || creditoIns == 0.20 || creditoIns == 0.50 || creditoIns == 1 || creditoIns == 2) {
			this.credito += creditoIns;
			return ("Credito attuale =" + credito + "€.");
		} else {
			return ("Moneta non accettata!");
		}
	}

	public String erogaProdotto(int nrProd) {
		if (elencoProdotti[nrProd].getCosto() < credito && elencoProdotti[nrProd].getQuantita() > 0) {
			elencoProdotti[nrProd].registraVendita();
			this.credito -= elencoProdotti[nrProd].getCosto();
			if (elencoProdotti[nrProd] instanceof Bevanda) {
				Bevanda bev = (Bevanda) elencoProdotti[nrProd];
				return ("Bevanda " + bev.getNome() + " Erogata correttamente. Tipologia : "
						+ ((bev.isZuccherata()) ? "Zuccherata" : "Non Zuccherata"));
			} else if ((elencoProdotti[nrProd] instanceof Snack)) {
				Snack snk = (Snack) elencoProdotti[nrProd];
				return "Snack " + snk.getNome() + " Erogato correttamente. Peso: " + snk.getPeso() + " grammi.";
			}
		} else if (elencoProdotti[nrProd].getCosto() < credito) {
			return ("Credito Insufficiente");
		} else if (elencoProdotti[nrProd].getQuantita() > 0) {
			return "Prodotto Esaurito";
		}
		return "ciao belo";
	}

	public String erogaResto() {
		double resto = this.credito;
		this.credito = 0;
		return "Resto erogato :" + resto + "€.";
	}

	public String visualizzaProdotto(int nrProd) {
		if (elencoProdotti[nrProd] instanceof Bevanda) {
			Bevanda bev = (Bevanda) elencoProdotti[nrProd];
			return bev.toString();

		} else if (elencoProdotti[nrProd] instanceof Snack) {
			Snack snk = (Snack) elencoProdotti[nrProd];
			return snk.toString();
		}
		return "";
	}
	public Prodotto[] getElencoProd() {
		return elencoProdotti;
	}
	public double getCredito() {
		return credito;
	}
}
