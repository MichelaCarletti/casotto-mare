import java.util.ArrayList;
import java.util.Scanner;


import java.sql.*;

public class Ospite extends Persona {

	public Ospite(int id_persona, String nome, String cognome, String ruolo, String email, String password) {
		super(id_persona, nome, cognome, ruolo, email, password);

	}

	public void connessioneDB() {
		 try { 
			    
	            String url = "jdbc:mysql://127.0.0.1:3306/casotto";     //jdbc:msql://127.0.0.1:3306/casotto
	            Connection conn = DriverManager.getConnection(url,"root","");   
	            Statement st = conn.createStatement() ; 
	            
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
			   
	            String url = "jdbc:mysql://127.0.0.1:3306/casotto";     //jdbc:msql://127.0.0.1:3306/casotto
	            Connection conn = DriverManager.getConnection(url,"root","");   
	            Statement st = conn.createStatement() ; 
	            ResultSet rs = st.executeQuery("SELECT * FROM Ombrellone"); 
	            ResultSetMetaData rsmd = rs.getMetaData();
	            int columnsNumber = rsmd.getColumnCount();
	            
	            while (rs.next()) {
	            	for(int i = 1 ; i <= columnsNumber; i++){
	            	System.out.print(rs.getString(i) + " "); //Stampa elementi di 1 riga 

	            	}
	            	System.out.println();
	            }
	           
	            conn.close(); 
	        } catch (Exception e) { 
	            System.err.println("Got an exception! "); 
	            System.err.println(e.getMessage()); 
	        } 
	}
	
	
	
	private void richiedi_preventivo() {
		// TODO
	}

	private boolean prenota_ombrellone() {
		
		//Lista ombrelloni - effettuare query per caricare ombrelloni
		ArrayList <Ombrellone> l1= new ArrayList<>();
//		Ombrellone ombrellone;
//		l1.add(ombrellone);
		Scanner in = new Scanner(System.in);
		System.out.println("Seleziona i giorni in cui vuoi effettaure la prenotazione: ");
		String day = in.next();
		for(Ombrellone ombrellone : l1) {
			/**
			 * query per prendere le prenotazioni legate all'ombrellone e confrontarle con le prenotazioni effettuate
			 * 
			 * foreach(tutte le prenotazioni effettuate){
			 * 	if(data == data_prenotazione){
			 * stampa
			 * }
			 * 
			 * }
			 */
		}
		return false;
	}

	private boolean prenota_tavolo() {
		return false;
	}

	@Override
	public boolean registrazione() throws SQLException  {
		//connessione db 
		String url = "jdbc:mysql://127.0.0.1:3306/casotto";     //jdbc:msql://127.0.0.1:3306/casotto
		Connection conn = DriverManager.getConnection(url,"root","");   
		Statement st = conn.createStatement() ; 
		        
		Scanner in = new Scanner(System.in);
		// Assegnamo ID da Database tramite autoIncrement 
	
	
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
			
			
		
//		do {
//			System.out.println("Inserisci la password: ");
//
//			pass1 = in.next();
//			System.out.println("Conferma password");
//			pass2 = in.next();
//		} while (pass1.equals(pass2));

		// serve per costruire l'oggetto nel main richiamando il metodo registrazione e
		// TODO inserire nel db
		this.setNome(name);
		this.setCognome(surname);
		this.setRuolo(role);
		this.setEmail(e_mail);
		this.setPassword(pass2);
		
		
	         
		
		
		System.out.println("Inserisco la registrazione nel db");
		
		if ((id_persona != id_persona+1) && (id_persona <= 100)){
			

		String query = 	"insert into Persona (nome,cognome,ruolo,email,password)" + "values (?, ?, ?, ?, ?)";
		
		 PreparedStatement preparedStmt = conn.prepareStatement(query);

		 
		 //FUNZIONANTE 
		 
	
	     preparedStmt.setString (1, name);
	     preparedStmt.setString (2, surname);
         preparedStmt.setString (3, role);
	     preparedStmt.setString (4, e_mail);
	     preparedStmt.setString (5, pass2);
	      
		
		preparedStmt.execute();
		
		conn.close();

		
		//st.executeUpdate( query ); 
		
		System.out.println("Query effettuata");
		
		}
		
		
		
		return false;
	}

	@Override
	public boolean autenticazione() {
		Scanner in = new Scanner(System.in);

		System.out.println("Inserire username: ");
		String username = in.next();

		System.out.println("Inserire la password: ");
		String pass1 = in.next();
		// serve per costruire l'oggetto richiamando il metodo autenticazione nel main e
		// TODO verificare nel db
		setEmail(username);
		setPassword(pass1);

		return false;
	}

	@Override
	public boolean logout() {
//		TODO
		return false;
	}

	/***
	 * Rappresenta la pagina personale
	 */
	@Override
	public void my_page() {
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
