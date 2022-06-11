
public class Staff extends Persona {

	private int stipendio;
	private String orario;
	
	public Staff(int id_persona, String nome, String cognome, String email, String password, int stipendio, String orario) {
		super(id_persona, nome, cognome, email, password);
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

	@Override
	public void my_page() {
		// TODO Auto-generated method stub
		
	}

}
