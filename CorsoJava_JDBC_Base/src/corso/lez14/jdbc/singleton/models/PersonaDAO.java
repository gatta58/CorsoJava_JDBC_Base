package corso.lez14.jdbc.singleton.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import corso.lez14.jdbc.singleton.models.db.ConnettoreDB;

public class PersonaDAO {

	public void insert(Persona per) {
		try {
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			
			String sqlInserimento = "INSERT INTO persona (nome, cognome, codice_fiscale) VALUES (?, ?, ?)";
			PreparedStatement ps = connessione.prepareStatement(sqlInserimento, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, per.getNome());
			ps.setString(2, per.getCognome());
			ps.setString(3, per.getCod_fis());
			
			ps.executeUpdate();
			
			ResultSet risultato = ps.getGeneratedKeys();
			risultato.next();
			
			per.setId(risultato.getInt(1));
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Persona findById(int id) {
		
		Persona temp = null;
		
		try {
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			
			String sqlRicerca = "SELECT personaId, nome, cognome, codice_fiscale "
					+ "FROM persona WHERE personaId = ?";
			
			PreparedStatement ps = connessione.prepareStatement(sqlRicerca);
			ps.setInt(1, id);
			
			ResultSet risultato = ps.executeQuery();
			risultato.next();
			
			temp = new Persona();
			temp.setId(risultato.getInt(1));
			temp.setNome(risultato.getString(2));
			temp.setCognome(risultato.getString(3));
			temp.setCod_fis(risultato.getString(4));

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return temp;
		
	}
	
	//TODO: delete
	
	//TODO: update
	
	//TODO: findAll
	
}