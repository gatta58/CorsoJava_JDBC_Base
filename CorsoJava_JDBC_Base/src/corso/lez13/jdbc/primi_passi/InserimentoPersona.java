package corso.lez13.jdbc.primi_passi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlDataSource;

public class InserimentoPersona {

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
			
			// -------------------------------- INSERT -----------------------------------------
			
			String varNome = "Altabano";
			String varCognome = "Rossi";
			String varCodFis = "ALTRSS";
			
			String sqlInserimento = "INSERT INTO persona (nome, cognome, codice_fiscale) VALUE (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sqlInserimento, Statement.RETURN_GENERATED_KEYS);
					
			ps.setString(1,  varNome);
			ps.setString(2,  varCognome);
			ps.setString(3,  varCodFis);
			
			ps.executeUpdate();
			
			ResultSet result = ps.getGeneratedKeys();
			result.next();								//Apro il pacchetto ResultSet e mi posiziono sulla prima riga!
			
			int idCreato = result.getInt(1);			//Prendo il valore della riga selezionata alla colonna 1

			System.out.println("Inserimento completato con ID: " + idCreato);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());		//Prendo solo il messaggio dell'exceptio e nient'altro!
		}
		
	}

}