package corso.lez14.jdbc.singleton.models;

public class Persona {

	private int id;
	private String nome;
	private String cognome;
	private String cod_fis;
	
	public Persona() {
		
	}
	
	public Persona(String nome, String cognome, String cod_fis) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.cod_fis = cod_fis;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCod_fis() {
		return cod_fis;
	}
	public void setCod_fis(String cod_fis) {
		this.cod_fis = cod_fis;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", cod_fis=" + cod_fis + "]";
	}
	
	
	
}