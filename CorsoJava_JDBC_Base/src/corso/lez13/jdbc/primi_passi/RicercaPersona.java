package corso.lez13.jdbc.primi_passi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.jdbc.MysqlDataSource;

public class RicercaPersona {

	public static void main(String[] args) {
		
		try {
			
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setServerName("localhost");					//Indirizzo del server MySql
			dataSource.setPort(3306);
			dataSource.setUser("root");
			dataSource.setPassword("");
			dataSource.setDatabaseName("rubrica_uno");
			dataSource.setUseSSL(false);
			dataSource.setServerTimezone("UTC");
			
			Connection conn = dataSource.getConnection(); 
			System.out.println("Sono connesso ");
			
			// -------------------------------- SELECT -----------------------------------------
			
			String selectQuery = "SELECT personaID, nome, cognome, codice_fiscale FROM persona";
			PreparedStatement ps = conn.prepareStatement(selectQuery);
			
			ResultSet result = ps.executeQuery();
			
			ArrayList<Persona> elenco = new ArrayList<Persona>();
			
			while(result.next()) {									//Estraggo le informazioni sulle persone dal Result Set
				Persona temp = new Persona();
				
				temp.setPerId(result.getInt(1));
				temp.setPerNome(result.getString(2));
				temp.setPerCognome(result.getString(3));
				temp.setPerCF(result.getString(4));
				
				elenco.add(temp);
			}
			
			//Stampo il mio elenco dopo averlo estratto dal DB
			
			for (int i=0; i<elenco.size(); i++) {
				Persona perTemp = elenco.get(i);
				System.out.println(perTemp.toString());
			}
			
			System.out.println("I record corrispondenti alla query di ricerca sono: " + elenco.size());
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
