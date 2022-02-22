package hr.java.vjezbe.entitet;

public class Kategorija {
	
	private String naziv;
	public Artikl[] artikli;
	
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Artikl[] getArtikli() {
		return artikli;
	}

	public void setArtikli(Artikl[] artikli) {
		this.artikli = artikli;
	}
/**
 * Klasa Kategorija sluzi za grupiranje artikala
 * @param naziv
 * @param artikli
 */
	public Kategorija(String naziv, Artikl[] artikli) {
		super();
		this.naziv = naziv;
		this.artikli = artikli;
	}

}
