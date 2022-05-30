
public class Cliente extends Persona{
	private int ombrelloni_prenotati;
	private int id_ordine;
	private int attivita_prenotate;
	
	
	public Cliente(int id_persona, String nome, String cognome, String ruolo, String email, String password, int ombrelloni_prenotati, int id_ordine, int attivita_prenotate   ) {
		super(id_persona, nome, cognome, ruolo, email, password);
		// TODO Auto-generated constructor stub
		this.ombrelloni_prenotati = ombrelloni_prenotati;
		this.id_ordine = id_ordine;
		this.attivita_prenotate = attivita_prenotate;
	}

	public int prenota_attivita() {
		return 0;
	}
	
	public void servizio_ombrellone () {
		
	}
	public void visualizza_prodotti () {
		//TODO
	}

	public void visualizza_attivita() {
		//TODO
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
