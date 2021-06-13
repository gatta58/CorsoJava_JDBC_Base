package corso.lez13.jsbc.separazione;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {


		GestorePersona ges = new GestorePersona();
		
//		// Stampa elenco persona
//		ArrayList<Persona> elenco_completo = ges.cercaTutti();
//		ges.stampaElenco(elenco_completo);
//		
//		//Inserimento in DB persona
//		int idInserito = ges.InserisciPersona("Daniela","Zanella","ZNLDNL");
//        System.out.println("Inserimento completato con ID: " + idInserito);
//
//       // Eliminazione in DB persona
//       int idEliminare = 55;
//       int nroelim = ges.eliminaPersona(idEliminare);
//        
//       if(nroelim > 0) {
//			System.out.println("Eliminazione effettuata con successo del ID = " + idEliminare);
//		 } 
//		 else {
//			System.out.println("Errore di eliminazione! ;(");
//		 }
        
        //Modifica in DB persona
                
        int nroMod = ges.modificaPersona(32, "Marco", "Fiore");
        
        System.out.println("nroMod = "+ nroMod);
        
        if(nroMod > 0) {
			System.out.println("Modifica effettuata con successo del ID = " + nroMod);
		}
		else {
			System.out.println("Errore di modifica! ;(");
		}
        
        // Cerca una persona con un dato ID
        
        Persona temp = new Persona();
        
        temp = ges.cercaPersonaId(2);
        
        if (temp.getPerId() !=  0) {
        	System.out.println(temp.toString());;
        }
        else {
        	System.out.println("Persona con questo ID non esiste");
        }
        
 
	}

}
