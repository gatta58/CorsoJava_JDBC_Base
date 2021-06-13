package corso.lez14.jdbc.gestionelibri.dao.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import corso.lez14.jdbc.gestionelibri.dao.models.db.ConnettoreDB;

public class LibroAutoreDAO {

	public LibroAutoreDAO() {
		
	}
	
	public void insert(LibroAutore t) {

		try {
			
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			String sqlinsert = "INSERT INTO libro_autore (ref_libro, ref_autore) VALUES (?, ?)";
			
			PreparedStatement ps = connessione.prepareStatement(sqlinsert, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, t.getRif_libro().getId());
			ps.setInt(2, t.getRif_autore().getId());
			ps.executeUpdate();
			
			ResultSet result = ps.getGeneratedKeys();
			result.next();
			
			LibroDAO libroDao = new LibroDAO();
			Libro rifLibro = libroDao.findById(result.getInt(1));
			t.setRif_libro(rifLibro);
			
			AutoreDAO autorDao = new AutoreDAO();
			Autore rifAutore = autorDao.findById(result.getInt(2));
			t.setRif_autore(rifAutore);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	@Override
	public LibroAutore findById(int id) {
			try {
			
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
//			String sqlinsert = "INSERT INTO libro_autore (ref_libro, ref_autore) VALUES (?, ?)";
//			
//			PreparedStatement ps = connessione.prepareStatement(sqlinsert, Statement.RETURN_GENERATED_KEYS);
//			ps.setInt(1, t.getRif_libro().getId());
//			ps.setInt(2, t.getRif_autore().getId());
//			ps.executeUpdate();
//			
//			ResultSet result = ps.getGeneratedKeys();
//			result.next();
//			
//			LibroDAO libroDao = new LibroDAO();
//			Libro rifLibro = libroDao.findById(result.getInt(1));
//			t.setRif_libro(rifLibro);
//			
//			AutoreDAO autorDao = new AutoreDAO();
//			Autore rifAutore = autorDao.findById(result.getInt(2));
//			t.setRif_autore(rifAutore);
//			
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		return null;
	}

	@Override
	public List<LibroAutore> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(LibroAutore t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(LibroAutore t) {
		// TODO Auto-generated method stub
		return false;
	}

}
