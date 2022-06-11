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

	private boolean prenota_tavolo() {
		return false;
	}
	public boolean prenota_ombrellone() throws SQLException {
		Scanner in = new Scanner(System.in);
		ArrayList<String> lista_prenotazione = new ArrayList<String>();
		String url = "jdbc:mysql://127.0.0.1:3306/casotto";
		Connection conn = DriverManager.getConnection(url, "root", "claMysql");
		Statement st = conn.createStatement();
		// da ricontrollare
		int p = 0;

		System.out.println("Seleziona il periodo di permanenza");
		
		System.out.println("1- MEZZA GIORNATA �10,00" + "\n" + "2- GIORNATA INTERA �20,00" + "\n"
				+ "3- GIORNATE CONSECUTIVE �15.00 cad. \n");
		
		p = in.nextInt();
		switch (p) {
		case 1:
			st.execute("SELECT id_ombrellone FROM prenotazione WHERE mezza_giornata = true AND giornata_intera = false");
			System.out.println(st.getResultSet()); 
			break;
		case 2:
			st.execute("SELECT id_ombrellone FROM prenotazione WHERE mezza_giornata = false AND giornata_intera = true");
			break;
		case 3:
			System.out.println("Inserire il numero di giorni\n");
			int d = in.nextInt();
			st.execute("SELECT id_ombrellone FROM prenotazione WHERE mezza_giornata = false AND giornata_intera = false");
			break;
		}
		ResultSet res_set = st.executeQuery("SELECT * FROM prenotazione");

		while (res_set.isAfterLast()) {
			System.out.println(res_set);
//			lista_prenotazione.add(rs);
		}

		conn.close();
		return false;
		
		/**
		 * query per prendere le prenotazioni legate all'ombrellone e confrontarle con
		 * le prenotazioni effettuate foreach(tutte le prenotazioni effettuate){ if(data
		 * == data_prenotazione){ stampa } }
		 */
	}
	public void richiedi_preventivo() throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/casottoDB"; // jdbc:msql://127.0.0.1:3306/casotto
		Connection conn = DriverManager.getConnection(url, "Capriotti Riccardo", "");
		Statement st = conn.createStatement();

		// SELECT per ritornare posizione e costo dell'ombrellone
		ResultSet rs = st.executeQuery("SELECT costo_ombrellone FROM Ombrellone");
//		ResultSetMetaData rsmd = rs.getMetaData();
		String costo = rs.getString("costo_ombrellone");
//		se mettiamo il costo uguale la posizione diventa ininfluente
//		String pos = rs.getString("posizione_ombrellone");
		System.out.println("L'ombrellone costa " + costo);
		conn.close();
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
