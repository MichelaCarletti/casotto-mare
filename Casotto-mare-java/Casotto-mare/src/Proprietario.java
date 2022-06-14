import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Proprietario extends Staff {
	
	double costo_ombrellone;
	int posizione_ombrellone;
	
	public Proprietario(int id_persona, String nome, String cognome, String email, String password,
			int stipendio, String orario) {
		super(id_persona, nome, cognome, email, password, stipendio, orario);
	}

	public boolean rifornisci_inventario() {
		return false;
		//TODO
	}
	public boolean aggiungi_nuovo_prodotto() {
		return false;
		//TODO
	}
	public boolean elimina_prodotto() {
		return false;
		//TODO
	}
	public boolean aggiorna_prodotto() {
		return false;
		//TODO
	}
	public void aggiungiOmbrelloni() throws SQLException {
		costo_ombrellone = 20.00;
		int[] pos = new int[50];
		String url = "jdbc:mysql://127.0.0.1:3306/casotto";
		Connection conn = DriverManager.getConnection(url, "root", "claMysql");
		Statement st = conn.createStatement();
		for (int i = 0; i < pos.length; i++) {
			posizione_ombrellone = i;
			pos[i] = posizione_ombrellone;

			String query = "insert into Ombrellone (costo_ombrellone,posizione_ombrellone)" + "values (?, ?)";

			PreparedStatement preparedStmt = conn.prepareStatement(query);
			// FUNZIONANTE
			preparedStmt.setDouble(1, costo_ombrellone);
			preparedStmt.setInt(2, posizione_ombrellone);
			preparedStmt.execute();
		}

		ResultSet rs = st.executeQuery("SELECT * FROM Ombrellone");

		conn.close();
	}
	public void visualizza_ombrelloni() {
		//TODO
	}
	public boolean modifica_ombrellone() {
		return false;
		//TODO
	}
	public boolean elimina_ombrellone() {
		return false;
		//TODO
	}
	public boolean sostituzione_ombrellone() {
		return false; 
	}
	
	public double applica_sconto() {
		return 0;}
	//TODO
	public void visualizza_dipendenti () {
		
	}
	public void gestione_dipendenti () {
		
	}
	

	public void visualizza_attivita() {

	}
	
	public void visualizza_prenotazione() {

	}

	

	
	
	
	
	
	
}
