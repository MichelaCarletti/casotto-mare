
public class Utente extends Persona {

	public Utente(int id_persona, String nome, String cognome, String ruolo, String email, String password) {
		super(id_persona, nome, cognome, ruolo, email, password);
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


	public String prenota_tavolo() {
		// TODO
		return null;}
	
/**
 * 
 * @return id dell'ombrellone prenotato
 */
	
	public int prenota_ombrellone() {
		// TODO
		return 0;}
	
}
