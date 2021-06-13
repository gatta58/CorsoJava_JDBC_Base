package corso.lez14.jdbc.singleton;

import corso.lez14.jdbc.singleton.models.Persona;
import corso.lez14.jdbc.singleton.models.PersonaDAO;

public class Main {

	public static void main(String[] args) {

		PersonaDAO perDao = new PersonaDAO();
		
//		Persona gio = new Persona("Giovanni", "Pace", "PCAGNN");
//		perDao.insert(gio);
//		if(gio.getId() > 0) {
//			System.out.println("Inserimento effettuato con successo");
//		}
//		else {
//			System.out.println("Errore di inserimento");
//		}
//		
//		Persona mar = new Persona("Mario", "Rossi", "MRRRSS");
//		perDao.insert(mar);
//		if(mar.getId() > 0) {
//			System.out.println("Inserimento effettuato con successo");
//		}
//		else {
//			System.out.println("Errore di inserimento");
//		}
		
		System.out.println(perDao.findById(1).toString());
		System.out.println(perDao.findById(2).toString());
		
	}

}