import java.sql.SQLException;

public class main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Ospite o = new Ospite(01, "Mario", "Rossi", "cameriere", "provaemail", "123");
		//o.selectDB();
		o.registrazione();
	}

}
