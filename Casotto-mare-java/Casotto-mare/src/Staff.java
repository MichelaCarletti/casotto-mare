
public class Staff extends Persona {

	private int stipendio;
	private String orario;
	
	public Staff(int id_persona, String nome, String cognome, String ruolo, String email, String password, int stipendio, String orario) {
		super(id_persona, nome, cognome, ruolo, email, password);
		this.stipendio = stipendio;
		this.orario = orario;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean registrazione() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean autenticazione() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

}
