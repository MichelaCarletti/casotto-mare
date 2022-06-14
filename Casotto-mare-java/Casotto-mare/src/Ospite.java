import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import java.sql.*;

public class Ospite extends Persona {
	private double costo_ombrellone;
	private int posizione_ombrellone;

	public Ospite(int id_persona, String nome, String cognome, String email, String password) {
		super(id_persona, nome, cognome, email, password);

	}


	/***
	 * Esempio Connessione ad database e Stampa una Query SELECT dal db
	 */
	public void selectDB() {
		try {

			String url = "jdbc:mysql://127.0.0.1:3306/casotto"; // jdbc:msql://127.0.0.1:3306/casotto
			Connection conn = DriverManager.getConnection(url, "root", "claMysql");
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
		String url = "jdbc:mysql://127.0.0.1:3306/casotto"; // jdbc:msql://127.0.0.1:3306/casotto
		Connection conn = DriverManager.getConnection(url, "root", "claMysql");
		Statement st = conn.createStatement();

		// SELECT per ritornare posizione e costo dell'ombrellone
		ResultSet rs = st.executeQuery("SELECT  costo_ombrellone FROM Ombrellone");
//		ResultSetMetaData rsmd = rs.getMetaData();
	
	
		//String costo = rs.getString("costo_ombrellone");
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();

		while (rs.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
				System.out.print("Il costo ombrellone: "+rs.getString(i) + " "); 

			}
			System.out.println();
		}
		
		conn.close();
	}



	public boolean prenota_ombrellone() throws SQLException {
		Scanner in = new Scanner(System.in);
		ArrayList<String> lista_prenotazione = new ArrayList<String>();
		String url = "jdbc:mysql://127.0.0.1:3306/casotto";
		Connection conn = DriverManager.getConnection(url, "root", "claMysql");
		Statement st = conn.createStatement();
		
		//ResultSet rs = st.executeQuery("SELECT * FROM Ombrellone");
		
		// da ricontrollare
		int p = 0;
		System.out.println("Sono liberi gli ombrelloni con il numero: \n ");
		
		//Ombrelloni liberi 
		ResultSet resultset = st.executeQuery("SELECT id_ombrellone FROM prenotazione WHERE mezza_giornata = false AND giornata_intera = false AND giorni_consecutivi = false");
		ResultSetMetaData resultsmd = resultset.getMetaData();
		int columnNumber = resultsmd.getColumnCount();
		
		
		//System.out.println(st.getResultSet()); 
		
		while (resultset.next()) {
			for (int i = 1; i <= columnNumber; i++) {
				System.out.print(resultset.getString(i) + " "); // Stampa elementi di 1 riga

			}
			System.out.println();
		}
		
		System.out.println("Seleziona il periodo di permanenza");
		
		System.out.println("1- MEZZA GIORNATA " + "\n" + "2- GIORNATA INTERA " + "\n"
				+ "3- GIORNATE CONSECUTIVE  cad. \n");
		
		

		int n = 0;
		p = in.nextInt();
		
		System.out.println("Inserisci il giorno: ");
		
		String giorno = in.next();
		
		
		switch (p) {
		
		case 1:

			ResultSet rs = st.executeQuery(
					"SELECT id_ombrellone FROM prenotazione WHERE mezza_giornata = true AND giornata_intera = false AND giorni_consecutivi = false  ");

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();

			// System.out.println(st.getResultSet());

			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					System.out.print("Ombrellone occupato: " + rs.getString(i) + " "); // Stampa elementi di 1 riga

				}
				System.out.println();
			}

			System.out.println("Inserisci id_ombrellone: ");

			int id_ombrellone = in.nextInt();

			int username_cliente = this.getId_persona(); // id_persona sarebbe l'username

			System.out.println("Inserisco la prenotazione nel db");

			String query = "insert into prenotazione (giorno,id_ombrellone,username_cliente, mezza_giornata, giornata_intera, giorni_consecutivi)"
					+ "values (?, ?, ?, ?, ?, ? )";

			PreparedStatement preparedStmt = conn.prepareStatement(query);

			// FUNZIONANTE
			preparedStmt.setString(1, giorno);
			preparedStmt.setInt(2, id_ombrellone);
			preparedStmt.setInt(3, username_cliente);
			preparedStmt.setBoolean(4, true);
			preparedStmt.setBoolean(5, false);
			preparedStmt.setBoolean(6, false);

			preparedStmt.execute();

			break;
		case 2:
			rs = st.executeQuery(
					"SELECT id_ombrellone FROM prenotazione WHERE mezza_giornata = false AND giornata_intera = true AND giorni_consecutivi = false");

