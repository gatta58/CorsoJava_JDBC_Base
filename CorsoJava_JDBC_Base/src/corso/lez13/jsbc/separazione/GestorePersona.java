package corso.lez13.jsbc.separazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.MysqlDataSource;

public class GestorePersona {

	
	/**
	 * Stampa tutte le persone che gli passo sotto forma di ArrayList
	 * @param varArray
	 */
	public void stampaElenco(ArrayList<Persona> varArray) {
		
		for (int i=0; i<varArray.size(); i++) {
			Persona temp = varArray.get(i);
			System.out.println(temp.toString());
		}
	}
	
	
	/**
	 * Recupera tutte le persone sul DB
	 * @return
	 */
	public ArrayList<Persona> cercaTutti(){
		
		ArrayList<Persona> elenco = new ArrayList<Persona>();
		
		try {
			
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setServerName("localhost");
			dataSource.setPort(3306);
			dataSource.setUser("root");
			dataSource.setPassword("");
			dataSource.setDatabaseName("rubrica_uno");
			dataSource.setUseSSL(false);
			dataSource.setServerTimezone("UTC");
			
			Connection conn = dataSource.getConnection();
			System.out.println("Sono connesso al DB!!!");
			
			// -------------------------------- SELECT -----------------------------------------
			
			String selectQuery = "SELECT personaID, nome, cognome, codice_fiscale FROM persona";
			PreparedStatement ps = conn.prepareStatement(selectQuery);
			
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				Persona temp = new Persona();
				temp.setPerId(result.getInt(1));
				temp.setPerNome(result.getString(2));
				temp.setPerCognome(result.getString(3));
				temp.setPerCF(result.getString(4));
				
				elenco.add(temp);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return elenco;
	}

	/**
	 * Inserisci persona
	 * @param varNome
	 * @param varCognome
	 * @param varCF
	 * @return
	 */
	
	public int InserisciPersona(String varNome, String varCognome, String varCF) {
		
		int idCreato = 0;
		
		try {
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setServerName("localhost");
			dataSource.setPort(3306);
			dataSource.setUser("root");
			dataSource.setPassword("");
			dataSource.setDatabaseName("rubrica_uno");
			dataSource.setUseSSL(false);
			dataSource.setServerTimezone("UTC");
			
			Connection conn = dataSource.getConnection();
			System.out.println("Sono connesso al DB!!!");
			
			// -------------------------------- INSERT -----------------------------------------
			String sqlInserimento = "INSERT INTO persona (nome, cognome, codice_fiscale) VALUE (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sqlInserimento, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, varNome);
			ps.setString(2, varCognome);
			ps.setString(3, varCF);
			
			ps.executeUpdate();
			
			ResultSet result = ps.getGeneratedKeys();
			result.next();									//Apro il pacchetto ResultSet e mi posiziono sulla prima riga!
			
			idCreato = result.getInt(1);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return idCreato;
	}
	
	
	/**
	 * Elimina persona con id = idPer
	 * @param idPer
	 * @return
	 */
	public int eliminaPersona(int idPer) {
		
		int nroRow = 0;
		
		try {
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setServerName("localhost");
			dataSource.setPortNumber(3306);
			dataSource.setUser("root");
			dataSource.setPassword("");
			dataSource.setDatabaseName("rubrica_uno");
			dataSource.setUseSSL(false);
			dataSource.setServerTimezone("UTC");
			
			Connection conn = dataSource.getConnection();
			System.out.println("Sono connesso al DB!!!");
			
			// -------------------------------- DELETE -----------------------------------------
			String sqlEliminazione = "DELETE FROM persona WHERE personaID = ?";
			PreparedStatement ps = conn.prepareStatement(sqlEliminazione);
			
			ps.setInt(1, idPer);
			nroRow = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return nroRow;
	}
	
	
	/**
	 * Modifica nome e cognome di un ID dato
	 * @param VarId
	 * @param varNome
	 * @param varCognome
	 * @return
	 */
	public int modificaPersona(int varId, String varNome, String varCognome) {
		int nroRow = 0;
		
		try {
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setServerName("localhost");
			dataSource.setPortNumber(3306);
			dataSource.setUser("root");
			dataSource.setPassword("");
			dataSource.setDatabaseName("rubrica_uno");
			dataSource.setUseSSL(false);
			dataSource.setServerTimezone("UTC");
			
			Connection conn = dataSource.getConnection();
			System.out.println("Sono connesso al DB!!!");
			
			// -------------------------------- UPDATE -----------------------------------------
			
			String queryUpdate = "UPDATE persona SET nome = ?, cognome = ? WHERE personaID = ?";
			PreparedStatement ps = conn.prepareStatement(queryUpdate);
			
			ps.setString(1, varNome.trim());							// eliminare spazi in più trim
			ps.setString(2, varCognome.trim());
			ps.setInt(3, varId);
			System.out.println(ps);
			
			nroRow = ps.executeUpdate();
			System.out.println(nroRow);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return nroRow;
	}
	
	
	/**
	 * cerca una persona con un ID
	 * @return
	 */
	public Persona cercaPersonaId(int varId){
		
		Persona varPersona = new Persona();
		
		try {
			
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setServerName("localhost");
			dataSource.setPort(3306);
			dataSource.setUser("root");
			dataSource.setPassword("");
			dataSource.setDatabaseName("rubrica_uno");
			dataSource.setUseSSL(false);
			dataSource.setServerTimezone("UTC");
			
			Connection conn = dataSource.getConnection();
			System.out.println("Sono connesso al DB!!!");
			
			// -------------------------------- SELECT -----------------------------------------
			
			String selectQuery = "SELECT personaID, nome, cognome, codice_fiscale FROM persona WHERE personaID = ?";
			PreparedStatement ps = conn.prepareStatement(selectQuery);
			
			ps.setInt(1, varId);
			
			ResultSet result = ps.executeQuery();
			
			if(result.next()) {
				varPersona.setPerId(result.getInt(1));
				varPersona.setPerNome(result.getString(2));
				varPersona.setPerCognome(result.getString(3));
				varPersona.setPerCF(result.getString(4));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return varPersona;
	}
}
