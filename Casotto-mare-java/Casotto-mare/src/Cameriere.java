
public class Cameriere extends Staff {

	public Cameriere(int id_persona, String nome, String cognome, String email, String password,
			int stipendio, String orario) {
		super(id_persona, nome, cognome,email, password, stipendio, orario);
		
		
	}
	
	public boolean notifica_prodotti_mancanti() {
		return false;
	}

}
