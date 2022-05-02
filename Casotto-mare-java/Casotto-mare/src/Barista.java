
public class Barista extends Staff {

	public Barista(int id_persona, String nome, String cognome, String ruolo, String email, String password,
			int stipendio, String orario) {
		super(id_persona, nome, cognome, ruolo, email, password, stipendio, orario);
		// TODO Auto-generated constructor stub
	}
	
	public boolean notifica_prodotti () {
		return false;
	}
	
	

}
