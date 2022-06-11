import java.sql.SQLException;

public abstract class Persona {

	protected int id_persona;
	private String nome;
	private String cognome;
	private String email;
	private String password;

	public Persona(int id_persona, String nome, String cognome, String email, String password) {

		this.id_persona = id_persona;
		this.setNome(nome);
		this.setCognome(cognome);
		this.setEmail(email);
		this.setPassword(password);
	}

	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}



	public abstract boolean registrazione() throws SQLException;

	public abstract boolean autenticazione() throws SQLException;

	public abstract boolean logout();
	
	public abstract void my_page() throws SQLException;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
