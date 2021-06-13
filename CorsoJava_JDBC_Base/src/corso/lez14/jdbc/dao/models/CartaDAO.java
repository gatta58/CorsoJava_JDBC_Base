package corso.lez14.jdbc.dao.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import corso.lez14.jdbc.dao.models.db.ConnettoreDB;

public class CartaDAO implements Dao<Carta>{

	@Override
	public void insert(Carta t) {
		
			
		try {
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			
			String sqlInserimento = "INSERT INTO carta_fedelta (numero_carta, negozio, personaRif) VALUE (?, ?, ?)";
			PreparedStatement ps = connessione.prepareStatement(sqlInserimento, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, t.getNumero());
			ps.setString(2, t.getNegozio());
			ps.setInt(3, t.getRiferimento().getId());
			
			ps.executeUpdate();
			ResultSet result = ps.getGeneratedKeys();
			result.next();
			
			t.setId(result.getInt(1));
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Carta findById(int id) {
		
		Carta car = null;
		
		try {
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			
			String sqlRicerca = "SELECT cartaId, numero_carta, negozio, personaRif "
					+ "FROM carta_fedelta WHERE cartaId = ?";
			PreparedStatement ps = connessione.prepareStatement(sqlRicerca);
			ps.setInt(1, id);
			
			ResultSet result = ps.executeQuery();
			result.next();
			
			car = new Carta();
			car.setId( result.getInt(1) );
			car.setNumero( result.getString(2) );
			car.setNegozio( result.getString(3) );
		

			/*
			 * Per popolare il setRiferimento ho bisogno di un oggetto di tipo "Persona", l'unico modo
			 * che ho per scrivere codice ben organizzato č scomodare il PersonaDAO e fargli reperire
			 * la persona di riferimento grazie all'ID che ottengo dalla colonna personaRif sulla mia 
			 * tabella.
			 */
			PersonaDAO perDao = new PersonaDAO();			
			Persona riferimento = perDao.findById( result.getInt(4) );
			
			car.setRiferimento(riferimento);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return car;
		
	}

	@Override
	public boolean delete(int id) {
		try {
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			
			String sqldelete = "DELETE FROM carta_fedelta WHERE cartaId = ?";
			
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
	public boolean delete(Carta t) {
		return this.delete(t.getId());					//Ritorno a cascata il risultato della delete per ID
	}

	@Override
	public List<Carta> findAll() {

		ArrayList<Carta> elencoC = new ArrayList<Carta>();
		
		try {
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			
			String sqlRicerca = "SELECT cartaId, numero_carta, negozio, personaRif "
					+ "FROM carta_fedelta";
			PreparedStatement ps = connessione.prepareStatement(sqlRicerca);
						
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				Carta temp = new Carta();
				temp.setId(result.getInt(1));
				temp.setNumero(result.getString(2));
				temp.setNegozio(result.getString(3));
				
				/*
				 * Per popolare il setRiferimento ho bisogno di un oggetto di tipo "Persona", l'unico modo
				 * che ho per scrivere codice ben organizzato č scomodare il PersonaDAO e fargli reperire
				 * la persona di riferimento grazie all'ID che ottengo dalla colonna personaRif sulla mia 
				 * tabella.
				 */
				PersonaDAO perDao = new PersonaDAO();			
				Persona riferimento = perDao.findById( result.getInt(4) );
				temp.setRiferimento(riferimento);
				elencoC.add(temp);
			};
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return elencoC;
	}

	@Override
	public boolean update(Carta t) {
		try {
			Connection connessione = ConnettoreDB.getIstanza().getConnessione();
			
			String sqlupdate = "UPDATE carta_fedelta SET negozio = ?, numero_carta = ? WHERE cartaId = ?";
			
			PreparedStatement ps = connessione.prepareStatement(sqlupdate);
			ps.setString(1, t.getNegozio());
			ps.setString(2, t.getNumero());
			ps.setInt(3, t.getId());
			
			int affRows = ps.executeUpdate();
			
			if(affRows > 0)
				return true;
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}

}