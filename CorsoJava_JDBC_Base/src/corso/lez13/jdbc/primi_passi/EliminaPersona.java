package corso.lez13.jdbc.primi_passi;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mysql.cj.jdbc.MysqlDataSource;

public class EliminaPersona {

	public static void main(String[] args) {

		try {
			
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setServerName("localhost");						//Indirizzo del server MySql
			dataSource.setPort(3306);
			dataSource.setUser("root");
			dataSource.setPassword("");                                 //dipende dal collegamento "toor"
			dataSource.setDatabaseName("rubrica_uno");
			dataSource.setUseSSL(false);
			dataSource.setServerTimezone("UTC");
			
			Connection conn = dataSource.getConnection();
			System.out.println("Sono connesso! :D");
			
			// -------------------------------- DELETE -----------------------------------------

			int idDaEliminare = 46;
			
			String sqlEliminazione = "DELETE FROM persona WHERE personaId = ?";
			PreparedStatement ps = conn.prepareStatement(sqlEliminazione);
			
			ps.setInt(1, idDaEliminare);
			
			int affRows = ps.executeUpdate();		//La executeUpdate restituisce il numero di righe coinvolte nell'operazione di DML
			if(affRows > 0) {
				System.out.println("Eliminazione effettuata con successo");
			}
			else {
				System.out.println("Errore di eliminazione! ;(");
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}