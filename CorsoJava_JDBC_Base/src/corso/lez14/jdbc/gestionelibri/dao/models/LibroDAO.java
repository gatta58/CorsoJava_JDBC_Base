package corso.lez14.jdbc.gestionelibri.dao.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import corso.lez14.jdbc.dao.models.Persona;
import corso.lez14.jdbc.dao.models.PersonaDAO;
import corso.lez14.jdbc.gestionelibri.dao.models.db.ConnettoreDB;

public class LibroDAO implements Dao<Libro>{

	@Override
	public void insert(Libro t) {
		try {
			
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			String sqlinserimento = "INSERT into libro (titolo, isbn, descrizione, ref_autore) VALUE (?, ?, ?, ?)";
			
			PreparedStatement ps = connessione.prepareStatement(sqlinserimento, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, t.getTitolo());
			ps.setString(2, t.getIsbn());
			ps.setString(3, t.getDescrizione());
			ps.setInt(4, t.getAutore_libro().getId());
			ps.executeUpdate();
			
			ResultSet result = ps.getGeneratedKeys();
			result.next();
			t.setId(result.getInt(1));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}

	@Override
	public Libro findById(int id) {
		
		Libro librot = null;
		
		try {
			
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			String sqlquery = "SELECT libroId, titolo, isbn, descrizione, ref_autore FROM Libro WHERE libroId = ?";
			
			PreparedStatement ps = connessione.prepareStatement(sqlquery);
			ps.setInt(1, id);
			
			ResultSet result = ps.executeQuery();
			result.next();
			
			librot = new Libro();
			librot.setId(result.getInt(1));
			librot.setTitolo(result.getString(2));
			librot.setIsbn(result.getString(3));
			librot.setDescrizione(result.getString(4));
			
			//ricuperare l'autore con il ID
			
			AutoreDAO autorDao = new AutoreDAO();
			Autore riferimento = autorDao.findById(result.getInt(5));
			librot.setAutore_libro(riferimento);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return librot;
	}

	@Override
	public List findAll() {

		ArrayList<Libro> elencoLibri = new ArrayList<Libro>();
		
		try {
			
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			String sqlquery = "SELECT libroId, titolo, isbn, descrizione, ref_autore FROM Libro";
			
			PreparedStatement ps = connessione.prepareStatement(sqlquery);
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				Libro temp = new Libro();
				temp.setId(result.getInt(1));
				temp.setTitolo(result.getString(2));
				temp.setIsbn(result.getString(3));
				temp.setDescrizione(result.getString(4));
				
				AutoreDAO autorDao = new AutoreDAO();
				Autore riferimento = autorDao.findById(result.getInt(5));
				temp.setAutore_libro(riferimento);
				
				elencoLibri.add(temp);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return elencoLibri;
	}

	@Override
	public boolean delete(int id) {
		
		Libro libro = this.findById(id);
		if(libro == null) { return false;}

		try {
			
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			String sqldelete = "DELETE from libro WHERE libroId = ?";
			
			PreparedStatement ps = connessione.prepareStatement(sqldelete);
			ps.setInt(1, id);
			
			int affRows = ps.executeUpdate();
			
			if(affRows > 0)
				return true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean delete(Libro t) {
		return this.delete(t.getId());
	}

	@Override
	public boolean update(Libro t) {
		
		if(this.findById(t.getId()) == null) { return false;} 		// Controllo se il libro già esiste.
		
		try {
			
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			String sqlupdate = "UPDATE libro SET titolo = ?, isbn = ?, descrizione = ? WHERE libroId = ?";
			
			PreparedStatement ps = connessione.prepareStatement(sqlupdate);
			ps.setString(1, t.getTitolo());
			ps.setString(2, t.getIsbn());
			ps.setString(3, t.getDescrizione());
			ps.setInt(4, t.getId());
			
			int affRows = ps.executeUpdate();
			if(affRows > 0)
				return true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}

	

	
}
