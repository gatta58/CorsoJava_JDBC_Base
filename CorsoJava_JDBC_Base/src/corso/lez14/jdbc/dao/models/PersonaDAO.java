package corso.lez14.jdbc.dao.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import corso.lez14.jdbc.dao.models.Persona;
import corso.lez14.jdbc.dao.models.db.ConnettoreDB;

public class PersonaDAO implements Dao<Persona>{

	@Override
	public void insert(Persona t) {
		try {
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			
			String sqlInserimento = "INSERT INTO persona (nome, cognome, codice_fiscale) VALUES (?, ?, ?)";
			PreparedStatement ps = connessione.prepareStatement(sqlInserimento, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, t.getNome());
			ps.setString(2, t.getCognome());
			ps.setString(3, t.getCod_fis());
			
			ps.executeUpdate();
			
			ResultSet risultato = ps.getGeneratedKeys();
			risultato.next();
			
			t.setId(risultato.getInt(1));
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
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

	@Override
	public boolean delete(int id) {

		try {
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			
			String sqlDelete = "DELETE FROM persona WHERE personaId = ?";
			PreparedStatement ps = connessione.prepareStatement(sqlDelete);
			ps.setInt(1, id);
			
			int affRows = ps.executeUpdate();
			
			if(affRows > 0) 
				return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return false;
		
	}

	@Override
	public boolean delete(Persona t) {		
		return this.delete(t.getId());		//Ritorno a cascata il risultato della delete per ID
	}

	@Override
	public List<Persona> findAll() {

		ArrayList<Persona> elenco = new ArrayList<Persona>();
		
		try {
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			
			String sqlRicerca = "SELECT personaId, nome, cognome, codice_fiscale FROM persona";
			PreparedStatement ps = connessione.prepareStatement(sqlRicerca);
			
			ResultSet risultato = ps.executeQuery();
			while(risultato.next()) {
			
				Persona temp = new Persona();
				temp.setId( risultato.getInt(1) );
				temp.setNome( risultato.getString(2) );
				temp.setCognome( risultato.getString(3) );
				temp.setCod_fis( risultato.getString(4) );
				
				elenco.add(temp);
			}			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return elenco;
		
	}

	/**
	 * Quando invoco la Update gli passo l'oggetto con i campi modificati TRANNE l'ID!
	 */
	@Override
	public boolean update(Persona t) {

		try {
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			
			String sqlUpdate = "UPDATE persona SET nome = ?, cognome = ?, codice_fiscale = ? "
					+ "WHERE personaId = ?";
			PreparedStatement ps = connessione.prepareStatement(sqlUpdate);
			ps.setString(1, t.getNome());
			ps.setString(2, t.getCognome());
			ps.setString(3, t.getCod_fis());
			ps.setInt(4, t.getId());
			
			int affRows = ps.executeUpdate();
			if(affRows > 0)
				return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return false;
		
	}

}