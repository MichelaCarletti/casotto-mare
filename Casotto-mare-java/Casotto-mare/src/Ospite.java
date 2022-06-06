import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import java.sql.*;

public class Ospite extends Persona {
	private double costo_ombrellone;
	private int posizione_ombrellone;

	public Ospite(int id_persona, String nome, String cognome, String ruolo, String email, String password) {
		super(id_persona, nome, cognome, ruolo, email, password);

	}

	public void connessioneDB() {
		try {

			String url = "jdbc:mysql://127.0.0.1:3306/casottoDB"; // jdbc:msql://127.0.0.1:3306/casotto
			Connection conn = DriverManager.getConnection(url, "Capriotti Riccardo", "");
			Statement st = conn.createStatement();

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

	/***
	 * Esempio Connessione ad database e Stampa una Query SELECT dal db
	 */
	public void selectDB() {
		try {

			String url = "jdbc:mysql://127.0.0.1:3306/casottoDB"; // jdbc:msql://127.0.0.1:3306/casotto
			Connection conn = DriverManager.getConnection(url, "Capriotti Riccardo", "");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Ombrellone");
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();

			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					System.out.print(rs.getString(i) + " "); // Stampa elementi di 1 riga

				}
				System.out.println();
			}

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
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

	public void addOmbrelloni() throws SQLException {
		costo_ombrellone = 20.00;
		int[] pos = new int[50];
		String url = "jdbc:mysql://127.0.0.1:3306/casottoDB";
		Connection conn = DriverManager.getConnection(url, "Capriotti Riccardo", "");
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

	public boolean prenota_ombrellone() throws SQLException {
		return false;
	}

	public void setCosto_ombrellone(double costo_ombrellone) {
		this.costo_ombrellone = costo_ombrellone;
	}

	public void setPosizione_ombrellone(int posizione_ombrellone) {
		this.posizione_ombrellone = posizione_ombrellone;
	}

	private boolean prenota_tavolo() {
		return false;
	}

	@Override
	public boolean registrazione() throws SQLException {
		// connessione db
		String url = "jdbc:mysql://127.0.0.1:3306/casottoDB"; // jdbc:msql://127.0.0.1:3306/casotto
		Connection conn = DriverManager.getConnection(url, "Capriotti Riccardo", "");
		Statement st = conn.createStatement();

		Scanner in = new Scanner(System.in);

		System.out.println("Inserisci il nome: ");
		// variabile di appoggio per la successiva creazione dell'oggetto Utente
		String name = in.next();

		System.out.println("Inserisci il cognome: ");
		// variabile di appoggio per la successiva creazione dell'oggetto Utente
		String surname = in.next();

		System.out.println("Inserisci il ruolo: ");
		// variabile di appoggio per la successiva creazione dell'oggetto Utente
		String role = in.next();

		System.out.println("Inserisci un'email: ");
		// variabile di appoggio per la successiva creazione dell'oggetto Utente
		String e_mail = in.next();

		// variabile di appoggio per la successiva creazione dell'oggetto Utente
		String pass1 = "";
		String pass2 = "";
		System.out.println("Inserisci la password: ");
		pass1 = in.next();
		System.out.println("Conferma password");
		pass2 = in.next();

		if (!(pass1.equals(pass2))) {
			System.out.println("Errore pass");
		}

		// serve per costruire l'oggetto nel main richiamando il metodo registrazione e
		// TODO inserire nel db
		this.setNome(name);
		this.setCognome(surname);
		this.setRuolo(role);
		this.setEmail(e_mail);
		this.setPassword(pass2);

		System.out.println("Inserisco la registrazione nel db");

		String query = "insert into Persona (nome,cognome,ruolo,email,password)" + "values (?, ?, ?, ?, ?)";

		PreparedStatement preparedStmt = conn.prepareStatement(query);

		// FUNZIONANTE
		preparedStmt.setString(1, name);
		preparedStmt.setString(2, surname);
		preparedStmt.setString(3, role);
		preparedStmt.setString(4, e_mail);
		preparedStmt.setString(5, pass2);

		preparedStmt.execute();

		System.out.println("Query effettuata");

//	}
		conn.close();
		return false;
	}

	@Override
	public boolean autenticazione() throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/casottoDB"; // jdbc:msql://127.0.0.1:3306/casotto
		Connection conn = null;
		conn = DriverManager.getConnection(url, "Capriotti Riccardo", "");
		Statement st = conn.createStatement();

		Scanner in = new Scanner(System.in);

		System.out.println("Inserire username: ");
		String username = in.next();

		System.out.println("Inserire la password: ");
		String pass1 = in.next();

		setEmail(username);
		setPassword(pass1);

		ResultSet rs = st.executeQuery("SELECT email, password FROM persona WHERE email = '" + username + "'AND password = '" + pass1+"'");
		if(rs !=null) {
			my_page();
		}else {
			System.out.println("Errore nell' inserimento delle credenziali !");
		}
		// serve per costruire l'oggetto richiamando il metodo autenticazione nel main e
		// TODO verificare nel db
		
		return false;
	}

	@Override
	public boolean logout() {
//		TODO
		return false;
	}

	/***
	 * Rappresenta la pagina personale
	 * 
	 * @throws SQLException
	 */
	@Override
	public void my_page() throws SQLException {
		int number = 0;
		System.out.println("1- Richiedi preventivo" + "\n" + "2- Prenota ombrellone" + "\n" + "3- Prenota tavolo");

		switch (number) {

		case 1:
			richiedi_preventivo();
			break;

		case 2:
			prenota_ombrellone();
			break;

		case 3:
			prenota_tavolo();
			break;
		}

	}
}