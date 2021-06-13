package corso.lez14.jdbc.gestionelibri.dao.models;
import java.util.List;

//Utilizzo questa interfaccia per obbligare i models ad implementare questi metodi
public interface Dao<T> {

	void insert(T t);
	
	T findById(int id);
	
	List<T> findAll();
	
	boolean delete(int id);
	
	boolean delete(T t);
	
	boolean update(T t);
	
}
