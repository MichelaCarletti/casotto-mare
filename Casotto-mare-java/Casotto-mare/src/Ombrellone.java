
public class Ombrellone {
	private int id_ombrellone;
	private int posizione_ombrellone;
	private double costo_ombrellone;

	public Ombrellone(int id_ombrellone, int posizione_ombrellone, double costo_ombrellone) {
		this.id_ombrellone = id_ombrellone;
		this.costo_ombrellone = costo_ombrellone;
		this.posizione_ombrellone = posizione_ombrellone;

	}

	public int getId_ombrellone() {
		return id_ombrellone;
	}

	public void setId_ombrellone(int id_ombrellone) {
		this.id_ombrellone = id_ombrellone;
	}

	public int getPosizione_ombrellone() {
		return posizione_ombrellone;
	}

	public void setPosizione_ombrellone(int posizione_ombrellone) {
		this.posizione_ombrellone = posizione_ombrellone;
	}

	public double getCosto_ombrellone() {
		return costo_ombrellone;
	}

	
}
