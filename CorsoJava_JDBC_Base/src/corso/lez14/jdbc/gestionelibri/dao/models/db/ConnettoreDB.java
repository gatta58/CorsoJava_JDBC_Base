package corso.lez14.jdbc.gestionelibri.dao.models.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnettoreDB {
	private static ConnettoreDB ogg_connettore;
	private Connection conn;
	
	public static ConnettoreDB getIstanza() {
		if(ogg_connettore == null) {
			ogg_connettore = new ConnettoreDB();
		}
		
		return ogg_connettore;
	}
	
	public Connection getConnessione() throws SQLException {
		if(conn == null) {
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setServerName("localhost");						//Indirizzo del server MySql
			dataSource.setPort(3306);
			dataSource.setUser("root");
			dataSource.setPassword("");
			dataSource.setDatabaseName("gestione_libri");
			dataSource.setUseSSL(false);
			dataSource.setServerTimezone("UTC");
			
			conn = dataSource.getConnection();
		}
		
		return conn;

	}
}
