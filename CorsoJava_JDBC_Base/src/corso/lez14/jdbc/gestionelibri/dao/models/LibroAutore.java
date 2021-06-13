package corso.lez14.jdbc.gestionelibri.dao.models;

public class LibroAutore {
	
	private Libro rif_libro;
	private Autore rif_autore;
	
	public LibroAutore() {
		
	}

	public LibroAutore(Libro rif_libro, Autore rif_autore) {
		super();
		this.rif_libro = rif_libro;
		this.rif_autore = rif_autore;
	}

	public Libro getRif_libro() {
		return rif_libro;
	}

	public void setRif_libro(Libro rif_libro) {
		this.rif_libro = rif_libro;
	}

	public Autore getRif_autore() {
		return rif_autore;
	}

	public void setRif_autore(Autore rif_autore) {
		this.rif_autore = rif_autore;
	}
	
	

}
