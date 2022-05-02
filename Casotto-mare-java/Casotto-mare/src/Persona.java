
public abstract class Persona {
	
private int id_persona;
private String nome;
private String cognome;
private String ruolo;
private String email;
private String password;

public Persona(int id_persona, String nome, String cognome, String ruolo, String email, String password) {
	
	this.id_persona = id_persona;
	this.nome = nome;
	this.cognome = cognome;
	this.ruolo = ruolo;
	this.email = email;
	this.password = password;
}

public abstract boolean registrazione(); 

public abstract boolean autenticazione();

public abstract boolean logout();

}
