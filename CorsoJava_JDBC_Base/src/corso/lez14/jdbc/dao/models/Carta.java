package corso.lez14.jdbc.dao.models;

public class Carta {

	private int id;
	private String numero;
	private String negozio;
	private Persona riferimento;
	
	public Carta() {
		
	}
	
	public Carta(String numero, String negozio) {
		super();
		this.numero = numero;
		this.negozio = negozio;
	}

	public Persona getRiferimento() {
		return riferimento;
	}

	public void setRiferimento(Persona riferimento) {
		this.riferimento = riferimento;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNegozio() {
		return negozio;
	}
	public void setNegozio(String negozio) {
		this.negozio = negozio;
	}

	@Override
	public String toString() {
		return "Carta [id=" + id + ", numero=" + numero + ", negozio=" + negozio + ", riferimento=" + riferimento + "]";
	}

	
	
	
	
	
}