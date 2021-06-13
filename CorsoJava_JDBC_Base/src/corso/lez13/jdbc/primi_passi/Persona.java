package corso.lez13.jdbc.primi_passi;

public class Persona {
	
	private int perId;
	private String perNome;
	private String perCognome;
	private String perCF;
	
	public Persona() {
		
	}

	public Persona(int perId, String perNome, String perCognome, String perCF) {
		super();
		this.perId = perId;
		this.perNome = perNome;
		this.perCognome = perCognome;
		this.perCF = perCF;
	}

	public int getPerId() {
		return perId;
	}

	public void setPerId(int perId) {
		this.perId = perId;
	}

	public String getPerNome() {
		return perNome;
	}

	public void setPerNome(String perNome) {
		this.perNome = perNome;
	}

	public String getPerCognome() {
		return perCognome;
	}

	public void setPerCognome(String perCognome) {
		this.perCognome = perCognome;
	}

	public String getPerCF() {
		return perCF;
	}

	public void setPerCF(String perCF) {
		this.perCF = perCF;
	}

	@Override
	public String toString() {
		return "Persona [perId=" + perId + ", perNome=" + perNome + ", perCognome=" + perCognome + ", perCF=" + perCF
				+ "]";
	}

	
}
