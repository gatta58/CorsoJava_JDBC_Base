package corso.lez13.spotifoo;

public class Customer extends User{

	public Customer() {
		super();
	}

	public Customer(int id, String username, String pass_code, String nome, String cognome) {
		super(id, username, pass_code, nome, cognome);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", pass_code=" + pass_code + ", nome=" + nome
				+ ", cognome=" + cognome + "]";
	}
	
	
}
