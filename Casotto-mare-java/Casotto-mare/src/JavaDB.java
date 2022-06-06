import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaDB {
	static final String db_url = "jdbc:mysql://127.0.0.1:3306/casottoDB";
	static final String user = "Capriotti Riccardo";
	

	public static void main(String[] args) throws SQLException {
		// apro la connessione
		Connection con = DriverManager.getConnection(db_url, user, "");
		Statement s = con.createStatement();
		
		//eseguo la query
		System.out.println("Inserisci dentro la tabella ombrellone (id_ombrellone, posizione, costo_ombrellone)"+"values (?,?,?");
		
		String sql = "INSERT INTO ombrellone VALUES (3,2,20.0)";
		s.executeUpdate(sql);
	}

}
