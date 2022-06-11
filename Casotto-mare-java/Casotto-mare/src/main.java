import java.sql.*;
import java.util.Scanner;
public class main {

	public static void main(String[] args) throws SQLException {
		Scanner in = new Scanner(System.in);
		Ospite o = new Ospite( 0,null, null, null, null );
		
	
		
		
		Proprietario p = new Proprietario(0, null, null, null, null, 0, null);
		
		//p.aggiungiOmbrelloni();
		
		//o.selectDB();
		o.autenticazione();
		
		//o.prenota_ombrellone();
		
		
    	//o.registrazione();
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

		
		
		
				
	}

}
