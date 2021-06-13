package corso.lez14.jdbc.singleton.models.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnettoreDB {

	//Creo l'oggetto ConnettoreDB SOLO se non esiste!
	
	private static ConnettoreDB ogg_connettore;			//Contiene l'unica istanza del mio connettore!
	private Connection conn;							//Contiene l'unica CONNESSIONE del mio connettore
	
	public static ConnettoreDB getIstanza() {			//Si occupa di istanziare il connettore per la prima volta! Se esiste allora lo restituisco			
		if(ogg_connettore == null) {
			ogg_connettore = new ConnettoreDB();		//Istanzio il connettore per la prima volta
		}
		
		return ogg_connettore;							//Viene restituito 
	}
	
	public Connection getConnessione() throws SQLException {
		if(conn == null) {
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setServerName("localhost");						//Indirizzo del server MySql
			dataSource.setPort(3306);
			dataSource.setUser("root");
			dataSource.setPassword("toor");
			dataSource.setDatabaseName("carte_fedelta");
			dataSource.setUseSSL(false);
			dataSource.setServerTimezone("UTC");
			
			conn = dataSource.getConnection();
		}
		
		return conn;
	}
	
	
}