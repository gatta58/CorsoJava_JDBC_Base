package corso.lez14.jdbc.gestionelibri.dao.models;

public class Autore {

	private int id;
	private String nome;
	private String cognome;
	private String data_nascita;
	private String codice_autore;
	
	public Autore() {
		
	}

	public Autore(String nome, String cognome, String data_nascita, String codice_autore) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.codice_autore = codice_autore;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getData_nascita() {
		return data_nascita;
	}
	
	public String getCodice_autore() {
		return codice_autore;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setData_nascita(String data_nascita) {
		this.data_nascita = data_nascita;
	}

	public void setCodice_autore(String codice_autore) {
		this.codice_autore = codice_autore;
	}

	@Override
	public String toString() {
		return "Autore [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", data_nascita=" + data_nascita
				+ ", codice_autore=" + codice_autore + "]";
	}

	
	
	
}
