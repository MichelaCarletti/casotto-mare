import java.util.ArrayList;
import java.util.Scanner;

public class Ospite extends Persona {

	public Ospite(int id_persona, String nome, String cognome, String ruolo, String email, String password) {
		super(id_persona, nome, cognome, ruolo, email, password);

	}

	private void richiedi_preventivo() {
		// TODO
	}

	private boolean prenota_ombrellone() {
		
		//effettuare query per caricare ombrelloni
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
	public boolean registrazione() {
		Scanner in = new Scanner(System.in);
		// id da assegnare tramite db
		System.out.println("Inserisci il nome: ");
		// variabile di appoggio per la successiva creazione dell'oggetto Utente
		String name = in.next();

		System.out.println("Inserisci il cognome: ");
		// variabile di appoggio per la successiva creazione dell'oggetto Utente
		String surname = in.next();

//		System.out.println("Inserisci il ruolo: ");
//		// variabile di appoggio per la successiva creazione dell'oggetto Utente
//		String role = in.next();

		System.out.println("Inserisci un'email: ");
		// variabile di appoggio per la successiva creazione dell'oggetto Utente
		String e_mail = in.next();

		// variabile di appoggio per la successiva creazione dell'oggetto Utente
		String pass1 = "";
		String pass2 = "";
		do {
			System.out.println("Inserisci la password: ");

			pass1 = in.next();
			System.out.println("Conferma password");
			pass2 = in.next();
		} while (pass1.equals(pass2));

		// serve per costruire l'oggetto nel main richiamando il metodo registrazione e
		// inserire nel db
		this.setNome(name);
		this.setCognome(surname);
		this.setEmail(e_mail);
		this.setPassword(pass2);
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
		// verificare nel db
		setEmail(username);
		setPassword(pass1);

		return false;
	}

	@Override
	public boolean logout() {
//		TODO
		return false;
	}

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
