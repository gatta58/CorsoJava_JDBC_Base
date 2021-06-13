package corso.lez13.jdbc.primi_passi;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ModificaPersona {
	
	public static void main(String[] args) {

		try {
			
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setServerName("localhost");						//Indirizzo del server MySql
			dataSource.setPort(3306);
			dataSource.setUser("root");
			dataSource.setPassword("");
			dataSource.setDatabaseName("rubrica_uno");
			dataSource.setUseSSL(false);
			dataSource.setServerTimezone("UTC");
			
			Connection conn = dataSource.getConnection();
			System.out.println("Sono connesso! :D");
			
			// -------------------------------- UPDATE -----------------------------------------

			int idPersonaModificare = 3;
			String varNome = "Saul  ";
			String varCognome = "   Goodman";
			
			String queryUpdate = "UPDATE persona SET nome = ?, cognome = ? WHERE personaID = ?";
			PreparedStatement ps = conn.prepareStatement(queryUpdate);
			
			ps.setString(1, varNome.trim());							// eliminare spazi in più trim
			ps.setString(2, varCognome.trim());
			ps.setInt(3, idPersonaModificare);
			
			int affRows = ps.executeUpdate();
			if(affRows > 0) {
				System.out.println("Modifica effettuata con successo");
			}
			else {
				System.out.println("Errore di modifica! ;(");
			}
			
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
	}
}