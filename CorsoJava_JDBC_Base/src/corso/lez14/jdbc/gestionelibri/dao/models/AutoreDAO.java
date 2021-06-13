package corso.lez14.jdbc.gestionelibri.dao.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import corso.lez14.jdbc.dao.models.Carta;
import corso.lez14.jdbc.gestionelibri.dao.models.db.ConnettoreDB;


public class AutoreDAO implements Dao<Autore>{

	@Override
	public void insert(Autore t) {
		
			
		try {
			
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			
			String sqlinserimento = "INSERT INTO autore (nome, cognome, data_nascita, codice_autore) VALUE (?, ?, ?, ?)";
			PreparedStatement ps = connessione.prepareStatement(sqlinserimento, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1,t.getNome());
			ps.setString(2, t.getCognome());
			ps.setString(3, t.getData_nascita());
			ps.setString(4, t.getCodice_autore());
			
			ps.executeUpdate();
			ResultSet result = ps.getGeneratedKeys();
			
			result.next();
			t.setId(result.getInt(1));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Autore findById(int id) {
		
		Autore auto = null;
		
		try {
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			
			String sqlquery = "SELECT autoreId, nome, cognome, data_nascita, codice_autore FROM autore WHERE autoreId = ?";
			PreparedStatement ps = connessione.prepareStatement(sqlquery);
			ps.setInt(1, id);
			
			ResultSet result = ps.executeQuery();
			result.next();
			
			auto = new Autore();
			auto.setId(result.getInt(1));
			auto.setNome(result.getString(2));
			auto.setCognome(result.getString(3));
			auto.setData_nascita(result.getString(4));
			auto.setCodice_autore(result.getString(5));
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return auto;
	}

	@Override
	public List findAll() {
		
		ArrayList<Autore> elenco_autori = new ArrayList<Autore>();
		
		try {
			
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			String sqlquery = "SELECT autoreId, nome, cognome, data_nascita, codice_autore FROM autore";
			
			PreparedStatement ps = connessione.prepareStatement(sqlquery);
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				Autore temp = new Autore();
				temp.setId(result.getInt(1));
				temp.setNome(result.getString(2));
				temp.setCognome(result.getString(3));
				temp.setData_nascita(result.getString(4));
				temp.setCodice_autore(result.getString(5));
				elenco_autori.add(temp);
			};
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return elenco_autori;
	}

	@Override
	public boolean delete(int id) {
		
		Autore autore = this.findById(id);
		if(autore == null) { return false;}
		
		try {
			
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			
			String sqldelete = "DELETE FROM autore WHERE autoreId = ?";
			PreparedStatement ps = connessione.prepareStatement(sqldelete);
			ps.setInt(1, id);
			
			int affRows = ps.executeUpdate();
			
			if (affRows > 0)
				return true;
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(Autore t) {
		return this.delete(t.getId());
	}

	@Override
	public boolean update(Autore t) {
		
		if(this.findById(t.getId()) == null) { return false;} 	// Controllo se l'Autore già esiste.
		
		try {
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			
			String sqlupdate ="UPDATE autore SET nome = ?, cognome = ?, data_nascita = ?, codice_autore =? WHERE autoreId = ?";
			PreparedStatement ps = connessione.prepareStatement(sqlupdate);
			
			ps.setString(1, t.getNome());
			ps.setString(2, t.getCognome());
			ps.setString(3, t.getData_nascita());
			ps.setString(4, t.getCodice_autore());
			ps.setInt(5, t.getId());
			
			int affRows = ps.executeUpdate();
			if (affRows > 0)
				return true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
