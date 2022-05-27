
public abstract class Persona {

	private int id_persona;
	private String nome;
	private String cognome;
	private String ruolo;
	private String email;
	private String password;

	public Persona(int id_persona, String nome, String cognome, String ruolo, String email, String password) {

		this.id_persona = id_persona;
		this.setNome(nome);
		this.setCognome(cognome);
		this.ruolo = ruolo;
		this.setEmail(email);
		this.setPassword(password);
	}

	public abstract boolean registrazione();

	public abstract boolean autenticazione();

	public abstract boolean logout();
	
	public abstract void my_page();

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

//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}

}
