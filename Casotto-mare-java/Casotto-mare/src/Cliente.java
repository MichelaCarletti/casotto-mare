import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Persona{
	private int ombrelloni_prenotati;
	private int id_ordine;
	private int attivita_prenotate;
	
	
	public Cliente(int id_persona, String nome, String cognome, String email, String password, int ombrelloni_prenotati, int id_ordine, int attivita_prenotate   ) {
		super(id_persona, nome, cognome, email, password);
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

	private boolean prenota_tavolo() {
		return false;
	}
	public boolean prenota_ombrellone() throws SQLException {
	return false;
	
		
	
	}
	public void richiedi_preventivo() throws SQLException {

	}
	
	@Override
	public boolean registrazione() {
		
		return false;
	}

	@Override
	public boolean autenticazione() {
		
		return false;
	}

	@Override
	public boolean logout() {
		
		return false;
	}

	@Override
	public void my_page() {
		
		
	}
}
