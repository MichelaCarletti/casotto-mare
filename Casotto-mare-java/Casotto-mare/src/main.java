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


		
		
		
				
	}

}
