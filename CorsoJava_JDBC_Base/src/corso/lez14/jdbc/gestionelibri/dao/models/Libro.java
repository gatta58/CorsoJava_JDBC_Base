package corso.lez14.jdbc.gestionelibri.dao.models;

public class Libro {
	
	private int id;
	private String titolo;
	private String isbn;
	private String descrizione;
	private Autore autore_libro;
	
	public Libro() {
		
	}

	public Libro(String titolo, String isbn, String descrizione) {
		super();
		this.titolo = titolo;
		this.isbn = isbn;
		this.descrizione = descrizione;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public void setAutore_libro(Autore autore_libro) {
		this.autore_libro = autore_libro;
	}

	public int getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public Autore getAutore_libro() {
		return autore_libro;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titolo=" + titolo + ", isbn=" + isbn + ", descrizione=" + descrizione
				+ ", autore_libro=" + autore_libro + "]";
	}

	

	
}
