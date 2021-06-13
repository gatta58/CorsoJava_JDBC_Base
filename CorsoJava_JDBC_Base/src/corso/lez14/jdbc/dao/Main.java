package corso.lez14.jdbc.dao;

import java.util.ArrayList;

import corso.lez14.jdbc.dao.models.Carta;
import corso.lez14.jdbc.dao.models.CartaDAO;
import corso.lez14.jdbc.dao.models.Persona;
import corso.lez14.jdbc.dao.models.PersonaDAO;

public class Main {

	public static void main(String[] args) {
		PersonaDAO perDao = new PersonaDAO();
		CartaDAO carDao = new CartaDAO();
		
		// prova INSERT persona
		System.out.println("\nInsert Persona ");
    	Persona gio = new Persona("Giovanni", "Pace", "PCAGNN");
  		perDao.insert(gio);
  		if(gio.getId() > 0) {
  			System.out.println("Inserimento effettuato con successo");
  		}
  		else {
  			System.out.println("Errore di inserimento");
  		}
  		
  		Persona mar = new Persona("Mario", "Rossi", "MRRRSS");
  		perDao.insert(mar);
  		if(mar.getId() > 0) {
  			System.out.println("Inserimento effettuato con successo");
  		}
  		else {
  			System.out.println("Errore di inserimento");
  		}
  		
  		Persona per3 = new Persona("Daniela", "Zanella", "ZNLDNL");
  		perDao.insert(per3);
  		if(per3.getId() > 0) {
  			System.out.println("Inserimento effettuato con successo");
  		}
  		else {
  			System.out.println("Errore di inserimento");
  		}
  		
  		Persona per4 = new Persona("Mario", "Grosso", "MRRGRS");
  		perDao.insert(per4);
  		if(per4.getId() > 0) {
  			System.out.println("Inserimento effettuato con successo");
  		}
  		else {
  			System.out.println("Errore di inserimento");
  		}
		
  		// select by ID persona
  		System.out.println("\nSELECT Persona findById");
		System.out.println(perDao.findById(1).toString());
		System.out.println(perDao.findById(2).toString());	
		
		// MODIFICA
		System.out.println("\nUPDATE Persona ");
		Persona ricercato = perDao.findById(2);
		System.out.println(ricercato.toString());
		
		ricercato.setNome("Saul");
		ricercato.setCognome("Goodman");
		ricercato.setCod_fis("SULGDM");
		
		if(perDao.update(ricercato)) {
			System.out.println("Modifica effettuata con successo, ecco i dettagli:");
			System.out.println(ricercato.toString());
		}
		else {
			System.out.println("Errore di esecuzione");
		}
		
		// prova SELECT ALL persona
		System.out.println("\nSELECT Persona findALL");
		ArrayList<Persona> elenco = (ArrayList<Persona>) perDao.findAll(); //Il cast è necessario perché la List si trasforma in ArrayList solo al Runtime
		//List<Persona> elenco = perDao.findAll();
		
		//Non va nel DAO perché non è una interazione con il DB!
		for(int i=0; i<elenco.size(); i++) {
			Persona temp = elenco.get(i);
			System.out.println(temp.toString());
		}
		
		//prova DELETE con ID persona
		System.out.println("\nDELETE Persona con parametro ID");
		if(perDao.delete(3)) {
			System.out.println("Eliminazione con ID effettuata con successo");
		}
		else {
			System.out.println("Errore in eliminazione con ID");
		}
		
		// prova DELETE con parametro Persona
		System.out.println("\nDELETE con parametro Persona");
		ricercato = perDao.findById(4);
		if(perDao.delete(ricercato)) {
			System.out.println("Eliminazione con parametro Persona effettuata con successo");
		}
		else {
			System.out.println("Errore in eliminazione con parametro Persona");
		}
			
		// prova INSERT di Carta Fedeltà
		System.out.println("\nINSERT Carta Fedeltá");
		Carta coop1 = new Carta("1234578","Coop");
		coop1.setRiferimento(gio);
		carDao.insert(coop1);
		if(coop1.getId() > 0) {
			System.out.println("Inserimento carta effettuato con successo");
		}
		else {
			System.out.println("Errore di inserimento carta");
		}
		
		System.out.println(carDao.findById(coop1.getId()).toString()+"\n");
		
		Carta conad1 = new Carta("1234599","Conad");
		conad1.setRiferimento(mar);
		carDao.insert(conad1);
		if(conad1.getId() > 0) {
			System.out.println("Inserimento carta effettuato con successo");
		}
		else {
			System.out.println("Errore di inserimento carta");
		}
		System.out.println(carDao.findById(conad1.getId()).toString()+"\n");
		
		Carta coop2 = new Carta("1234579","Coop");
		coop2.setRiferimento(mar);
		carDao.insert(coop2);
		if(coop2.getId() > 0) {
			System.out.println("Inserimento carta effettuato con successo");
		}
		else {
			System.out.println("Errore di inserimento carta");
		}
		System.out.println(carDao.findById(coop2.getId()).toString()+"\n");
		
		Carta conad2 = new Carta("1234600","Conad");
		conad2.setRiferimento(gio);
		carDao.insert(conad2);
		if (conad2.getId() > 0 ) {
			System.out.println("Inserimento carta effettuato con successo");
		}
		else {
			System.out.println("Errore di inserimento carta");
		}
		System.out.println(carDao.findById(conad2.getId()).toString()+"\n");
		
		
		// prova select FindALL
		System.out.println("\nFindALL Carta Fedeltá");
		ArrayList<Carta> elencoCarta = (ArrayList) carDao.findAll();
		
		System.out.println("\n Elenco Carte Fedeltá: ");
		for (int i=0; i < elencoCarta.size(); i++) {
			Carta temp = elencoCarta.get(i);
			System.out.println(temp.toString());
		}
		
		System.out.println("\n La carta 1 = " + carDao.findById(1).toString());
		
		// prova UPDATE
		System.out.println("\nUPDATE Carta Fedeltá");
		System.out.println("\nAggionare la carta: " + carDao.findById(conad2.getId()).toString());
		conad2.setNegozio("Esselunga");
		conad2.setNumero("1234567890");
		if(carDao.update(conad2)) {
			System.out.println("Aggiornamento effettuato con successo");
			System.out.println("\nCarta aggiornata: " + carDao.findById(conad2.getId()).toString());
		}
		else {
			System.out.println("Errore al realizzare update carta");
		}
		
		// prova DELETE con ID
		System.out.println("\nDELETE Carta Fedeltá con ID");
		System.out.println("\nEliminare la carta con ID: " + carDao.findById(conad1.getId()).toString());
		if (carDao.delete(conad1.getId())){
			System.out.println("Eliminazione con ID effettuata con successo");
		}
		else {
			System.out.println("Errore al realizzare il DELETE de la carta con ID");
		}
		
		// prova DELETE con la carta
		System.out.println("\nDELETE Carta Fedeltá con la Carta");
		System.out.println("\nEliminare la carta con CARTA: " + carDao.findById(coop1.getId()).toString());
		if (carDao.delete(coop1)){
			System.out.println("Eliminazione con CARTA effettuata con successo");
		}
		else {
			System.out.println("Errore al realizzare il DELETE con la carta");
		}
		
		
	}

};

