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


	


	
}
