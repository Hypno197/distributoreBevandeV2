package org.generation.italy;

import java.util.Scanner;

import org.generation.italy.model.Distributore;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Distributore dis=new Distributore();
		int scelta=0, codProd;
		double moneta;
		boolean esci=false;
		do {
			try {
		for(int i=0; i<dis.getElencoProd().length; i++)
		System.out.println("Codice "+i+":\n"+dis.visualizzaProdotto(i)+"\n");
		double sarchio=Math.round(dis.getCredito()*100.0)/100.0;
		System.out.println("Credito disponibile: "+sarchio);
		System.out.println("Scegli l'operazione da eseguire: ");
		System.out.println("1. Inserisci moneta");
		System.out.println("2. Eroga Prodotto");
		System.out.println("3. Eroga Resto");
		System.out.println("4. Esci");
		scelta=sc.nextInt();
		sc.nextLine();
		switch (scelta) {
		case 1 :{
			System.out.println("Inserire il valore della moneta: ");
			moneta=sc.nextDouble();
			sc.nextLine();
			System.out.println(dis.inserisciMoneta(moneta));
			System.out.println("Premi invio per continuare..");
			sc.nextLine();
			break;
		}
		case 2 :{
			System.out.println("Inserisci il codice del prodotto da erogare: ");
			codProd=sc.nextInt();
			sc.nextLine();
			System.out.println(dis.erogaProdotto(codProd));
			sarchio=Math.round(dis.getCredito()*100.0)/100.0;
			System.out.println("Credito disponibile: "+sarchio);
			System.out.println("Premi invio per continuare..");
			sc.nextLine();
			break;
		}
		case 3 :{
			System.out.println(dis.erogaResto());
			System.out.println("Premi invio per continuare..");
			sc.nextLine();
			break;
		}
		case 4 :{
			esci=true;
			break;
		}
		default: {
			System.out.println("Selezione non valida!");
			System.out.println("Premi invio per continuare..");
			sc.nextLine();
			break;
		}
		}
		
		}catch (Exception e) {
			System.err.println("Errore: "+e.getMessage());			}
			}while(!esci);
					
			sc.close();
	}

}
