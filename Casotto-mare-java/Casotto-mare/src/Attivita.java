
public class Attivita {

	private int id_attivita;
	private String nome_attivita;
	private String data_attivita;
	private int numero_partecipanti;
	private int [] lista_partecipanti;
	private String orario_attivita;
	
	public Attivita(int id_attivita, String nome_attivita, String data_attivita,int numero_partecipanti, String orario_attivita ) {
		this.id_attivita = id_attivita;
		this.nome_attivita = nome_attivita;
		this.data_attivita = data_attivita;
		this.numero_partecipanti = numero_partecipanti;
	    lista_partecipanti = new int [numero_partecipanti];
	    this.orario_attivita = orario_attivita;
	}
}
