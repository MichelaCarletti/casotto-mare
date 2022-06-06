import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Prenotazione {
	private int id_prenotazione;
	private String data_prenotazione;
	private int id_cliente;
	private int durata_prenotazione;
	private int id_ombrellone;
	private double costo_prenotazione;

	public Prenotazione(int id_prenotazione, String data_prenotazione, int id_cliente, int durata_prenotazione,
			int id_ombrellone, double costo_prenotazione) {
		this.id_prenotazione = id_prenotazione;
		this.data_prenotazione = data_prenotazione;
		this.id_cliente = id_cliente;
		this.durata_prenotazione = durata_prenotazione;
		this.id_ombrellone = id_ombrellone;
		this.costo_prenotazione = costo_prenotazione;
	}

	public void prenota() throws SQLException {
		Scanner in = new Scanner(System.in);
		ArrayList<String> lista_prenotazione = new ArrayList<String>();
		String url = "jdbc:mysql://127.0.0.1:3306/casottoDB";
		Connection conn = DriverManager.getConnection(url, "Capriotti Riccardo", "");
		Statement st = conn.createStatement();
		// da ricontrollare
		int p = 0;
//		System.out.println("Inserisci il giorno in cui vuoi effettaure la prenotazione: ");
//		String day = in.next();
		System.out.println("Seleziona il periodo di permanenza");
		
		System.out.println("1- MEZZA GIORNATA €10,00" + "\n" + "2- GIORNATA INTERA €20,00" + "\n"
				+ "3- GIORNATE CONSECUTIVE €15.00 cad. \n");
		
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

//		System.out.println("Quale posizione preferisce ? (1,2,3)");
//		int position = in.nextInt();
//		ResultSet rs = st.executeQuery("SELECT posizione_ombrellone FROM ombrellone WHERE posizione_ombrellone = " + position);
		// con questa query vado a selezionare l'ombrellone scelto da cliente
//		rs = st.executeQuery("SELECT id_ombrellone FROM ombrellone WHERE posizione_ombrellone = " + position);
		// qui mi voglio stampare a video l'ombrellone scelto
//		ResultSetMetaData rsmd = rs.getMetaData();
//		int columnsNum = rsmd.getColumnCount();
//		while (rs.next()) {
//			for (int i = 1; i <= columnsNum; i++) {
//				System.out.println(rs.getString(i) + " ");
//			}
//		}

//		System.out.println("Il tuo ombrellone e': "+rs.getRowId(2)+" ed e' in posizione "+rs.getRowId(3));
		conn.close();
		//// for (Ombrellone ombrellone : l1) {
		/**
		 * query per prendere le prenotazioni legate all'ombrellone e confrontarle con
		 * le prenotazioni effettuate foreach(tutte le prenotazioni effettuate){ if(data
		 * == data_prenotazione){ stampa } }
		 */

//		}

	}
}
