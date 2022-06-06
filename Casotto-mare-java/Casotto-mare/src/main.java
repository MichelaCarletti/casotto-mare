import java.sql.*;
import java.util.Scanner;
public class main {

	public static void main(String[] args) throws SQLException {
		Scanner in = new Scanner(System.in);
		Ospite o = new Ospite(1, null, null, null, null, null);
//		o.registrazione();
//		int n = 0;
//		System.out.println("Benvenuto. Seleziona il numero desiderato.\n");
//		System.out.println("1- REGISTRAZIONE" + "\n" + "2- AUTENTICAZIONE" + "\n" + "3- MY_PAGE\n");
//		n = in.nextInt();
//		switch (n) {
//
//		case 1:
//			o.registrazione();
//			break;
//
//		case 2:
//			o.autenticazione();
//			break;
//
//		}
		Prenotazione p = new Prenotazione(1, null, 0, 0, 0, 0);
		p.prenota();
		
		
		
				
	}

}