			ResultSetMetaData resmd = rs.getMetaData();
			int numberColomn = resmd.getColumnCount();

			// System.out.println(st.getResultSet());

			while (rs.next()) {
				for (int i = 1; i <= numberColomn; i++) {
					System.out.print("Il tuo ombrellone è il numero: " + rs.getString(i) + " "); // Stampa elementi di 1
																									// riga

				}
				System.out.println();
			}

			System.out.println("Inserisci id_ombrellone: ");

			int idombrellone = in.nextInt();

			int usernamecliente = this.getId_persona(); // id_persona sarebbe l'username

			System.out.println("Inserisco la prenotazione nel db");

			String q = "insert into prenotazione (giorno,id_ombrellone,username_cliente, mezza_giornata, giornata_intera, giorni_consecutivi)"
					+ "values (?, ?, ?, ?, ?, ? )";

			PreparedStatement preparedStmts = conn.prepareStatement(q);

			// FUNZIONANTE
			preparedStmts.setString(1, giorno);
			preparedStmts.setInt(2, idombrellone);
			preparedStmts.setInt(3, usernamecliente);
			preparedStmts.setBoolean(4, false);
			preparedStmts.setBoolean(5, true);
			preparedStmts.setBoolean(6, false);

			preparedStmts.execute();

			break;
		case 3:
			System.out.println("Inserire il numero di giorni\n");
			int d = in.nextInt();
			rs = st.executeQuery(
					"SELECT id_ombrellone FROM prenotazione WHERE mezza_giornata = false AND giornata_intera = false AND giorni_consecutivi = true");

			ResultSetMetaData resumd = rs.getMetaData();
			int numbColomn = resumd.getColumnCount();

			// System.out.println(st.getResultSet());

			while (rs.next()) {
				for (int i = 1; i <= numbColomn; i++) {
					System.out.print("Il tuo ombrellone è il numero: " + rs.getString(i) + " "); // Stampa elementi di 1
																									// riga

				}
				System.out.println();
			}

			System.out.println("Inserisci id_ombrellone: ");

			int Idombrellone = in.nextInt();

			int Usernamecliente = this.getId_persona(); // id_persona sarebbe l'username

			System.out.println("Inserisco la prenotazione nel db");

			String quer = "insert into prenotazione (giorno,id_ombrellone,username_cliente, mezza_giornata, giornata_intera, giorni_consecutivi)"
					+ "values (?, ?, ?, ?, ?, ? )";

			PreparedStatement PreparedStmts = conn.prepareStatement(quer);

			// FUNZIONANTE
			PreparedStmts.setString(1, giorno);
			PreparedStmts.setInt(2, Idombrellone);
			PreparedStmts.setInt(3, Usernamecliente);
			PreparedStmts.setBoolean(4, false);
			PreparedStmts.setBoolean(5, false);
			PreparedStmts.setBoolean(6, true);

			PreparedStmts.execute();

			break;
		}

		conn.close();

		
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
		String url = "jdbc:mysql://127.0.0.1:3306/casotto"; // jdbc:msql://127.0.0.1:3306/casotto
		Connection conn = DriverManager.getConnection(url, "root", "claMysql");
		Statement st = conn.createStatement();

		Scanner in = new Scanner(System.in);

		System.out.println("Inserisci il nome: ");
		// variabile di appoggio per la successiva creazione dell'oggetto Utente
		String name = in.next();

		System.out.println("Inserisci il cognome: ");
		// variabile di appoggio per la successiva creazione dell'oggetto Utente
		String surname = in.next();


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

		this.setNome(name);
		this.setCognome(surname);
		this.setEmail(e_mail);
		this.setPassword(pass2);

		System.out.println("Inserisco la registrazione nel db");

		String query = "insert into Persona (nome,cognome,email,password)" + "values (?, ?, ?, ?)";

		PreparedStatement preparedStmt = conn.prepareStatement(query);

		// FUNZIONANTE
		preparedStmt.setString(1, name);
		preparedStmt.setString(2, surname);
		preparedStmt.setString(3, e_mail);
		preparedStmt.setString(4, pass2);

		preparedStmt.execute();

		System.out.println("Query effettuata");

//	}
		conn.close();
		return false;
	}

	@Override
	public boolean autenticazione() throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/casotto"; // jdbc:msql://127.0.0.1:3306/casotto
		Connection conn = null;
		conn = DriverManager.getConnection(url, "root", "claMysql");
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
		System.out.println("1- Richiedi preventivo" + "\n" + "2- Prenota ombrellone" + "\n" + "3- Prenota tavolo" + "\n");
		Scanner s = new Scanner(System.in);
		
		number =  s.nextInt();
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