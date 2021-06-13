package corso.lez14.jdbc.gestionelibri.dao;

import java.util.ArrayList;

import corso.lez14.jdbc.dao.models.Carta;
import corso.lez14.jdbc.gestionelibri.dao.models.Autore;
import corso.lez14.jdbc.gestionelibri.dao.models.AutoreDAO;
import corso.lez14.jdbc.gestionelibri.dao.models.Libro;
import corso.lez14.jdbc.gestionelibri.dao.models.LibroAutore;
import corso.lez14.jdbc.gestionelibri.dao.models.LibroAutoreDAO;
import corso.lez14.jdbc.gestionelibri.dao.models.LibroDAO;

public class Main {

	public static void main(String[] args) {
		
		AutoreDAO autoDao = new AutoreDAO();
		LibroDAO libroDao = new LibroDAO();
		LibroAutoreDAO libAutDAO = new LibroAutoreDAO();

		// prova inserimento autore
		System.out.println("\nInsert Autore ");
				
		Autore auto1 = new Autore("Nome1", "Cognome1", "1960-01-12", "nom1ape1");
		autoDao.insert(auto1);
		
		if (auto1.getId()> 0) {
			System.out.println("Inserimento autore effettuato con successo Id = 1");
			System.out.println(auto1.toString());
		}
		else {
			System.out.println("Errore al inserire autore");
		}
		
		Autore auto2 = new Autore("Nome2", "Cognome2", "1970-10-12", "nom2ape2");
		autoDao.insert(auto2);
		
		if (auto2.getId()> 0) {
			System.out.println("Inserimento autore effettuato con successo Id = 2");
			System.out.println(auto2.toString());
		}
		else {
			System.out.println("Errore al inserire autore");
		}

		Autore auto3 = new Autore("Nome3", "Cognome3", "1997-02-25", "nom3ape3");
		autoDao.insert(auto3);
		
		if (auto3.getId()> 0) {
			System.out.println("Inserimento autore effettuato con successo Id = 3");
			System.out.println(auto3.toString());
		}
		else {
			System.out.println("Errore al inserire autore");
		}

		Autore auto4 = new Autore("Nome4", "Cognome4", "2014-09-20", "nom4ape4");
		autoDao.insert(auto4);
		
		if (auto4.getId()> 0) {
			System.out.println("Inserimento autore effettuato con successo Id = 4");
			System.out.println(auto4.toString());
		}
		else {
			System.out.println("Errore al inserire autore");
		}
		
		// prova SELECT byiD
		System.out.println("\nSELECT findById Autore ");
		Autore temp = autoDao.findById(1);
		System.out.println(temp.toString());
		
		int id = auto2.getId();
		System.out.println(autoDao.findById(id).toString());
		

		// prova select *
		System.out.println("\nSELECT findALL Autore ");
		ArrayList<Autore> elencoAutori = (ArrayList) autoDao.findAll();
				
		System.out.println("\n Elenco Autori: ");
		for (int i=0; i < elencoAutori.size(); i++) {
			temp = elencoAutori.get(i);
			System.out.println(temp.toString());
		}	
		
//		// prova del delete con id
//		System.out.println("\nDELETE Autore con parametro ID ");
//		
//		if(autoDao.delete(3)) {
//			System.out.println("DELETE di Autore con parametro Id effettuato con successo");
//		}
//		else {
//			System.out.println("Errore in DELETE con ID");
//		}
//		
//		// prova del delete con parametro autore
//		System.out.println("\nDELETE con parametro Autore");
//		temp = autoDao.findById(4);
//		if(autoDao.delete(temp)) {
//			System.out.println("DELETE con parametro Autore effettuato con successo");
//		}
//		else {
//			System.out.println("Errore in DELETE con parametro Autore");
//		}
		
		// prova UPDATE
		System.out.println("\nUPDATE di Autore");
		
		Autore ricercato = autoDao.findById(2);
		System.out.println(ricercato.toString());
		ricercato.setNome("Nome modificato");
		ricercato.setCognome("Cognome modificato");
		ricercato.setData_nascita("1999/09/19");
		
		if(autoDao.update(ricercato)) {
			System.out.println("Modifica effettuata con successo, ecco i dettagli: ");
			System.out.println(ricercato.toString());
		}
		else {
			System.out.println("Errore in UPDATE del Autore");
		}
		
		//Elenco autori aggiornato
		elencoAutori = (ArrayList) autoDao.findAll();
		System.out.println("\n Elenco Autori aggiornato: ");
		for (int i=0; i < elencoAutori.size(); i++) {
			temp = elencoAutori.get(i);
			System.out.println(temp.toString());
		}	
		
		// -------------- PROVE CON LIBRO --------------------------------------------
		// prova INSERT Libro
		System.out.println("\n------------- PROVE CON Libro ------------------------------");
		
		System.out.println("\n------------- INSERT di Libro");
		
		Autore tempAutore = autoDao.findById(1);
		Libro libro1 = new Libro("Titolo1", "ISBN1234","Descrizione libro1");
		libro1.setAutore_libro(tempAutore);
		libroDao.insert(libro1);
		
		if(libro1.getId() > 0) {
			System.out.println("Inserimento libro effettuato con successo id = " + libro1.getId());
		}
		else {
			System.out.println("Errore in inserimento libro");
		}
		
		tempAutore = autoDao.findById(2);
		Libro libro2 = new Libro("Titolo2", "ISBN4567", "Descrizione libro2");
		libro2.setAutore_libro(tempAutore);
		libroDao.insert(libro2);
		
		if(libro2.getId() > 0) {
			System.out.println("Inserimento libro efettuato con successo id = " + libro2.getId());
		}
		else {
			System.out.println("Errore in inserimento libro");
		}

		tempAutore = autoDao.findById(4);
		Libro libro3 = new Libro("Titolo3","ISBN7890", "Descrizione libro3");
		libro3.setAutore_libro(tempAutore);
		libroDao.insert(libro3);
		
		if(libro3.getId() > 0) {
			System.out.println("Inserimento libro efettuato con successo id = " + libro3.getId());
		}
		else {
			System.out.println("Errore in inserimento libro");
		}
		
		tempAutore = autoDao.findById(3);
		Libro libro4 = new Libro("Titolo4", "ISBN0987", "Descrizione libro4");
		libro4.setAutore_libro(tempAutore);
		libroDao.insert(libro4);
		
		if(libro4.getId() > 0) {
			System.out.println("Inserimento libro efettuato con successo id = " + libro4.getId());
		}
		else {
			System.out.println("Errore in inserimento libro");
		}

		// prova findALL libri
		System.out.println("\n------------- findALL di Libro");
		ArrayList<Libro> elencoLibri = (ArrayList) libroDao.findAll(); 
		System.out.println("Elenco libri: ");
		for (int i = 0; i < elencoLibri.size(); i++) {
			Libro tempL = elencoLibri.get(i);
			System.out.println(temp.toString());
		}
		
		// prova findById libri
		System.out.println("\n------------- findById di Libro");
		
		Libro tempL = libroDao.findById(1);
		System.out.println("Id = 1 " + tempL.toString());
		
//		// prova delete con libroId
//		System.out.println("\n-------------  delete di Libro con libroId");
//		
//		if (libroDao.delete(2)) {
//			System.out.println("Eliminazione libro effettuata con succcesso Id = 2");
//		}
//		else {
//			System.out.println("Errore in eliminazione libro");
//		}
//		
//		// prova delete con parametro Libro
//		System.out.println("\n-------------  delete di Libro con il parametro Libro");
//		Libro tempLibro = libroDao.findById(3);
//				
//		if (libroDao.delete(tempLibro)) {
//			System.out.println("Eliminazione libro effettuata con succcesso Id = 3");
//		}
//		else {
//			System.out.println("Errore in eliminazione libro");
//		}
		
		// prova update 
		System.out.println("\n-------------  UPDATE di Libro");
		tempL = libroDao.findById(4);
		System.out.println(tempL.toString());
		tempL.setDescrizione("Descrizione 4 modificata");
		tempL.setIsbn("ISBN modificato");
		
		if (libroDao.update(tempL)) {
			System.out.println("Aggiornamento di libro effettuato con successo Id = 4");
			System.out.println(tempL.toString());
		}
		else {
			System.out.println("Errore in aggiornamento Libro");
		}
		
		
		// -------------- PROVE CON LIBRO --------------------------------------------
		// prova INSERT Libro
		System.out.println("\n------------- PROVE CON Libro_Autore ------------------------------");
				
		System.out.println("\n------------- INSERT di Libro_Autore");

		Libro tempLibro1 = libroDao.findById(1);
		Autore tempAutore1 = autoDao.findById(1);
		Autore tempAutore2 = autoDao.findById(4);
		
		LibroAutore libaut1 = new LibroAutore();
		libaut1.setRif_libro(tempLibro1);
		libaut1.setRif_autore(tempAutore1);
		libAutDAO.insert(libaut1);
		
		if (libaut1.getRif_libro() != null) {
			System.out.println("Inserimento libroautore effettuato con successo ");
		} else {
			System.out.println("Errore in inserimento librolibroautore");
		}
		
		LibroAutore libaut2 = new LibroAutore();
		libaut1.setRif_libro(tempLibro1);
		libaut1.setRif_autore(tempAutore2);
		libAutDAO.insert(libaut2);
		
		if (libaut2.getRif_libro() != null) {
			System.out.println("Inserimento libroautore effettuato con successo ");
		} else {
			System.out.println("Errore in inserimento librolibroautore");
		}

	}

}
