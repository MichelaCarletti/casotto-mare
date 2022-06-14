
public class Barista extends Staff {

	public Barista(int id_persona, String nome, String cognome, String email, String password,
			int stipendio, String orario) {
		super(id_persona, nome, cognome, email, password, stipendio, orario);
		
	}
	
	public boolean notifica_prodotti () {
		return false;
	}
	
	

}
