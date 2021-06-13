package corso.lez13.spotifoo;

public class User {

	protected int id;
	protected String username;
	protected String pass_code;
	protected String nome;
	protected String cognome;
	
	public User() {
		
	}
	
	public User(int id, String username, String pass_code, String nome, String cognome) {
		this.setUsername(username);
		this.setPass_code(pass_code);
		this.setNome(nome);
		this.setCognome(cognome);
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPass_code(String pass_code) {
		this.pass_code = pass_code;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPass_code() {
		return pass_code;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}
	
	
	

}
